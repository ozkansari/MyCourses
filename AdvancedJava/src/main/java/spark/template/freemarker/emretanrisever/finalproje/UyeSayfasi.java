package spark.template.freemarker.emretanrisever.finalproje;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;

public class UyeSayfasi {

	public static void sayfalariTanimla() {
		uyeSayfasi();
		UyeOl();
	}
	
	private static void uyeSayfasi() {
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
				// http://0.0.0.0:4567//ozkansari/uye_sayfasi/
				FreeMarkerRoute girisSayfasi = new FreeMarkerRoute(
						"/emretanrisever/uye_sayfasi/" // Sayfaya hangi URL ile erisecegimi tanimliyorum
				) {
					@Override
					public Object handle(Request istek, Response cevap) {
						return new ModelAndView(
								null, 
								"/emretanrisever/finalproje/uye_sayfasi.html" // spark/template/freemarker/ altindaki dosya yolu
						);
					}
				};
				get(girisSayfasi);
	}
	
	private static void UyeOl() {
		Route girisFormPostAction = new Route("/emretanrisever/uye_sayfasi/create") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				// giris_sayfasi.html form icinde
				// <input type="text" name="kullaniciadi" />
				String kullaniciadi = istek.queryParams("kullanici_adi"); 
				String kullaniciyas = istek.queryParams("kullanici_yas");
				int yas = Integer.valueOf(kullaniciyas);
				String cinsiyet = istek.queryParams("kullanici_cinsiyet");
				char Cinsiyet = cinsiyet.charAt(0);
				String sifre = istek.queryParams("kullanici_sifre");
				
				Boolean kayit = VeritabaniYonetimi.kullanici_Kayit(kullaniciadi, yas, Cinsiyet, sifre);
				if(kayit == true) {
					System.out.println("Kayýt baþarýlý");
					cevap.redirect("/emretanrisever/giris_sayfasi/");
				} else {
					cevap.redirect("/emretanrisever/hata");
				}
				
				return null;
			}
		};
		post(girisFormPostAction);
	}
	
}
