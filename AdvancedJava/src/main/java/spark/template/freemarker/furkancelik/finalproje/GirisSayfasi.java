package spark.template.freemarker.furkancelik.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.furkancelik.finalproje.modeller.Kullanici;

public class GirisSayfasi extends IsimAbstract {

    Sunucu sunucu;
    String islem;

    protected GirisSayfasi(String path, Sunucu sunucu, String islem) {
        super(path);
        this.sunucu = sunucu;
        this.islem = islem;
    }

    @Override
    public Object handle(Request request, Response response) {


        if(islem.equals("giris_goster")){
            return new ModelAndView(null,"/furkancelik/finalproje/giris_sayfasi.html");
        }

        if(islem.equals("giris_yap")){
            String kullaniciAdi = request.queryParams("kullaniciadi");

            String sifre = request.queryParams("sifre");

            Kullanici kullanici = sunucu.veritabani.KullaniciBul(kullaniciAdi);

            // Kullanici bulundu sifre kontrolü yap
            if(kullanici != null){
                if(kullanici.getSifre().equals(sifre)){
                    System.out.println("Kullanici giris yapti : " + kullaniciAdi);
                    sunucu.girisYapmisKullanici = kullanici;

                    // Rol kontrolü yap
                    if(kullanici.getKullaniciTipi().equals("ADMIN")){
                        response.redirect("/furkancelik/yonetici");
                    }else{
                        response.redirect("/furkancelik/");
                    }

                }else{
                    sunucu.hata="Şifreniz kullanıcı ile uyuşmadı!";
                    response.redirect("/furkancelik/hata");
                }

            }else{
                sunucu.hata="Kullanıcı bulunamadı!";
                response.redirect("/furkancelik/hata");
            }

            return null;
        }


        if(islem.equals("kayit_goster")){
            return new ModelAndView(null,"/furkancelik/finalproje/kayitol.html");
        }

        if(islem.equals("kayit_ol")){
            String kullaniciAdi = request.queryParams("kullaniciadi");
            String kullaniciTipi = "NORMAL";
            String sifre = request.queryParams("sifre");
            String cinsiyet = request.queryParams("cinsiyet");
            String yas = request.queryParams("yas");

            if (kullaniciAdi == null || sifre == null || cinsiyet == null || yas == null) {
                System.out.println("Kayıt olurken eksik bilgi girildi");
                sunucu.hata = "Eksik yada yanlış bilgi girdiniz";
                response.redirect("/furkancelik/hata");
                return null;
            }

            Kullanici kullanici = new Kullanici(kullaniciAdi, kullaniciTipi, Integer.parseInt(yas), cinsiyet, sifre);

            sunucu.veritabani.KullaniciEkle(kullanici);

            System.out.println("Kullanıcı Eklendi");
            response.redirect("/furkancelik/giris_sayfasi");
            return null;
        }


        return null;

    }
}
