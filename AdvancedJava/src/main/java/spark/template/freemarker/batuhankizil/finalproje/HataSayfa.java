package spark.template.freemarker.batuhankizil.finalproje;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class HataSayfa extends FreeMarkerRoute {

	protected HataSayfa(String path) {
		super(path);
	}

	@Override
	public Object handle(Request request, Response response) {
		return new ModelAndView(null, "/batuhankizil/finalproje/hata.html");
	}

}
