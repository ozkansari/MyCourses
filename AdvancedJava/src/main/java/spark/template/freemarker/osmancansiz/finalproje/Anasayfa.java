package spark.template.freemarker.osmancansiz.finalproje;

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
		yoneticiSayfaGet();
	}
	
	private static void anaSayfaGET() {
		FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/osmancansiz/" // Sayfaya hangi URL ile
																						// erisecegimi tanimliyorum
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				// Kullanici kullanici = VeritabaniYonetimi.kullaniciSorgula("guest");
				Kullanici kullanici = UygulamaMain.girisYapmisKullanici;
				if (kullanici == null) {
					System.out.println("Once giris yapilmali");
					cevap.redirect("/osmancansiz/giris_sayfasi/");
				}
				
				Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
				sayfaVerisi.put("kullaniciadi", kullanici.getKullaniciAdi());
				
				return new ModelAndView(sayfaVerisi, "/osmancansiz/finalproje/anasayfa.html" // spark/template/freemarker/
																							// altindaki dosya yolu
				);
			}
			
		};
		get(anaSayfa);
	}
	
	private static void yoneticiSayfaGet() {
		FreeMarkerRoute yoneticiSayfa = new FreeMarkerRoute("/osmancansiz/yonetici_anasayfa/")
		{
			@Override
			public Object handle(Request istek, Response cevap) {
				
				// Kullanici kullanici = VeritabaniYonetimi.kullaniciSorgula("guest");
				Kullanici kullanici = UygulamaMain.girisYapmisKullanici;
				if (kullanici == null) {
					System.out.println("Once giris yapilmali");
					cevap.redirect("/osmancansiz/giris_sayfasi/");
				}
				
				Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
				sayfaVerisi.put("kullaniciadi", kullanici.getKullaniciAdi());
				
				return new ModelAndView(sayfaVerisi, "/osmancansiz/finalproje/yonetici_anasayfa.html" // spark/template/freemarker/
																							// altindaki dosya yolu
				);
			}
			
		};
		get(yoneticiSayfa);
	}
	
}
