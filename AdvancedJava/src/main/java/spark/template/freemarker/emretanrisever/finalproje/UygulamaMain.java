package spark.template.freemarker.emretanrisever.finalproje;

public class UygulamaMain {

	public static Kullanici girisYapmisKullanici = null;
	public static Kullanici Admin = null;
	
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
