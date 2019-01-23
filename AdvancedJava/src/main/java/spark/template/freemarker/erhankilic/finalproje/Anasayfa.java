package spark.template.freemarker.erhankilic.finalproje;

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
		FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/erhankilic/anasayfa" ) {
			@Override
			public Object handle(Request istek, Response cevap) {
				Kullanici kullanici = UygulamaMain.girisYapmisKullanici;
				if (kullanici == null) {
					System.out.println("Once giris yapilmali");
					cevap.redirect("/finalproje/giris_sayfasi/");
				}
				
				Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
				sayfaVerisi.put("kullaniciadi", kullanici.getKullaniciAdi());
				return new ModelAndView(sayfaVerisi, "/erhankilic/finalproje/anasayfa.html" 
				);
			}
		};
		get(anaSayfa);
	}
}