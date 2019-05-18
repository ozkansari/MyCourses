package spark.template.freemarker.medipol.ornek;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

public class WebOrnek3 {
	public static void main(String[] args) {
		
		// http://localhost:4567/medipol/ornek/sayfa1
		Route sayfa1 = new Route("/medipol/ornek/sayfa1") {
			@Override
			public Object handle(Request request, Response response) {
				System.out.println("Sayfa 1 cagrildi. Request: " + 
						request);
				return "sayfa 1";
			}
		};
		get(sayfa1);
		
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
		
		// http://localhost:4567/medipol/ornek/sayfa3
		FreeMarkerRoute sayfa3 = new FreeMarkerRoute("/medipol/ornek/sayfa3") {
			@Override
			public Object handle(Request request, Response response) {
				System.out.println("Anasayfa cagrildi. Request: " + 
						request.body());
				return new ModelAndView( null , "/medipol/ornek/sayfa3.html" );
			}
		};
		get(sayfa3);
	}
}
