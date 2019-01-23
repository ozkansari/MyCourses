package spark.template.freemarker.osmancansiz.finalproje;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;

public class UyeSayfasi {

	public static void sayfalariTanimla() {

		uyeSayfasiTanimla();
		uyeSayfasiPostTanimla();

	}

	public static void uyeSayfasiPostTanimla() {
		// üye sayfasi form post action
		Route uyeFormPostAction = new Route("/osmancansiz/uye_sayfasi/create") {
			@Override
			public Object handle(Request istek, Response cevap) {

				// giris_sayfasi.html form icinde
				// <input type="text" name="kullaniciadi" />
				String kullaniciadi = istek.queryParams("kullaniciadi");
				String yas = istek.queryParams("yas");
				String cinsiyet = istek.queryParams("cinsiyet");
				String sifre = istek.queryParams("sifre");
				int parseYas = Integer.parseInt(yas);					

				Kullanici kullanici = VeritabaniYonetimi.kullanicilariOlustur(kullaniciadi, parseYas, cinsiyet, sifre);
				if (kullanici == null) {
					System.out.println("Verilen kullanici bulunamadi " + kullaniciadi);
					// TODO hatayi sayfada goster
					cevap.redirect("/osmancansiz/giris_sayfasi/");
				} 
				
				if(" ".equals(kullaniciadi) || " ".equals(yas) || " ".equals(cinsiyet) || " ".equals(sifre)) {
					System.out.println("Alanları boş bırakmayınız.");
					cevap.redirect("/osmancansiz/uye_sayfası");
				}
				else {
					VeritabaniYonetimi.kullanicilariOlustur(kullaniciadi, parseYas, cinsiyet, sifre);
				}

				return null;
			}
		};
		post(uyeFormPostAction);
	}

	public static void uyeSayfasiTanimla() {

		FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/osmancansiz/uye_sayfasi/" // Sayfaya hangi URL ile
																						// erisecegimi tanimliyorum
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(null, "/osmancansiz/finalproje/uye_sayfasi.html" // spark/template/freemarker/
																						// altindaki dosya yolu
				);
			}
		};
		get(girisSayfasi);
	}
}
