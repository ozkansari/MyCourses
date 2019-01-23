package spark.template.freemarker.emretanrisever.finalproje;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;

public class YoneticiAnasayfa {

	
	public static void sayfalariTanimla() {
		yoneticiSayfasiTanimla();
	}
	
	private static void yoneticiSayfasiTanimla() {
		FreeMarkerRoute yoneticiSayfasi = new FreeMarkerRoute("/emretanrisever/admin/") {
			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				
				return new ModelAndView(null, "/emretanrisever/finalproje/yonetici_anasayfa.html/");
			}
		};
		get(yoneticiSayfasi);
	}
}
