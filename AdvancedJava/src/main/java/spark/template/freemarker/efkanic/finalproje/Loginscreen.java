package spark.template.freemarker.efkanic.finalproje;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

public class Loginscreen {
	public static void sayfalariTanimla() {

	girisSayfasiTanimla();
	girisFormPostTanimla();

}

private static void girisFormPostTanimla() {

	// giris sayfasi form post action
	Route girisFormPostAction = new Route("/efkanic/finalproje/giris_sayfasi") {
		@Override
		public Object handle(Request istek, Response cevap) {
			Map<String,String> sayfaVerisi = new HashMap<>();
			// giris_sayfasi.html form icinde
			// <input type="text" name="kullaniciadi" />
			sayfaVerisi.put("hata", "yok");
			String kullaniciadi = istek.queryParams("kullaniciadi"); 
			User kullanici = VeritabaniYonetimi.kullaniciSorgula(kullaniciadi);
			if(kullanici == null) {
				System.out.println("Verilen kullanici bulunamadi " + kullaniciadi);
				// TODO hatayi sayfada goster
				cevap.redirect("/efkanic/finalproje/giris_sayfasi");
			} else {
				
				// giris_sayfasi.html form icinde
				// <input type="text" name="sifre" />
				String sifre = istek.queryParams("sifre");
				
				if(kullanici.getSifre().equals(sifre)) {
					System.out.println("Sifre dogru. Giris basarili");
					HomePage.sayfalariTanimla();
					cevap.redirect("/efkanic/finalproje/homepage");
				} else {
					System.out.println("Sifre hatali.");
					cevap.redirect("/efkanic/finalproje/giris_sayfasi");
				}
			}
			return null;
		}
	};
	post(girisFormPostAction);

}

private static void girisSayfasiTanimla() {
	// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
	// http://0.0.0.0:4567/ozkansari/giris_sayfasi/
	FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/efkanic/finalproje/giris_sayfasi" // Sayfaya hangi URL ile
																					// erisecegimi tanimliyorum
	) {
		@Override
		public Object handle(Request istek, Response cevap) {
			return new ModelAndView(null, "/efkanic/finalproje/giris_sayfasi.html" // spark/template/freemarker/
																						// altindaki dosya yolu
			);
		}
	};
	get(girisSayfasi);
}
}
