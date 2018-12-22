import spark.*;
import static spark.Spark.*;

public class WebOrnek1 {

	public static void main(String[] args) {
		// YONTEM 1
		// anonymous inner class kullanimi ornek
		// http://127.0.0.1:4567/webornek/sayfa1b/
		Route sayfa1 = new Route("/webornek/sayfa1/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return "Sayfa 1 Ornek - <b>Yontem 1</b>";
			}
		};
		get(sayfa1);
		
		// YONTEM 2
		// http://0.0.0.0:4567/webornek/sayfa1b/
		Sayfa1Route sayfa1b = new Sayfa1Route("/webornek/sayfa1b/");
		Spark.get(sayfa1b);
		
	}
	
	public static class Sayfa1Route extends Route {
		protected Sayfa1Route(String path) {
			super(path);
		}
		@Override
		public Object handle(Request arg0, Response arg1) {
			return "Sayfa 1 Ornek - Yontem 2";
		}	
	}

}
