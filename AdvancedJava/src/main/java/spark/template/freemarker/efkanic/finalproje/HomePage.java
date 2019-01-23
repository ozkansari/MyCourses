package spark.template.freemarker.efkanic.finalproje;

import static spark.Spark.get;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class HomePage {
	public static void sayfalariTanimla() {
		homepage();
	}
	private static void homepage() {
			// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
			// http://0.0.0.0:4567/ozkansari/giris_sayfasi/
			FreeMarkerRoute homepage = new FreeMarkerRoute("/efkanic/finalproje/homepage" // Sayfaya hangi URL ile
																							// erisecegimi tanimliyorum
			) {// altindaki dosya yolu
				@Override
				public Object handle(Request istek, Response cevap) {			
					return new ModelAndView(null, "/efkanic/finalproje/homepage.html" // spark/template/freemarker/
					);
				}
			};
			get(homepage);
	}
}
