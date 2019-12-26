package spark.template.freemarker.ornek1;

import spark.*;
import static spark.Spark.*;

public class WebOrnek1 {

	public static void main(String[] args) {
		
		// http://localhost:4567/medipol/ornek1
		Route webSayfasi1 = new WebSayfasi("/medipol/ornek1");
		Route webSayfasi2 = new WebSayfasi("/medipol/ornek2");
		
		get(webSayfasi1);
		get(webSayfasi2);
		// yukarida import static yapildigindan
		//  spark.Spark.get(webSayfasi1);
		// seklinde yazmamiza gerek yok
	}
	
	private static class WebSayfasi extends Route {

		protected WebSayfasi(String path) {
			super(path);
		}

		@Override
		public Object handle(Request request, 
				Response response) {
			
			String path = request.pathInfo();
			System.out.println(path);
			
			String icerik;
			if(path.endsWith("ornek1")) {
				icerik = "Sayfa 1";
			} else if(path.endsWith("ornek2")) {
				icerik = "Sayfa 2";
			} else {
				icerik = "Bilinmeyen Sayfa";
			}
			
			String[] pathParts = path.split("/");
			return "<html>"
					+ "<head>"
					+ "<title>"
					+ pathParts[pathParts.length-1]
					+ "</title>"
					+ "</head>"
					+ "<body>"
					+ icerik
					+ "</body>"+ 
					"</html>";
		}
		
	}

}
