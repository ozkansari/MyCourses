package spark.template.freemarker.musasoysal;
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

public class Spark {
    
    private static final List<Urun> URUNLER = new ArrayList<Urun>();
    private static final Gson jsonYardimci = new GsonBuilder().create();
 
    public static void main(String[] args) {
        
        DerbyVeritabani.veritabaniniYukle();
        DerbyVeritabani.veritabaninaBaglan();
        DerbyVeritabani.tablolariOlustur();
        yonetimGiris();
        yonetimPaneli();
        urunlerJson();
        urunleriGoruntule();
        urunEklemeSayfasi();
        urunEklemeIslemi();
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
                DerbyVeritabani.urunSil(id);
                
                // Urun sildikten sonra urunler sayfasina geri don.
                cevap.redirect("/musa_soysal/yonetim/urunler");
                
                return null;
            }
        };
        get(urunSilmeIslemi);
    }
   
    private static void urunEklemeIslemi() {
        FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/urunekle") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                
                String urunAdi = istek.queryParams("urunadi"); 
               
               
                
                int fiyat;
                try {
                    fiyat = Integer.valueOf( istek.queryParams("fiyat") );
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/musa_soysal/yonetim/urunekle");
                    return null;
                }
                
                // Urun olustur ve listeye ekle
                Urun urun = new Urun(Urun.ID++,urunAdi, fiyat);
                DerbyVeritabani.urunEkle(urun);
 
                // Islem bittikten sonra panele geri doner
                cevap.redirect("/musa_soysal/yonetimpanel");
                
                return null;
            }
        };
        post(urunEkleIslemi); // 
    }
    
    
    private static void yonetimGiris() {
        FreeMarkerRoute yonetimGiris = new FreeMarkerRoute("/musa_soysal/yonetim") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "YonetimPaneliGiris.html");
            }
        };
        get(yonetimGiris);
    }
    private static void yonetimPaneli() {
        FreeMarkerRoute yonetimPaneli = new FreeMarkerRoute("/musa_soysal/yonetimpanel") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "yonetimpaneli.html");
            }
        };
        get(yonetimPaneli);
    }

    
    private static void urunEklemeSayfasi() {
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/musa_soysal/yonetim/urunekle") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "urunekle.html");
            }
        };
        get(urunEkleSayfasi);
    }

   
    private static void urunleriGoruntule() {
        FreeMarkerRoute sayfa3 = new FreeMarkerRoute("/musa_soysal/yonetim/urunler") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                
                List<Urun> urunler = DerbyVeritabani.kayitlariAl();
                
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                // ozellikler.put("urunler", URUNLER);
                ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "urunler.html");
            }
        };
        get(sayfa3);
        
        
    }

    
    private static void urunlerJson() {
        Route sayfa2 = new Route("/urunler/json") {
            public Object handle(Request istek, Response cevap) {
                List<Urun> urunler = DerbyVeritabani.kayitlariAl();
                return jsonYardimci.toJson(urunler);
            }
        };
        get(sayfa2);
    }
    
   

    
  
}

 
 

