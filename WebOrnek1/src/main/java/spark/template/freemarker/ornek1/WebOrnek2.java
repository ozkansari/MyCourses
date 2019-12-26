package spark.template.freemarker.ornek1;

import spark.*;
import static spark.Spark.*;

public class WebOrnek2 {

	public static void main(String[] args) {
		
		// http://localhost:4567/medipol/ornek2
		Route webSayfasi2 = new Route("/medipol/ornek2") {
			@Override
			public Object handle(Request request, 
					Response response) {
				return "<html>"
						+ "<head>"
						+ "<title>Ornek 1</title>"
						+ "</head>"
						+ "<body>sayfa 1</body>"+ 
						"</html>";
			}
		};
		
		get(webSayfasi2);
		// yukarida import static yapildigindan
		//  spark.Spark.get(webSayfasi1);
		// seklinde yazmamiza gerek yok
	}

}
