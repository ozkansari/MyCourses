package tr.edu.medipol.ilerijava.ders09;
import spark.*;
import spark.template.freemarker.*;
import static spark.Spark.*;

public class WebOrnek2 {

	public static void main(String[] args) {
		
		// Default html dosyalarinin koyulacagi dizin: "spark/template/freemarker/"

		FreeMarkerRoute indexSayfa = new FreeMarkerRoute("/webornek/sayfa2/") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				return new ModelAndView(null, "/index.html");
			}
		};
		get(indexSayfa);
	}

}
