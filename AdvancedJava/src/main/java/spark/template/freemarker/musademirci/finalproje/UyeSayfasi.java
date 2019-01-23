package spark.template.freemarker.musademirci.finalproje;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;

public class UyeSayfasi {

	public static void sayfalariTanimla() {

		// http://localhost:4567//musademirci/uye_sayfasi/
		FreeMarkerRoute girisSayfasi = new FreeMarkerRoute(
				"/musademirci/uye_sayfasi/") 
		{
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(
						null, 
						"/musademirci/finalproje/uye_sayfasi.html");
			}
		};
		get(girisSayfasi);
	}
}
