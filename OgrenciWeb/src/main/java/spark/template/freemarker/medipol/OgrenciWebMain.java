package spark.template.freemarker.medipol;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*; // get(..) ve post(..) direkt cagirabilmek icin

import java.util.*;

public class OgrenciWebMain {

	private static List<String> ogrenciListesi = new ArrayList<String>();
	private static List<String> ogretmenListesi = new ArrayList<String>();
	static {
		ogrenciListesi.add("Mustafa");
		ogrenciListesi.add("Ahmet");
		ogrenciListesi.add("Aziz");
		ogretmenListesi.add("Ali");
		ogretmenListesi.add("Ozkan");
	}
	private static String kullaniciAdi = "";
	private static String hataMesaji = "";
	
	public static void main(String[] args) {

		// http://localhost:4567/medipol/
		FreeMarkerRoute anasayfaGET = new FreeMarkerRoute("/medipol/") {
			@Override
			public Object handle(Request request, Response response) {
				sayfaLogu("Anasayfa", request.body());
				
				Map<String, Object> sayfaVerisi = new HashMap<String,Object>();
				sayfaVerisi.put("ogrenciler", ogrenciListesi);
				sayfaVerisi.put("ogretmenler", ogretmenListesi);
				sayfaVerisi.put("kullanici_adi", kullaniciAdi);
				sayfaVerisi.put("hata_mesaji", hataMesaji);

				return new ModelAndView(sayfaVerisi , "/medipol/index.html" );
			}
		};
		get(anasayfaGET);
		
		
		// http://localhost:4567/medipol/ogrencisil?id=0
		Route ogrenciSilIstegi = new Route("/medipol/ogrencisil") {
			@Override
			public Object handle(Request request, Response response) {
				
				String idParam = request.queryParams("id");
				if(idParam != null) {
					int id = Integer.valueOf(idParam);
					ogrenciListesi.remove(id);
				}
				
				response.redirect("/medipol/");
				return null;
			}
			
		};
		get(ogrenciSilIstegi);
		post(ogrenciSilIstegi);
		
		Route ogrenciEklemeIstegi = new Route("/medipol/ogrenciekle") {
			@Override
			public Object handle(Request request, Response response) {
				String isimParam = request.queryParams("isim");
				if(isimParam != null) {
					ogrenciListesi.add(isimParam);
				}
				
				response.redirect("/medipol/");
				return null;
			}
			
		};
		spark.Spark.post(ogrenciEklemeIstegi);
		
		Route loginIstegi = new Route("/medipol/login") {
			@Override
			public Object handle(Request istek, Response cevap) {
				String adParam = istek.queryParams("ad");
				String sifreParam = istek.queryParams("sifre");
				if(adParam != null && !adParam.trim().equals("")) {
					kullaniciAdi = adParam;
					hataMesaji = "";
				} else {
					hataMesaji = "Kullanici adi ya da sifre hatali.";
				}
				cevap.redirect("/medipol/");
				return null;
			}
			
		};
		post(loginIstegi);
		
		Route logoutIstegi = new Route("/medipol/logout") {
			@Override
			public Object handle(Request request, Response response) {
				kullaniciAdi = "";
				response.redirect("/medipol/");
				return null;
			}
			
		};
		get(logoutIstegi);
	}
	
	public static void sayfaLogu(String sayfaIsmi, String ekBilgi) {
		System.out.println(sayfaIsmi + " cagrildi. Request: " + ekBilgi);
	}

}
