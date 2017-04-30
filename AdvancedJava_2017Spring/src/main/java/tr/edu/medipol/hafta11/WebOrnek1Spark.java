package tr.edu.medipol.hafta11;

import static spark.Spark.*;
import com.google.gson.*;
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
		
 *
 * Daha fazla bilgi: http://sparkjava.com/documentation#getting-started
 * 
 */
public class WebOrnek1Spark {
	
	private static final Gson JSON_HELPER = new Gson();
	// private static final Gson JSON_HELPER = new GsonBuilder().setPrettyPrinting().create();
	
    public static void main(String[] args) {
    	
    	port(4567); // default port, belirtmesek de olur
    	
    	// http://localhost:4567/ornek1
        get("/ornek1", (request, response) -> "Merhaba Web!");
        
        // http://localhost:4567/ornek2/Ahmet
		get("/ornek2/:isim", (request, response) -> {
			return "Merhaba " + request.params(":isim");
		});
        
        // http://localhost:4567/ornek3
        get("/ornek3", (request, response) -> {
			response.type("application/json");
            return JSON_HELPER.toJson(new Ogrenci("Zihni Sinir", "On Lisans", "MYO"));
		});
        
    }
}
