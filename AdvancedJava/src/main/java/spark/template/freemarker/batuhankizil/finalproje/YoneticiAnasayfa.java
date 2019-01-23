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
import spark.template.freemarker.batuhankizil.finalproje.model.Siparis;
import spark.template.freemarker.batuhankizil.finalproje.model.Urun;
import spark.template.freemarker.batuhankizil.finalproje.service.KullaniciServis;
import spark.template.freemarker.batuhankizil.finalproje.service.SiparisServis;
import spark.template.freemarker.batuhankizil.finalproje.service.UrunServis;

public class YoneticiAnasayfa extends FreeMarkerRoute{
	
	private UrunServis urunServis;
	private KullaniciServis kullaniciServis;
	private SiparisServis siparisServis;

	
	protected YoneticiAnasayfa(String path) {
		super(path);
		urunServis = new UrunServis();	
		kullaniciServis = new KullaniciServis();	
		siparisServis = new SiparisServis();
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
		List<Kullanici> kullanicilar = kullaniciServis.tumKullanicilar();
		veriler.put("kullanici", user); 
		veriler.put("kullanicilar",kullanicilar);
		List<Siparis> siparisler = siparisServis.siparisleriListele();
		veriler.put("siparisler", siparisler);
		
		return new ModelAndView(veriler, "/batuhankizil/finalproje/yonetici_anasayfa.html");
	}

}