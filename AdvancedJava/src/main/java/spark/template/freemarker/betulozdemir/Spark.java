package spark.template.freemarker.betulozdemir;
import static spark.Spark.*;
// **************
// OZKANS DUZELTME import Request *;
//**************
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//**************
//OZKANS DUZELTME
// import org.omg.CORBA.Request;

import spark.template.freemarker.*;

//**************
//OZKANS DUZELTME
import spark.*;
//**************

/**
 * @author 
 *
 */

public class Spark {

	private static final ArrayList<Kitap> KİTAPLAR = new ArrayList<Kitap>();

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {

		VeriTabani.veritabaniniYukle();
		VeriTabani.veritabaninaBaglan();
		VeriTabani.tablolariOlustur();

		KİTAPLAR.add(new Kitap(Kitap.ID++, "Kürk Mantolu Madonna", 55, "Sbahattin Ali"));
		kitaplarJson();

		// http://localhost:4567/anasayfa
		kitaplariGoruntule();

		// http://localhost:4567/kitapekle
		kitapEklemeIslemi();

		// http://localhost:4567/kitapekle 'ye gelen POST isteklerine karsila
	kitapEklemeIslemi();

		// http://localhost:4567/kitapsil 'e gelen POST isteklerine karsila
		kitapSilmeIslemi();
	
	}

	// **************
	// OZKANS DUZELTME
	//private static void kitaplariGoruntule() {
		// TODO Auto-generated method stub
	//	
	//}
	//


	private static void kitaplarJson() {
		// TODO Auto-generated method stub
		
	}


	private static void kitapSilmeIslemi() {

		FreeMarkerRoute kitapSilmeIslemi =new FreeMarkerRoute("/") {
			@Override
			public Object handle(Request istek, Response cevap) {

				int id = Integer.valueOf(istek.queryParams("id"));
				
// **********************************
// OZKANS DUZELTME
//				VeriTabani.kitapSil(id);
// **********************************
				// Islem bitince /anasayfaya sayfasina geri don
				cevap.redirect("/anasayfa");

				return null;
			}
		};
		get(kitapSilmeIslemi);
	}


	private static void kitapEklemeIslemi() {
		FreeMarkerRoute kitapEkleIslemi = new FreeMarkerRoute() {
			@Override
			public Object handle(Request istek, Response cevap) {

				// Kullanicinin kitapekle.html'den girdigi form degerlerini al
				String kitapAdi = istek.queryParams("kitapadi");
				String kitapDetayi = istek.queryParams("kitapdetay");
				// urunadi html input text'deki name

				}

				// kitap olustur ve listeye ekle
				Kitap kitap = new Kitap(kitap.ID++, kitapAdi, fiyat, kitapDetayi);
				// KİTAPLAR.add(kitap);
				VeriTabani.kitapEkle(Kitap);

				// Islem bitince /anasayfa sayfasina geri don
				cevap.redirect("/anasayfa");

				return null;
			}
		};
		post(kitapEkleIslemi); // bu yonlendirme post isteklerini karsilasin
	}

	private static void kitapEklemeSayfasi() {
		FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute() {
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", KİTAPLAR);
				return new ModelAndView(ozellikler, "kitapekle.html");
			}
		};
		get(kitapEkleSayfasi);
	}

	private static void kitaplariGoruntule() {
		FreeMarkerRoute kitaplariGoruntule = new FreeMarkerRoute("/anasayfa") {
			@Override
			public Object handle(Request arg0, Response arg1) {

				List<Kitap> kitaplar =VeriTabani.kayitlariAl();
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar",kitaplar);
				return new ModelAndView(ozellikler, "anasayfa.html");
			}
		};
		get(kitaplari);

// **************
// OZKANS DUZELTME
	}
// **************

}
