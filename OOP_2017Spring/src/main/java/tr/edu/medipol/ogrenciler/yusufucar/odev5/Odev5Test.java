package tr.edu.medipol.ogrenciler.yusufucar.odev5;

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

Yorum:
- Biraz gec gonderim: -10 puan
- Ismail Sahin ile tamamen aynı: -25 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5
- Test kod mantigi: 0/5

SONUC: 30/110

 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		islemlerOgrenci = new Odev5Islemler(); 
		
		Ogrenci ogrenci = new OgrenciYuksekLisans("6666","Ogrenci-1");
		Ogrenci ogrenci2  = new OgrenciLisans("7777","Ogrenci-2");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("Ba�ar�yla eklendi mi: " + "=>"+ " " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("6666");
		System.out.println("Kar��la�t�rma ba�ar�l� oldu mu: " + "=>"+ " "  +ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("7777");
		System.out.println("Ogrenci-2 null m� de�il mi: "+ "=>"+ " "  + bulunanOgrenci2);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("5");
		System.out.println("Silme durumu oldu mu: " + "=>"+ " "  + silmeBasarili);
		
		int[] dizi = new int[0];
		islemlerOgrenci.ogrenciEkle(ogrenci2);
		System.out.println(islemlerOgrenci.ogrenciList().size());
		
		LinkedList<Ogrenci> ll = islemlerOgrenci.ogrenciLinkedList();
		ll.removeFirst();
		System.out.println(ll.size());
		
		System.out.println(islemlerOgrenci.ogrenciMap().containsKey("Ogrenci-1"));
		System.out.println(islemlerOgrenci.ogrenciMap().containsKey("Ogrenci-3"));

	}

}