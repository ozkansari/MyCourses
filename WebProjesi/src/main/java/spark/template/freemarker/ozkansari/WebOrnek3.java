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
		
		// http://0.0.0.0:4567/webornek/sayfa3/
		FreeMarkerRoute ogrencilerSayfasi = new FreeMarkerRoute("/webornek/sayfa3/") {
			
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
		};
		get(ogrencilerSayfasi);
	}
}
