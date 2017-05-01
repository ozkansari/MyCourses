package tr.edu.medipol.odev.odev5;

import tr.edu.medipol.odev.Ogrenci;
import tr.edu.medipol.odev.OgrenciYuksekLisans;

public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerOgrenci sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerOgrenci = new Odev5Islemler();
		
		Ogrenci ogrenci = new OgrenciYuksekLisans("11111","Ogrenci 1");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("11111");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("22222");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("1");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);

		// YAPILACAKLAR - 2 **************************************************
		// islemlerOgrenci sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
	}

}
