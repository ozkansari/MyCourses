package tr.edu.medipol.ilerijava.final_odev2.batuhan_kizil;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

import java.util.*; // List ve ArrayList icin

public class classapp {
	
	private static List<String> ogrenciListesi = new ArrayList<>();
	private static List<String> ogretmenListesi = new ArrayList<>();
	
	public static void main(String[] args) {
		
		ogrenciListesi.add("Batu");
		
		ogretmenListesi.add("Ali");
		
		FreeMarkerRoute ogrencilerSayfasi = new 
				OgrencilerSayfasiFreemarkerRoute("/classapp/ogrenciler");
		get(ogrencilerSayfasi);
		
		FreeMarkerRoute indexSayfa = new FreeMarkerRoute("/classapp/ogrenciekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/batukankizil/finalodev2/ogrenciekle.html");
			}
		};
		get(indexSayfa);
		
		FreeMarkerRoute indexSayfa2 = new FreeMarkerRoute("/classapp/ogretmenekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/batukankizil/finalodev2/ogretmenekle.html");
			}
		};
		get(indexSayfa2);
		
				Route ogrenciEkleSayfasi = new Route("/classapp/ogrencieklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogrenciListesi.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/classapp/ogrenciler");
				return null;
			}
		};
		post(ogrenciEkleSayfasi);
		
				Route ogretmenEklePage = new Route("/classapp/ogretmeneklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogretmenListesi.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/classapp/ogrenciler");
				return null;
			}
		};
		post(ogretmenEklePage);
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
			
			
			return new ModelAndView(sayfaVerisi, "/classapp/ogrenciler.html");
		}
	}
}
