package spark.template.freemarker.resulvural;

import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;


public class SparkFtl {

    /*-- 
     * http://taywils.me/2013/11/05/javasparkframeworktutorial/
     */
    public static void main(String[] args) {
        
        List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
        ogrenciler.add(new Ogrenci("Resul Vural", "Bilgisayar Prog", "MYO"));
        ogrenciler.add(new Ogrenci("Ali Babacan", "Mühendislik", "Lisans"));
        ogrenciler.add(new Ogrenci("Burak Yavuz ", "Dil Eðitim", "Doktora"));
        
        // setPort(80);
        
        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "resulvural/ogrenciler2.ftl"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        
        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "resulvural/ogrenciekle2.ftl"); // resources'daki ftl
            }
        };
        get(ogrenciekleGet);
        
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
        
        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                String ogrenciNo = req.params("ogrencino");
                
                // Ogrenciyi bul
                Ogrenci bulunan = null;
                
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);
                
                return new ModelAndView(attributes, "resulvural/ogrenci.ftl");
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



