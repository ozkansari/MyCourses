package spark.template.freemarker.emretanrisever.finalproje;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.*;


public class HataSayfasi {
	
	public static void sayfalariTanimla() {
		HataSayfasi();
	}
	
	private static void HataSayfasi() {
		FreeMarkerRoute hataSayfasi = new FreeMarkerRoute("/emretanrisever/hata/") {
			
			@Override
			public Object handle(Request request, Response response) {
				// TODO Auto-generated method stub
				return new ModelAndView(null, "/emretanrisever/finalproje/hata.html");
			}
		};
		get(hataSayfasi);
	}
}
