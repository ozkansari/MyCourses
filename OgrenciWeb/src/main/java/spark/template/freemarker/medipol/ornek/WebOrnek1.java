package spark.template.freemarker.medipol.ornek;

import spark.*;
import static spark.Spark.*;

/**
 * HTML sayfa kullanmadan return edilen degerin web sayfasi olarak gosterilmesi
 */
public class WebOrnek1 {
	public static void main(String[] args) {
		
		// Web sayfanin calistigi IP ve port : http://localhost:4567
		// Sayfanin alt dizini: /medipol/ornek/sayfa1
		
		// http://localhost:4567/medipol/ornek/sayfa1
		Route sayfa1 = new Route("/medipol/ornek/sayfa1") {
			@Override
			public Object handle(Request request, Response response) {
				System.out.println("Sayfa 1 cagrildi. Request: " + request);
				return "sayfa 1";
			}
		};
		get(sayfa1);
	}
}
