package spark.template.freemarker.gamzenurkeskin;
import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;
import com.google.gson.*;
import java.util.*;

/**
 * 
 * Bu sinif web servis sayfalarini ve islemleri olusturur.
 * 
 * @author Gamze Keskin
 *
 */
public class Spark {

	/**
	 * Urunler listesi olusturulur.
	 * 
	 * @param URUNLER
	 * 
	 */
	private static final List<Urun> URUNLER = new ArrayList<Urun>();

	/**
	 * 
	 * Gson olusturulur.
	 * 
	 * @param jsonYardimci
	 * 
	 */
	private static final Gson jsonYardimci = new GsonBuilder().create();

	/**
	 * 
	 * Veritabani yuklenir. Baglanti kurulur. Tablo olusturulur. Siniflar cagirilir.
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		DerbyVeritabani.VeritabaniniYukle();
		DerbyVeritabani.VeritabaninaBaglan();
		DerbyVeritabani.TabloOlustur();

		UrunlerJson();

		// http://localhost:4567/gamzekeskin/magaza
		MagazaSayfasi();

		// http://localhost:4567/gamzekeskin/urunler
		UrunleriGoruntule();

		// http://localhost:4567/gamzekeskin/musteri
		MusteriUrunleriGoruntule();

		// http://localhost:4567/gamzekeskin/sepetim
		SepetSayfasi();

		// http://localhost:4567/gamzekeskin/urunler/ekle
		UrunEklemeSayfasi();

		// http://localhost:4567/gamzekeskin/urunler/ekle
		UrunEklemeIslemi();

		// http://localhost:4567/gamzekeskin/urunler/sil
		UrunSilmeIslemi();

		// http://localhost:4567/gamzekeskin/urunler/guncelle
		UrunGuncellemeSayfasi();

		UrunGuncellemeIslemi();
	}

	/**
	 * 
	 * Urun ekleme islemi olusturulur.
	 * 
	 * @param UrunEkleIslemi
	 * 
	 */
	private static void UrunEklemeIslemi() {
		FreeMarkerRoute UrunEkleIslemi = new FreeMarkerRoute("/gamzekeskin/urunler/ekle") {
			@Override
			public Object handle(Request istek, Response cevap) {

				String urunAdi = istek.queryParams("urunadi");

				int fiyat;
				try {
					fiyat = Integer.valueOf(istek.queryParams("fiyat"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/gamzekeskin/urunler/ekle");
					return null;
				}

				Urun urun = new Urun(Urun.ID++, urunAdi, fiyat);
				DerbyVeritabani.UrunEkle(urun);

				cevap.redirect("/gamzekeskin/urunler");

				return null;
			}
		};
		post(UrunEkleIslemi);
	}

	/**
	 * 
	 * Urun ekleme sayfasi olusturulur.
	 * 
	 * @param UrunEklemeSayfasi
	 * 
	 */
	private static void UrunEklemeSayfasi() {
		FreeMarkerRoute UrunEkleSayfasi = new FreeMarkerRoute("/gamzekeskin/urunler/ekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", URUNLER);
				return new ModelAndView(ozellikler, "/gamzenurkeskin/urunekle.html");
			}
		};
		get(UrunEkleSayfasi);
	}

