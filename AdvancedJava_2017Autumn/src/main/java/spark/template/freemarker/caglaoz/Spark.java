package spark.template.freemarker.caglaoz;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;
import com.google.gson.*;
import java.util.*;

/**
 * @author �a�la
 *
 */
public class Spark {

	private static final List<Urun> URUNLER = new ArrayList<Urun>();
	private static final Gson jsonYardimci = new GsonBuilder().create();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Magaza_Yonetim.veritabaniniYukle();
		Magaza_Yonetim.veritabaninaBaglan();
		Magaza_Yonetim.tablolariOlustur();

		URUNLER.add(new Urun(Urun.ID++, "etek", 55, "mavi pileli etek"));
		urunlerJson();

		// http://localhost:4567/anasayfa
		urunleriGoruntule();

		// http://localhost:4567/urunekle
		urunEklemeSayfasi();

		// http://localhost:4567/urunekle 'ye gelen POST isteklerine karsila
		urunEklemeIslemi();

		// http://localhost:4567/urunsil 'e gelen POST isteklerine karsila
		urunSilmeIslemi();
	}


	private static void urunSilmeIslemi() {
		 /**
		 * @author �a�la
		 *
		 */
		
		FreeMarkerRoute urunSilmeIslemi =new FreeMarkerRoute("/urunsil") {
			/* (non-Javadoc)
			 * @see spark.Route#handle(spark.Request, spark.Response)
			 */
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				Magaza_Yonetim.urunSil(id);

				// Islem bitince /anasayfaya sayfasina geri don
				cevap.redirect("/anasayfa");

				return null;
			}
		};
		get(urunSilmeIslemi);
	}

	private static void urunguncellemeIslemi() {
		 /**
		 * @author �a�la
		 *
		 */
		FreeMarkerRoute urunguncellemeIslemi =		new FreeMarkerRoute("/urunsil") {
			/* (non-Javadoc)
			 * @see spark.Route#handle(spark.Request, spark.Response)
			 */
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				Magaza_Yonetim.urunGuncelle(id);

				// Islem bitince /anasayfa sayfasina geri don
				cevap.redirect("/anasayfa");

				return null;
			}
		};
		put(urunguncellemeIslemi);
	}

	/**
	 * 
	 */
	private static void urunEklemeIslemi() {
		FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/urunekle") {
			/* (non-Javadoc)
			 * @see spark.Route#handle(spark.Request, spark.Response)
			 */
			@Override
			public Object handle(Request istek, Response cevap) {

				// Kullanicinin urunekle.html'den girdigi form degerlerini al
				String urunAdi = istek.queryParams("urunadi");
				String urunDetayi = istek.queryParams("urundetay");
				// urunadi html input text'deki name

				// Fiyati inte cevir
				int fiyat;
				try {
					fiyat = Integer.valueOf(istek.queryParams("fiyat"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/urunekle");
					return null;
				}

				// Urun olustur ve listeye ekle
				Urun urun = new Urun(Urun.ID++, urunAdi, fiyat, urunDetayi);
				// URUNLER.add(urun);
				Magaza_Yonetim.urunEkle(urun);

				// Islem bitince /anasayfa sayfasina geri don
				cevap.redirect("/anasayfa");

				return null;
			}
		};
		post(urunEkleIslemi); // bu yonlendirme post isteklerini karsilasin
	}

	/**
	 * 
	 */
	private static void urunEklemeSayfasi() {
		FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/urunekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", URUNLER);
				return new ModelAndView(ozellikler, "/caglaoz/urunekle.html");
			}
		};
		get(urunEkleSayfasi);
	}

	/**
	 * 
	 */
	private static void urunleriGoruntule() {
		FreeMarkerRoute urunleriGoruntule = new FreeMarkerRoute("/anasayfa") {
			@Override
			public Object handle(Request arg0, Response arg1) {

				List<Urun> urunler = Magaza_Yonetim.kayitlariAl();
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", urunler);
				return new ModelAndView(ozellikler, "/caglaoz/anasayfa.html");
			}
		};
		get(urunleriGoruntule);
	}

	/**
	 * 
	 */
	private static void urunlerJson() {
		Route urunlerJson = new Route("/anasayfa/json") {
			public Object handle(Request istek, Response cevap) {
				List<Urun> urunler = Magaza_Yonetim.kayitlariAl();
				// return jsonYardimci.toJson(URUNLER);
				return jsonYardimci.toJson(urunler);
			}
		};
		get(urunlerJson);
	}

}
