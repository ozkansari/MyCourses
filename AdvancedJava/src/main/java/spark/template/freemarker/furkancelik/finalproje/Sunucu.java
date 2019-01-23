package spark.template.freemarker.furkancelik.finalproje;
import spark.Spark;
import spark.template.freemarker.furkancelik.finalproje.modeller.Kullanici;
import spark.template.freemarker.furkancelik.finalproje.modeller.Siparis;
import spark.template.freemarker.furkancelik.finalproje.modeller.Urun;

import java.util.ArrayList;
import java.util.List;


public class Sunucu {

    public VeritabaniIslemleri veritabani;

    public Kullanici girisYapmisKullanici = null;

    public List<Urun> sepetim = new ArrayList<Urun>();

    public String hata = null;

    public void baslat(){

        // Veritabani baglantisi olustur
        veritabani = new VeritabaniIslemleri();
        // Tablolar eklenmemişse oluştur
        veritabani.TablolariOlustur();

        // Giris Sayfasi
        Spark.get(new GirisSayfasi("giris_sayfasi", this, "giris_goster"));
        Spark.post(new GirisSayfasi("giris_sayfasi/giris", this, "giris_yap"));
        Spark.get(new GirisSayfasi("giris_sayfasi/kayitol", this, "kayit_goster"));
        Spark.post(new GirisSayfasi("giris_sayfasi/kayitol/olustur", this, "kayit_ol"));

        // Uye Sayfasi
        Spark.get(new AnaSayfa("", this, "anasayfa_goster"));
        Spark.get(new AnaSayfa("urun_ekle", this, "urun_ekle"));
        Spark.get(new AnaSayfa("urun_kaldir", this, "urun_kaldir"));
        Spark.get(new AnaSayfa("siparis_olustur", this, "siparis_olustur"));


        // Yonetici Sayfalari
        Spark.get(new YoneticiAnasayfa("yonetici", this, "anasayfa"));
        Spark.post(new YoneticiAnasayfa("yonetici/kullanici_ekle", this, "kullanici_ekle"));
        Spark.get(new YoneticiAnasayfa("yonetici/kullanici_sil", this, "kullanici_sil"));
        Spark.post(new YoneticiAnasayfa("yonetici/urun_ekle", this, "urun_ekle"));


        // Hata Sayfasi
        Spark.get(new HataSayfasi("hata", this));

        // Cikis islemi
        Spark.get(new Cikis("cikis", this));

    }
}
