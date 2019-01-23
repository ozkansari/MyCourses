// OZKANS FIX package ErtugrulSueren.Ertugrull;
package spark.template.freemarker.ertugrulsueren.finalproje;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import java.util.*;

// OZKANS FIX public class Anasayfa {
public class anasayfa {
	
	public static void sayfalariTanimla() {
		anaSayfaGET();
	}
	
	private static void anaSayfaGET() {
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
		// http://0.0.0.0:4567/ozkansari/
		FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/ozkansari/" // Sayfaya hangi URL ile
																						// erisecegimi tanimliyorum
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				// Kullanici kullanici = VeritabaniYonetimi.kullaniciSorgula("guest");
// OZKANS FIX	Kullanici kullanici = UygulamaMain.girisYapmisKullanici;
				Kullanici kullanici = null;
				if (kullanici == null) {
					System.out.println("Once giris yapilmali");
					cevap.redirect("/ozkansari/giris_sayfasi/");
				}
				
				Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
				sayfaVerisi.put("kullaniciadi", kullanici.getKullaniciAdi());
				return new ModelAndView(sayfaVerisi, "/ozkansari/finalproje/anasayfa.html" // spark/template/freemarker/
																							// altindaki dosya yolu
				);
			}
		};
		get(anaSayfa);
	}
}