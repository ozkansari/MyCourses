package spark.template.freemarker.onurkaral.finalproje;

import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class HataSayfasi {
	 public static void sayfalariTanimla() {
	        HataSayfaGET();
	    }

	    private static void  HataSayfaGET() {
	        FreeMarkerRoute HataSayfa= new FreeMarkerRoute("/onurkaral/hata_sayfasi/") {
	            @Override
	            public Object handle(Request istek, Response cevap) {
	            	

	                return new ModelAndView(null, "/onurkaral/finalproje/hata_sayfasi.html");
	            }
	        };
	        get(HataSayfa);
	    }
	}


