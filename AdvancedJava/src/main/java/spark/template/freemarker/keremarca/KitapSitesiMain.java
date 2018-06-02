package spark.template.freemarker.keremarca;

import static spark.Spark.*;
import spark.*;
import spark.template.freemarker.FreeMarkerRoute;
import com.google.gson.*;
import java.util.*;

/**
 * 
 * Bu sinif web servis sayfalarini ve islemleri olusturur.
 * 
 * @author Kerem Arca
 *
 */

public class KitapSitesiMain {

	/**
	 * Kitaplar listesi olusturulur.
	 * 
	 * @param KITAPLAR
	 * 
	 */
	private static final List<kitaplar> KITAPLAR = new ArrayList<kitaplar>();
	
	
	/**
	 * Siparis listesi olusturulur.
	 * 
	 * @param SIPARİSLER
	 * 
	 */
	private static final List<siparisler> SIPARISLER = new ArrayList<siparisler>();


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

		KitaplarJson();

		// http://localhost:4567/keremarca/anasayfa
		Anasayfa();

		// http://localhost:4567/keremarca/kitaplaranasayfa
		KitaplarAnasayfa();

		// http://localhost:4567/keremarca/kitapliste
		KitaplariGoruntule();

		// http://localhost:4567/keremarca/sepetim
		SepetSayfasi();

		// http://localhost:4567/keremarca/siparisonay/ekle
		SiparisEklemeSayfasi();

		// http://localhost:4567/keremarca/siparisonay/ekle
		SiparisEklemeIslemi();
		
		// http://localhost:4567/keremarca/siparislite
		SiparisListelemeSayfasi();
				
		// http://localhost:4567/keremarca/kitaplar/ekle
		KitapEklemeSayfasi();

		// http://localhost:4567/keremarca/kitaplar/ekle
		KitapEklemeIslemi();

		// http://localhost:4567/keremarca/kitaplar/sil
		KitapSilmeIslemi();

		// http://localhost:4567/keremarca/kitaplar/guncelle
		KitapGuncellemeSayfasi();

