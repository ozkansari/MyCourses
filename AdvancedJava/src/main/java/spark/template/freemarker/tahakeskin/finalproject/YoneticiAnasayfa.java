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

public class YoneticiAnasayfa {
	
	public static void sayfalariTanimla(){
		
		FreeMarkerRoute yoneticiSayfasiIndex = new yoneticiSayfasiFreemarkerRoute("/tahakeskin/yonetici/");
		get(yoneticiSayfasiIndex);
		
		Route yoneticiUserAddSayfasi = new yoneticiKullaniciEkleRoute("/tahakeskin/yonetici_sayfasipost1");
		post(yoneticiUserAddSayfasi);
		
		Route yoneticiUrunAddSayfasi = new yoneticiUrunEkleRoute("/tahakeskin/yonetici_sayfasipost2");
		post(yoneticiUrunAddSayfasi);
		
		Route kullanicisilpage = new yoneticiUserDelRoute("/tahakeskin/kullanicisil");
		post(kullanicisilpage);
		}
	//--------------------------------------(4)yoneticiSayfaFreemarkerRoute---------------------------------------	
			private static class yoneticiSayfasiFreemarkerRoute extends FreeMarkerRoute {

				protected yoneticiSayfasiFreemarkerRoute(String path) {
					super(path);
				}

				@Override
				public Object handle(Request arg0, Response arg1) {
					Map<String, Object> sayfaVerisi = new HashMap<>();

					VeriTabaniClass.siparisSýralama();
					sayfaVerisi.put("siparisler", VeriTabaniClass.siparisListesi);
					
					VeriTabaniClass.kullaniciSýralama();
					sayfaVerisi.put("kullanicilar", VeriTabaniClass.kullaniciListesi);
					
					
					VeriTabaniClass.urunlerSýralama();
					sayfaVerisi.put("urunler", VeriTabaniClass.urunListesi);
					
					
					return new ModelAndView(sayfaVerisi ,"tahakeskin/finalproject/yonetici_anasayfa.html");
				}
			}
			
			//--------------------------------------(4)yoneticiSayfaFreemarkerRoute---------------------------------------
			private static class yoneticiKullaniciEkleRoute extends Route {

				protected yoneticiKullaniciEkleRoute(String path) {
					super(path);
				}

				@Override
				public Object handle(Request istek, Response cevap) {
					String yetki = istek.queryParams("yetki");
					String isim = istek.queryParams("name");
					String yas = istek.queryParams("yas");
					String cinsiyet = istek.queryParams("gender");
					String pass = istek.queryParams("pass");
				
					if( yetki==null || "".equals(isim) || "".equals(pass) || "".equals(yas) || cinsiyet == null) {
						System.out.println("Isim ve sifre bos olamaz.");
						cevap.redirect("/tahakeskin/yonetici/");
					} 
					else if (yetki=="admin") {
						VeriTabaniClass.kullaniciEkle( isim, "admin",  Integer.valueOf(yas),  cinsiyet,  pass);
						Anasayfa.sayfalariTanimla();
						cevap.redirect("/tahakeskin/yonetici/");
					}
					else {
						VeriTabaniClass.kullaniciEkle( isim, "normal",  Integer.valueOf(yas),  cinsiyet,  pass);
						Anasayfa.sayfalariTanimla();
						cevap.redirect("/tahakeskin/yonetici/");
					}
					return null;
				}
			}
			
			private static class yoneticiUrunEkleRoute extends Route {

				protected yoneticiUrunEkleRoute(String path) {
					super(path);
				}

				@Override
				public Object handle(Request istek, Response cevap) {
					String urun = istek.queryParams("uname");
					String kategori = istek.queryParams("ukategori");
					String fiyat = istek.queryParams("ufiyat");
				
					if(  "".equals(urun) || "".equals(kategori) || "".equals(fiyat)) {
						System.out.println("Isim ve sifre bos olamaz.");
						cevap.redirect("/tahakeskin/yonetici/");
					} 
					else  {
						VeriTabaniClass.urunEkle(urun, kategori, Integer.valueOf(fiyat));
						Anasayfa.sayfalariTanimla();
						cevap.redirect("/tahakeskin/yonetici/");
					}
					
					return null;
				}
			}
			
			private static class yoneticiUserDelRoute extends Route{

				protected yoneticiUserDelRoute(String path) {
					super(path);
				}

				@Override
				public Object handle(Request istek, Response cevap) {

					String kullanici = istek.queryParams("username");
					VeriTabaniClass.silmetod(kullanici);
					cevap.redirect("/tahakeskin/yonetici/");
					return null;
				}
			}

}
