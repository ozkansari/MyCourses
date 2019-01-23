package spark.template.freemarker.efkanic.finalproje;

public class ApplicationMain {
	public static User girisYapmisKullanici = null;
	public static void main(String[] args) {

		VeritabaniYonetimi.veritabaniBaglantisiKur();
		VeritabaniYonetimi.tablolariOlustur();
		VeritabaniYonetimi.kullanicilariOlustur();
		VeritabaniYonetimi.urunleriolustur();
		Register.sayfalariTanimla();
		Loginscreen.sayfalariTanimla();
		Error.sayfalariTanimla();
	}
}
