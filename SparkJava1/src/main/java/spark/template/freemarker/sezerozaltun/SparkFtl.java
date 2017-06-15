package spark.template.freemarker.sezerozaltun;
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
        
        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("", "", "","" ));
        // setPort(80); 
        
        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "sezerozaltun/ogrenciler2.ftl"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sezerozaltun/ogrenciekle2.ftl"); // resources'daki ftl
            }
        };
        get(ogrenciekleGet);
        
        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {
            	
            	String ogrenciNo = istek.queryParams("ogrenciNo");
            	String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
               
                
                
                ogrenciler.add(new Ogrenci(ogrenciNo,adSoyad, ogrenciTipi, bolum));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);
        
        /*
        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");
                
                // Ogrenciyi bul
                Ogrenci bulunan = null;
                
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);
                
                return new ModelAndView(attributes, "ogrenciler.ftl");
            }
        };
        get(ogrenciGoruntule);
        
        FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");
                
                // Ogrenciyi bul
                Ogrenci bulunan = null;
                ogrenciler.remove(bulunan);
                
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);
                
                // belirtilen uri'ye yonlendir.
                resp.redirect("/ogrenciler");
                return null;
            }
        };
        get(ogrenciSil);
        */
        
        FreeMarkerRoute ogrencisilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sezerozaltun/ogrencisil2.ftl"); // resources'daki ftl
            }
        };
        get(ogrencisilGet);
        
        
        
        FreeMarkerRoute ogrencisilPost = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request istek, Response cevap) {
                
            	String ogrenciNo = istek.queryParams("ogrenciNo");
            	Ogrenci bulunan = null;
                ogrenciler.remove(bulunan);
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencisilPost);
        
        
        
        
        List<Ders> dersler = new ArrayList<Ders>();
        dersler.add(new Ders("", "", ""));
        // setPort(80); 
        
        FreeMarkerRoute derslerGet = new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", dersler);
                return new ModelAndView(attributes, "sezerozaltun/dersler2.ftl"); // resources'daki ftl
            }
        };
        get(derslerGet);
        
        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sezerozaltun/dersekle2.ftl"); // resources'daki ftl
            }
        };
        get(dersekleGet);
        
        FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request istek, Response cevap) {
            	
            	String dersNo =   istek.queryParams("dersNo");
            	String dersAdi = istek.queryParams("dersAdi");
                String dersTipi = istek.queryParams("dersTipi");
               
            
               
                
                
                dersler.add(new Ders(dersNo, dersAdi, dersTipi));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/dersler");
                return null;
            }
        };
        post(derseklePost);
        
        
        
        
        FreeMarkerRoute derssilGet = new FreeMarkerRoute("/derssil") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "sezerozaltun/derssil2.ftl"); // resources'daki ftl
            }
        };
        get(derssilGet);
        
        
        
        FreeMarkerRoute derssilPost = new FreeMarkerRoute("/derssil") {
            public Object handle(Request istek, Response cevap) {
                
            	String dersNo = istek.queryParams("dersNo");
            	Ders bulunan = null;
                dersler.remove(bulunan);
   

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/dersler");
                return null;
            }
        };
        post(derssilPost);
        
        
    }

    
    
}











