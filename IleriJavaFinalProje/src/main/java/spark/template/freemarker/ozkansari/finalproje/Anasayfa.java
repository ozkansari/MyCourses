package spark.template.freemarker.ozkansari.finalproje;

import static spark.Spark.get;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class Anasayfa {

	public static void sayfalariTanimla() {
		anaSayfaGET();
	}
	
	private static void anaSayfaGET() {
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
		// http://0.0.0.0:4567/ozkansari/
		FreeMarkerRoute anaSayfa = new FreeMarkerRoute("/ozkansari/" // Sayfaya hangi URL ile
																						// erisecegimi tanimliyorum
		) {
			@Override
			public Object handle(Request istek, Response cevap) {
				return new ModelAndView(null, "/ozkansari/finalproje/anasayfa.html" // spark/template/freemarker/
																							// altindaki dosya yolu
				);
			}
		};
		get(anaSayfa);
	}
}
