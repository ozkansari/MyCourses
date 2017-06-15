package spark.template.freemarker.firatkoc;
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
    public static List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
    public static List<Ders> dersler = new ArrayList<>();

    public static void main(String[] args) {

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "firatkoc/ogrenciler.ftl"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "firatkoc/ogrenciekle.ftl"); // resources'daki ftl
            }
        };
        get(ogrenciekleGet);
        
        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {
            	String adSoyad = istek.queryParams("adSoyad");
                String bolum = istek.queryParams("bolum");
                Ogrenci ogrenci = new Ogrenci(adSoyad,bolum);
                ogrenciler.add(ogrenci);
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {

                return new ModelAndView(null, "firatkoc/dersekle.ftl"); // resources'daki ftl
            }
        };
        get(dersekleGet);

        FreeMarkerRoute derseklePost= new FreeMarkerRoute("/dersekle") {
            public Object handle(Request istek, Response cevap) {
                String ad = istek.queryParams("dersAd");
                String akts = istek.queryParams("dersAkts");
                Ders ders = new Ders(ad,akts);
                dersler.add(ders);
                cevap.redirect("/dersler");
                return null;
            }
        };
        post(derseklePost);

        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", dersler);

                return new ModelAndView(attributes, "firatkoc/dersler.ftl"); // resources'daki ftl
            }
        };
        get(derslerGet);

        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrencidetay/:adSoyad") {
            public Object handle(Request req, Response resp) {
                String adSoyad = req.params("adSoyad");
                Ogrenci bul = null;
                for (Ogrenci ogrenci:ogrenciler){
                    if (ogrenci.adSoyad.equals(adSoyad)){
                        bul = ogrenci;
                        break;
                    }
                }
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bul);

                return new ModelAndView(attributes, "firatkoc/ogrencidetay.ftl");

            }
        };
        get(ogrenciGoruntule);
        
        FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil/:adSoyad") {
            public Object handle(Request req, Response resp) {
                String adSoyad = req.params("adSoyad");
                
                Ogrenci bul = null;
                 for (Ogrenci ogrenci:ogrenciler)
                    if (ogrenci.adSoyad.equals(adSoyad))
                        bul = ogrenci;

                ogrenciler.remove(bul);
                resp.redirect("/ogrenciler");
                return null;
            }
        };
        get(ogrenciSil);
    }
}