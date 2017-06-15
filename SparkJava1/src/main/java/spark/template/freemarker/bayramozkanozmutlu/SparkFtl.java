package spark.template.freemarker.bayramozkanozmutlu;
import static spark.Spark.*;

import java.util.*;

import spark.*;
import spark.template.freemarker.*;


public class SparkFtl {

    public static void main(String[] args) {

        final List<Ogrenci> ogrenciler = new ArrayList<Ogrenci>();
            ogrenciler.add(new Ogrenci("Ozkan Ozmutlu", "ON LÝSANS", "MYO","1","Java","Matematik"));

        

        // setPort(5834);

        FreeMarkerRoute ogrencilerGet = new FreeMarkerRoute("/ogrenciler") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "bayramozkanozmutlu/ogrenciler.html"); // resources'daki ftl
            }
        };
        get(ogrencilerGet);
        

        FreeMarkerRoute ogrenciSilGet = new FreeMarkerRoute("/ogrencisil") {
            public Object handle(Request req, Response resp) {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenciler", ogrenciler);
                return new ModelAndView(attributes, "bayramozkanozmutlu/ogrencisil.html"); // resources'daki ftl
            }
        };
        get(ogrenciSilGet);


        FreeMarkerRoute ogrenciekleGet = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request req, Response resp) {
                return new ModelAndView(null, "bayramozkanozmutlu/ogrenciekle.html"); // resources'daki ftl
            }
        };
        get(ogrenciekleGet);

        FreeMarkerRoute ogrencieklePost = new FreeMarkerRoute("/ogrenciekle") {
            public Object handle(Request istek, Response cevap) {
            	 String DersAd= istek.queryParams("DersAd");
                String adSoyad = istek.queryParams("adSoyad");
                String ogrenciTipi = istek.queryParams("ogrenciTipi");
                String bolum = istek.queryParams("bolum");
                String numara = istek.queryParams("numara");
                String ogrenciDers = istek.queryParams("ogrenciDers");



                ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,numara,ogrenciDers,DersAd));

                // belirtilen uri'ye yonlendir.
                cevap.redirect("/ogrenciler");
                return null;
            }
        };
        post(ogrencieklePost);

        FreeMarkerRoute ogrenciGoruntule = new FreeMarkerRoute("/ogrenci/:ogrencino") {
            public Object handle(Request req, Response resp) {
                // Ogrenciyi bul
                Ogrenci bulunan = null;

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("ogrenci", bulunan);

                return new ModelAndView(attributes, "bayramozkanozmutlu/ogrenci.html");
            }
        };
        get(ogrenciGoruntule);




    FreeMarkerRoute ogrenciSil = new FreeMarkerRoute("/ogrencisil") {
        public Object handle(Request req, Response resp) {
            String ogrenciNo = req.queryParams("ogrencino");

            // Ogrenciyi bul

            try{
                for (Ogrenci ogr :ogrenciler){
                    if (ogr.ogrenciNo.equals(ogrenciNo)){
                        ogrenciler.remove(ogr);
                    }
                }
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }

            //ogrenciler.remove(bulunan);

           // Map<String, Object> attributes = new HashMap<>();
           // attributes.put("ogrenci", bulunan);

            // belirtilen uri'ye yonlendir.
            resp.redirect("/ogrenciler");
            return null;
        }
    };
    post(ogrenciSil);
    		
    FreeMarkerRoute dersekleGet = new FreeMarkerRoute("/dersekle") {
        public Object handle(Request req, Response resp) {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("ogrenciler", ogrenciler);
            return new ModelAndView(attributes, "bayramozkanozmutlu/dersekle.html"); // resources'daki ftl
        }
    };
    get(dersekleGet);
    
    FreeMarkerRoute derseklePost = new FreeMarkerRoute("/dersekle") {
        public Object handle(Request istek, Response cevap) {

            String DersAd= istek.queryParams("DersAd");
            String adSoyad = istek.queryParams("adSoyad");
            String ogrenciTipi = istek.queryParams("ogrenciTipi");
            String bolum = istek.queryParams("bolum");
            String numara = istek.queryParams("numara");
            String ogrenciDers = istek.queryParams("ogrenciDers");
            

            
      



            ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,numara,ogrenciDers,DersAd));

            // belirtilen uri'ye yonlendir.
            cevap.redirect("/ogrenciler");
            return null;
        }
    };
    post(derseklePost);
    
    FreeMarkerRoute derslistelePost = new FreeMarkerRoute("/derslistele") {
        public Object handle(Request istek, Response cevap) {

            String DersAd= istek.queryParams("DersAd");
            String adSoyad = istek.queryParams("adSoyad");
            String ogrenciTipi = istek.queryParams("ogrenciTipi");
            String bolum = istek.queryParams("bolum");
            String numara = istek.queryParams("numara");
            String ogrenciDers = istek.queryParams("ogrenciDers");
            

            
      



            ogrenciler.add(new Ogrenci(adSoyad, ogrenciTipi, bolum,numara,ogrenciDers,DersAd));

            // belirtilen uri'ye yonlendir.
            cevap.redirect("/ogrenciler");
            return null;
        }
    };
    post(derseklePost);
  
}
}


