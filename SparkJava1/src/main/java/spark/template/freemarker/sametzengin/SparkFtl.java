package spark.template.freemarker.sametzengin;
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
        final List<Ders> dersler = new ArrayList<Ders>();
        ogrenciler.add(new Ogrenci("Samet Zengin", "Yüksek Lisans", "HUKUK","1"));
        ogrenciler.add(new Ogrenci("Burak Kaya", "Meslek Yüksek Okulu", "TIP","2"));


        dersler.add(new Ders("İleri Java Uygulamaları",  "1235"));
        dersler.add(new Ders("Android Ugulamalar",  "1245"));

        setPort(1996);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "sametzengin/ogrenciler.html"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", dersler);
                return new ModelAndView(attributes, "sametzengin/dersler.html"); // resources'daki ftl
            }
        };
        get(derslerGet);


        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "sametzengin/ogrencisil.html"); // resources'daki ftl
            }
        };
        get(ogrenciSilGet);


        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sametzengin/dersekle.html"); // resources'daki ftl
            }
        };
        get(dersekleGet);

        FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request istek, Response cevap) {

                String dersAdi = istek.queryParams("dersAdi");
                String dersId = istek.queryParams("dersId");

                dersler.add(new Ders(dersAdi, dersId));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/dersler");
                return null;
            }
        };
        post(derseklePost);


        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sametzengin/ogrenciekle.html"); // resources'daki ftl
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

                return new ModelAndView(attributes, "sametzengin/ogrenci.html");
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


        FreeMarkerRoute dersSilGet = new FreeMarkerRoute("/derssil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", dersler);
                return new ModelAndView(attributes, "sametzengin/derssil.html"); // resources'daki ftl
            }
        };
        get(dersSilGet);

        FreeMarkerRoute dersSil = new FreeMarkerRoute("/derssil") {
            public Object handle(Request req, Response resp) {
                String dersId = req.queryParams("dersId");

                // Ogrenciyi bul

                try{
                    Ogrenci bulunan = null;
                    for (Ders drs :dersler){
                        if (drs.dersId.equals(dersId)){
                            dersler.remove(drs);
                        }
                    }
                }
                catch (Exception ex){
                    System.out.println(ex.getMessage());
                }

                resp.redirect("/dersler");
                return null;
            }
        };
        post(dersSil);

}
}


