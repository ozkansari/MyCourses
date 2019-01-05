package tr.edu.medipol.ilerijava.ders11;

import spark.*;
import static spark.Spark.*;
import spark.template.freemarker.*;

import java.util.*;

public class UygulamaMain {

	private static final List<String> ogrenciler = new ArrayList();
	
	public static void main(String[] args) {
		
		ogrenciler.add("Efkan");
		ogrenciler.add("Berke");
		ogrenciler.add("Ali");
		
		// http://localhost:4567/web/ozkansari/ogrencilistele
		FreeMarkerRoute ogrenciListesi = new FreeMarkerRoute("/web/ozkansari/ogrencilistele") {

			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String,List<String>> ozellikler = new HashMap();
				ozellikler.put("ogrnci", ogrenciler);
				
				return new ModelAndView(ozellikler,"/ogrenciler_sayfasi.html");
			}
		};
		get(ogrenciListesi);
		
		Route ogrenciSilAksiyonu = new Route("/web/ozkansari/ogrencisil") {

			@Override
			public Object handle(Request istek, Response cevap) {
				
				String idstr = istek.queryParams("id");
				if(idstr != null ) {
					int idint = Integer.valueOf(idstr);
					ogrenciler.remove(idint);
				}
				cevap.redirect("/web/ozkansari/ogrencilistele");
				return null;
			}
			
		};
		get(ogrenciSilAksiyonu);
		post(ogrenciSilAksiyonu);
		
		
		
	}

}
