package spark.template.freemarker.filizdagdeviren;
import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;

public class Sparkftl {
	 public static void main(String[] args) {
	        
	        final List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
	        ogrenciler.add(new Ogrenci("Ogrenci Bir", "Lisans", "Pc", "Lisans", "Pc"));
	        ogrenciler.add(new Ogrenci("Ogrenci Iki", "123", "On Lisans", "MYO", "MYO"));
	        ogrenciler.add(new Ogrenci("Ogrenci Uc","456", "On Lisans", "MYO", "MYO"));
	        
	        // setPort(80);
	        
	        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
	            public Object handle(Request req, Response resp) {
	                Map<String, Object> attributes = new HashMap<>();
	                attributes.put("ogrenciler", ogrenciler);
	                return new ModelAndView(attributes, "filizdagdeviren/ogrenciler.ftl"); // resources'daki ftl
	            }
	        };
	        get(ogrencilerGet);
	        
	        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
	            public Object handle(Request req, Response resp) {
	                return new ModelAndView(null, "filizdagdeviren/ogrenciekle.ftl"); // resources'daki ftl
	            }
	        };
	        get(ogrenciekleGet);
	        
	        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
	            public Object handle(Request istek, Response cevap) {
	                
	            	String adSoyad = istek.queryParams("adSoyad");
	                String ogrenciTipi = istek.queryParams("ogrenciTipi");
	                String ogrenciNo = istek.queryParams("ogrenciNo");
	                String ogrenciTipiId = istek.queryParams("ogrenciTipiId");
	                String bolum = istek.queryParams("bolum");
	                
	                
	                ogrenciler.add(new Ogrenci(adSoyad,ogrenciTipi, ogrenciNo, ogrenciTipiId, bolum));

	                // belirtilen uri'ye yonlendir.
	                cevap.redirect("/ogrenciler");
	                return null;
	            }
	        };
	        post(ogrencieklePost);
	        
	        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
	            public Object handle(Request req, Response resp) {
	                String ogrenciNo = req.params("ogrencino");
	                
	                // Ogrenciyi bul
	                Ogrenci bulunan = null;
	                
	                Map<String, Object> attributes = new HashMap<>();
	                attributes.put("ogrenci", bulunan);
	                
	                return new ModelAndView(attributes, "filizdagdeviren/ogrenci.ftl");
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
	    }
}
