package spark.template.freemarker.kerimbiber;

import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;

public class SparkFtl {
	    public static void main(String[] args) {

	        final List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();

	        // setPort(6161);

	        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
	            public Object handle(Request req, Response resp) {
	                Map<String, Object> attributes = new HashMap<String, Object>();
	                attributes.put("ogrenciler", ogrenciler);
	                return new ModelAndView(attributes, "kerimbiber/ogrenciler.html");
	            }
	        };
	        get(ogrencilerGet);

	        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrenci_sil") {
	            public Object handle(Request req, Response resp) {
	                Map<String, Object> attributes = new HashMap<String, Object>();
	                attributes.put("ogrenciler", ogrenciler);
	                return new ModelAndView(attributes, "kerimbiber/ogrenci_sil.html");
	            }
	        };
	        get(ogrenciSilGet);


	        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenci_ekle") {
	            public Object handle(Request req, Response resp) {
	                return new ModelAndView(null, "kerimbiber/ogrenci_ekle.html");
	            }
	        };
	        get(ogrenciekleGet);

	        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenci_ekle") {
	            public Object handle(Request istek, Response cevap) {

	                String adSoyad = istek.queryParams("adSoyad");
	                String ogrenciTipi = istek.queryParams("ogrenciTipi");
	                String bolum = istek.queryParams("bolum");
	                String numara = istek.queryParams("numara");



	                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,numara));

	          
	                cevap.redirect("/ogrenciler");
	                return null;
	            }
	        };
	        post(ogrencieklePost);

	        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
	            public Object handle(Request req, Response resp) {
	                String ogrenciNo = req.params("ogrencino");

	                
	                Ogrenci bulunan = null;

	                Map<String, Object> attributes = new HashMap<String, Object>();
	                attributes.put("ogrenci", bulunan);

	                return new ModelAndView(attributes, "kerimbiber/ogrenci.html");
	            }
	        };
	        get(ogrenciGoruntule);




	    FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrenci_sil") {
	        public Object handle(Request req, Response resp) {
	            String ogrenciNo = req.queryParams("ogrencino");

	          

	            try{
	                Ogrenci bulunan = null;
	                for (Ogrenci ogr :ogrenciler){
	                    if (ogr.ogrenciNo.equals(ogrenciNo)){
	                        ogrenciler.remove(ogr);
	                    }
	                }
	            }
	            catch (Exception ex){
	                System.out.println(ex.getMessage());
	            }

	          
	            resp.redirect("/ogrenciler");
	            return null;
	        }
	    };
	    post(ogrenciSil);
	    }
}
	
	