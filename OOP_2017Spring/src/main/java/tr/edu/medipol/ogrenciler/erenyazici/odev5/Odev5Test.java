package tr.edu.medipol.ogrenciler.erenyazici.odev5;

import java.util.LinkedList;
import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/*
10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[ ] - boolean ogrenciSil(String ogrenciNo) -> kod= 5/5 , test: 5/5
[X] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 1/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciSiraliList() -> kod= 5/5 , test: 5/5
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 5/5 , test: 5/5
[ ] - Set<Ogrenci> ogrenciSet() -> kod= 5/5 , test: 5/5
[X] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 0/5 , test: 0/5
[ ] - Map<String, Ogrenci> ogrenciMap() -> kod= 5/5 , test: 5/5
[X] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 0/5 , test: 0/5

Bonus:
- Exception kontrolu: 5/5
- Clean/Kod Duzenli Kod: 1/5
- Test kod mantigi: 5/5

Yorum:
- Biraz gec gonderim: -5 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 0/5

SONUC: 70/115
 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerOgrenci sinifini extends eden sinifiniz ile new'leyiniz.
		islemlerOgrenci = new Eren();
		
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
		
		 Ogrenci listogrenci = (Ogrenci) islemlerOgrenci.ogrenciList();
		 System.out.println(ogrenci);
		
		Ogrenci sortlist =  (Ogrenci) islemlerOgrenci.ogrenciSiraliList();
		System.out.println(ogrenci);
		
		LinkedList<Ogrenci> linkList = islemlerOgrenci.ogrenciLinkedList();
		System.out.println(ogrenci);
		
		Ogrenci setogrenci = (Ogrenci) islemlerOgrenci.ogrenciSet();
		System.out.println(ogrenci);
		
		Ogrenci mapogrenci = (Ogrenci) islemlerOgrenci.ogrenciMap();
		System.out.println(ogrenci);


	}

}
