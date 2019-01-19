package tr.edu.medipol.ilerijava.final_odev2.osmancansiz;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

import java.util.*; // List ve ArrayList icin

public class WebMain {
	
	private static List<String> ogrenciListesi = new ArrayList<String>();
	private static List<String> ogretmenListesi = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		ogrenciListesi.add("Efkan");
		ogrenciListesi.add("Berke");
		ogrenciListesi.add("Osman");
		
		ogretmenListesi.add("Ali");
		ogretmenListesi.add("Ozkan");
		
		// http://0.0.0.0:4567/weborn/ogrenciler/ anasayfamızda get işlemi
		FreeMarkerRoute ogrencilerSayfasi = new 
				OgrencilerSayfasiFreemarkerRoute("/weborn/ogrenciler");
		get(ogrencilerSayfasi);
		

		FreeMarkerRoute indexSayfa = new FreeMarkerRoute("/weborn/ogrenciekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/osmancansiz/finalodev2/ogrenciekle.html");
			}
		};
		get(indexSayfa);
		
		FreeMarkerRoute ogretmenSayfa = new FreeMarkerRoute("/weborn/ogrenciekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/osmancansiz/finalodev2/ogretmenekle.html");
			}
		};
		get(ogretmenSayfa);
		
		// http://0.0.0.0:4567/weborn/ogrenciekle/ sayfasında post
		
		Route ogrenciEkleSayfasi = new Route("/weborn/ogrencieklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogrenciListesi.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/weborn/ogrenciler");
				return null;
			}
		};
		post(ogrenciEkleSayfasi);
		
		// http://0.0.0.0:4567/weborn/ogretmenekle/ sayfasında post
		
		Route ogretmenEkleSayfasi = new Route("/weborn/ogretmeneklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogretmenListesi.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/weborn/ogrenciler");
				return null;
			}
		};
		post(ogretmenEkleSayfasi);
	}
	
	private static class OgrencilerSayfasiFreemarkerRoute extends FreeMarkerRoute {
		
		protected OgrencilerSayfasiFreemarkerRoute(String path) {
			super(path);
		}

		@Override
		public Object handle(Request arg0, Response arg1) {
			Map<String, Object> sayfaVerisi = new HashMap<String, Object>();
			sayfaVerisi.put("ogretmenler", ogretmenListesi);
			return new ModelAndView(sayfaVerisi, "/osmancansiz/finalodev2/ogrenciler.html");
		}
	}
}
