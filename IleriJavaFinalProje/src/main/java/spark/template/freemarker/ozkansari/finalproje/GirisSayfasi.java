package spark.template.freemarker.ozkansari.finalproje;

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
		Route girisFormPostAction = new Route("/ozkansari/giris_sayfasi/login") {
			@Override
			public Object handle(Request istek, Response cevap) {

				// giris_sayfasi.html form icinde
				// <input type="text" name="kullaniciadi" />
				String kullaniciadi = istek.queryParams("kullaniciadi"); 
				
				// giris_sayfasi.html form icinde
				// <input type="text" name="sifre" />
				String sifre = istek.queryParams("sifre");
				
				System.out.println("" + kullaniciadi + " " + sifre);
				// TODO Kullanici adi ve sifre kontrol et
				
				cevap.redirect("/ozkansari/");
				return null;
			}
		};
		post(girisFormPostAction);

	}

	private static void girisSayfasiTanimla() {
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
		// http://0.0.0.0:4567/ozkansari/giris_sayfasi/
		FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/ozkansari/giris_sayfasi/" // Sayfaya hangi URL ile
																						// erisecegimi tanimliyorum
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(null, "/ozkansari/finalproje/giris_sayfasi.html" // spark/template/freemarker/
																							// altindaki dosya yolu
				);
			}
		};
		get(girisSayfasi);
	}
}
