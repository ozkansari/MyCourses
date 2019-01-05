package spark.template.freemarker.ozkansari;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

import java.util.*; // List ve ArrayList icin

public class WebOrnek3 {
	
	private static List<String> ogrenciListesi = new ArrayList<>();
	private static List<String> ogretmenListesi = new ArrayList<>();
	
	public static void main(String[] args) {
		
		ogrenciListesi.add("Efkan");
		ogrenciListesi.add("Berke");
		ogrenciListesi.add("Osman");
		
		ogretmenListesi.add("Ali");
		ogretmenListesi.add("Ozkan");
		
		// (1) http://0.0.0.0:4567/webornek/ogrenciler/
		FreeMarkerRoute ogrencilerSayfasi = new 
				OgrencilerSayfasiFreemarkerRoute("/webornek/ogrenciler");
		get(ogrencilerSayfasi);
		
		// (2) http://0.0.0.0:4567/webornek/ogrenciekle/
		FreeMarkerRoute indexSayfa = new FreeMarkerRoute("/webornek/ogrenciekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/ozkansari/ogrenciekle.html");
			}
		};
		get(indexSayfa);
		
		// (3) ogrenci ekle form post action
		Route ogrenciEkleSayfasi = new Route("/webornek/ogrencieklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogrenciListesi.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/webornek/ogrenciler");
				return null;
			}
		};
		post(ogrenciEkleSayfasi);
		
		
		Route ogrenciSilAksiyonu = new Route("/webornek/ogrencisil") {

			@Override
			public Object handle(Request istek, Response cevap) {
				
				String idstr = istek.queryParams("id");
				if(idstr != null ) {
					int idint = Integer.valueOf(idstr);
					ogrenciListesi.remove(idint);
				}
				cevap.redirect("/webornek/ogrenciler");
				return null;
			}
			
		};
		get(ogrenciSilAksiyonu);
		post(ogrenciSilAksiyonu);
	}
	
	private static class OgrencilerSayfasiFreemarkerRoute extends FreeMarkerRoute {
		
		protected OgrencilerSayfasiFreemarkerRoute(String path) {
			super(path);
		}

		@Override
		public Object handle(Request arg0, Response arg1) {
			Map<String, Object> sayfaVerisi = new HashMap<>();
			
			// HTML sayfasinda ogrenciListesi'ne 
			//  hangi anahtar kelimeyle erisecegimi belirtiyorum
			// <#list ogrenciler as ogrenci>
			sayfaVerisi.put("ogrenciler", ogrenciListesi);
			// sayfaVerisi.get("ogrenciler") --> ogrenciListesi
			
			sayfaVerisi.put("ogretmenler", ogretmenListesi);
			
			// Aslinda gerekli degil
			// Sayfadaki kullaniminin benzerini gostermek icin
			/*--
			for(String ogrenci : ogrenciListesi) {
				System.out.println(ogrenci);
			}
			*/
			
			return new ModelAndView(sayfaVerisi, "/ozkansari/ogrenciler.html");
		}
	}
}
