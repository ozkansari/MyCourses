package spark.template.freemarker.mertcanarici;
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

/**
 * Bu sinif web sayfalarini ve web islemleri tanimlanir.
 * 
 * @author Mertcan Arici
 *
 */
public class Spark {
    
	/**
	 * Urunler listesi tanimlanir. Urunler sinifi listeye atanir.
	 * 
	 * @param URUNLER
	 * 
	 */
    private static final List<Urun> URUNLER = new ArrayList<Urun>();
    
    /**
	 * Gson nesnesi tanimlanir.
	 * 
	 * @param jsonYardimci
	 * 
	 */
    private static final Gson jsonYardimci = new GsonBuilder().create();
 
    /**
     * Veritabani y�klenme, veritabani baglantisi ve tablolar cagirilir. Islem siniflari
	 * eklenir.
	 * 
	 * @param args
	 * 
	 */
    public static void main(String[] args) {
        
        Veritabani.veritabaniniYukle();
        Veritabani.veritabaninaBaglan();
        Veritabani.tablolariOlustur();
                
        urunlerJson();
        
        // http://localhost:4567/mertcanarici/yonetim/urunler
        urunleriGoruntule();
        
        // http://localhost:4567/mertcanarici/kullanici/sepet
        sepetGoruntule();
        
        // http://localhost:4567/mertcanarici/yonetim/urunekle_guncelle
        urunEkleme_GuncellemeSayfasi();
        
        // http://localhost:4567/mertcanarici/yonetim/urunekle_guncelle
        urunEkleme_GuncellemeIslemi();
        
        // http://localhost:4567/mertcanarici/yonetim/urunsil
        urunSilmeIslemi();
        
     // http://localhost:4567/mertcanarici/kullanici
        kullaniciSayfasi();
    }

    /**
	 * Urun silme islemi tanimlanir.
	 * 
	 * @param urunSilmeIslemi
	 * @return null
	 */
    private static void urunSilmeIslemi() {
        FreeMarkerRoute urunSilmeIslemi = new FreeMarkerRoute("/mertcanarici/yonetim/urunsil") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                int id = Integer.valueOf( istek.queryParams("id") );
                Veritabani.urunSil(id);
                
                cevap.redirect("/mertcanarici/yonetim/urunler");
                
                return null;
            }
        };
        get(urunSilmeIslemi);
    }
    
    /**
	 * Urun ekleme ve guncelleme islemi tanimlanir.
	 * 
	 * @param urunEkleme_GuncellemeIslemi
	 * @return null, null
	 * 
	 */
    private static void urunEkleme_GuncellemeIslemi() {
        FreeMarkerRoute urunEkleme_GuncellemeIslemi = new FreeMarkerRoute("/mertcanarici/yonetim/urunekle_guncelle") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                String urunAdi = istek.queryParams("urunadi"); 
               
                int fiyat;
                try {
                    fiyat = Integer.valueOf( istek.queryParams("fiyat") );
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/mertcanarici/yonetim/urunekle_guncelle");
                    return null;
                }
                
                Urun urun = new Urun(Urun.ID++,urunAdi, fiyat);
                Veritabani.urunEkle(urun);
 
                cevap.redirect("/mertcanarici/yonetim/urunler");
                
                return null;
            }
        };
        post(urunEkleme_GuncellemeIslemi); 
    }

    /**
	 * Urun ekleme ve guncelleme sayfasi tanimlanir.
	 * 
	 * @param urunEkleme_GuncellemeSayfasi
	 * @return urunekle_guncelle.html
	 * 
	 */
    private static void urunEkleme_GuncellemeSayfasi() {
        FreeMarkerRoute urunEkleme_GuncellemeSayfasi = new FreeMarkerRoute("/mertcanarici/yonetim/urunekle_guncelle") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "/mertcanarici/urunekle_guncelle.html");
            }
        };
        get(urunEkleme_GuncellemeSayfasi);
    }
    
    /**
	 * Urunleri goruntuleme islemi tanimlanir.
	 * 
	 * @param urunleriGoruntule
	 * @return urunler.html
	 * 
	 */
    private static void urunleriGoruntule() {
        FreeMarkerRoute urunleriGoruntule = new FreeMarkerRoute("/mertcanarici/yonetim/urunler") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                
                List<Urun> urunler = Veritabani.kayitlariAl();
                
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                // ozellikler.put("urunler", URUNLER);
                ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "/mertcanarici/urunler.html");
            }
        };
        get(urunleriGoruntule);
    }
    
    /**
	 * Sepeti goruntuleme islemi tanimlanir.
	 * 
	 * @param sepetGoruntule
	 * @return sepet.html
	 * 
	 */
    private static void sepetGoruntule() {
        FreeMarkerRoute sepetGoruntule = new FreeMarkerRoute("/mertcanarici/kullanici/sepet") {
        	@Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "/mertcanarici/sepet.html");
            }
        };
        get(sepetGoruntule);
    }
    
    /**
	 * Kullanici sayfasi tanimlanir.
	 * 
	 * @param kullaniciSayfasi
	 * @return kullanici.html
	 * 
	 */
    private static void kullaniciSayfasi() {
        FreeMarkerRoute kullaniciSayfasi = new FreeMarkerRoute("/mertcanarici/kullanici") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                
                List<Urun> urunler = Veritabani.kayitlariAl();
                
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                // ozellikler.put("urunler", URUNLER);
                ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "/mertcanarici/kullanici.html");
            }
        };
        get(kullaniciSayfasi);
    }

    /**
	 * Urunler Json
	 * 
	 * @param UrunlerJson
	 * @return urunler
	 * 
	 */
    private static void urunlerJson() {
        Route urunlerJson = new Route("/urunler/json") {
            public Object handle(Request istek, Response cevap) {
                List<Urun> urunler = Veritabani.kayitlariAl();
                // return jsonYardimci.toJson(URUNLER);
                return jsonYardimci.toJson(urunler);
            }
        };
        get(urunlerJson);
    }
   
}