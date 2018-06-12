package spark.template.freemarker.betulozdemir;
import static spark.Spark.*;
// **************
// OZKANS DUZELTME import Request *;
//**************
//OZKANS Duzeltme  import java.awt.List;
import java.util.List;
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

	private static final ArrayList<Kitap> KiTAPLAR = new ArrayList<Kitap>();

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {

		VeriTabani.veritabaniniYukle();
		VeriTabani.veritabaninaBaglan();
		VeriTabani.tablolariOlustur();

		KiTAPLAR.add(new Kitap(Kitap.ID++, "Kurk Mantolu Madonna", 55, "Sbahattin Ali"));
		kitaplarJson();

		// http://localhost:4567/anasayfa
		kitaplariGoruntule();

		// http://localhost:4567/kitapekle
		//OZKANS Duzeltme kitapEklemeIslemi();

		// http://localhost:4567/kitapekle 'ye gelen POST isteklerine karsila
		//OZKANS Duzeltme kitapEklemeIslemi();

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

	/* OZKANS Derlenmiyordu kapatildi
	private static void kitapEklemeIslemi() {
		FreeMarkerRoute kitapEkleIslemi = new FreeMarkerRoute() {
			@Override
			public Object handle(Request istek, Response cevap) {

				// Kullanicinin kitapekle.html'den girdigi form degerlerini al
				String kitapAdi = istek.queryParams("kitapadi");
				String kitapDetayi = istek.queryParams("kitapdetay");
				// urunadi html input text'deki name

				// OZKANS Duzeltme}

				// kitap olustur ve listeye ekle
				Kitap kitap = new Kitap(kitap.ID++, kitapAdi, fiyat, kitapDetayi);
				// KiTAPLAR.add(kitap);
				VeriTabani.kitapEkle(Kitap);

				// Islem bitince /anasayfa sayfasina geri don
				cevap.redirect("/anasayfa");

				return null;
			}
		};
		post(kitapEkleIslemi); // bu yonlendirme post isteklerini karsilasin
		
	}*/

	private static void kitapEklemeSayfasi() {
		FreeMarkerRoute urunEkleSayfasi = new FreeMarkerRoute("") { // OZKANS Duzeltme
			public Object handle(Request arg0, Response arg1) {
				Map<String, Object> ozellikler = new HashMap<String, Object>();
				ozellikler.put("kitaplar", KiTAPLAR);
				return new ModelAndView(ozellikler, "kitapekle.html");
			}
		};
		// OZKANS Duzeltme get(kitapEkleSayfasi); 
		get(urunEkleSayfasi);
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
		// OZKANS Duzeltme get(kitaplari);
		get(kitaplariGoruntule);

// **************
// OZKANS DUZELTME
	}
// **************

}
