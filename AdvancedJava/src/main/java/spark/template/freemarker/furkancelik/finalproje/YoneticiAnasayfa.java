package spark.template.freemarker.furkancelik.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.furkancelik.finalproje.modeller.Kullanici;
import spark.template.freemarker.furkancelik.finalproje.modeller.Urun;

import java.util.HashMap;
import java.util.Map;

public class YoneticiAnasayfa extends IsimAbstract {
    Sunucu sunucu;
    String islem = null;

    protected YoneticiAnasayfa(String path, Sunucu sunucu, String islem) {
        super(path);
        this.sunucu = sunucu;
        this.islem = islem;
    }

    @Override
    public Object handle(Request request, Response response) {

        if (sunucu.girisYapmisKullanici == null) {
            sunucu.hata = "Anasayfaya gitmek için lütfen önce giriş yapın!";
            response.redirect("/furkancelik/hata");
            return null;
        }

        if (!sunucu.girisYapmisKullanici.getKullaniciTipi().equals("ADMIN")) {
            sunucu.hata = "Kullanıcının bu sayfayı görmeye yetkisi yoktur";
            response.redirect("/furkancelik/hata");
            return null;
        }

        // Yonetici anasayfasini göster
        if (islem.equals("anasayfa")) {
            Map<String, Object> sayfaVerisi = new HashMap<String, Object>();

            sayfaVerisi.put("kullanici", sunucu.girisYapmisKullanici);
            sayfaVerisi.put("kullanicilar", sunucu.veritabani.KullanicilariGetir());
            sayfaVerisi.put("urunler", sunucu.veritabani.UrunleriGetir());
            sayfaVerisi.put("siparisler", sunucu.veritabani.SiparisleriGetir());

            return new ModelAndView(sayfaVerisi, "/furkancelik/finalproje/yonetici_anasayfa.html");
        }

        if (islem.equals("kullanici_ekle")) {
            String kullaniciAdi = request.queryParams("kullaniciadi");
            String kullaniciTipi = request.queryParams("kullanicitipi");
            String sifre = request.queryParams("sifre");
            String cinsiyet = request.queryParams("cinsiyet");
            String yas = request.queryParams("yas");

            if (kullaniciAdi == null || kullaniciTipi == null || sifre == null || cinsiyet == null || yas == null) {
                System.out.println("Eksik bilgi girildi");
                response.redirect("/furkancelik/yonetici");
                return null;
            }

            Kullanici kullanici = new Kullanici(kullaniciAdi, kullaniciTipi, Integer.parseInt(yas), cinsiyet, sifre);

            sunucu.veritabani.KullaniciEkle(kullanici);

            System.out.println("Kullanıcı Eklendi");
            response.redirect("/furkancelik/yonetici");
            return null;

        }

        if (islem.equals("kullanici_sil")) {

            String kullaniciAdi = request.queryParams("kullaniciadi");

            if (kullaniciAdi == null) {
                response.redirect("/furkancelik/yonetici");
                return null;
            }

            sunucu.veritabani.KullaniciSil(kullaniciAdi);

            response.redirect("/furkancelik/yonetici");
            return null;
        }

        if (islem.equals("urun_ekle")) {

            String urunAdi = request.queryParams("urunadi");
            String urunKategori = request.queryParams("urunkategori");
            String fiyat = request.queryParams("fiyat");

            if (urunAdi == null || urunKategori == null || fiyat == null) {
                System.out.println("Eksik bilgi girildi");
                response.redirect("/furkancelik/yonetici");
                return null;
            }

            Urun urun = new Urun(sunucu.veritabani.EssizIdGetir("urunler"), urunAdi, urunKategori, Integer.parseInt(fiyat));

            sunucu.veritabani.UrunEkle(urun);

            response.redirect("/furkancelik/yonetici");
            return null;

        }


        return "Yonetici Sayfasi";
    }
}
