package spark.template.freemarker.ahmetselcukozdemir;
import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;


public class AhmetSelcukOzdemirOdev3 {

   
     
    public static void main(String[] args) {
        
        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Ahmet Selçuk", "On Lisans", "Doktora"));
        ogrenciler.add(new Ogrenci("deneme", "On Lisans", "MYO"));
        ogrenciler.add(new Ogrenci("deneme2", "Lisans", "Yüksek Lisans"));
        
        
        List<Dersler> dersler=new ArrayList<Dersler>();
        dersler.add(new Dersler("Matematik", "Ali Demir"));
        dersler.add(new Dersler("Ýngilizce", "Görkem Gökmen"));
        
        // setPort(80);
        
        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "ahmetselcukozdemir/ogrenciler.ftl"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute ogrencilerEkle = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
            	
            	
                     Map<String, Object> attributes = new HashMap<>();
                     attributes.put("ogrenciler", ogrenciler);
                     return new ModelAndView(attributes, "ahmetselcukozdemir/ogrenciekle.ftl"); // resources'daki ftl
            }
        };
        
        get(ogrencilerEkle);
        FreeMarkerRoute dersEkle = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
            	
            	
                     Map<String, Object> attributes = new HashMap<>();
                     attributes.put("dersler", dersler);
                     return new ModelAndView(attributes, "ahmetselcukozdemir/dersekle.ftl"); // resources'daki ftl
            }
        };
        
        get(dersEkle);
        
        FreeMarkerRoute ogrencilerSil = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "ahmetselcukozdemir/ogrenciler.ftl"); // resources'daki ftl
            }
        };
        
        get(ogrencilerEkle);
        
        FreeMarkerRoute ogrencidetayGet = new FreeMarkerRoute("/ogrencidetay") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "ahmetselcukozdemir/ogrencidetay.ftl"); // resources'daki ftl
            }
        };
        get(ogrencidetayGet);
        
   
      
        FreeMarkerRoute Dersler= new FreeMarkerRoute("/dersler") {
            public Object handle(Request req, Response resp) {
            	  Map<String, Object> attributes = new HashMap<>();
                  attributes.put("dersler", dersler);
                  return new ModelAndView(attributes, "ahmetselcukozdemir/dersler.ftl"); // resources'daki ftl
            	
               
            }
        };
        get(Dersler);
        
        
        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {
                
            	String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                
                
                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum));

                // belirtilen uri'ye yonlendir.
              
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);
        
        FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request istek, Response cevap) {
                
            	String dersAdi= istek.queryParams("dersadi");
                String dersHoca= istek.queryParams("hocaadi");
                
               
                
                
                dersler.add(new Dersler(dersAdi, dersHoca));

               
                cevap.redirect("/dersler");
                
                
                
                return null;
            }
        };
        post(derseklePost);
        
        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");
                
                // Ogrenciyi bul
                Ogrenci bulunan = null;
                
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);
                
                return new ModelAndView(attributes, "ahmetselcukozdemir/ogrenci.ftl");
            }
        };
        get(ogrenciGoruntule);
        
        FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");
                
                
                Ogrenci bulunan = null;
                ogrenciler.remove(bulunan);
                
                Map<String, Object> attributes = new HashMap<>();
                
                
                attributes.put("ogrenci", bulunan);
                
                
                resp.redirect("/ogrenciler");
                return null;
            }
        };
        get(ogrenciSil);
        
        
    }
}

