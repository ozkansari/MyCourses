package spark.template.freemarker.efkanic.finalproje;

import static spark.Spark.get;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class Error {

	public static void sayfalariTanimla() {
		errorpage();
	}
	private static void errorpage() {
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
		// http://0.0.0.0:4567/ozkansari/giris_sayfasi/
		FreeMarkerRoute girisSayfasi = new FreeMarkerRoute("/efkanic/finalproje/error" // Sayfaya hangi URL ile
																						// erisecegimi tanimliyorum
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(null, "/efkanic/finalproje/error.html" // spark/template/freemarker/
																							// altindaki dosya yolu
				);
			}
		};
		get(girisSayfasi);
	}

}
