package tr.edu.medipol.ogrenciler.ismailsahin.odev5;

import java.util.LinkedList;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;


/*

10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[X] - boolean ogrenciSil(String ogrenciNo) -> kod= 2/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[X] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 2/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciSiraliList() -> kod= 5/5 , test: 0/5
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 5/5 , test: 5/5
[X] - Set<Ogrenci> ogrenciSet() -> kod= 4/5 , test: 0/5
[X] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 1/5 , test: 0/5
[ ] - Map<String, Ogrenci> ogrenciMap() -> kod= 5/5 , test: 5/5
[X] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 1/5 , test: 0/5

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 5/5

SONUC: 75/110

 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		islemlerOgrenci = new Odev5Islemler(); 
		
		Ogrenci ogrenci = new OgrenciYuksekLisans("11111","Ogrenci 1");
		Ogrenci ogrenci2  = new OgrenciLisans("15423","Ogrenci 2 ");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("11111");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("22222");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("1");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);
		
		int[] dizi = new int[0];
		islemlerOgrenci.ogrenciEkle(ogrenci2);
		System.out.println(islemlerOgrenci.ogrenciList().size());
		
		LinkedList<Ogrenci> ll = islemlerOgrenci.ogrenciLinkedList();
		ll.removeFirst();
		System.out.println(ll.size());
		
		System.out.println(islemlerOgrenci.ogrenciMap().containsKey("Ogrenci 1"));
		System.out.println(islemlerOgrenci.ogrenciMap().containsKey("Ogrencisdsf"));

	}

}