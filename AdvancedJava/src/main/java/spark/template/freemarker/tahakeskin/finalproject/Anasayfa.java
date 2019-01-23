package spark.template.freemarker.tahakeskin.finalproject;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

public class Anasayfa {
	private static List<String> sepettekilerListesi = new ArrayList<>();
	private static List<String> urunadetListesi = new ArrayList<>();
	
	
	public static void sayfalariTanimla(){
		
		FreeMarkerRoute girisSayfasiIndex = new anaSayfaFreemarkerRoute("/tahakeskin/");
		get(girisSayfasiIndex);
		
		Route addbag = new anaSayfaAddbagRoute("/tahakeskin/sepetekle");
		get(addbag);
		
		Route checkout = new anaSayfaCheckoutRoute("/tahakeskin/siparisver");
		get(checkout);
		
		}
	//--------------------------------------(3)anaSayfaFreemarkerRoute---------------------------------------	adddbag kýsmý sorulacak
		//sepettekiler while ile sonsuz dongüde basýldýkca adeti artacak mi?
		private static class anaSayfaFreemarkerRoute extends FreeMarkerRoute {

			protected anaSayfaFreemarkerRoute(String path) {
				super(path);
			
			}

			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> sayfaVerisi = new HashMap<>();

				sayfaVerisi.put("sepettekiler", sepettekilerListesi);
				sayfaVerisi.put("urunadeti", urunadetListesi);
				
				VeriTabaniClass.urunlerSýralama();
				sayfaVerisi.put("urunler", VeriTabaniClass.urunListesi);          
				
				return new ModelAndView(sayfaVerisi ,"tahakeskin/finalproject/anasayfa.html");
			}
		}
		//--------------------------------------(3)anaSayfaAddbagRoute---------------------------------------
		private static class anaSayfaAddbagRoute extends Route{

			protected anaSayfaAddbagRoute(String path) {
				super(path);
			}

			@Override
			public Object handle(Request istek, Response cevap) {

				String urun = istek.queryParams("urunadi");
				sepettekilerListesi.add(urun);
				cevap.redirect("/tahakeskin/");
				return null;
			}
		}
		
	//--------------------------------------(3)anaSayfaCheckoutRoute---------------------------------------
			private static class anaSayfaCheckoutRoute extends Route{

				protected anaSayfaCheckoutRoute(String path) {
					super(path);
				}

				@Override
				public Object handle(Request istek, Response cevap) {
					//siparisver(kullaniciAdi,urunIDler,toplamFiyat); 
					cevap.redirect("/tahakeskin/");
					return null;
				}
			}
	
}
