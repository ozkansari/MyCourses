package spark.template.freemarker.onurkaral.finalproje;
import static spark.Spark.get;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class YoneticiAnasayfa {
	  public static void sayfalariTanimla() {
	        YoneticiSayfaGET();
	    }

	    private static void YoneticiSayfaGET() {
	        FreeMarkerRoute YoneticiSayfa = new FreeMarkerRoute("/onurkaral/yonetici_anasayfa/") {
	            @Override
	            public Object handle(Request istek, Response cevap) {

	                Kullanici ADMIN = UygulamaMain.girisYapmisKullanici;
	               
	               if(ADMIN == null ) {
	            	  
	                    	cevap.redirect("/onurkaral/hata_sayfasi/");

	               }

	                Map<String, Object> sayfaVerisi1 = new HashMap<String, Object>();
	                sayfaVerisi1.put("kullanicitipi", ADMIN.getKullaniciTipi());
	                return new ModelAndView(sayfaVerisi1, "/onurkaral/finalproje/yonetici_anasayfa.html");
	            }
	        };
	        get(YoneticiSayfa);
	    }
	}

