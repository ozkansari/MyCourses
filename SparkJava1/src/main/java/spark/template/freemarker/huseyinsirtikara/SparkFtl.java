package spark.template.freemarker.huseyinsirtikara;
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
    public static List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
    public static List<Ders> dersler = new ArrayList<>();

    public static void main(String[] args) {
        
        ogrenciler.add(new Ogrenci("Ogrenci Bir", "On Lisans", "MYO",1));
        ogrenciler.add(new Ogrenci("Ogrenci Iki", "On Lisans", "MYO",2));
        ogrenciler.add(new Ogrenci("Ogrenci Uc", "On Lisans", "MYO",3));
        setPort(80);
        
        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "huseyinsirtikara/ogrenciler.ftl"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "huseyinsirtikara/ogrenciekle.ftl"); // resources'daki ftl
            }
        };
        get(ogrenciekleGet);
        
        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {
                
            	String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                int no = Integer.parseInt(istek.queryParams("no"));
                
                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,no));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "huseyinsirtikara/dersekle.ftl"); // resources'daki ftl
            }
        };
        get(dersekleGet);

        FreeMarkerRoute derseklePost= new FreeMarkerRoute("/dersekle") {
            public Object handle(Request istek, Response cevap) {

                String ders = istek.queryParams("ders");
                dersler.add(new Ders(ders));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/dersler");
                return null;
            }
        };
        post(derseklePost);

        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", dersler);
                return new ModelAndView(attributes, "huseyinsirtikara/dersler.ftl"); // resources'daki ftl
            }
        };
        get(derslerGet);


        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:no") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("no");
                // Ogrenciyi bul
                Ogrenci bulunan = null;
                for (Ogrenci ogrenci:ogrenciler){
                    if (ogrenci.ogrenciNumara == Integer.parseInt(ogrenciNo)){
                        Map<String, Object> attributes = new HashMap<>();
                        attributes.put("ogrenci", ogrenci);
                        return new ModelAndView(attributes, "huseyinsirtikara/ogrenci.ftl");
                    }
                }
            return null;
            }
        };
        get(ogrenciGoruntule);
        
        FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil/:no") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("no");
                
                // Ogrenciyi bul
                 for (Ogrenci ogrenci:ogrenciler){
                    if (ogrenci.ogrenciNumara == Integer.parseInt(ogrenciNo)){
                        ogrenciler.remove(ogrenci);
                    }
                }
                 // belirtilen uri'ye yonlendir.
                resp.redirect("/ogrenciler");
                return null;
            }
        };
        get(ogrenciSil);
    }
}











