package spark.template.freemarker.efkanic.finalproje;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

public class Register {

	public static void sayfalariTanimla() {

	registerpage();
	registerform();

}
private static void registerform() {
	Route registerFormPostAction = new Route("/efkanic/finalproje/kayit") {
		@Override
		public Object handle(Request istek, Response cevap) {		
	String kullaniciadi = istek.queryParams("kullaniciadi");
	String sifre = istek.queryParams("sifre");
    String yas = istek.queryParams("yas");
	String cinsiyet = istek.queryParams("cinsiyet");
	User kullanici = VeritabaniYonetimi.kullaniciSorgula(kullaniciadi);
	if(kullanici == null) {
		if ("".equals(sifre)&&"".equals(cinsiyet)&&"".equals(yas)) {
			System.out.println("Bütün alanlarý doldurunuz.");
			cevap.redirect("/efkanic/finalproje/kayit");
		}else {
		       VeritabaniYonetimi.kayitol(kullaniciadi, yas, cinsiyet, sifre);
		        cevap.redirect("/efkanic/finalproje/giris_sayfasi");
	    }
	}
		else {
		System.out.println("Kullanýcý zaten var");
		cevap.redirect("/efkanic/finalproje/kayit");
	}
	return null;
		}
		};
		
post(registerFormPostAction);
	}
private static void registerpage() {
	// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
	// http://0.0.0.0:4567/ozkansari/giris_sayfasi/
	FreeMarkerRoute registerpage = new FreeMarkerRoute("/efkanic/finalproje/kayit" // Sayfaya hangi URL ile
																					// erisecegimi tanimliyorum
	) {// altindaki dosya yolu
		@Override
		public Object handle(Request istek, Response cevap) {			
			return new ModelAndView(null, "/efkanic/finalproje/kayit.html" // spark/template/freemarker/
			);
		}
	};
	get(registerpage);
}
	

}
