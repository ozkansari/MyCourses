package spark.template.freemarker.ozkansari;

// spark-core lib
import static spark.Spark.get;
import static spark.Spark.post;

// java standart utilility lib
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// gson lib
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
// spark-template-freemarker lib
import spark.template.freemarker.FreeMarkerRoute;

public class KitapSitesiMain {

	public static void main(String[] args) {

		List<Kitap> kitaplar = new ArrayList<>();
    	kitaplar.add( new Kitap("Simyaci", "Paulo", "Coelho"));
    	kitaplar.add(new Kitap("Kurk Mantolu Madonna", "Sabahattin", "Ali"));
    	kitaplar.add(new Kitap("Incognito", "Joe", "Doe"));
    	
		// http://localhost:4567/ozkansari/
        Route sayfa1 = new Route("/ozkansari/merhaba") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);
        
        /* ----------------------------------------------------------------- */
        /* ANASAYFA */
        /* ----------------------------------------------------------------- */
        // http://localhost:4567/ozkansari/
        FreeMarkerRoute anasayfa = new FreeMarkerRoute("/ozkansari/") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/ozkansari/index.html");
            }
        };
        get(anasayfa);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR JSON SERVISI */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/ozkansari/kitaplar/json
        Route sayfa2 = new Route("/ozkansari/kitaplar/json") {
            public Object handle(Request istek, Response cevap) {
            	Gson jsonYardimci = new GsonBuilder().setPrettyPrinting().create();
				return jsonYardimci.toJson(kitaplar);
            }
        };
        get(sayfa2);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR HTML SAYFA (GET) */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/ozkansari/kitaplar/html
        FreeMarkerRoute kitaplarHtmlSayfa = new FreeMarkerRoute("/ozkansari/kitaplar/html") {
            public Object handle(Request istek, Response cevap) {
            	Map<String, Object> ozellikler = new HashMap<>();
                ozellikler.put("kitaplar", kitaplar);
                // Object kitaplarMap = ozellikler.get("kitaplar");
                return new ModelAndView(ozellikler, "/ozkansari/kitaplar.html");
            }
        };
        get(kitaplarHtmlSayfa);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR EKLE HTML (GET) */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/kitaplar/ekle/html
        FreeMarkerRoute kitaplarEkleHtmlSayfa = new FreeMarkerRoute("/ozkansari/kitaplar/ekle/html") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/ozkansari/kitaplar_ekle.html");
            }
        };
        get(kitaplarEkleHtmlSayfa);
        
        /* ----------------------------------------------------------------- */
        /* KITAPLAR EKLE HTMLDEN CAGRILAN POST ISTEGI (Bkz. kitaplar_ekle.html) */
        /* ----------------------------------------------------------------- */
        
        Route kitaplarEklePost = new Route("/ozkansari/kitaplar/ekle/post") {
            public Object handle(Request istek, Response cevap) {
            	String kitapAdi = istek.queryParams("kitapadi"); 
            	String yazarAdi = istek.queryParams("yazaradi"); 
            	String yazarSoyadi = istek.queryParams("yazarsoyadi"); 
            	kitaplar.add(new Kitap(kitapAdi, yazarAdi, yazarSoyadi));

                cevap.redirect("/ozkansari/kitaplar/html");
                return null;
            }
        };
        post(kitaplarEklePost);
        
        /* ----------------------------------------------------------------- */
        /* YAZARLAR HTML (GET) */
        /* ----------------------------------------------------------------- */
        
        // http://localhost:4567/yazarlar/html
        FreeMarkerRoute yazarlarHtmlSayfa = new FreeMarkerRoute("/ozkansari/yazarlar/html") {
			
			@Override
			public Object handle(Request request, Response response) {
				
				List<Yazar> yazarListesi = new ArrayList<>();
				for (Kitap kitap : kitaplar) {
					yazarListesi.add(kitap.getYazar());
				}
				
				// Ekstra bilgi. Java 8 Fonksiyonel Programlama
				// kitaplar.forEach( k -> yazarListesi.add(k.getYazar()));
				
				Map<String,Object> ozellikler = new HashMap<>() ;
				ozellikler.put("yazarListesi", yazarListesi);
				return new ModelAndView(ozellikler , "/ozkansari/yazarlar.html");
			}
		};
		get(yazarlarHtmlSayfa);
		
        
	}

	
	
	
}
