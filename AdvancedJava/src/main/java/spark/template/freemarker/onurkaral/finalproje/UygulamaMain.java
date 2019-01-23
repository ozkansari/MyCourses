package spark.template.freemarker.onurkaral.finalproje;

public class UygulamaMain {

    public static Kullanici girisYapmisKullanici = null;

    public static void main(String[] args) {

        VeritabaniYonetimi.veritabaniBaglantisiKur();
        VeritabaniYonetimi.tablolariOlustur();
        VeritabaniYonetimi.kullanicilariOlustur();
        GirisSayfasi.sayfalariTanimla();
        UyeSayfasi.sayfalariTanimla();
        Anasayfa.sayfalariTanimla();
        YoneticiAnasayfa.sayfalariTanimla();
        HataSayfasi.sayfalariTanimla();
    }
}

