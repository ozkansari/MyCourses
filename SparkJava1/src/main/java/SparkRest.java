import static spark.Spark.*;

import java.util.ArrayList;

import spark.*;
import com.google.gson.*;
import java.util.*;

/*--
 *  Programi calistirmak icin Maven projesi olusturun ve pom.xml dosyasina 
 *  asagidaki bagimliliklari (dependency) ekleyin:
 
        <dependency>
            <groupId>com.sparkjava</groupId>
            <artifactId>spark-core</artifactId>
            <version>1.1.1</version>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.6.2</version>
        </dependency>
 */
public class SparkRest {
    public static void main(String[] args) { /* localhost:4567/hello */
        // setPort(80);
        Route route = new Route("/hello") {
            public Object handle(Request req, Response resp) {
                return "hello";
            }
        };
        get(route);

        Route route2 = new Route("/hello2/:isim") {
            public Object handle(Request req, Response resp) {
                return "hello" + req.params("isim");
            }
        };
        get(route2);

        final Gson helper = new GsonBuilder().setPrettyPrinting().create();
        Route route3 = new Route("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                resp.type("application/json");
                List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
                ogrenciler.add(new Ogrenci("Mustafa", "On Lisans", "MYO"));
                ogrenciler.add(new Ogrenci("Gorkem", "On Lisans", "MYO"));
                ogrenciler.add(new Ogrenci("Funda", "On Lisans", "MYO"));
                return helper.toJson(ogrenciler);
            }
        };
        get(route3);

    }

}
