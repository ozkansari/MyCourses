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
				
				Map<String, Object> sayfaVerisi = ortakSayfaVerisiOlustur();
				sayfaVerisi.put("ogrenciler", ogrenciListesi);
				sayfaVerisi.put("ogretmenler", ogretmenListesi);

				return new ModelAndView(sayfaVerisi , "/medipol/index.html" );
			}
		};
		get(anasayfaGET);
		get( yonlendirmeSayfasi("/medipol/index", "/medipol/") );
		
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
		
		Map<String, Object> ortakSayfaVerisi = ortakSayfaVerisiOlustur();
		htmlAdresiEslestir("/medipol/sayfa1", "/medipol/sayfa1.html", ortakSayfaVerisi);
		htmlAdresiEslestir("/medipol/sayfa2", "/medipol/sayfa2.html", ortakSayfaVerisi);
		
	}

	private static Map<String, Object> ortakSayfaVerisiOlustur() {
		Map<String, Object> ortakSayfaVerisi = new HashMap<String,Object>();
		ortakSayfaVerisi.put("kullanici_adi", kullaniciAdi);
		ortakSayfaVerisi.put("hata_mesaji", hataMesaji);
		return ortakSayfaVerisi;
	}

	private static void htmlAdresiEslestir(String adres, String htmlSayfasi, Map<String, Object> sayfaVerisi) {
		FreeMarkerRoute sayfaGET = new FreeMarkerRoute(adres) {
			@Override
			public Object handle(Request request, Response response) {
				sayfaLogu(adres, request.queryString());
				return new ModelAndView(sayfaVerisi , htmlSayfasi );
			}
		};
		get(sayfaGET);
	}

	private static Route yonlendirmeSayfasi(String yeniAdresEslesmesi, String yonlendirilecekAdres) {
		return new Route(yeniAdresEslesmesi) {
			@Override
			public Object handle(Request request, Response response) {
				response.redirect(yonlendirilecekAdres);
				return null;
			}	
		};
	}
	
	public static void sayfaLogu(String sayfaIsmi, String ekBilgi) {
		System.out.println(sayfaIsmi + " cagrildi. Request: " + ekBilgi);
	}

}

