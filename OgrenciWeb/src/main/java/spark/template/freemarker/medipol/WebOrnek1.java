package spark.template.freemarker.medipol;

import spark.*;
import static spark.Spark.*;

public class WebOrnek1 {
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
	}
}
