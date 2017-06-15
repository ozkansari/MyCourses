package spark.template.freemarker.sefaokuyucu;

import static spark.Spark.*;

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
        final List<Ogrenci> dersler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Sefa Okuyucu", "On Lisans", "MYO","1"));
        ogrenciler.add(new Ogrenci("Remzi Bayraktar", "Doktora", "DOKTORA","2"));
        ogrenciler.add(new Ogrenci("Mehmet Ýnönü", "On Lisans", "MYO","3"));
        	
        dersler.add(new Ogrenci("Java"));
        // setPort(3452);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "sefaokuyucu/ogrenciler.html"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);

        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "sefaokuyucu/ogrencisil.html"); // resources'daki ftl
            }
        };
        get(ogrenciSilGet);
        
        FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersEkle") {
            public Object handle(Request req, Response resp) {
                
                String ders = req.queryParams("ders");               
                dersler.add(new Ogrenci(ders));         
                resp.redirect("/dersListesi");
                return null;
            }
        };
        
        post(derseklePost);
        
        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersEkle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sefaokuyucu/dersEkle.html"); 
            }
        };
        get(dersekleGet);
        
        FreeMarkerRoute derslistesiGet = new FreeMarkerRoute("/dersListesi") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", dersler);
                return new ModelAndView(attributes, "sefaokuyucu/dersListesi.html"); 
            }
        };
        get(derslistesiGet);

        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sefaokuyucu/ogrenciekle.html"); // resources'daki ftl
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

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);

                return new ModelAndView(attributes, "sefaokuyucu/ogrenci.html");
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


