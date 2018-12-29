package spark.template.freemarker.ozkansari;
import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

public class WebOrnek2 {

	public static void main(String[] args) {
		
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"
		// http://0.0.0.0:4567/webornek/sayfa2/
		FreeMarkerRoute indexSayfa = new FreeMarkerRoute("/webornek/sayfa2/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/ozkansari/index.html");
			}
		};
		get(indexSayfa);
	}

}
