package com.medipol.ilerijava;

// spark-core lib
import static spark.Spark.*;
import spark.*;
// spark-template-freemarker lib
import spark.template.freemarker.*;
// gson lib
import com.google.gson.*;
// java standart utilility lib
import java.util.*;

public class KitapSitesiMain {

	public static void main(String[] args) {

		List<Kitap> kitaplar = new ArrayList<>();
    	kitaplar.add( new Kitap("Simyaci", "Paulo", "Coelho"));
    	kitaplar.add(new Kitap("Kurk Mantolu Madonna", "Sabahattin", "Ali"));
    	kitaplar.add(new Kitap("Incognito", "Joe", "Doe"));
    	
		// http://localhost:4567/
        Route sayfa1 = new Route("/") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);
        
        // http://localhost:4567/kitaplar/json
        Route sayfa2 = new Route("/kitaplar/json") {
            public Object handle(Request istek, Response cevap) {
            	Gson jsonYardimci = new GsonBuilder().setPrettyPrinting().create();
				return jsonYardimci.toJson(kitaplar);
            }
        };
        get(sayfa2);
        
        // http://localhost:4567/kitaplar/html
        FreeMarkerRoute kitaplarHtmlSayfa = new FreeMarkerRoute("/kitaplar/html") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<>();
                ozellikler.put("kitaplar", kitaplar);
                // Object kitaplarMap = ozellikler.get("kitaplar");
                return new ModelAndView(ozellikler, "kitaplar.html");
            }
        };
        get(kitaplarHtmlSayfa);
        
        // http://localhost:4567/kitaplar/ekle/html
        FreeMarkerRoute kitaplarEkleHtmlSayfa = new FreeMarkerRoute("/kitaplar/ekle/html") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "kitaplar_ekle.html");
            }
        };
        get(kitaplarEkleHtmlSayfa);
        
        Route kitaplarEklePost = new Route("/kitaplar/ekle/post") {
            public Object handle(Request istek, Response cevap) {
            	String kitapAdi = istek.queryParams("kitapadi"); 
            	String yazarAdi = istek.queryParams("yazaradi"); 
            	String yazarSoyadi = istek.queryParams("yazarsoyadi"); 
            	kitaplar.add(new Kitap(kitapAdi, yazarAdi, yazarSoyadi));

                cevap.redirect("/kitaplar/html");
                return null;
            }
        };
        post(kitaplarEklePost);
        
	}

	
	
	
}
