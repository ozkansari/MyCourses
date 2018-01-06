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
        
        Route sayfa2 = new Route("/urunler") {
            public Object handle(Request istek, Response cevap) {
                return jsonYardimci.toJson(URUNLER);
            }
        };
        get(sayfa2);
        
        // http://localhost:4567/urunler2
        FreeMarkerRoute sayfa3 = new FreeMarkerRoute("/urunler2") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "urunler.html");
            }
        };
        get(sayfa3);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
