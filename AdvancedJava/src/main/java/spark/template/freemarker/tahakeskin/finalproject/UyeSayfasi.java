package spark.template.freemarker.tahakeskin.finalproject;

import static spark.Spark.get;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

public class UyeSayfasi {
	
	public static void sayfalariTanimla(){
		//(1) http://localhost:4567/tahakeskin/giris_sayfasi
		FreeMarkerRoute uyeSayfasiIndex = new uyeSayfasiFreemarkerRoute("/tahakeskin/uye_sayfasi");
		get(uyeSayfasiIndex);
		
		Route uyeSayfasi = new uyeSayfasiRoute("/tahakeskin/uye_sayfasipost");
		post(uyeSayfasi);
		}
	

//--------------------------------------(2)uyeSayfasiFreemarkerRoute---------------------------------------
			
	private static class uyeSayfasiFreemarkerRoute extends FreeMarkerRoute {

		protected uyeSayfasiFreemarkerRoute(String path) {
		super(path);
		// TODO Auto-generated constructor stub
		}

		@Override
		public Object handle(Request arg0, Response arg1) {
			
			return new ModelAndView( null ,"tahakeskin/finalproject/uye_sayfasi.html");
		}
	}
	
//--------------------------------------(2)uyeSayfasiRoute---------------------------------------
	private static class uyeSayfasiRoute extends Route{

		protected uyeSayfasiRoute(String path) {
			super(path);
		}

		@Override
		public Object handle(Request istek, Response cevap) {

			String isim = istek.queryParams("name");
			String yas = istek.queryParams("yas");
			String cinsiyet = istek.queryParams("gender");
			String pass = istek.queryParams("pass");
		
			if(" ".equals(isim) || " ".equals(pass) || "".equals(isim) || "".equals(pass) || "".equals(yas) || cinsiyet == null) {
				System.out.println("Isim ve sifre bos olamaz.");
				cevap.redirect("/tahakeskin/uye_sayfasi");
			} 
			
			else {
				VeriTabaniClass.kullaniciEkle( isim, "normal",  Integer.valueOf(yas),  cinsiyet,  pass);
				Anasayfa.sayfalariTanimla();
				cevap.redirect("/tahakeskin/");
			}
			return null;
		}
	}
	
}
