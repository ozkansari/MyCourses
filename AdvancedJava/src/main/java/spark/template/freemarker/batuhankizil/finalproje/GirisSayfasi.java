package spark.template.freemarker.batuhankizil.finalproje;



import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import spark.template.freemarker.batuhankizil.finalproje.service.KullaniciServis;

public class GirisSayfasi extends FreeMarkerRoute{

	private KullaniciServis kullaniciServis;
	
	protected GirisSayfasi(String path) {
		super(path);
		kullaniciServis = new KullaniciServis();
	}

	@Override
	public Object handle(Request request, Response response) {
		return new ModelAndView(null, "/batuhankizil/finalproje/giris_sayfasi.html");
	}
	
	

}
