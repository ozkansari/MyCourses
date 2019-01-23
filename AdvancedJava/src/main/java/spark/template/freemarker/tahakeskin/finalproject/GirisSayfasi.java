package spark.template.freemarker.tahakeskin.finalproject;

import static spark.Spark.get;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

public class GirisSayfasi {
	
	public static void sayfalariTanimla(){
		//(1) http://localhost:4567/tahakeskin/giris_sayfasi
		FreeMarkerRoute girisSayfasiIndex = new girisSayfasiFreemarkerRoute("/tahakeskin/giris_sayfasi");
		get(girisSayfasiIndex);
		
		Route girisSayfasi = new girisSayfasiRoute("/tahakeskin/giris_sayfasipost");
		post(girisSayfasi);
		}
	
	

//--------------------------------------(1)girisSayfasiFreemarkerRoute--------------------------------------- hata gönderme olmadý
	private static class girisSayfasiFreemarkerRoute extends FreeMarkerRoute {

		protected girisSayfasiFreemarkerRoute(String path) {
		super(path);
		// TODO Auto-generated constructor stub
		}

		@Override
		public Object handle(Request arg0, Response arg1) {
			/*Map<String, Object> sayfaVerisi = new HashMap<>();

			sayfaVerisi.put("hata1", hata1);
			
			sayfaVerisi.put("hata2", hata2);*/
			
			return new ModelAndView(/*sayfaVerisi*/ null,"tahakeskin/finalproject/giris_sayfasi.html");
		}
	}
//--------------------------------------(1)girisSayfasiRoute---------------------------------------	
	private static String hata1,hata2;
	
	private static class girisSayfasiRoute extends Route{

		protected girisSayfasiRoute(String path) {
			super(path);
			
		}

		@Override
		public Object handle(Request istek, Response cevap) {

			String isim = istek.queryParams("isim");
			Kullanici kullanici = VeriTabaniClass.kullaniciSorgula(isim);
			
			if (kullanici==null) {
				System.out.println("Isim ve sifre bos olamaz.");
				hata1 ="Isim ve sifre bos olamaz.";
				cevap.redirect("/tahakeskin/giris_sayfasi");
			} else {
				hata1 = null;
				
				String pass = istek.queryParams("pass");
				
				if(kullanici.getSifre().equals(pass) && kullanici.getKullaniciTipi().equals("normal")) {
					Anasayfa.sayfalariTanimla();
					cevap.redirect("/tahakeskin/");}
				else if (kullanici.getSifre().equals(pass) && kullanici.getKullaniciTipi().equals("admin")) {
					YoneticiAnasayfa.sayfalariTanimla();
					cevap.redirect("/tahakeskin/yonetici/");}
				else {
					System.out.println("isim veya sifre hatali");
					hata2 ="isim veya sifre hatali";
					cevap.redirect("/tahakeskin/giris_sayfasi");}
			}
			return null;
		}
	}
	
}
