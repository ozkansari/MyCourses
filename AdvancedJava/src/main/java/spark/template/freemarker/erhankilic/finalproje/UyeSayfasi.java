package spark.template.freemarker.erhankilic.finalproje;


import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;

public class UyeSayfasi {

	public static void sayfalariTanimla() {

		FreeMarkerRoute girisSayfasi = new FreeMarkerRoute(
				"/erhankilic/uye_sayfasi/"
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(
						null, 
						"/erhankilic/finalproje/uye_sayfasi.html" // 
				);
			}
		};
		get(girisSayfasi);
	}
}