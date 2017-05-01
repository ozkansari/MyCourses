package tr.edu.medipol.hafta11;

import static spark.Spark.*;
import static j2html.TagCreator.*;
import spark.*;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.0</version>
    </dependency>
    
    <dependency>
        <groupId>com.j2html</groupId>
        <artifactId>j2html</artifactId>
        <version>0.99</version>
    </dependency>

 *
 * Daha fazla bilgi: 
 *     http://sparkjava.com/documentation#getting-started
 *  https://j2html.com/
 * 
 */
public class WebOrnek3SparkVeGsonVeJ2html {
    
    private static final Gson JSON_HELPER = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        
        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Ogrenci Bir", "On Lisans", "MYO"));
        ogrenciler.add(new Ogrenci("Ogrenci Iki", "On Lisans", "MYO"));
        ogrenciler.add(new Ogrenci("Ogrenci Uc", "On Lisans", "MYO"));
        
        get("/ogrenciler", (request, response) -> {
            if (shouldReturnHtml(request)) {
                // http://localhost:4567/ogrenciler
                return body().with(
                        h1("Ogrenciler"), 
                        div().with(
                                ul().with( 
                                        ogrenciler.stream().map( (o) -> li(o.ogrenciBilgileriAl())).collect(Collectors.toList())
                                )
                            )
                        )
                        .render();
            } else {
                
                // http://localhost:4567/ogrenciler?json=true
                response.type("application/json");
                return JSON_HELPER.toJson(ogrenciler);
            }
        });
        
    }
    
    /**
     * istegin headerina gore istek html mi degil mi kontrol eder
     * 
     * @param request html request objesi
     * @return html ise true, json ise false doner
     */
     private static boolean shouldReturnHtml(Request request) {
         String accept = request.headers("Accept");
         if (request.queryMap().hasKey("json")) {
             return false;
         }
         if (accept != null && accept.contains("text/html")) {
             return true;
         }
         return false;
     }
}
