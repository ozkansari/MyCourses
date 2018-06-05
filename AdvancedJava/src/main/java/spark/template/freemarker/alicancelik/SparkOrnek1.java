package spark.template.freemarker.alicancelik;
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

public class SparkOrnek1 {
    
    private static final List<Kitap> KITAPLAR = new ArrayList<Kitap>();
    private static final Gson jsonYardimci = new GsonBuilder().create();
 
    public static void main(String[] args) {
        
        DerbyVeritabaniOrnek.veritabaniniYukle();
        DerbyVeritabaniOrnek.veritabaninaBaglan();
        DerbyVeritabaniOrnek.tablolariOlustur();
        
        // merhabaOrnek();
        
        
        // kitaplarJson();
        
        // http://localhost:4567/urunler2
        kitapGoruntule();
        
        // http://localhost:4567/urunekle
        kitapEklemeSayfasi();
        
        // http://localhost:4567/urunekle 'ye gelen POST isteklerine karsila
        kitapEklemeIslemi();
        
     // http://localhost:4567/urunsil 'e gelen POST isteklerine karsila
        kitapSilmeIslemi();
   
    }

    /**
     * 
     */
    private static void kitapSilmeIslemi() {
        FreeMarkerRoute kitapSilmeIslemi = new FreeMarkerRoute("/kitapsil") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                int id = Integer.valueOf( istek.queryParams("id") );
                DerbyVeritabaniOrnek.kitapSil(id);
                
                // Islem bitince /urunler sayfasina geri don
                cevap.redirect("/kitaplar");
                
                return null;
            }
        };
        get(kitapSilmeIslemi);
    }
    
    private static void sepeteEklemeIslemi() {
        FreeMarkerRoute sepeteEklemeIslemi = new FreeMarkerRoute("/sepeteat") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                int id = Integer.valueOf( istek.queryParams("id") );
                DerbyVeritabaniOrnek.sepeteEkle(id);
                
                // Islem bitince /urunler sayfasina geri don
                cevap.redirect("/kitaplar");
                
                return null;
            }
        };
        get(sepeteEklemeIslemi);
    }
    /**
     * 
     */
    private static void kitapEklemeIslemi() {
        FreeMarkerRoute kitapEkleIslemi = new FreeMarkerRoute("/kitapekle") {
            @Override
            public Object handle(Request istek, Response cevap) {
                int id = 0;
                // Kullanicinin urunekle.html'den girdigi form degerlerini al
            	String kitapAdi = istek.queryParams("kitapadi");
            	String yazaradi = istek.queryParams("yazaradi");
                String yazarsoyadi = istek.queryParams("yazarsoyadi");
                String yayinevi = istek.queryParams("yayinevi");
                // urunadi html input text'deki name
               
                // Fiyati inte cevir
                int fiyat;
                try {
                    fiyat = Integer.valueOf( istek.queryParams("fiyat") );
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/kitapekle");
                    return null;
                }
                
                // Urun olustur ve listeye ekle
                Kitap kitap = new Kitap( id,kitapAdi, yazaradi,yazarsoyadi,yayinevi, fiyat);
                // KITAPLAR.add(kitap);
                DerbyVeritabaniOrnek.kitapEkle(kitap);
 
                // Islem bitince /urunler sayfasina geri don
                cevap.redirect("/kitaplar");
                
                return null;
            }
        };
        post(kitapEkleIslemi); // bu yonlendirme post isteklerini karsilasin
    }

    /**
     * 
     */
    private static void kitapEklemeSayfasi() {
        FreeMarkerRoute kitapEklemeSayfasi = new FreeMarkerRoute("/kitapekle") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("kitaplar", KITAPLAR);
                return new ModelAndView(ozellikler, "kitapekle.html");
            }
        };
        get(kitapEklemeSayfasi);
    }

    /**
     * 
     */
    private static void kitapGoruntule() {
        FreeMarkerRoute kitapGoruntule = new FreeMarkerRoute("/kitaplar") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                
                List<Kitap> kitaplar = DerbyVeritabaniOrnek.kayitlariAl();
                
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                // ozellikler.put("kitaplar", KITAPLAR);
                ozellikler.put("kitaplar", kitaplar);
                return new ModelAndView(ozellikler, "kitaplar.html");
            }
        };
        get(kitapGoruntule);
    }

    /**
     * 
     */
    // OZKANS ALAKASIZ
    /*
    private static void kitaplarJson() {
        Route kitaplarJson = new Route("/kitaplar/json") {
            public Object handle(Request istek, Response cevap) {
                List<Kitap> kitaplar = DerbyVeritabaniOrnek.kayitlariAl();
                // return jsonYardimci.toJson(URUNLER);
                return jsonYardimci.toJson(kitaplar);
            }
        };
        get(kitaplarJson);
    }
	*/
    
    /**
     * 
     */
    // OZKANS ALAKASIZ
    /*
    private static void merhabaOrnek() {
        // http://localhost:4567/
        Route sayfa1 = new Route("/") {
            public Object handle(Request istek, Response cevap) {
                return "Merhaba!";
            }
        };
        get(sayfa1);
    }
    */
    
    
    
}