		KitapGuncellemeIslemi();
	}

	/**
	 * 
	 * Siparis ekleme islemi olusturulur.
	 * 
	 * @param SiparisEklemeIslemi
	 * 
	 */
	
	private static void SiparisEklemeIslemi() {
		FreeMarkerRoute SiparisEklemeIslemi = new FreeMarkerRoute("/keremarca/siparisonay/ekle") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				String siparis_veren = istek.queryParams("siparis_veren");


				int toplam_ucret;
				try {
					toplam_ucret = Integer.valueOf(istek.queryParams("toplam_ucret"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/keremarca/siparisonay/ekle");
					return null;
				}

				siparisler siparis = new siparisler(id, siparis_veren, toplam_ucret);
				DerbyVeritabani.SiparisEkle(siparis);

				cevap.redirect("/keremarca/siparisliste");

				return null;
			}
		};
		post(SiparisEklemeIslemi);
	}

	/**
	 * 
	 * Siparis ekleme sayfasi olusturulur.
	 * 
	 * @param SiparisEklemeSayfasi
	 * 
	 */
	private static void SiparisEklemeSayfasi() {
		FreeMarkerRoute SiparisEklemeSayfasi = new FreeMarkerRoute("/keremarca/siparisonay/ekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("siparisler", SIPARISLER);
				return new ModelAndView(ozellikler, "siparisonay.html");
			}
		};
		get(SiparisEklemeSayfasi);
	}
	
	
	
	
	/**
	 * 
	 * Siparis listeleme sayfasi olusturulur.
	 * 
	 * @param SiparisListelemeSayfasi
	 * 
	 */
	private static void SiparisListelemeSayfasi() {
		FreeMarkerRoute SiparisListelemeSayfasi = new FreeMarkerRoute("/keremarca/siparisliste") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("siparisler", SIPARISLER);
				return new ModelAndView(ozellikler, "siparisliste.html");
			}
		};
		get(SiparisListelemeSayfasi);
	}
	
	
	
	
	
	
	/**
	 * 
	 * Kitap ekleme islemi olusturulur.
	 * 
	 * @param KitapEkleIslemi
	 * 
	 */
	
	private static void KitapEklemeIslemi() {
		FreeMarkerRoute KitapEklemeIslemi = new FreeMarkerRoute("/keremarca/kitaplar/ekle") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				String ad = istek.queryParams("ad");
				String yazarAd = istek.queryParams("yazar_ad");
				String yazarSoyad = istek.queryParams("yazar_soyad");
				String yayinevi = istek.queryParams("yayinevi");


				int fiyat;
				try {
					fiyat = Integer.valueOf(istek.queryParams("fiyat"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/keremarca/kitaplar/ekle");
					return null;
				}

				kitaplar kitap = new kitaplar(id, ad, yazarAd, yazarSoyad, yayinevi, fiyat);
				DerbyVeritabani.KitapEkle(kitap);

				cevap.redirect("/keremarca/kitaplar");

				return null;
			}
		};
		post(KitapEklemeIslemi);
	}

	/**
	 * 
	 * Kitap ekleme sayfasi olusturulur.
	 * 
	 * @param KitapEklemeSayfasi
	 * 
	 */
	private static void KitapEklemeSayfasi() {
		FreeMarkerRoute KitapEkleSayfasi = new FreeMarkerRoute("/keremarca/kitaplar/ekle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", KITAPLAR);
				return new ModelAndView(ozellikler, "kitapekle.html");
			}
		};
		get(KitapEkleSayfasi);
	}

	/**
	 * 
	 * Sepet sayfasi olusturulur.
	 * 
	 * @param SepetSayfasi
	 * 
	 */
	private static void SepetSayfasi() {
		FreeMarkerRoute SepetSayfasi = new FreeMarkerRoute("/keremarca/sepetim") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", KITAPLAR);
				return new ModelAndView(ozellikler, "sepetim.html");
			}
		};
		get(SepetSayfasi);
	}

	/**
	 * 
	 * Anasayfa sayfasi olusturulur.
	 * 
	 * @param Anasayfa
	 * 
	 */
	private static void Anasayfa() {
		FreeMarkerRoute Anasayfa = new FreeMarkerRoute("/keremarca/anasayfa") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", KITAPLAR);
				return new ModelAndView(ozellikler, "anasayfa.html");
			}
		};
		get(Anasayfa);
	}

	/**
	 * 
	 * Kitap silme islemi olusturulur.
	 * 
	 * @param KitapSilmeIslemi
	 * 
	 */
	private static void KitapSilmeIslemi() {
		FreeMarkerRoute KitapSilmeIslemi = new FreeMarkerRoute("/keremarca/kitaplar/sil") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				DerbyVeritabani.KitapSil(id);

				// Islem bitince /kitaplar sayfasina geri don
				cevap.redirect("/keremarca/kitaplar");

				return null;
			}
		};
		get(KitapSilmeIslemi);
	}

	/**
	 * 
	 * Kitap guncelleme islemi olusturulur.
	 * 
	 * @param KitapGuncellemeIslemi
	 * 
	 */
	private static void KitapGuncellemeIslemi() {
		FreeMarkerRoute KitapGuncellemeIslemi = new FreeMarkerRoute("/keremarca/kitaplar/guncelle") {
			@Override
			public Object handle(Request istek, Response cevap) {

				String ad = istek.queryParams("ad");
				String yazarAd = istek.queryParams("yazar_ad");
				String yazarSoyad = istek.queryParams("yazar_soyad");
				String yayinevi = istek.queryParams("yayinevi");				
				
				int fiyat;
				try {
					fiyat = Integer.valueOf(istek.queryParams("fiyat"));
				} catch (Exception e) {
					e.printStackTrace();
					cevap.redirect("/keremarca/kitaplar/guncelle");
					return null;
				}

				int id = Integer.valueOf(istek.queryParams("id"));
				DerbyVeritabani.KitapGuncelle(id, ad, yazarAd, yazarSoyad, yayinevi, fiyat);

				cevap.redirect("/keremarca/kitaplar");

				return null;
			}
		};
		post(KitapGuncellemeIslemi);
	}

	/**
	 * 
	 * Kitap guncelleme sayfasi olusturulur.
	 * 
	 * @param KitapGuncellemeSayfasi
	 * 
	 */
	private static void KitapGuncellemeSayfasi() {
		FreeMarkerRoute KitapGuncellemeSayfasi = new FreeMarkerRoute("/keremarca/kitaplar/guncelle") {
			@Override
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", KITAPLAR);
				return new ModelAndView(ozellikler, "kitapguncelle.html");
			}
		};
		get(KitapGuncellemeSayfasi);
	}

	/**
	 * 
	 * KitaplarAnasayfa olusturulur.
	 * 
	 * @param KitaplariGoruntule
	 * 
	 */
	private static void KitaplarAnasayfa() {
		FreeMarkerRoute KitaplarAnasayfa = new FreeMarkerRoute("/keremarca/kitaplaranasayfa") {
			@Override
			public Object handle(Request arg0, Response arg1) {

				List<kitaplar> kitaplar = DerbyVeritabani.KayitlariAl();

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", kitaplar);
				return new ModelAndView(ozellikler, "kitaplaranasayfa.html");
			}
		};
		get(KitaplarAnasayfa);
	}

	/**
	 * 
	 * Kitaplari goruntuleme olusturulur.
	 * 
	 * @param KitaplariGoruntule
	 * 
	 */
	private static void KitaplariGoruntule() {
		FreeMarkerRoute KitaplariGoruntule = new FreeMarkerRoute("/keremarca/kitapliste") {
			@Override
			public Object handle(Request arg0, Response arg1) {

				List<kitaplar> kitaplar = DerbyVeritabani.KayitlariAl();

				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("KitaplariGoruntule", kitaplar);
				return new ModelAndView(ozellikler, "kitapliste.html");
			}
		};
		get(KitaplariGoruntule);
	}

	/**
	 * 
	 * @param KitaplarJson
	 * 
	 */
	private static void KitaplarJson() {
		Route KitaplarJson = new Route("/kitaplar/json") {
			public Object handle(Request istek, Response cevap) {
				List<kitaplar> kitaplar = DerbyVeritabani.KayitlariAl();
				return jsonYardimci.toJson(kitaplar);
			}
		};
		get(KitaplarJson);
	}

}