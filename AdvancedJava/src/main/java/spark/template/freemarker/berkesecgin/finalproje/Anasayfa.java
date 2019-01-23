package spark.template.freemarker.berkesecgin.finalproje;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import java.util.*;

public class Anasayfa {

	public static void sayfalariTanimla() {
		anaSayfaGET();
	}
	
	private static void anaSayfaGET() {
		
		FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/berkesecgin/" ) {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				
				Kullanici kullanici = UygulamaMain.girisYapmisKullanici;
				if (kullanici == null) {
					System.out.println("Once giris yapilmali");
					cevap.redirect("/berkesecgin/giris_sayfasi/");
				}
				
				Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
				sayfaVerisi.put("kullaniciadi", kullanici.getKullaniciAdi());
				return new ModelAndView(sayfaVerisi, "/berkesecgin/finalproje/anasayfa.html");
			}
		};
		get(anaSayfa);
	}
}
