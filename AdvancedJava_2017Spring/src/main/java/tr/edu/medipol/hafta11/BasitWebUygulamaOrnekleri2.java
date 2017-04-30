package tr.edu.medipol.hafta11;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.List;

import spark.Request;
import tr.edu.medipol.hafta3.Ogrenci;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
public class BasitWebUygulamaOrnekleri2 {
	
	private static final Gson JSON_HELPER = new GsonBuilder().setPrettyPrinting().create();
	
    public static void main(String[] args) {
    	
    	List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
    	ogrenciler.add(new Ogrenci("Ogrenci Bir", "On Lisans", "MYO"));
    	ogrenciler.add(new Ogrenci("Ogrenci Iki", "On Lisans", "MYO"));
    	ogrenciler.add(new Ogrenci("Ogrenci Uc", "On Lisans", "MYO"));
    	
    	get("/ogrenciler", (request, response) -> {
    	    if (shouldReturnHtml(request)) {
    	    	// http://localhost:4567/ogrenciler
    	        String ogrencilerHtml = "";
    	        for (Ogrenci ogrenci : ogrenciler) {
    	        	ogrencilerHtml += "<li>" + ogrenci.ogrenciBilgileriAl() + "</li>\n";
				}
				return 
    	        		"<html>\n" + 
    	        			"<head><title>Ogrenciler</title></head>\n" +
    	        			"<body>\n" + 
    	        				"<ul>\n" +
    	        					ogrencilerHtml  +
    	        				"</ul>\n" +
    	        			"</body>\n" +
    	        		"</html>\n";
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
