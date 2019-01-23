package spark.template.freemarker.musademirci.finalproje;

public class UygulamaMain {

	public static Kullanici girisYapmisKullanici = null;
	
	public static void main(String[] args) {
		
		VeritabaniYonetimi.veritabaniBaglantisiKur();
		VeritabaniYonetimi.tablolariOlustur();
		VeritabaniYonetimi.kullanicilariOlustur();
		GirisSayfasi.sayfalariTanimla();
		UyeSayfasi.sayfalariTanimla();
		Anasayfa.sayfalariTanimla();
	}
}
