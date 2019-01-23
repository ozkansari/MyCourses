package spark.template.freemarker.osmancansiz.finalproje;

public class UygulamaMain {

	public static Kullanici girisYapmisKullanici = null;
	
	public static void main(String[] args) {
		
		VeritabaniYonetimi.veritabaniBaglantisiKur();
		VeritabaniYonetimi.tablolariOlustur();
		VeritabaniYonetimi.urunleriOlustur();
		VeritabaniYonetimi.urunleriListele();
		GirisSayfasi.sayfalariTanimla();
		UyeSayfasi.sayfalariTanimla();
		Anasayfa.sayfalariTanimla();
	}
}
