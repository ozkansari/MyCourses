package spark.template.freemarker.furkancelik.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.furkancelik.finalproje.modeller.Siparis;
import spark.template.freemarker.furkancelik.finalproje.modeller.Urun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnaSayfa extends IsimAbstract {

    Sunucu sunucu;
    String islem;
    protected AnaSayfa(String path, Sunucu sunucu, String islem) {
        super(path);
        this.sunucu = sunucu;
        this.islem = islem;
    }

    @Override
    public Object handle(Request request, Response response) {
        if(sunucu.girisYapmisKullanici == null){
            sunucu.hata = "Anasayfaya gitmek için lütfen önce giriş yapın!";
            response.redirect("hata");
            return null;
        }

        if(islem.equals("anasayfa_goster")){
            Map<String, Object> siteVerisi = new HashMap<String, Object>();

            siteVerisi.put("kullanici", sunucu.girisYapmisKullanici);
            siteVerisi.put("urunler", sunucu.veritabani.UrunleriGetir());
            siteVerisi.put("sepetim", sunucu.sepetim);

            return new ModelAndView(siteVerisi, "/furkancelik/finalproje/anasayfa.html");
        }

        if(islem.equals("urun_ekle")){

            String urunId = request.queryParams("urunid");

            if(urunId != null){
                Urun bulunanUrun = sunucu.veritabani.UrunGetir(urunId);
                if(bulunanUrun != null){
                    sunucu.sepetim.add(bulunanUrun);
                }
            }

            response.redirect("/furkancelik/");
            return null;

        }

        if(islem.equals("urun_kaldir")){

            String gelenUrunId = request.queryParams("urunid");

            if(gelenUrunId != null){
                Urun bulunanUrun = sunucu.veritabani.UrunGetir(gelenUrunId);

                if(bulunanUrun != null){
                    List<Urun> yeniSepet = new ArrayList<Urun>();

                    for(Urun sepettekiUrun : sunucu.sepetim){
                        if(sepettekiUrun.getUrunId() != bulunanUrun.getUrunId()){
                            yeniSepet.add(sepettekiUrun);
                        }
                    }

                    sunucu.sepetim = yeniSepet;
                }
            }

            response.redirect("/furkancelik/");
            return null;
        }

        if(islem.equals("siparis_olustur")){

            Siparis siparis = new Siparis(sunucu.veritabani.EssizIdGetir("siparisler"), sunucu.girisYapmisKullanici.getKullaniciAdi(), null, 0);
            String urunIdler = "";
            Integer toplamFiyat = 0;
            for(Urun urun : sunucu.sepetim){
                toplamFiyat = toplamFiyat + urun.getFiyat();
                urunIdler = urunIdler + urun.getUrunId() + ",";
            }

            siparis.setToplamUcret(toplamFiyat);
            siparis.setUrunIdler(urunIdler);

            sunucu.veritabani.SiparisEkle(siparis);

            sunucu.sepetim = new ArrayList<Urun>();

            response.redirect("/furkancelik/");
        }


        return null;
    }
}
