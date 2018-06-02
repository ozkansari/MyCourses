package spark.template.freemarker.mustafacumhur_oksuz;



// spark-core lib
import static spark.Spark.get;
import static spark.Spark.post;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// java standart utilility lib
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// gson lib
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
// spark-template-freemarker lib
import spark.template.freemarker.FreeMarkerRoute;

public class KitapSitesiMain {

    private static final String VERITABANI_DIZINI =
            ".\\.cumhuroksuz\\veritabani\\";

    private static final String VERITABANI_URL =
            "jdbc:derby:" + VERITABANI_DIZINI + ";create=true";

    private static final List<Kitap> kitaplar = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Veritabani URL'i " + VERITABANI_URL);


        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(VERITABANI_URL);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.out.println("Veritabanina baglanirken hata olustu: " + VERITABANI_URL );
            e.printStackTrace();
            return;
        }

        final Statement stmt;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Veritabani ifadesi olustururken hata: " + VERITABANI_URL );
            e.printStackTrace();
            return;
        }


        String kitapTabloAdi = "kitaplar";
        try {
            stmt.executeUpdate(
                    "CREATE TABLE " + kitapTabloAdi +
                            " (" +
                            "kitap_id int primary key, " +
                            "kitap_adi varchar(30)," +
                            "yazar_adi varchar(30)," +
                            "yazar_soyadi varchar(30)" +
                            ")"
            );
            System.out.println("Tablo " + kitapTabloAdi + " olusturuldu");


            kitaplar.add( new Kitap("Yuzuk Kardesligi", "J.R.R", "Tolkien"));
            kitaplar.add(new Kitap("Iki kule", "J.R.R", "Tolkien"));
            kitaplar.add(new Kitap("Kralin Donusu", "J.R.R", "Tolkien"));

            for (int i = 0; i < kitaplar.size(); i++) {
                Kitap k = kitaplar.get(i);
                kayitekle(stmt, kitapTabloAdi,
                        k.getKitapAdi(),
                        k.getYazar().getYazarAdi(),
                        k.getYazar().getYazarSoyadi(),
                        i+1);

            }

        } catch (Exception e) {

            System.out.println("Tablo " + kitapTabloAdi + " zaten mevcut " + e.getMessage());
        }


        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + kitapTabloAdi);
            while (rs.next()) {
                int kitap_id = rs.getInt("kitap_id");
                String kitap_adi = rs.getString("kitap_adi");
                String yazar_adi = rs.getString("yazar_adi");
                String yazar_soyadi = rs.getString("yazar_soyadi");
                kitaplar.add( new Kitap(kitap_adi, yazar_adi, yazar_soyadi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        Route sayfa1 = new Route("/cumhuroksuz/merhaba") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);


        FreeMarkerRoute anasayfa = new FreeMarkerRoute("/cumhuroksuz/") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/cumhuroksuz/index.html");
            }
        };
        get(anasayfa);



        Route sayfa2 = new Route("/cumhuroksuz/kitaplar/json") {
            public Object handle(Request istek, Response cevap) {
                Gson jsonYardimci = new GsonBuilder().setPrettyPrinting().create();
                return jsonYardimci.toJson(kitaplar);
            }
        };
        get(sayfa2);



        FreeMarkerRoute kitaplarHtmlSayfa = new FreeMarkerRoute("/cumhuroksuz/kitaplar/html") {
            public Object handle(Request istek, Response cevap) {
                Map<String, Object> ozellikler = new HashMap<>();
                ozellikler.put("kitaplar", kitaplar);
                // Object kitaplarMap = ozellikler.get("kitaplar");
                return new ModelAndView(ozellikler, "/cumhuroksuz/kitaplar.html");
            }
        };
        get(kitaplarHtmlSayfa);


        FreeMarkerRoute kitaplarEkleHtmlSayfa = new FreeMarkerRoute("/cumhuroksuz/kitaplar/ekle/html") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/cumhuroksuz/kitaplar_ekle.html");
            }
        };
        get(kitaplarEkleHtmlSayfa);



        Route kitaplarEklePost = new Route("/cumhuroksuz/kitaplar/ekle/post") {
            public Object handle(Request istek, Response cevap) {
                String kitapAdi = istek.queryParams("kitapadi");
                String yazarAdi = istek.queryParams("yazaradi");
                String yazarSoyadi = istek.queryParams("yazarsoyadi");
                kitaplar.add(new Kitap(kitapAdi, yazarAdi, yazarSoyadi));

                int id = kitaplar.size();


                kayitekle(stmt, kitapTabloAdi, kitapAdi, yazarAdi, yazarSoyadi, id);

                cevap.redirect("/cumhuroksuz/kitaplar/html");
                return null;
            }
        };
        post(kitaplarEklePost);


        FreeMarkerRoute yazarlarHtmlSayfa = new FreeMarkerRoute("/cumhuroksuz/yazarlar/html") {

            @Override
            public Object handle(Request request, Response response) {

                List<Yazar> yazarListesi = new ArrayList<>();
                for (Kitap kitap : kitaplar) {
                    yazarListesi.add(kitap.getYazar());
                }


                Map<String,Object> ozellikler = new HashMap<>() ;
                ozellikler.put("yazarListesi", yazarListesi);
                return new ModelAndView(ozellikler , "/cumhuroksuz/yazarlar.html");
            }
        };
        get(yazarlarHtmlSayfa);



// ********************************************
// OZKANS DUZELTME
//   FreeMarkerRoute sepetHtmlSayfa = new FreeMarkerRoute ("/cumhuroksuz/sepet/html"){
//       List<Sepet> Sepetim = new ArrayList<>();
//               for (Kitap kitap : kitaplar) {
//           Sepetim.add(kitap.getYazar());
//        }
//    }
// ********************************************

    }



    private static void kayitekle(final Statement stmt, String kitapTabloAdi, String kitapAdi, String yazarAdi,
                                  String yazarSoyadi, int id) {
        try {
            stmt.executeUpdate(
                    "INSERT INTO " + kitapTabloAdi + " VALUES ("
                            +  id + " ,"
                            +  "\'"+ kitapAdi + "\',"
                            +  "\'"+ yazarAdi + "\',"
                            +  "\'"+ yazarSoyadi + "\'"
                            + ")"
            );
            System.out.println("Kayit eklendi");
        } catch(Exception e) {
            System.out.println("Kayit zaten mevcut. Hata: " + e.getMessage());
        }
    }


}