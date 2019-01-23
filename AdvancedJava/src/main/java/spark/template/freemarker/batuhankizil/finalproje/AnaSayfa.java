package spark.template.freemarker.batuhankizil.finalproje;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;
import spark.template.freemarker.batuhankizil.finalproje.model.Kullanici;
import spark.template.freemarker.batuhankizil.finalproje.model.Urun;
import spark.template.freemarker.batuhankizil.finalproje.service.UrunServis;


public class AnaSayfa extends FreeMarkerRoute{
	
	private UrunServis urunServis;
	
	protected AnaSayfa(String path) {
		super(path);
		urunServis = new UrunServis();	
	}

	@Override
	public Object handle(Request request, Response response) {
		List<Urun> urunlerList = new ArrayList<>();
		Map<String, Object> veriler = new HashMap<String, Object>();
		
		
		/**
      	 * Ürünler UrunServis'den çaðýrýlýr ve listelenir.
    	 * */
		List<Urun> uruns = urunServis.urunListele();	
		urunlerList.addAll(uruns);
		veriler.put("urunler", urunlerList);
		Kullanici user = UygulamaMain.girisYapmisKullanici; 
		veriler.put("kullanici", user); 
		List<Urun> sepettekiler = UygulamaMain.siparisMap.get(user.getKullanici_adi());
		veriler.put("sepettekiler", sepettekiler);
		return new ModelAndView(veriler, "/batuhankizil/finalproje/anasayfa.html");
	}

}
