import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

public class SparkOrnek1 {
    
    private static final List<Urun> URUNLER = new ArrayList<Urun>();
    
    public static void main(String[] args) {
        // http://localhost:4567/
        Route sayfa1 = new Route("/") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);
        
        URUNLER.add(new Urun("Didi", 5));
        URUNLER.add(new Urun("Kalem", 1));
        final Gson jsonYardimci = new GsonBuilder().create();
        
        Route sayfa2 = new Route("/urunler/json") {
            public Object handle(Request istek, Response cevap) {
                return jsonYardimci.toJson(URUNLER);
            }
        };
        get(sayfa2);
        
        // http://localhost:4567/urunler2
        FreeMarkerRoute sayfa3 = new FreeMarkerRoute("/urunler") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "urunler.html");
            }
        };
        get(sayfa3);
        
        
        // http://localhost:4567/urunekle
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/urunekle") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "urunekle.html");
            }
        };
        get(urunEkleSayfasi);
        
        // http://localhost:4567/urunekle 'ye gelen POST isteklerine karsila
        FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/urunekle") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                // Kullanicinin urunekle.html'den girdigi form degerlerini al
                String urunAdi = istek.queryParams("urunadi"); 
                // urunadi html input text'deki name
               
                // Fiyati inte cevir
                int fiyat;
                try {
                    fiyat = Integer.valueOf( istek.queryParams("fiyat") );
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/urunekle");
                    return null;
                }
                
                // Urun olustur ve listeye ekle
                Urun urun = new Urun(urunAdi, fiyat);
                URUNLER.add(urun);
                
                // Islem bitince /urunler sayfasina geri don
                cevap.redirect("/urunler");
                
                return null;
            }
        };
        post(urunEkleIslemi); // bu yonlendirme post isteklerini karsilasin
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
