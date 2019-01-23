package spark.template.freemarker.batuhankizil.finalproje;



import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import spark.template.freemarker.batuhankizil.finalproje.service.KullaniciServis;

public class UyeSayfasi extends FreeMarkerRoute{

	protected UyeSayfasi(String path) {
		super(path);
	}


	@Override
	public Object handle(Request request, Response response) {
		return new ModelAndView(null, "/batuhankizil/finalproje/uye_sayfasi.html");
	}
	
	

}
