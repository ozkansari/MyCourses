package spark.template.freemarker.onurkaral.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

import static spark.Spark.get;
import static spark.Spark.post;

public class GirisSayfasi {
    public static void sayfalariTanimla() {
        GirisSayfasiTanimla();
        GirisFormTanimla();

    }
    private static void GirisFormTanimla() {


        Route girisFormPostAction = new Route("/onurkaral/giris_sayfasi/login") {
            @Override
            public Object handle(Request istek, Response cevap) {
                String kullaniciadi = istek.queryParams("kullaniciadi");
                
                // OZKANS Neden iki kere ayni sorgu???
                Kullanici kullanici = VeritabaniYonetimi.kullaniciSorgula(kullaniciadi);
                Kullanici ADMIN = VeritabaniYonetimi.kullaniciSorgula(kullaniciadi);
                
                if(kullanici == null) {
                    System.out.println("Verilen Kullanici Bulunamadi.! " + kullaniciadi);
                    // TODO hatayi sayfada goster
                    cevap.redirect("/onurkaral/giris_sayfasi/");
                } else {

                	
                    String sifre = istek.queryParams("sifre");
                    
                    // OZKANS kullanici adi ile kullanici tipini karsilastirmak manasiz. Ikisi farkli alan. ???
                    if(kullanici.getKullaniciTipi().equals(kullaniciadi)){
                    	UygulamaMain.girisYapmisKullanici = ADMIN;
                    	cevap.redirect("/onurkaral/yonetici_anasayfa/");
                    } else if(kullanici.getSifre().equals(sifre)) {
                        System.out.println("Sifre Dogru. Giris Basarili.");
                        UygulamaMain.girisYapmisKullanici = kullanici;
                        cevap.redirect("/onurkaral/");
                 
                    }else {
                        System.out.println("Sifre Hatali.!");
                        cevap.redirect("/onurkaral/giris_sayfasi/");
                    }
                }
                return null;
            }
        };
        post(girisFormPostAction);
    }
    private static void GirisSayfasiTanimla() {
        FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/onurkaral/giris_sayfasi/") {
            @Override
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/onurkaral/finalproje/giris_sayfasi.html");
            }
        };
        get(girisSayfasi);
    }
}
