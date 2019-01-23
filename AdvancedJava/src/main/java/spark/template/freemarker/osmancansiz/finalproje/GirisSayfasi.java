package spark.template.freemarker.osmancansiz.finalproje;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;

public class GirisSayfasi {

	public static void sayfalariTanimla() {

		girisSayfasiTanimla();
		girisFormPostTanimla();

	}

	private static void girisFormPostTanimla() {

		// giris sayfasi form post action
		Route girisFormPostAction = new Route("/osmancansiz/giris_sayfasi/login") {
			@Override
			public Object handle(Request istek, Response cevap) {

				// giris_sayfasi.html form icinde
				// <input type="text" name="kullaniciadi" />
				String kullaniciadi = istek.queryParams("kullaniciadi"); 
				
				Kullanici kullanici = VeritabaniYonetimi.kullaniciSorgula(kullaniciadi);
				if(kullanici == null) {
					System.out.println("Verilen kullanici bulunamadi " + kullaniciadi);
					// TODO hatayi sayfada goster
					cevap.redirect("/osmancansiz/giris_sayfasi/");
				} 				
				
				else {
					String sifre = istek.queryParams("sifre");
					if(kullanici.getSifre().equals(sifre)) {
						if(kullanici.getKullaniciTipi().equals("ADMIN")) {
							System.out.println("Sifre dogru. Giris basarili");
							UygulamaMain.girisYapmisKullanici = kullanici;
							cevap.redirect("/osmancansiz/yonetici_anasayfa/");
						}else {
							System.out.println("Sifre dogru. Giris basarili");
							UygulamaMain.girisYapmisKullanici = kullanici;
							cevap.redirect("/osmancansiz/");
						}
					} else {
						System.out.println("Sifre hatali.");
						cevap.redirect("/osmancansiz/giris_sayfasi/");
					}
				}
				return null;
			}
		};
		post(girisFormPostAction);

	}

	private static void girisSayfasiTanimla() {
		FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/osmancansiz/giris_sayfasi/" // Sayfaya hangi URL ile
																						// erisecegimi tanimliyorum
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(null, "/osmancansiz/finalproje/giris_sayfasi.html" // spark/template/freemarker/
																							// altindaki dosya yolu
				);
			}
		};
		get(girisSayfasi);
	}
}
