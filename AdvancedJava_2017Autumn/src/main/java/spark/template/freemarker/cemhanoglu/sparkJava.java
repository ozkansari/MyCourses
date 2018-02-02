package spark.template.freemarker.cemhanoglu;
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

public class sparkJava {
    private static final List<Urun> URUNLER = new ArrayList<Urun>();
    private static final Gson jsonYardimci = new GsonBuilder().create();
    public static void main(String[] args) {
        
        Veritabani.veritabaniniYukle();
        Veritabani.veritabaninaBaglan();
        Veritabani.tablolariOlustur();
        urunlerJson();
        //Varolan ürünleri görüntüler
        urunleriGoruntule();
        //ürünlerimizi eklemememizi sağlayan fonksiyonumuz.
        urunEklemeSayfasi();
        //Kullanıcının girdiği verileri veritabanına ekler.
        urunEklemeIslemi();
        //Sepete ekleme işlemi.
        sepet();
        urunSilmeIslemi();
    }
private static void sepet(){
    FreeMarkerRoute sepeteEkle = new FreeMarkerRoute("/Sepet") {
        @Override
        public Object handle(Request istek, Response cevap) {
            String aliciadi =istek.queryParams("aliciadi");
            String gondericiadi = istek.queryParams("göndericiadi");

            try {
                int id = Integer.valueOf(istek.queryParams(""));
                Veritabani.Sepetim(id);
            } catch(Exception e) {
                e.printStackTrace();
                cevap.redirect("/eklenenUrun");
                return null;
            }
            return null;
        }

    };
    get(sepeteEkle);
}
    private static void urunSilmeIslemi() {
        FreeMarkerRoute urunSilmeIslemi = new FreeMarkerRoute("/urunsil") {
            @Override
            public Object handle(Request istek, Response cevap) {
                
                int id = Integer.valueOf( istek.queryParams("id") );
                Veritabani.urunSil(id);
                
                // İşlemimiz tamamlandıktan sonra urunler sayfasına geri döneriz.
                cevap.redirect("/urunler");
                return null;
            }
        };
        get(urunSilmeIslemi);
    }
    private static void urunEklemeIslemi() {
        FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/eklenenUrun") {
            @Override
            public Object handle(Request istek, Response cevap) {
                String marka = istek.queryParams("marka");
                String model = istek.queryParams("model");
                int fiyat;
                int adet;
                //Gelen verilerimiz String şeklinde geldiği için bunları integer a dönüştürürüz.
                try {
                    adet = Integer.valueOf(istek.queryParams("adet"));
                    fiyat = Integer.valueOf( istek.queryParams("fiyat") );
                } catch(Exception e) {
                    e.printStackTrace();
                    cevap.redirect("/eklenenUrun");
                    return null;
                }
                // Yeni bir ürün nesnesi oluştururuz ve girdiğimiz değerleri bu nesneye eşitleriz.
                Urun urun = new Urun(Urun.ID++,marka, model,adet,fiyat);
                Veritabani.urunEkle(urun);
                cevap.redirect("/urunler");
                return null;
            }
        };
        post(urunEkleIslemi);
    }
    private static void urunEklemeSayfasi() {
        FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/eklenenUrun") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                ozellikler.put("urunler", URUNLER);
                return new ModelAndView(ozellikler, "eklenenUrun.html");
            }
        };
        get(urunEkleSayfasi);
    }
    private static void urunlerJson() {
        Route sayfa2 = new Route("/urunler/json") {
            public Object handle(Request istek, Response cevap) {
                List<Urun> urunler = Veritabani.kayitlariAl();
                // return jsonYardimci.toJson(URUNLER);
                return jsonYardimci.toJson(urunler);
            }
        };
        get(sayfa2);
    }
    private static void urunleriGoruntule() {
        FreeMarkerRoute sayfa3 = new FreeMarkerRoute("/urunler") {
            @Override
            public Object handle(Request arg0, Response arg1) {
                List<Urun> urunler = Veritabani.kayitlariAl();
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                // ozellikler.put("urunler", URUNLER);
                ozellikler.put("urunler", urunler);
                return new ModelAndView(ozellikler, "urunler.html");
            }
        };
        get(sayfa3);
    }

}