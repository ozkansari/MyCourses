package tr.edu.medipol.ogrenciler.selahattinbozat.odev5.ikincigonderim;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/*
10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[ ] - boolean ogrenciSil(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 4/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 2/5 , test: 0/5
[X] - List<Ogrenci> ogrenciSiraliList() -> kod= 1/5 , test: 0/5
[X] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 1/5 , test: 0/5
[X] - Set<Ogrenci> ogrenciSet() -> kod= 1/5 , test: 0/5
[X] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 1/5 , test: 0/5
[X] - Map<String, Ogrenci> ogrenciMap() -> kod= 1/5 , test: 0/5
[X] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 1/5 , test: 0/5

Yorum:
- Emek: +10 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 3/5
- Test kod mantigi: 0/5

SONUC: 40/115
 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerOgrenci sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerOgrenci = new Odev5Islemler();
		
		Ogrenci ogrenci = new OgrenciYuksekLisans("11111","Ogrenci 1");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		islemlerOgrenci.ogrenciEkle(new OgrenciYuksekLisans("160016","��renci2"));
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		islemlerOgrenci.ogrenciEkle(new OgrenciYuksekLisans("160016","��renci3"));
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("11111");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("22222");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		islemlerOgrenci.ogrenciList();
		islemlerOgrenci.ogrenciList();
		
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("1");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);
		boolean silmeBasarilii = islemlerOgrenci.ogrenciSil("160016");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);

		// YAPILACAKLAR - 2 **************************************************
		// islemlerOgrenci sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
	}

}