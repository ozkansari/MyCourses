package tr.edu.medipol.ilerijava.final_odev2.tahakeskin;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

import java.util.*; // List ve ArrayList icin

public class TahaKeskinWebOdev {
	
	private static List<String> ogrenciListesi = new ArrayList<>();
	private static List<String> ogretmenListesi = new ArrayList<>();
	
	public static void main(String[] args) {
		
		ogrenciListesi.add("Mehmet");
		ogrenciListesi.add("Arda");
		ogrenciListesi.add("Tolga");
		ogrenciListesi.add("Ümit");
		
		ogretmenListesi.add("Musa");
		ogretmenListesi.add("Berke");
		ogretmenListesi.add("Batuhan");
		
		// 1 
		FreeMarkerRoute ogrencilerSayfasi = new OgrencilerSayfasiFreemarkerRoute("/websayfasi/ogrenciler");
		get(ogrencilerSayfasi);
		
		// 2 
		FreeMarkerRoute indexSayfa = new FreeMarkerRoute("/websayfasi/ogrenciekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/tahakeskin/finalodev2/ogrenciekle.html");
			}
		};
		get(indexSayfa);
		
		FreeMarkerRoute indexSayfa2 = new FreeMarkerRoute("/websayfasi/ogretmenekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/tahakeskin/finalodev2/ogretmenekle.html");
			}
		};
		get(indexSayfa2);
		
		// 3
		Route ogrenciEkleSayfasi = new Route("/websayfasi/ogrencieklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogrenciListesi.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/websayfasi/ogrenciler");
				return null;
			}
		};
		post(ogrenciEkleSayfasi);
		
		
		Route ogretmenEkleSayfasi = new Route("/websayfasi/ogretmeneklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogretmenListesi.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/websayfasi/ogrenciler");
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
			Map<String, Object> sayfaVerisi = new HashMap<>();
			
			sayfaVerisi.put("ogrenciler", ogrenciListesi);
			
			sayfaVerisi.put("ogretmenler", ogretmenListesi);
			
			return new ModelAndView(sayfaVerisi, "/tahakeskin/finalodev2/ogrenciler.html");
		}
	}
}
