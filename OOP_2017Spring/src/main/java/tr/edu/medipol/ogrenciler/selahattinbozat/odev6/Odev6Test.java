package tr.edu.medipol.ogrenciler.selahattinbozat.odev6;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;


public class Odev6Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerGeneric = new Odev6Islemler();
		
		Ogrenci kayit = new OgrenciYuksekLisans("11111","Ogrenci 1");
		boolean eklemeBasarili = islemlerGeneric.kayitEkle(kayit);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		/* HATALI
		Ogrenci bulunanKayit = islemlerGeneric.kayitEkle("11111");
		System.out.println("Karsilastirma true olmali: " + kayit.getNo().equals(bulunanKayit.getNo()));
		
		Ogrenci bulunanKayit2 = islemlerGeneric.kayitEkle("22222");
		System.out.println("bulunanKayit2 null olmali: " + bulunanKayit2);
		*/
		boolean silmeBasarili = islemlerGeneric.kayitSil("1");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);

		// YAPILACAKLAR - 2 **************************************************
		// islemlerGeneric sinifinin diger metodlarini da ayni sekilde test edin
// .......................s

	}

}
