package tr.edu.medipol.ogrenciler.berkaydusmez.odev5;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/*
 10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 2/5 , test: 5/5
[ ] - boolean ogrenciSil(String ogrenciNo) -> kod= 2/5 , test: 5/5
[ ] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 3/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 0/5
[ ] - List<Ogrenci> ogrenciSiraliList() -> kod= 2/5 , test: 0/5
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 1/5 , test: 0/5
[ ] - Set<Ogrenci> ogrenciSet() -> kod= 1/5 , test: 0/5
[ ] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 2/5 , test: 0/5
[ ] - Map<String, Ogrenci> ogrenciMap() -> kod= 2/5 , test: 0/5
[ ] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 2/5 , test: 0/5

Yorum:
- Gec gonderim: -25 puan
- Emek: +25 puan
- Derlenmeyen Kod: -10 puan

Bonus:
- Exception kontrolu: 5/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 3/5 (tr karakter sorunu)

SONUC: 30/115
 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = new OgrenciIslemler();
		
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