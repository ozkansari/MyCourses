package spark.template.freemarker.ornek1;

import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

public class WebOrnek3 {

	public static void main(String[] args) {
		
		// http://localhost:4567/medipol/ornek3
		FreeMarkerRoute webSayfasi3 = 
				new FreeMarkerRoute("/medipol/ornek3") {
					@Override
					public Object handle(Request request, 
							Response response) {
						return new ModelAndView(null, "/ornek1/sayfa3.html");
					}
			
		};
		get(webSayfasi3);
		
	}

}
