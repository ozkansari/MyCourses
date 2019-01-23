package spark.template.freemarker.musademirci.finalproje;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class Anasayfa {

	public static void sayfalariTanimla() {
		anaSayfaGET();
	}
	
	private static void anaSayfaGET() {
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
		// http://0.0.0.0:4567/ozkansari/
		FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/musademirci/") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				// Kullanici kullanici = VeritabaniYonetimi.kullaniciSorgula("guest");
				Kullanici kullanici = UygulamaMain.girisYapmisKullanici;
				if (kullanici == null) {
					System.out.println("Once giris yapilmali");
					cevap.redirect("/musademirci/giris_sayfasi/");
				}
				
				Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
				sayfaVerisi.put("kullaniciadi", kullanici.getKullaniciAdi());
				return new ModelAndView(sayfaVerisi, "/musademirci/finalproje/anasayfa.html" 
				);
			}
		};
		get(anaSayfa);
	}
}