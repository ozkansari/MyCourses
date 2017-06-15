package spark.template.freemarker.recepefemayoglu;
/**
 * Created by Efe Mayoğlu on 21.5.2017.
 */
import static spark.Spark.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import spark.*;
import spark.template.freemarker.*;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SparkFtl {
    private static final String VERITABANI_DIZINI = "\\RECEPEFEMAYOGLU9";
    private static final String VERITABANI_URL = "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";
    private static Connection veritabaniBaglantisi = null;
    private static Statement veritabaniIfadesi = null;

    public static List<Ogrenci> ogrenciListesi = new ArrayList<Ogrenci>();
    public static List<Ders> dersListesi = new ArrayList<Ders>();
    public static List<OgrenciDers> ogrenciDersListesi = new ArrayList<OgrenciDers>();


    public static void main(String[] args) throws Exception {
        {

            veritabaniBaglantisi = baglantiKur();
            veritabaniIfadesi = veritabaniBaglantisi.createStatement();

            gerekliTablolariOlustur();
            getDersTablosu();
            getOgrenciTablosu();

            final FreeMarkerRoute dersOgrenciGet = new FreeMarkerRoute("/dersogrenci") {
                public Object handle(Request req, Response resp) {
                    Map<String, Object> attributes = new HashMap<>();
                    return new ModelAndView(attributes, "recepefemayoglu/dersogrenci.ftl"); // resources'daki ftl
                }
            };
            get(dersOgrenciGet);

            FreeMarkerRoute dersOgrenciPost = new FreeMarkerRoute("/dersogrencipost") {
                public Object handle(Request istek, Response cevap) {
                    String dersId = istek.queryParams("dersId");
                    String numara = istek.queryParams("ogrenciNumara");
                    OgrenciDers ogrenciDers = new OgrenciDers(numara,dersId);
                    ogrenciDersListesi.add(ogrenciDers);
                    try {
                        setOgrenciDersTablo(ogrenciDers);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    cevap.redirect("/dersler");
                    return null;
                }
            };
            post(dersOgrenciPost);

            final FreeMarkerRoute ogrenciListesiGet = new FreeMarkerRoute("/ogrenciler") {
                public Object handle(Request req, Response resp) {
                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("ogrenciler", ogrenciListesi);
                    return new ModelAndView(attributes, "recepefemayoglu/ogrenciler.ftl"); // resources'daki ftl
                }
            };
            get(ogrenciListesiGet);

            FreeMarkerRoute dersListesiGet = new FreeMarkerRoute("/dersler") {
                public Object handle(Request req, Response resp) {
                    Map<String, Object> attributes = new HashMap<>();
                    attributes.put("dersler", dersListesi);
                    return new ModelAndView(attributes, "recepefemayoglu/dersler.ftl"); // resources'daki ftl
                }
            };
            get(dersListesiGet);

            FreeMarkerRoute dersEkleGet = new FreeMarkerRoute("/dersekle") {
                public Object handle(Request req, Response resp) {
                    return new ModelAndView(null, "recepefemayoglu/dersekle.ftl"); // resources'daki ftl
                }
            };
            get(dersEkleGet);

            FreeMarkerRoute ogrenciEkleGet = new FreeMarkerRoute("/ogrenciekle") {
                public Object handle(Request req, Response resp) {
                    return new ModelAndView(null, "recepefemayoglu/ogrenciekle.ftl"); // resources'daki ftl
                }
            };
            get(ogrenciEkleGet);

            FreeMarkerRoute ogrenciEklePost = new FreeMarkerRoute("/ogrenciekle") {
                public Object handle(Request istek, Response cevap) {
                    String ad = istek.queryParams("ad");
                    String soyad = istek.queryParams("soyad");
                    String numarasi = istek.queryParams("numara");
                    String ogrenciTipiId = istek.queryParams("ogrenciTipi");
                    Ogrenci ogrenci = new Ogrenci(ad,soyad,numarasi,ogrenciTipiId);
                    ogrenciListesi.add(ogrenci);

                    try {
                        setOgrenciTablo(ogrenci);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    cevap.redirect("/ogrenciler");
                    return null;
                }
            };
            post(ogrenciEklePost);

            FreeMarkerRoute dersEklePost = new FreeMarkerRoute("/derseklepost") {
                public Object handle(Request istek, Response cevap) {
                    String ad = istek.queryParams("Ad");
                    String akts = istek.queryParams("Akts");
                    String id = istek.queryParams("Id");
                    Ders ders = new Ders(ad,akts,id);
                    dersListesi.add(ders);
                    try {
                        setDersTablo(ders);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    cevap.redirect("/dersler");
                    return null;
                }
            };
            post(dersEklePost);

            FreeMarkerRoute ogrenciGoruntuleGet = new FreeMarkerRoute("/ogrencigoruntule/:numara") {
                public Object handle(Request req, Response resp) {
                    final String numara = req.params("numara");
                    Map<String, Object> attributes = new HashMap<>();
                    List<Ogrenci> ogrenciler = ogrenciListesi.stream().filter(x-> x.getNumara().equalsIgnoreCase(numara)).collect(Collectors.toList());
                    Ogrenci ogrenci = ogrenciler.get(0);
                    List<Ders> dersler = new ArrayList<>();
                    for (OgrenciDers ogrenciDers:ogrenciDersListesi){
                        if(ogrenciDers.getOgrenciNumara().equalsIgnoreCase(ogrenci.getNumara())){
                            List<Ders> dersx = dersListesi.stream().filter(x->x.getId().equalsIgnoreCase(ogrenciDers.getDersId())).collect(Collectors.toList());
                            dersler.add(dersx.get(0));
                        }
                    }
                    attributes.put("dersler", dersler);
                    attributes.put("ogrenci", ogrenciler.get(0));
                    return new ModelAndView(attributes, "recepefemayoglu/ogrencigoruntule.ftl");
                }
            };
            get(ogrenciGoruntuleGet);

            FreeMarkerRoute dersGoruntuleGet = new FreeMarkerRoute("/dersgoruntule/:id") {
                public Object handle(Request req, Response resp) {
                    String ders_id = req.params("id");
                    Map<String, Object> attributes = new HashMap<>();
                    List<Ders> dersler = dersListesi.stream().filter(x->x.getId().equalsIgnoreCase(ders_id)).collect(Collectors.toList());
                    Ders ders = dersler.get(0);
                    attributes.put("ders",ders);
                    List<Ogrenci> ogrenciler = new ArrayList<>();
                    for (OgrenciDers ogrenciDers:ogrenciDersListesi){
                        if(ogrenciDers.getDersId().equalsIgnoreCase(ders.getId())){
                            List<Ogrenci> ogrenci = ogrenciListesi.stream().filter(x->x.getNumara().equalsIgnoreCase(ogrenciDers.getOgrenciNumara())).collect(Collectors.toList());
                            ogrenciler.add(ogrenci.get(0));
                        }
                    }
                    attributes.put("ogrenciler",ogrenciler);

                    return new ModelAndView(attributes, "recepefemayoglu/dersgoruntule.ftl");
                }
            };
            get(dersGoruntuleGet);

            FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil/:numara") {
                public Object handle(Request req, Response resp) {
                    String numara = req.params("numara");
                    try {
                        ogrenciSil(numara);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    resp.redirect("/ogrenciler");
                    return null;
                }
            };
            get(ogrenciSilGet);

            FreeMarkerRoute dersSilGet = new FreeMarkerRoute("/derssil/:id") {
                public Object handle(Request req, Response resp) {
                    String id = req.params("id");
                    try {
                        dersSil(id);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    resp.redirect("/dersler");
                    return null;
                }
            };
            get(dersSilGet);
        }
    }

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
    private static void gerekliTablolariOlustur() throws SQLException {
        try {
            veritabaniIfadesi.executeUpdate("Create table OgrenciTablosu (Ad varchar(50),Soyad varchar(50),Numara varchar(50),OgrenciTipiId varchar(20))");
        } catch(SQLException e) {

        }
        try {
            veritabaniIfadesi.executeUpdate("Create table DersTablosu (Ad varchar(50),Akts varchar(50),Id varchar(11))");
        } catch(SQLException e) {
        }
        try {
            veritabaniIfadesi.executeUpdate("Create table OgrenciDersTablosu (OgrenciNumara varchar(11), DersId varchar(11))");
        } catch(SQLException e) {

        }

    }
    private static void setOgrenciTablo(Ogrenci ogrenci) throws SQLException {
        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("insert into OgrenciTablosu(Ad,Soyad,Numara,OgrenciTipiId) VALUES (?,?,?,?)");
        stmt.setString(1, ogrenci.getAd());
        stmt.setString(2, ogrenci.getSoyad());
        stmt.setString(3, ogrenci.getNumara());
        stmt.setString(4, ogrenci.getOgrenciTipiId());
        stmt.executeUpdate();
    }

    private static void setDersTablo(Ders ders) throws SQLException {
        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("insert into DersTablosu(Ad,Akts,Id) VALUES (?,?,?)");
        stmt.setString(1, ders.getAd());
        stmt.setString(2, ders.getAkts());
        stmt.setString(3, ders.getId());
        stmt.executeUpdate();
    }

    private static void setOgrenciDersTablo(OgrenciDers ogrenciDers) throws SQLException {
        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("insert into OgrenciDersTablosu(OgrenciNumara,DersId) VALUES (?,?)");
        stmt.setString(1, ogrenciDers.getOgrenciNumara());
        stmt.setString(2, ogrenciDers.getDersId());
        stmt.executeUpdate();
    }

    private static void dersSil( String id) throws SQLException {
        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("delete from DersTablosu where Id=(?)");
        stmt.setString(1, id);
        stmt.executeUpdate();

        List<Ders> yeni_ders_listesi = new ArrayList<>();
        for (Ders ders:dersListesi)
            if (!ders.getId().equalsIgnoreCase(id))
                yeni_ders_listesi.add(ders);
        dersListesi = yeni_ders_listesi;
    }
    private static void ogrenciSil(String numara) throws SQLException {
        PreparedStatement stmt = veritabaniBaglantisi.prepareStatement("delete from OgrenciTablosu where Numara=(?)");
        stmt.setString(1, numara);
        stmt.executeUpdate();

        List<Ogrenci> yeni_ogrenci_listesi = new ArrayList<>();
        for (Ogrenci ogrenci:ogrenciListesi)
            if (!ogrenci.getNumara().equalsIgnoreCase(numara))
                yeni_ogrenci_listesi.add(ogrenci);
        ogrenciListesi = yeni_ogrenci_listesi;
    }
    private static void getOgrenciTablosu() throws SQLException {

        ResultSet response = veritabaniIfadesi.executeQuery("select * from OgrenciTablosu");
        List<Ogrenci> yeni_ogrenciler = new ArrayList<>();
        while (response.next()) {
            String ad = response.getString("Ad");
            String soyad = response.getString("Soyad");
            String numara = response.getString("Numara");
            String ogrenciTipiId = response.getString("OgrenciTipiId");
            Ogrenci ogrenci = new Ogrenci(ad,soyad,numara,ogrenciTipiId);
            yeni_ogrenciler.add(ogrenci);
        }
        ogrenciListesi = yeni_ogrenciler;

    }

    private static void getDersTablosu() throws SQLException {
        ResultSet response = veritabaniIfadesi.executeQuery("select * from  DersTablosu");
        List<Ders> yeni_dersler = new ArrayList<>();
        while (response.next()) {
            String ad = response.getString("Ad");
            String akts = response.getString("Akts");
            String id = response.getString("Id");
            Ders ders = new Ders(ad,akts,id);
            yeni_dersler.add(ders);
        }
        dersListesi = yeni_dersler;
    }

    private static void getOgrenciDersTablosu() throws SQLException {
        ResultSet response = veritabaniIfadesi.executeQuery("select * from OgrenciDersTablosu");
        List<OgrenciDers> yeni_ogrenci_ders = new ArrayList<>();
        while (response.next()) {
            String ogrenciNumara = response.getString("OgrenciNumara");
            String dersId = response.getString("DersId");
            OgrenciDers ogrenciDers = new OgrenciDers(ogrenciNumara,dersId);
            yeni_ogrenci_ders.add(ogrenciDers);
        }
        ogrenciDersListesi = yeni_ogrenci_ders;
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
}