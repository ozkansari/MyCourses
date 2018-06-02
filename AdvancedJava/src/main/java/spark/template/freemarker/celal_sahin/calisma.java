package spark.template.freemarker.celal_sahin;


import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;

import com.google.gson.*;

import java.util.*;

public class calisma {

	private static final List<kitaplar> kitaplarr = new ArrayList<kitaplar>();
	private static final Gson jsonYardimci = new GsonBuilder().create();

	public static void main(String[] args) {

		veriTabani.veritabaniniYukle();
		veriTabani.veritabaninaBaglan();
		veriTabani.tablolariOlustur();

	}

	public static void kitapEklemeIslemi() {
		FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/kitapEkle") {

			public Object handle(Request istek, Response cevap) {

				// Kullanicinin urunekle.html'den girdigi form degerlerini al
				String kitapAdi = istek.queryParams("kitapadi");
				String yazarAdi = istek.queryParams("yazaradi");
				String yazarSoyadi = istek.queryParams("yazarsoyadi");
				String yayinEvi = istek.queryParams("yayinEvi");

				// Fiyati inte cevir
				int fiyat;
				try {
					fiyat = Integer.valueOf(istek.queryParams("fiyat"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/kitapEkle");
					return null;
				}

				// Urun olustur ve listeye ekle
				kitaplar kitap = new kitaplar(kitaplar.ID++, kitapAdi, yazarAdi, yazarSoyadi, yayinEvi, fiyat);
				// URUNLER.add(urun);
				veriTabani.kitapEkle(kitap);

				// Islem bitince sayfaya geri don
				cevap.redirect("/kitaplar");

				return null;
			}
		};
		post(urunEkleIslemi); // bu yonlendirme post isteklerini karsilasin
	}

	public static void urunEklemeSayfasi() {
		FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/urunekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", kitaplarr);
				return new ModelAndView(ozellikler, "kitapEkle.html");
			}
		};
		get(urunEkleSayfasi);
	}

	public static void urunlerJson() {
		Route sayfa2 = new Route("/urunler/json") {
			public Object handle(Request istek, Response cevap) {
				List<kitaplar> urunler = veriTabani.kayitlariAl();
				// return jsonYardimci.toJson(URUNLER);
				return jsonYardimci.toJson(urunler);
			}
		};
		get(sayfa2);
	}

}
