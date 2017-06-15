package spark.template.freemarker.oguzhanyalcin;
import static spark.Spark.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.*;
import spark.template.freemarker.*;


public class SparkFtl {

    /*--
     * http://taywils.me/2013/11/05/javasparkframeworktutorial/
     */
    public static void main(String[] args) throws Exception {

        Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:derby:c:\\_veritabani;create=true");

        Statement statement = connection.createStatement();

        birDefaCalistirilacakKod(statement);

        ResultSet rs = statement.executeQuery("select * from ogrenciler");

        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();

        while (rs.next()) {
            int id = rs.getInt(1);
            String adSoyad = rs.getString(2);
            String ogrenciTipi = rs.getString(3);
            String bolum = rs.getString(4);
            int numara = rs.getInt(5);

            ogrenciler.add(new Ogrenci(id, adSoyad, ogrenciTipi, bolum, numara));
        }

        // setPort(3737);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();

                try {
                    ResultSet rs = statement.executeQuery("select * from ogrenciler");

                    List<Ogrenci> ogrenciler1 = new ArrayList<Ogrenci>();

                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String adSoyad = rs.getString(2);
                        String ogrenciTipi = rs.getString(3);
                        String bolum = rs.getString(4);
                        int numara = rs.getInt(5);

                        ogrenciler1.add(new Ogrenci(id, adSoyad, ogrenciTipi, bolum, numara));
                    }
                    attributes.put("ogrenciler", ogrenciler1);
                } catch (Exception e) {
                    System.out.print(e);
                }


