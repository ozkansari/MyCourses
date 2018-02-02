package spark.template.freemarker.didemlaloglu;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import spark.template.freemarker.didemlaloglu.db.DerbyDb;
import spark.template.freemarker.didemlaloglu.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;;

public class App {

	private static final List<Product> URUNLER = new ArrayList<Product>();
	private static final Gson jsonYardimci = new GsonBuilder().create();
	private static final List<String> KATEGORI = new ArrayList<>();
	private static Map<Object, Object> SEPET = new HashMap<Object, Object>();
	private static int sepettekiUrunSayisi = 0;

	public static void main(String[] args) {

		DerbyDb.veritabaniniYukle();
		DerbyDb.veritabaninaBaglan();
		DerbyDb.tablolariSil();
		DerbyDb.tablolariOlustur();

		KATEGORI.add("Laptop");
		KATEGORI.add("Telefon");
		KATEGORI.add("Televizyon");

		urunEklemeSayfasi();
		urunEklemeIslemi();
		urunleriGoruntule();
		sepeteEklemeIslemi();
		yonetimSayfasi();
		urunSilmeIslemi();
		sepettekiUrunleriGoruntule();
		yonetimUrunDetay();
		sepettenSilmeIslemi();
	}

	private static void yonetimSayfasi() {
		FreeMarkerRoute yonetimSayfasi = new FreeMarkerRoute("/didemlaloglu/yonetim/urunler") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id;
				List<Product> urunler;
				if (istek.queryParams("kategori") != null) {
					id = KATEGORI.indexOf(istek.queryParams("kategori"));

					urunler = DerbyDb.getProductByCategoryId(id);
				} else
					urunler = DerbyDb.getProductAll();

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				// ozellikler.put("urunler", URUNLER);
				ozellikler.put("urunler", urunler);
				ozellikler.put("kategoriler", KATEGORI);
				ozellikler.put("sepettekiUrunSayisi", sepettekiUrunSayisi);
				return new ModelAndView(ozellikler, "urunler-yonetim.html");
			}
		};
		get(yonetimSayfasi);
	}

	private static void yonetimUrunDetay() {
		FreeMarkerRoute yonetimUrunDetay = new FreeMarkerRoute("/didemlaloglu/yonetim/urunDetay") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id;
				List<Product> urunler;
				if (istek.queryParams("kategori") != null) {
					id = KATEGORI.indexOf(istek.queryParams("kategori"));

					urunler = DerbyDb.getProductByCategoryId(id);
				} else
					urunler = DerbyDb.getProductAll();

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				// ozellikler.put("urunler", URUNLER);
				ozellikler.put("urunler", urunler);
				ozellikler.put("kategoriler", KATEGORI);
				ozellikler.put("sepettekiUrunSayisi", sepettekiUrunSayisi);
				return new ModelAndView(ozellikler, "urun-detay-yonetim.html");
			}
		};
		get(yonetimUrunDetay);
	}

	private static void urunEklemeIslemi() {
		FreeMarkerRoute urunEkleIslemi = new FreeMarkerRoute("/didemlaloglu/yonetim/urunekle") {
			@Override
			public Object handle(Request istek, Response cevap) {

				// Kullanicinin urunekle.html'den girdigi form degerlerini al
				String urunAdi = istek.queryParams("urunadi");
				String urunAciklamasi = istek.queryParams("urunaciklamasi");

				int fiyat;
				int stok;
				int kategoryId;
				try {
					fiyat = Integer.valueOf(istek.queryParams("fiyat"));
					stok = Integer.valueOf(istek.queryParams("stok"));
					kategoryId = KATEGORI.indexOf(istek.queryParams("kategoryId"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/urunekle");
					return null;
				}

				// Urun olustur ve listeye ekle
				Product urun = new Product(Product.ID++, kategoryId, urunAdi, urunAciklamasi, fiyat, stok);
				// URUNLER.add(urun);
				DerbyDb.addProduct(urun);

				// Islem bitince /urunler sayfasina geri don
				cevap.redirect("/didemlaloglu/yonetim/urunler");

				return null;
			}
		};
		post(urunEkleIslemi); // bu yonlendirme post isteklerini karsilasin
	}

	/**
	 * 
	 */
	private static void urunEklemeSayfasi() {
		FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("/didemlaloglu/yonetim/urunekle") {
			@Override
			public Object handle(Request istek, Response cevap) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", URUNLER);
				ozellikler.put("kategoriler", KATEGORI);

				return new ModelAndView(ozellikler, "urunekle.html");
			}
		};
		get(urunEkleSayfasi);
	}

	private static void urunleriGoruntule() {
		FreeMarkerRoute urunleriGoruntule = new FreeMarkerRoute("/didemlaloglu/urunler") {
			@Override
			public Object handle(Request istek, Response cevap) {
				int kategoriId;
				List<Product> urunler;
				int urunId;
				if (istek.queryParams("kategori") != null) {
					kategoriId = KATEGORI.indexOf(istek.queryParams("kategori"));

					urunler = DerbyDb.getProductByCategoryId(kategoriId);
				} else if (istek.queryParams("urunId") != null) {
					urunId = KATEGORI.indexOf(istek.queryParams("urunId"));

					urunler = DerbyDb.getProductByCategoryId(urunId);
				} else
					urunler = DerbyDb.getProductAll();

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				// ozellikler.put("urunler", URUNLER);
				ozellikler.put("urunler", urunler);
				ozellikler.put("kategoriler", KATEGORI);
				ozellikler.put("sepettekiUrunSayisi", sepettekiUrunSayisi);
				return new ModelAndView(ozellikler, "urunler.html");
			}
		};
		get(urunleriGoruntule);
	}

	private static void sepettekiUrunleriGoruntule() {
		FreeMarkerRoute sepettekiUrunleriGoruntule = new FreeMarkerRoute("/didemlaloglu/sepet/urunler") {
			@Override
			public Object handle(Request istek, Response cevap) {
				List<Product> urunler = new ArrayList<>();
				Object[] productIds = SEPET.keySet().toArray();
				for (Object i : productIds) {
					urunler.add(DerbyDb.getProductById((int) i));
				}

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				// ozellikler.put("urunler", URUNLER);
				ozellikler.put("urunler", urunler);
				ozellikler.put("kategoriler", KATEGORI);
				ozellikler.put("sepettekiUrunSayisi", sepettekiUrunSayisi);
				return new ModelAndView(ozellikler, "sepet.html");
			}
		};
		get(sepettekiUrunleriGoruntule);
	}

	private static void sepettenSilmeIslemi() {
		FreeMarkerRoute sepettenSilmeIslemi = new FreeMarkerRoute("/didemlaloglu/sepettenSil") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				SEPET.remove(id);
				sepettekiUrunSayisiHesapla();

				// Islem bitince /urunler sayfasina geri don
				cevap.redirect("/didemlaloglu/sepet/urunler");

				return null;
			}
		};
		get(sepettenSilmeIslemi);
	}

	private static void urunSilmeIslemi() {
		FreeMarkerRoute urunSilmeIslemi = new FreeMarkerRoute("/didemlaloglu/yonetim/urunSil") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				DerbyDb.removeProduct(id);

				// Islem bitince /urunler sayfasina geri don
				cevap.redirect("/didemlaloglu/yonetim/urunler");

				return null;
			}
		};
		get(urunSilmeIslemi);
	}

	private static void sepeteEklemeIslemi() {
		FreeMarkerRoute sepeteEklemeIslemi = new FreeMarkerRoute("/didemlaloglu/sepeteEkle") {
			@Override
			public Object handle(Request istek, Response cevap) {

				List<Product> urunler = DerbyDb.getProductAll();
				int id = Integer.valueOf(istek.queryParams("id"));
				sepeteEkle(id);

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				// ozellikler.put("urunler", URUNLER);
				ozellikler.put("urunler", urunler);
				ozellikler.put("kategoriler", KATEGORI);
				ozellikler.put("sepettekiUrunSayisi", sepettekiUrunSayisi);
				cevap.redirect("/didemlaloglu/urunler");
				return null;
			}

		};
		get(sepeteEklemeIslemi);
	}

	private static void sepeteEkle(int id) {

		if (SEPET.containsKey(id)) {
			Object o = SEPET.get(id);
			SEPET.remove(id);
			int tmp = 0;
			tmp = Integer.valueOf(String.valueOf(o)) + 1;

			SEPET.put(id, tmp);

		} else {
			SEPET.put(id, 1);
		}
		sepettekiUrunSayisiHesapla();

	}

	private static void sepettekiUrunSayisiHesapla() {
		sepettekiUrunSayisi = 0;
		Object[] productIds = SEPET.keySet().toArray();
		for (Object i : productIds) {
			sepettekiUrunSayisi = sepettekiUrunSayisi + (int) SEPET.get(i);
		}
	}

}
