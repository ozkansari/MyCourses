package spark.template.freemarker.gurkanertas;
import static spark.Spark.*;

import java.sql.*;
import java.util.*;

import spark.*;
import spark.template.freemarker.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


public class SparkFtl {

    private static final String VERITABANI_DIZINI = "c:\\GURKANERTAS";
    private static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

    private static Connection veritabaniBaglantisi = null;

    private static Statement veritabaniIfadesi = null;

    public static List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
     public static List<Ders> dersler = new ArrayList<Ders>();

    public static List<OgrenciDersler> ogrenciDerslers = new ArrayList<OgrenciDersler>();
    private static Connection baglantiKur() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Connection conn = DriverManager.getConnection(VERITABANI_URL);
            return conn;
        } catch (Exception except) {
            except.printStackTrace();
        }
        return null;
    }
    private static boolean tabloOlustur() throws SQLException {
        try {
             veritabaniIfadesi.executeUpdate("Create table ogrenciler7 (adSoyad varchar(30), ogrenciTipi varchar(50), bolum varchar(50), numara varchar(20))");

            return true;
        } catch(SQLException e) {
            // Tablo zaten var
            return false;
        }


    }
    private static boolean tabloOlustur2() throws SQLException {
        try {
            veritabaniIfadesi.executeUpdate("Create table dersler3 (dersAdi varchar(50), dersKodu varchar(50))");

            return true;
        } catch(SQLException e) {
            // Tablo zaten var
            return false;
        }


    }
    private static boolean tabloOlustur3() throws SQLException {
        try {
            veritabaniIfadesi.executeUpdate("Create table ogrencidersler (numara varchar(50), dersKodu varchar(50))");

            return true;
        } catch(SQLException e) {
            // Tablo zaten var
            return false;
        }


    }
    private static void baglantiyiKapat() {
        try {
            if (veritabaniIfadesi != null) {
                veritabaniIfadesi.close();
            }
            if (veritabaniBaglantisi != null) {
                DriverManager.getConnection(VERITABANI_URL + ";shutdown=true");
                veritabaniBaglantisi.close();
            }
        } catch (SQLException sqlExcept) {
        }
    }
    private static void tabloyaKayitEkle(String adSoyad,String ogrenciTipi,String bolum,String numara) throws SQLException {

        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("INSERT INTO ogrenciler7(adSoyad, ogrenciTipi, bolum,numara) VALUES (?, ?, ?,?)");
        stmt.setString(1, adSoyad);
        stmt.setString(2, ogrenciTipi);
        stmt.setString(3, bolum);
        stmt.setString(4, numara);
        stmt.executeUpdate();

    }


    private static void tabloyaKayitEkleDers(String dersAdi,String dersKodu) throws SQLException {

        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("INSERT INTO dersler3(dersAdi, dersKodu) VALUES (?, ?)");
        stmt.setString(1, dersAdi);
        stmt.setString(2, dersKodu);

        stmt.executeUpdate();
     }

    private static void tabloyaKayitEkleOgrenciDers(String numara,String dersKodu) throws SQLException {
        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("INSERT INTO ogrencidersler(numara, dersKodu) VALUES (?, ?)");
        stmt.setString(1, numara);
        stmt.setString(2, dersKodu);

        stmt.executeUpdate();
    }
    private static void tabloOgrenciSil( String numara) throws SQLException {

        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("DELETE FROM ogrenciler7 where numara=?");
        stmt.setString(1, numara);

        stmt.executeUpdate();
    }
    private static void tabloogrenciderslersil( ) throws SQLException {

        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("DELETE FROM ogrencidersler");
        stmt.executeUpdate();
    }

    private static void tabloDersSil( String dersKodu) throws SQLException {

        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("DELETE FROM dersler3 where dersKodu=?");
        stmt.setString(1, dersKodu);

        stmt.executeUpdate();
    }
    private static void tabloyuSorgula() throws SQLException {

        // Veritabanina sorgu at
        ResultSet rs2 = veritabaniIfadesi.executeQuery("SELECT * FROM ogrenciler7");

        ogrenciler= new ArrayList<>();
        // Sorgu sonuclarini konsola bas
        while (rs2.next()) {
            String adSoyad = rs2.getString("adSoyad");
            String ogrenciTipi = rs2.getString("ogrenciTipi");
            String bolum = rs2.getString("bolum");
            String numara = rs2.getString("numara");

            ogrenciler.add(new Ogrenci(adSoyad,ogrenciTipi,bolum,numara));

        }

        ResultSet rs3 = veritabaniIfadesi.executeQuery("SELECT * FROM dersler3");

        dersler = new ArrayList<>();
        while (rs3.next()) {
            String dersAdi = rs3.getString("dersAdi");
            String dersKodu = rs3.getString("dersKodu");

            dersler.add(new Ders(dersAdi,dersKodu));

        }

    }
    public static void main(String[] args) throws Exception {
        {

            veritabaniBaglantisi = baglantiKur();
            veritabaniIfadesi = veritabaniBaglantisi.createStatement();

            boolean yeniVeritabani = tabloOlustur();
            boolean yeniveritabani2 = tabloOlustur2();
            boolean yeniveritabani3 = tabloOlustur3();

            if (yeniveritabani2 == true)
                dersler.add(new Ders("11","22"));
            //tabloyaKayitEkle("gurkan","ertas","pc","123456");
            tabloyuSorgula();


            final FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
                public Object handle(Request req, Response resp) {
                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("ogrenciler", ogrenciler);
                    return new ModelAndView(attributes, "gurkanertas/ogrenciler.ftl"); // resources'daki ftl
                }
            };
            get(ogrencilerGet);


            FreeMarkerRoute dersGet = new FreeMarkerRoute("/dersler") {
                public Object handle(Request req, Response resp) {
                    Map<String, Object> attributes = new HashMap<>();


                    attributes.put("dersler", dersler);
                    return new ModelAndView(attributes, "gurkanertas/dersler.ftl"); // resources'daki ftl
                }
            };
            get(dersGet);


            FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
                public Object handle(Request req, Response resp) {
                    return new ModelAndView(null, "gurkanertas/dersekle.ftl"); // resources'daki ftl
                }
            };
            get(dersekleGet);

            FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
                public Object handle(Request req, Response resp) {
                    return new ModelAndView(null, "gurkanertas/ogrenciekle.ftl"); // resources'daki ftl
                }
            };
            get(ogrenciekleGet);

            FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
                public Object handle(Request istek, Response cevap) {

                    String adSoyad = istek.queryParams("adSoyad");
                    String ogrenciTipi = istek.queryParams("ogrenciTipi");
                    String bolum = istek.queryParams("bolum");
                    String numara = istek.queryParams("numara");
                    ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum, numara));

                    try {
                        tabloyaKayitEkle(adSoyad,ogrenciTipi,bolum,numara);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    cevap.redirect("/ogrenciler");
                    return null;
                }
            };
            post(ogrencieklePost);



            FreeMarkerRoute derseogrencieklepost = new FreeMarkerRoute("/derseogrenciekle") {



                public Object handle(Request istek, Response cevap) {

                     String dersKodu = istek.queryParams("dersKodu");
                    String numara = istek.queryParams("numara");
                    ogrenciDerslers.add(new OgrenciDersler(numara,dersKodu));

                    //String [] checklistesis = istek.params("checklistesi");

                    try {
                        tabloogrenciderslersil();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                  /*  try {
                       for  (String str :checklistesis){
                            tabloyaKayitEkleOgrenciDers(str,dersKodu);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }*/
                    cevap.redirect("/ogrenciler");
                    return null;
                }
            };
            post(derseogrencieklepost);


            FreeMarkerRoute derseklepost = new FreeMarkerRoute("/derseklepost") {
                public Object handle(Request istek, Response cevap) {

                    String dersAdi = istek.queryParams("dersAdi");
                    String dersKodu = istek.queryParams("dersKodu");

                    dersler.add(new Ders(dersAdi, dersKodu));

                    try {
                        tabloyaKayitEkleDers(dersAdi,dersKodu);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    cevap.redirect("/dersler");
                    return null;
                }
            };
            post(derseklepost);
            FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrencidetay/:ogrencino") {
                public Object handle(Request req, Response resp) {
                    String ogrenciNo = req.params("ogrencino");
                    Map<String, Object> attributes = new HashMap<>();
                    for (Ogrenci ogr : ogrenciler) {
                        if (ogr.Numara.equals(ogrenciNo)) {
                            attributes.put("ogrenci", ogr);
                            return new ModelAndView(attributes, "gurkanertas/ogrencidetay.ftl");
                        }
                    }
                    resp.redirect("/ogrenciler");
                    return null;
                }
            };
            get(ogrenciGoruntule);



            FreeMarkerRoute dersGoruntule = new FreeMarkerRoute("/dersdetay/:derskodu") {
                public Object handle(Request req, Response resp) {
                    List<Ogrenci> dersiAlanogrenciListesi = new ArrayList<>();
                    String derskodu = req.params("derskodu");
                    Map<String, Object> attributes = new HashMap<>();
                    for (Ders ders : dersler) {
                        if (ders.dersKodu.equals(derskodu)) {
                            attributes.put("ders", ders);
                            for(Ogrenci ogrenci:ogrenciler){
                                ogrenci.checkDurumu="";
                                for (OgrenciDersler ogrenciDersler: ogrenciDerslers){
                                    if (ogrenci.getNumara().equals(ogrenciDersler.ogrenciNumara)){
                                        ogrenci.checkDurumu="checked";
                                     }

                                }
                                dersiAlanogrenciListesi.add(ogrenci);
                            }
                            attributes.put("dersiAlanogrenciListesi",dersiAlanogrenciListesi);
                            return new ModelAndView(attributes, "gurkanertas/dersdetay.ftl");
                        }
                    }
                    resp.redirect("/dersler");
                    return null;
                }
            };
            get(dersGoruntule);

            FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil/:ogrencino") {
                public Object handle(Request req, Response resp) {
                    String ogrenciNo = req.params("ogrencino");
                    // Ogrenciyi bul

                    try {
                        tabloOgrenciSil(ogrenciNo);
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }

                    try {
                        tabloyuSorgula();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    resp.redirect("/ogrenciler");
                    return null;
                }
            };
            get(ogrenciSil);

            FreeMarkerRoute dersSil = new FreeMarkerRoute("/derssil/:derskodu") {
                public Object handle(Request req, Response resp) {
                    String derskodu = req.params("derskodu");
                    // Ogrenciyi bul

                    try {
                        tabloDersSil(derskodu);
                    } catch (SQLException e) {

                        e.printStackTrace();
                    }

                    try {
                        tabloyuSorgula();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        tabloyuSorgula();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    resp.redirect("/dersler");
                    return null;
                }
            };
            get(dersSil);
        }
    }
}
