import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

public class SparkOrnek1 {
    
    private static final List<Urun> URUNLER = new ArrayList<Urun>();
    private static final Gson jsonYardimci = new GsonBuilder().create();
 
    public static void main(String[] args) {
        
        DerbyVeritabaniOrnek.veritabaniniYukle();
        DerbyVeritabaniOrnek.veritabaninaBaglan();
        DerbyVeritabaniOrnek.tablolariOlustur();
        
        merhabaOrnek();
        
        URUNLER.add(new Urun(Urun.ID++,"Didi", 5));
        URUNLER.add(new Urun(Urun.ID++,"Kalem", 1));
        
        urunlerJson();
        
        // http://localhost:4567/urunler2
        urunleriGoruntule();
        
        // http://localhost:4567/urunekle
        urunEklemeSayfasi();
        
        // http://localhost:4567/urunekle 'ye gelen POST isteklerine karsila
        urunEklemeIslemi();
        
        // http://localhost:4567/urunsil 'e gelen POST isteklerine karsila
        urunSilmeIslemi();
    }

    /**
     * 
     */
    private static void urunSilmeIslemi() {
        FreeMarkerRoute urunSilmeIslemi = new FreeMarkerRoute("/urunsil") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                int id = Integer.valueOf( istek.queryParams("id") );
                DerbyVeritabaniOrnek.urunSil(id);
                
                // Islem bitince /urunler sayfasina geri don
                cevap.redirect("/urunler");
                
                return null;
            }
        };
        get(urunSilmeIslemi);
    }
    /**
     * 
     */
    private static void urunEklemeIslemi() {
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
                Urun urun = new Urun(Urun.ID++,urunAdi, fiyat);
                // URUNLER.add(urun);
                DerbyVeritabaniOrnek.urunEkle(urun);
 
                // Islem bitince /urunler sayfasina geri don
                cevap.redirect("/urunler");
                
                return null;
            }
        };
        post(urunEkleIslemi); // bu yonlendirme post isteklerini karsilasin
    }

    /**
     * 
     */
    private static void urunEklemeSayfasi() {
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/urunekle") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "urunekle.html");
            }
        };
        get(urunEkleSayfasi);
    }

    /**
     * 
     */
    private static void urunleriGoruntule() {
        FreeMarkerRoute sayfa3 = new FreeMarkerRoute("/urunler") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                
                List<Urun> urunler = DerbyVeritabaniOrnek.kayitlariAl();
                
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                // ozellikler.put("urunler", URUNLER);
                ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "urunler.html");
            }
        };
        get(sayfa3);
    }

    /**
     * 
     */
    private static void urunlerJson() {
        Route sayfa2 = new Route("/urunler/json") {
            public Object handle(Request istek, Response cevap) {
                List<Urun> urunler = DerbyVeritabaniOrnek.kayitlariAl();
                // return jsonYardimci.toJson(URUNLER);
                return jsonYardimci.toJson(urunler);
            }
        };
        get(sayfa2);
    }

    /**
     * 
     */
    private static void merhabaOrnek() {
        // http://localhost:4567/
        Route sayfa1 = new Route("/") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);
    }
}
