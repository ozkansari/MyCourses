package spark.template.freemarker.medipol.ornek;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

public class WebOrnek2 {
	public static void main(String[] args) {
		// http://localhost:4567/medipol/ornek/sayfa2
		FreeMarkerRoute sayfa2 = new FreeMarkerRoute("/medipol/ornek/sayfa2") {
			@Override
			public Object handle(Request request, Response response) {
				System.out.println("Sayfa 2 cagrildi. Request: " + 
						request.body());
				return new ModelAndView( null , "/medipol/ornek/sayfa2.html" );
			}
		};
		get(sayfa2);
	}
}
