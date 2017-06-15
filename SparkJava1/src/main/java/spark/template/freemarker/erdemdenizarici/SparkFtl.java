package spark.template.freemarker.erdemdenizarici;



/*
 * Yararlandığım yerler sadece bizim derste yaptıklarımzızı aldım.*/

import static spark.Spark.*;

import java.sql.*;
import java.util.*;

import spark.*;
import spark.template.freemarker.*;

/*--
 * Programi calistirmak icin Maven projesi olusturun ve pom.xml dosyasina
 *  asagidaki bagimliliklari (dependency) ekleyin:

        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-core</artifactId>
            <version>1.1.1</version>
        </dependency>
        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-template-freemarker</artifactId>
            <version>1.0</version>
        </dependency>

 */
public class SparkFtl {

    /*--
     * http://taywils.me/2013/11/05/javasparkframeworktutorial/
     */
    public static void main(String[] args) {
    	

        final List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Erdem Deniz Arici", "On Lisans", "MYO","1"));
        ogrenciler.add(new Ogrenci("Can Cevik", "Yuksek Lisans", "Muhendislik","2"));
        ogrenciler.add(new Ogrenci("Ferit Ceri", "Lisans", "Tip","3"));
        
        final List<Ders> dersler = new ArrayList<Ders>();
        dersler.add(new Ders("Ileri Java", "Bolum Dersi", "MYO", "1"));
        dersler.add(new Ders("Matematik", "Genel Ders", "Tum Bolumler", "2"));
        dersler.add(new Ders("Anatomi", "Bolum Dersi", "Tip", "3"));

        setPort(1234);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "erdemdenizarici/ogrenciler.html"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("dersler", dersler);
                return new ModelAndView(attributes, "erdemdenizarici/dersler.html"); // resources'daki ftl
            }
        };
        get(derslerGet);
        
        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "erdemdenizarici/dersekle.html"); // resources'daki ftl
            }
        };
        get(dersekleGet);
        
        FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request istek, Response cevap) {

                String dersAdi = istek.queryParams("dersAdi");
                String dersTipi = istek.queryParams("dersTipi");
                String bolum = istek.queryParams("bolum");
                String dersNo = istek.queryParams("dersNo");


                dersler.add(new Ders(dersAdi, dersTipi, bolum,dersNo));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/dersler");
                return null;
            }
        };
        post(derseklePost);

        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "erdemdenizarici/ogrencisil.html"); // resources'daki ftl
            }
        };
        get(ogrenciSilGet);


        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "erdemdenizarici/ogrenciekle.html"); // resources'daki ftl
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {

                String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                String numara = istek.queryParams("numara");


               	ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,numara));
               	
                // belirtilen uri'ye yonlendir.
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");

                // Ogrenciyi bul
                Ogrenci bulunan = null;

                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("ogrenci", bulunan);

                return new ModelAndView(attributes, "erdemdenizarici/ogrenci.html");
            }
        };
        get(ogrenciGoruntule);




    FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil") {
        public Object handle(Request req, Response resp) {
            String ogrenciNo = req.queryParams("ogrencino");

            // Ogrenciyi bul

            try{
                Ogrenci bulunan = null;
                for (Ogrenci ogr :ogrenciler){
                    if (ogr.ogrenciNo.equals(ogrenciNo)){
                        ogrenciler.remove(ogr);
                    }
                }
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            //ogrenciler.remove(bulunan);

           // Map<String, Object> attributes = new HashMap<>();
           // attributes.put("ogrenci", bulunan);

            // belirtilen uri'ye yonlendir.
            resp.redirect("/ogrenciler");
            return null;
        }
    };
    post(ogrenciSil);
}
}



