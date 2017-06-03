package tr.edu.medipol.ogrenciler.erenyazici.odev6;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

/*
9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 5/5 , test: 5/5
[X] - TYPE kayitBul(KEY kayitNo) -> kod= 1/5 , test: 5/5
[X] - List<TYPE> kayitList() -> kod= 1/5 , test: 0/5
[X] - LinkedList<TYPE> kayitLinkedList() -> kod= 1/5 , test: 0/5
[X] - Set<TYPE> kayitSet() -> kod= 1/5 , test: 0/5
[X] - SortedSet<TYPE> kayitSortedSet() -> kod= 1/5 , test: 0/5
[X] - Map<KEY, TYPE> kayitMap() -> kod= 1/5 , test: 0/5
[X] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 1/5 , test: 0/5
[X] - Generic Kullanimi ve Duzgun Test: 0/10

Yorum:
- Gec Gonderim: -25 puan
- Emek: +30 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 0/5

SONUC: 47/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerGeneric = new Odev6Islemler();
		islemlerGeneric = new Eren();

		
		Ogrenci kayit = new OgrenciYuksekLisans("11111","Ogrenci 1");
		boolean eklemeBasarili = islemlerGeneric.kayitEkle(kayit);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanKayit = islemlerGeneric.kayitBul("11111");
		System.out.println("Karsilastirma true olmali: " + kayit.getNo().equals(bulunanKayit.getNo()));
		
		Ogrenci bulunanKayit2 = islemlerGeneric.kayitBul("22222");
		System.out.println("bulunanKayit2 null olmali: " + bulunanKayit2);
		
		boolean silmeBasarili = islemlerGeneric.kayitSil("1");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);

		// YAPILACAKLAR - 2 **************************************************
		// islemlerGeneric sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
		
		
	}
}
