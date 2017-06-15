package spark.template.freemarker.omeroguzkasap;
import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;


public class SparkFtl {


    public static void main(String[] args) {

        final List<Ogrenci> yeniogrenci = new ArrayList<Ogrenci>();
        final List<Ogrenci> dersler = new ArrayList<Ogrenci>();

        yeniogrenci.add(new Ogrenci("MEHMET", "On Lisans", "MYO","1"));
        yeniogrenci.add(new Ogrenci("ALÝ", "On Lisans", "MYO","2"));
        yeniogrenci.add(new Ogrenci("HASAN", "On Lisans", "MYO","3"));
        yeniogrenci.add(new Ogrenci("NURÝ", "On Lisans", "MYO","4"));
        yeniogrenci.add(new Ogrenci("KAMÝL", "On Lisans", "MYO","5"));
        
        dersler.add(new Ogrenci("Android"));
        dersler.add(new Ogrenci("Java"));
        
        setPort(1299);
        
        FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                
                String Ders = req.queryParams("Ders");               
                dersler.add(new Ogrenci(Ders));         
                resp.redirect("/ogrenciler");
                return null;
            }
        };
        
        post(derseklePost);
        
        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", yeniogrenci);
                return new ModelAndView(attributes, "omeroguzkasap/ogrenciler.html"); 
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute derslistesiGet = new FreeMarkerRoute("/derslistesi") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("dersler", dersler);
                return new ModelAndView(attributes, "omeroguzkasap/derslistesi.html"); 
            }
        };
        get(derslistesiGet);
        
        FreeMarkerRoute ogrencilerrGet = new FreeMarkerRoute("/ogrenciDetay") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", yeniogrenci);
                return new ModelAndView(attributes, "omeroguzkasap/ogrenciDetay.html"); 
            }
        };
        get(ogrencilerrGet);
        
        FreeMarkerRoute ogrencisilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", yeniogrenci);
                return new ModelAndView(attributes, "omeroguzkasap/ogrencisil.html"); 
            }
        };
        get(ogrencisilGet);

        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "omeroguzkasap/ogrenciekle.html"); 
            }
        };
        get(ogrenciekleGet);
        
        FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "omeroguzkasap/dersekle.html"); 
            }
        };
        get(dersekleGet);

        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {

                String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                String numara = istek.queryParams("numara");
                String Ders = istek.queryParams("Ders");

                yeniogrenci.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,numara));
                
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);
        
        FreeMarkerRoute ogrencisil = new FreeMarkerRoute("/ogrencisil") {
        	 public Object handle(Request req, Response resp) {
                 String ogrenciNo = req.queryParams("ogrencino");
                
                 try{
                     Ogrenci Select = null;
                     for (Ogrenci ogrenci :yeniogrenci){
                         if (ogrenci.ogrenciNo.equals(ogrenciNo)){
                        	 yeniogrenci.remove(ogrenci);
 
             }
                }
             }
                 catch (Exception ex){
                 }

                 resp.redirect("/ogrenciler");
                 return null;
             }
         };
        post(ogrencisil);
        
       
   
    }
}
    
    




