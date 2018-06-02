package spark.template.freemarker.iskenderuzuner;

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
        urunlerJson();
        urunleriGoruntule();
        urunEklemeSayfasi();
        urunEklemeIslemi();
        urunSilmeIslemi();
        kitapListeleSayfa();
        anaSayfa();
        sepetSayfa();
    }

private static void sepeteEkle(){
    FreeMarkerRoute sepeteEklemeIslemi = new FreeMarkerRoute("/sepeteekle") {
        @Override
        public Object handle(Request istek, Response cevap) {
            int id = Integer.valueOf(istek.queryParams("id"));

            try {
                id = Integer.valueOf(istek.queryParams("id"));
                DerbyVeritabani.sepeteEkle(id);
            } catch(Exception e) {
                e.printStackTrace();
                cevap.redirect("/iskenderuzuner/yonetim/kitapekle");
                return null;
            }
            return null;
        }
    };
}
    private static void urunSilmeIslemi() {
        FreeMarkerRoute urunSilmeIslemi = new FreeMarkerRoute("/urunsil") {
            @Override
            public Object handle(Request istek, Response cevap) {
                int id = Integer.valueOf( istek.queryParams("id") );
                DerbyVeritabani.urunSil(id);
                cevap.redirect("/urunler");
                return null;
            }
        };
        get(urunSilmeIslemi);
    }
    private static void musteriKayit() {
        FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/Siparisler") {
            @Override
            public Object handle(Request istek, Response cevap) {
                String adi = istek.queryParams("adi");
                String soyadi = istek.queryParams("soyadi");
                String adres= istek.queryParams("adres");
                int kkbilgisi;
                int tckimlik;
                int telno;
                try {
                    tckimlik = Integer.valueOf(istek.queryParams("kkbilgisi"));
                    telno = Integer.valueOf(istek.queryParams("telno"));
                    kkbilgisi = Integer.valueOf(istek.queryParams("kkbilgisi"));
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/iskenderuzuner/yonetim/kitapekle");
                    return null;
                }
                Musteri musteri = new Musteri(adi,soyadi,adres,kkbilgisi,tckimlik,telno);
                cevap.redirect("/Siparisler");
                return null;
            }
        };
        post(urunEkleIslemi);
    }

    private static void urunEklemeIslemi() {
        FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/iskenderuzuner/yonetim/kitapekle") {
            @Override
            public Object handle(Request istek, Response cevap) {
                String kitapadi = istek.queryParams("kitapadi");
                String yazaradi = istek.queryParams("yazaradi");
                String yazarsoyadi = istek.queryParams("yazarsoyadi");
                String yayinevi = istek.queryParams("yayinevi");
                int fiyati;
                try {
                    fiyati = Integer.valueOf( istek.queryParams("fiyati") );
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/iskenderuzuner/yonetim/kitapekle");
                    return null;
                }
                Urun urun = new Urun(Urun.ID++,kitapadi, yazaradi,fiyati,yayinevi,yazarsoyadi);
                DerbyVeritabani.urunEkle(urun);
                cevap.redirect("/urunler");
                return null;
            }
        };
        post(urunEkleIslemi);
    }

    private static void urunEklemeSayfasi() {
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/iskenderuzuner/yonetim/kitapekle") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "kitapekle.html");
            }
        };
        get(urunEkleSayfasi);
    }

    private static void urunleriGoruntule() {
        FreeMarkerRoute sayfa3 = new FreeMarkerRoute("/urunler") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                List<Urun> urunler = DerbyVeritabani.kayitlariAl();
                Map<String, Object> ozellikler = new HashMap<String, Object>();
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
    

    
    private static void anaSayfa() {
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("index", URUNLER);
                return new ModelAndView(ozellikler, "index.html");
            }
        };
        get(urunEkleSayfasi);
    }
    
    
    private static void kitapListeleSayfa() {
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/iskenderuzuner/yonetim/kitaplistele") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("kitaplistele", URUNLER);
                return new ModelAndView(ozellikler, "kitaplistele.html");
            }
        };
        get(urunEkleSayfasi);
    }
    
    private static void sepetSayfa() {
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/iskenderuzuner/yonetim/sepet") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("sepet", URUNLER);
                return new ModelAndView(ozellikler, "sepet.html");
            }
        };
        get(urunEkleSayfasi);
    }
    
    

}
