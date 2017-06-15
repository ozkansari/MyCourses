package spark.template.freemarker.halilonan;
import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;


public class SparkFtl {


    public static void main(String[] args) {

        final List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Halil Onan", "On Lisans", "MYO","1", "Matematik"));
        ogrenciler.add(new Ogrenci("Erdem Deniz Arýcý", "On Lisans", "MYO","2", "Fizik"));
        ogrenciler.add(new Ogrenci("Ömer Oðuz Kasap", "On Lisans", "MYO","3","Kimya"));

        setPort(9256);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "halilonan/ogrenciler.html"); 
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute ogrencilerrGet = new FreeMarkerRoute("/ogrenciDetay") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "halilonan/ogrenciDetay.html"); 
            }
        };
        get(ogrencilerrGet);
        
        FreeMarkerRoute studentDeleteGet = new FreeMarkerRoute("/studentDelete") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "halilonan/studentDelete.html"); 
            }
        };
        get(studentDeleteGet);

        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "halilonan/ogrenciekle.html"); 
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {

                String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                String numara = istek.queryParams("numara");
                String Ders = istek.queryParams("Ders");

                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,numara,Ders));
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");

                Ogrenci Select = null;
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", Select);

                return new ModelAndView(attributes, "halilonan/ogrenci.html");
            }
        };
        get(ogrenciGoruntule);

    FreeMarkerRoute ogrencisil = new FreeMarkerRoute("/ogrencisil") {
        public Object handle(Request req, Response resp) {
            String ogrenciNo = req.queryParams("ogrencino");

            try{
                Ogrenci Select = null;
                for (Ogrenci ogr :ogrenciler){
                    if (ogr.ogrenciNo.equals(ogrenciNo)){
                        ogrenciler.remove(ogr);
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
    
    




