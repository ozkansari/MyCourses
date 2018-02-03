package spark.template.freemarker.atakantalay;
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

public class JavaSpark {
    
    private static final List<Urun> URUNLER = new ArrayList<Urun>();
    private static final Gson jsonYardimci = new GsonBuilder().create();
 
    public static void main(String[] args) {
        
        DerbyVTO.veritabaniniYukle();
        DerbyVTO.veritabaninaBaglan();
        DerbyVTO.tablolariOlustur();

        urunlerJson();
        urunleriGoruntule();
        //Ürünlerimizi görüntülememizi sağlar.
        urunEklemeSayfasi();
        urunEklemeIslemi();
        //Burada girdiğimiz değerleri bir diziye eşitleyip veritabanımımıza atar.
        urunSilmeIslemi();
        //Bu fonksiyon ile ürünler sayfamızda bulunan 'sil' ile ürünlerimiz silinebilir.
        KullaniciSepet();
    }
    private static void urunlerJson() {
        Route sayfa1 = new Route("/Listeleme/json") {
            public Object handle(Request istek, Response cevap) {
                List<Urun> urunler = DerbyVTO.kayitlariAl();
                return jsonYardimci.toJson(urunler);
            }
        };
        get(sayfa1);
    }
    private static void urunleriGoruntule() {
        FreeMarkerRoute sayfa2 = new FreeMarkerRoute("/urunler") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                List<Urun> urunler = DerbyVTO.kayitlariAl();
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                // ozellikler.put("urunler", URUNLER);
                ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "/atakantalay/Listeleme.html");
            }
        };
        get(sayfa2);
    }
    private static void urunEklemeSayfasi() {
        FreeMarkerRoute YeniUrun = new FreeMarkerRoute("/ekle") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "/atakantalay/ekle.html");
            }
        };
        get(YeniUrun);
    }
    private static void urunEklemeIslemi() {
        FreeMarkerRoute urunEklemeIslemi = new FreeMarkerRoute("/ekle") {
            @Override
            public Object handle(Request istek, Response cevap) {
                //Girdiğimiz değerleri alır.
                String ad = istek.queryParams("ad");
                String tur = istek.queryParams("tur");
                int deger;
                int Stok;
                try {
                    Stok = Integer.valueOf(istek.queryParams("stok"));
                    deger = Integer.valueOf(istek.queryParams("deger"));
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/ekle");
                    return null;
                }
                // Girdiğimiz bilgilere göre bilgilerimiz alınır ve bu bilgilerle yeni bir ürün nesnesi oluşturulur.
                Urun urun = new Urun(Urun.ID++,ad, tur,Stok,deger);
                //ID yi her ürün eklediğimizde bir arttırır.
                DerbyVTO.urunEkle(urun);
                cevap.redirect("/Listeleme");
                return null;
            }
        };
        post(urunEklemeIslemi); // post istekleri karşılanır.
    }
    private static void KullaniciSepet(){
    FreeMarkerRoute sepeteEklemeIslemi = new FreeMarkerRoute("/Listeleme") {
        @Override
        public Object handle(Request istek, Response cevap) {
            try {
               int id = Integer.valueOf(istek.queryParams("id"));
                DerbyVTO.KullaniciSepet(id);
            } catch(Exception e) {
                e.printStackTrace();
                cevap.redirect("/Listeleme");
                return null;
            }
            return null;
        }
    };
    get(sepeteEklemeIslemi);
}
    private static void urunSilmeIslemi() {
        FreeMarkerRoute urunSilmeIslemi = new FreeMarkerRoute("/urunsil") {
            @Override
            public Object handle(Request istek, Response cevap) {
                int id = Integer.valueOf( istek.queryParams("id") );
                DerbyVTO.urunSil(id);
                cevap.redirect("/Listeleme");
                return null;
            }
        };
        get(urunSilmeIslemi);
    }

}
