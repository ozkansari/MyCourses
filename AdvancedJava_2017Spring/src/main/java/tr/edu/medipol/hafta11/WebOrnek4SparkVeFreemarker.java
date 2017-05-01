package tr.edu.medipol.hafta11;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import java.util.Map;

import tr.edu.medipol.hafta3.Ogrenci;

/*--
 * Programi calistirmak icin Maven projesi olusturun ve pom.xml dosyasina 
 *  asagidaki bagimliliklari (dependency) ekleyin:

     <dependency>
        <groupId>com.sparkjava</groupId>
        <artifactId>spark-core</artifactId>
        <version>2.5.5</version>
    </dependency>
    
    <dependency>
        <groupId>com.sparkjava</groupId>
        <artifactId>spark-template-freemarker</artifactId>
        <version>2.5.5</version>
    </dependency>
    
 *
 * Daha fazla bilgi: 
 *     http://sparkjava.com/documentation#getting-started
 *  http://freemarker.org/docs/ref_directive_list.html
 * 
 */
public class WebOrnek4SparkVeFreemarker {
    
    public static void main(String[] args) {
        
        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Ogrenci Bir", "On Lisans", "MYO"));
        ogrenciler.add(new Ogrenci("Ogrenci Iki", "On Lisans", "MYO"));
        ogrenciler.add(new Ogrenci("Ogrenci Uc", "On Lisans", "MYO"));
        
        // http://localhost:4567/ogrenciler
        get("/ogrenciler", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("ogrenciler", ogrenciler);
            return new ModelAndView(attributes, "ogrenciler.ftl"); // resources'daki ftl
        }, new FreeMarkerEngine());
        
        // http://localhost:4567/ogrenciekle
        get("/ogrenciekle", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("ogrenciler", ogrenciler);
            return new ModelAndView(attributes, "ogrenciekle.ftl"); // resources'daki ftl
        }, new FreeMarkerEngine());
        
        // http://localhost:4567/ogrenciekle
        post("/ogrenciekle", (request, response) -> {
            String adSoyad = request.queryParams("adSoyad");
            String ogrenciTipi = request.queryParams("ogrenciTipi");
            String bolum = request.queryParams("bolum");
            ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum));

            response.redirect("/ogrenciler");
            return null;
        });
        
    }
    
}