                return new ModelAndView(attributes, "oguzhanyalcin/ogrenciler.html"); // resources'daki html veya ftl
            }
        };
        get(ogrencilerGet);

        FreeMarkerRoute dersgoruntulePost = new FreeMarkerRoute("/dersgoruntuleme") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                try {
                    ResultSet rs = statement.executeQuery("select * from ogrenciler where id not in (select ogr.id from ogrenciler as ogr join ogrenci_ders as od on od.ogrenci_id=ogr.id where od.ders_id=" + req.queryParams("id")+") order by id desc");

                    List<Ogrenci> ogrenciler1 = new ArrayList<Ogrenci>();
                    List<Ogrenci> activeList = new ArrayList<Ogrenci>();

                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String adSoyad = rs.getString(2);
                        String ogrenciTipi = rs.getString(3);
                        String bolum = rs.getString(4);
                        int numara = rs.getInt(5);

                        ogrenciler1.add(new Ogrenci(id, adSoyad, ogrenciTipi, bolum, numara));
                    }
                    attributes.put("ogrenciler", ogrenciler1);
                    attributes.put("ders", new Ders(12, "ccc"));

                    rs = statement.executeQuery("select ogr.* from ogrenciler as ogr join ogrenci_ders as od on od.ogrenci_id=ogr.id where od.ders_id=" + req.queryParams("id") + " order by ogr.id desc");
                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String adSoyad = rs.getString(2);
                        String ogrenciTipi = rs.getString(3);
                        String bolum = rs.getString(4);
                        int numara = rs.getInt(5);

                        activeList.add(new Ogrenci(id, adSoyad, ogrenciTipi, bolum, numara));
                    }

                    attributes.put("activeList", activeList);
                    rs = statement.executeQuery("select * from dersler where id=" + req.queryParams("id"));

                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String ad = rs.getString(2);

                        attributes.put("ders", new Ders(id, ad));
                    }
                } catch (Exception e) {
                    System.out.print(e);
                }


                return new ModelAndView(attributes, "oguzhanyalcin/dersgoruntuleme.html"); // resources'daki html veya ftl
            }
        };
        post(dersgoruntulePost);

        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();

                try {
                    ResultSet rs = statement.executeQuery("select * from dersler");

                    List<Ders> dersler = new ArrayList<Ders>();

                    while (rs.next()) {
                        int id = rs.getInt(1);
                        String ad = rs.getString(2);

                        dersler.add(new Ders(id, ad));
                    }
                    attributes.put("dersler", dersler);
                } catch (Exception e) {
                    System.out.print(e);
                }


                return new ModelAndView(attributes, "oguzhanyalcin/dersler.html"); // resources'daki html veya ftl
            }
        };
        get(derslerGet);

        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "oguzhanyalcin/ogrenciekle.html"); // resources'daki html veya ftl
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", ogrenciler);
                return new ModelAndView(attributes, "oguzhanyalcin/dersekle.html"); // resources'daki html veya ftl
            }
        };
        get(dersekleGet);

        FreeMarkerRoute ogrencisilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "oguzhanyalcin/ogrencisil.html"); // resources'daki html veya ftl
            }
        };
        get(ogrencisilGet);

        FreeMarkerRoute derssilGet = new FreeMarkerRoute("/derssil") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "oguzhanyalcin/derssil.html"); // resources'daki html veya ftl
            }
        };
        get(derssilGet);

        FreeMarkerRoute ogrenciler1Get = new FreeMarkerRoute("/ogrencigoruntuleme") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "oguzhanyalcin/ogrencigoruntuleme.html"); // resources'daki html veya ftl
            }
        };
        get(ogrenciler1Get);


        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                String adSoyad = req.queryParams("adSoyad");
                String ogrenciTipi = req.queryParams("ogrenciTipi");
                String bolum = req.queryParams("bolum");
                int numara = Integer.parseInt(req.queryParams("numara"));

                try {
                    statement.executeUpdate
                            ("insert into ogrenciler (ad_soyad, ogrenci_tipi, bolum, numara) values ( '" + adSoyad + "',  '" + ogrenciTipi + "', '" + bolum + "', " + numara + ")");
                } catch (Exception e) {
//TODO:fill in the blanks
                    System.out.print(e);
                }

                resp.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                String ad = req.queryParams("ad");

                try {
                    statement.executeUpdate
                            ("insert into dersler (ad) values ( '" + ad + "')");
                } catch (Exception e) {
//TODO:fill in the blanks
                    System.out.print(e);
                }

                resp.redirect("/dersler");
                return null;
            }
        };
        post(derseklePost);

        FreeMarkerRoute dersogrencieklePost = new FreeMarkerRoute("/dersogrenciekle") {
            public Object handle(Request req, Response resp) {
                String ogrenciid = req.queryParams("ogrenciid");
                String dersid = req.queryParams("dersid");
                String added = req.queryParams("added");

                try {
                    statement.execute("delete from ogrenci_ders where ogrenci_id=" + ogrenciid + " and ders_id=" + dersid);
                    if (added.toLowerCase().equals("on")) {
                        statement.executeUpdate
                                ("insert into ogrenci_ders (ogrenci_id, ders_id) values ( " + ogrenciid + ", " + dersid + ")");
                    }
                } catch (Exception e) {
//TODO:fill in the blanks
                    System.out.print(e);
                }

                resp.redirect("/dersler");
                return null;
            }
        };
        post(dersogrencieklePost);


        FreeMarkerRoute ogrencisilPost = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                int id = Integer.parseInt(req.queryParams("id"));

                try {
                    statement.execute("delete from ogrenciler where id = " + id);
                } catch (Exception e) {
                    System.out.println(e);
                }

                resp.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencisilPost);

        FreeMarkerRoute derssilPost = new FreeMarkerRoute("/derssil") {
            public Object handle(Request req, Response resp) {
                int id = Integer.parseInt(req.queryParams("id"));

                try {
                    statement.execute("delete from ogrenci_ders where ders_id = " + id);
                    statement.execute("delete from dersler where id = " + id);
                } catch (Exception e) {
                    System.out.println(e);
                }

                resp.redirect("/dersler");
                return null;
            }
        };
        post(derssilPost);
    }

    private static void birDefaCalistirilacakKod(Statement veritabaniIfadesi) {
        try {
            veritabaniIfadesi.executeUpdate
                    ("CREATE TABLE ogrenciler (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), ad_soyad varchar(30), ogrenci_tipi varchar(30), bolum varchar(30), numara integer, CONSTRAINT primary_key PRIMARY KEY (id))");
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            veritabaniIfadesi.executeUpdate
                    ("CREATE TABLE dersler (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), ad varchar(30), CONSTRAINT primary_key2 PRIMARY KEY (id))");


        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            veritabaniIfadesi.executeUpdate
                    ("CREATE TABLE ogrenci_ders (ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), ogrenci_id INTEGER references ogrenciler(id), ders_id INTEGER references dersler(id), CONSTRAINT primary_key3 PRIMARY KEY (id))");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}



        //KAYNAK
//http://getbootstrap.com/css/#tables
//https://github.com/ozkansari/MyCourses/tree/master/SparkJava1
//https://apps.its.uiowa.edu/dispatch/help/freemarker
//https://stackoverflow.com/questions/9855656/how-to-submit-a-form-using-javascript
//https://www.w3schools.com/tags/att_input_checked.asp
//http://www.binarytides.com/create-autoincrement-columnfield-in-apache-derby/
//https://stackoverflow.com/questions/23571095/declaring-foreign-key-in-apache-derby-database
