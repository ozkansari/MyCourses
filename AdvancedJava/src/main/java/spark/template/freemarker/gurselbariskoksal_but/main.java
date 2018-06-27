package spark.template.freemarker.gurselbariskoksal_but;
/**
 * Kullanici nesnesi.
 * @author bariskoksal
 *
 */
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

    static List<kullanici> kullanicilarList = new ArrayList<kullanici>();

    /**
     * Oturum bilgileri.
     */
    static boolean kullaniciNormal = false;
    static boolean kullaniciAdmin = false;

    static veriTabani vTabani;

    static kullanici admin ;

    public static void main(String[] args ) throws Exception{

        /**
         * Veri tabani kullanıma hazirlanir,
         * Admin veritabanina eklenir.
         */
        vTabani = new veriTabani();
        admin = new kullanici("gursel","admin",20,"e","123");
        vTabani.kullaniciEkle(admin);

        /**
         * Giris sayfasi get methodu.
         *
         */
        FreeMarkerRoute anaSayfaRoute = new FreeMarkerRoute("/giris_sayfasi"){
            public Object handle(Request istek, Response cevap) {

                //Veri tabanindan kullanicilar cekilerek HashMap araciligiyla aktarilir.
                Map<String, Object> ozellikler = new HashMap<String, Object>();
                try {
                    kullanicilarList = vTabani.kayitlariAl();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ozellikler.put("kullanicilar", kullanicilarList);

                return new ModelAndView(ozellikler, "/gurselbariskoksal_but/giris_sayfasi.html");
            }
        };get(anaSayfaRoute);

        /**
         * Giris sayfasi post.
         *
         */
        FreeMarkerRoute kullaniciEkleIslemi = new FreeMarkerRoute("/giris") {
            @Override
            public Object handle(Request istek, Response cevap) {


                String ad = istek.queryParams("ad");
                String sifre = istek.queryParams("sifre");

                boolean sonuc = vTabani.kullaniciKontrol(ad,sifre);

                //Giris basariliyla / dizinine
                //Giris basarisizsa ayni sayfaya tekrar yonlendirilir.
                if(sonuc){
                    kullaniciNormal = true;
                    if(ad.equals(admin.getKullanici_adi()))
                        kullaniciAdmin = true;
                    cevap.redirect("/");
                }else{
                    return new ModelAndView(null, "/gurselbariskoksal_but/hata.html");
                }
                return null;
            }
        };
        post(kullaniciEkleIslemi);

        /**
         * Uye sayfasi get methodu.
         */

        FreeMarkerRoute kullaniciEkle = new FreeMarkerRoute("/uye_sayfasi") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/gurselbariskoksal_but/uye_sayfasi.html");
            }
        };
        get(kullaniciEkle);

        /**
         * Yeni kullanici ekle post.
         *
         */

        Route yeniKullaniciEklePostRoute = new FreeMarkerRoute("/yeniKullaniciEkle") {

            public Object handle(Request istek, Response cevap) {
                String ad = istek.queryParams("ad");
                int yas = Integer.parseInt(istek.queryParams("yas"));
                String cinsiyet = istek.queryParams("cinsiyet");
                String sifre = istek.queryParams("sifre");

                try {
                    vTabani.kullaniciEkle(ad, "normal" , yas, cinsiyet, sifre);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                kullaniciNormal =  true ;
                cevap.redirect("/");
                return null;
            }
        };
        post(yeniKullaniciEklePostRoute);

        /**
         * yeni kullanici olusturmaktan vazgec.
         *
         */
        FreeMarkerRoute eklemektenVazgec = new FreeMarkerRoute("/vazgec") {
            public Object handle(Request istek, Response cevap) {
                return new ModelAndView(null, "/gurselbariskoksal_but/giris_sayfasi.html");
            }
        };
        get(eklemektenVazgec);


        FreeMarkerRoute normalKullanici = new FreeMarkerRoute("/") {
            public Object handle(Request istek, Response cevap) {
                if(kullaniciNormal){
                    Map<String, Object> ozellikler = new HashMap<String, Object>();
                    kullanicilarList = vTabani.kayitlariAl();

                    ozellikler.put("kullanicilar", kullanicilarList);

                    return new ModelAndView(ozellikler, "/gurselbariskoksal_but/kullanici_goruntule.html");
                }else{


                    return new ModelAndView(null, "/gurselbariskoksal_but/hata.html");
               }

            }
        };
        get(normalKullanici);
        /**
         * yonetici
         *oturum durumuna gore hata sayfasina yada yonetici paneline yonlendirir
         */
        FreeMarkerRoute adminKullanici = new FreeMarkerRoute("/yonetici") {
            public Object handle(Request istek, Response cevap) {

                    if(kullaniciAdmin){
                        Map<String, Object> ozellikler = new HashMap<String, Object>();
                        kullanicilarList = vTabani.kayitlariAl();

                        ozellikler.put("kullanicilar", kullanicilarList);

                        return new ModelAndView(ozellikler, "/gurselbariskoksal_but/yonetici.html");
                    }
                    else{

                            return new ModelAndView(null, "/gurselbariskoksal_but/hata.html");
                        }



            }
        };
        get(adminKullanici);

        /**
         * kullanici sil post.
         *
         */
        Route kitapSilPostRoute = new FreeMarkerRoute("/kullanici_sil") {
            public Object handle(Request istek, Response cevap) {

                String ad =  istek.queryParams("kullaniciAdi");

                try {
                    vTabani.kullaniciSil(ad);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                cevap.redirect("/yonetici");
                return null;
            }
        };
        post(kitapSilPostRoute);

    }

}

