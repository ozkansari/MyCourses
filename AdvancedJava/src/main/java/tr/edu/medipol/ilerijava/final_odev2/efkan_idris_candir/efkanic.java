package tr.edu.medipol.ilerijava.final_odev2.efkan_idris_candir;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

import java.util.*; 

public class efkanic {
	
	private static List<String> ogrenciList = new ArrayList<>();
	private static List<String> ogretmenList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		ogrenciList.add("Efkan");
		ogrenciList.add("Hakan");
		ogrenciList.add("Ertuðrul");
		
		ogretmenList.add("Orhan");
		ogretmenList.add("Dilek");
		
		FreeMarkerRoute ogrenciogretmensayfasi = new 
				ogrenciogretmensayfasi("/efkanic/ogretmenogrenci");
		get(ogrenciogretmensayfasi);
		
		FreeMarkerRoute indexSayfa = new FreeMarkerRoute("/efkanic/ogrenciekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/efkanic/finalodev2/ogrenciekle.html");
			}
		};
		get(indexSayfa);
		
		FreeMarkerRoute indexSayfa2 = new FreeMarkerRoute("/efkanic/ogretmenekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/efkanic/finalodev2/ogretmenekle.html");
			}
		};
		get(indexSayfa2);
		
				Route ogrenciEkleSayfasi = new Route("/efkanic/ogrencieklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogrenciList.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/efkanic/ogretmenogrenci");
				return null;
			}
		};
		post(ogrenciEkleSayfasi);
		
				Route ogretmenEklePage = new Route("/efkanic/ogretmeneklepost") {
			@Override
			public Object handle(Request istek, Response cevap) {
				
				String isim = istek.queryParams("isim");
				if (isim != null) {
					ogretmenList.add(isim);
				} else {
					System.out.println("Isim bos olamaz.");
				}
				
				cevap.redirect("/efkanic/ogretmenogrenci");
				return null;
			}
		};
		post(ogretmenEklePage);
	}
	
	private static class ogrenciogretmensayfasi extends FreeMarkerRoute {
		
		protected ogrenciogretmensayfasi(String path) {
			super(path);
		}

		@Override
		public Object handle(Request arg0, Response arg1) {
			Map<String, Object> sayfaVerisi = new HashMap<>();
			
		
			sayfaVerisi.put("ogrenciler", ogrenciList);
			
			sayfaVerisi.put("ogretmenler", ogretmenList);
			
			
			return new ModelAndView(sayfaVerisi, "/efkanic/finalodev2/ogrenciler.html");
		}
	}
}