	/**
	 * 
	 * Sepet sayfasi olusturulur.
	 * 
	 * @param SepetSayfasi
	 * 
	 */
	private static void SepetSayfasi() {
		FreeMarkerRoute SepetSayfasi = new FreeMarkerRoute("/gamzekeskin/sepetim") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", URUNLER);
				return new ModelAndView(ozellikler, "/gamzenurkeskin/sepetim.html");
			}
		};
		get(SepetSayfasi);
	}

	/**
	 * 
	 * Magaza sayfasi olusturulur.
	 * 
	 * @param Magazasayfasi
	 * 
	 */
	private static void MagazaSayfasi() {
		FreeMarkerRoute MagazaSayfasi = new FreeMarkerRoute("/gamzekeskin/magaza") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", URUNLER);
				return new ModelAndView(ozellikler, "/gamzenurkeskin/magaza.html");
			}
		};
		get(MagazaSayfasi);
	}

	/**
	 * 
	 * Urun silme islemi olusturulur.
	 * 
	 * @param UrunSilmeIslemi
	 * 
	 */
	private static void UrunSilmeIslemi() {
		FreeMarkerRoute UrunSilmeIslemi = new FreeMarkerRoute("/gamzekeskin/urunler/sil") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				DerbyVeritabani.UrunSil(id);

				// Islem bitince /urunler sayfasina geri don
				cevap.redirect("/gamzekeskin/urunler");

				return null;
			}
		};
		get(UrunSilmeIslemi);
	}

	/**
	 * 
	 * Urun guncelleme islemi olusturulur.
	 * 
	 * @param UrunGuncellemeIslemi
	 * 
	 */
	private static void UrunGuncellemeIslemi() {
		FreeMarkerRoute UrunGuncellemeIslemi = new FreeMarkerRoute("/gamzekeskin/urunler/guncelle") {
			@Override
			public Object handle(Request istek, Response cevap) {

				String urunAdi = istek.queryParams("urunadi");
				int fiyat;
				try {
					fiyat = Integer.valueOf(istek.queryParams("fiyat"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/gamzekeskin/urunler/guncelle");
					return null;
				}

				int id = Integer.valueOf(istek.queryParams("id"));
				DerbyVeritabani.UrunGuncelle(id, urunAdi, fiyat);

				cevap.redirect("/gamzekeskin/urunler");

				return null;
			}
		};
		post(UrunGuncellemeIslemi);
	}

	/**
	 * 
	 * Urun guncelleme sayfasi olusturulur.
	 * 
	 * @param UrunGuncellemeSayfasi
	 * 
	 */
	private static void UrunGuncellemeSayfasi() {
		FreeMarkerRoute UrunGuncellemeSayfasi = new FreeMarkerRoute("/gamzekeskin/urunler/guncelle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", URUNLER);
				return new ModelAndView(ozellikler, "/gamzenurkeskin/urunguncelle.html");
			}
		};
		get(UrunGuncellemeSayfasi);
	}

	/**
	 * 
	 * Urunleri goruntuleme olusturulur.
	 * 
	 * @param UrunleriGoruntule
	 * 
	 */
	private static void UrunleriGoruntule() {
		FreeMarkerRoute UrunleriGoruntule = new FreeMarkerRoute("/gamzekeskin/urunler") {
			@Override
			public Object handle(Request arg0, Response arg1) {

				List<Urun> urunler = DerbyVeritabani.KayitlariAl();

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", urunler);
				return new ModelAndView(ozellikler, "/gamzenurkeskin/urunler.html");
			}
		};
		get(UrunleriGoruntule);
	}

	/**
	 * 
	 * Musteri urunleri goruntuleme olusturulur.
	 * 
	 * @param MusteriUrunleriGoruntule
	 * 
	 */
	private static void MusteriUrunleriGoruntule() {
		FreeMarkerRoute MusteriUrunleriGoruntule = new FreeMarkerRoute("/gamzekeskin/musteri") {
			@Override
			public Object handle(Request arg0, Response arg1) {

				List<Urun> urunler = DerbyVeritabani.KayitlariAl();

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("urunler", urunler);
				return new ModelAndView(ozellikler, "/gamzenurkeskin/musteri.html");
			}
		};
		get(MusteriUrunleriGoruntule);
	}

	/**
	 * 
	 * @param UrunlerJson
	 * 
	 */
	private static void UrunlerJson() {
		Route UrunlerJson = new Route("/urunler/json") {
			public Object handle(Request istek, Response cevap) {
				List<Urun> urunler = DerbyVeritabani.KayitlariAl();
				return jsonYardimci.toJson(urunler);
			}
		};
		get(UrunlerJson);
	}

}