package tr.edu.medipol.ogrenciler.didemlaloglu.odev6;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

/*
9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[X] - boolean kayitSil(KEY kayitNo) -> kod= 1/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[X] - TYPE kayitBul(KEY kayitNo) -> kod= 1/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[ ] - List<TYPE> kayitList() -> kod= 5/5 , test: 0/5
[ ] - LinkedList<TYPE> kayitLinkedList() -> kod= 5/5 , test: 0/5
[X] - Set<TYPE> kayitSet() -> kod= 4/5 , test: 0/5 <<< ozkans: hashset olsa daha iyi >>>
[ ] - SortedSet<TYPE> kayitSortedSet() -> kod= 5/5 , test: 0/5
[X] - Map<KEY, TYPE> kayitMap() -> kod= 4/5 , test: 0/5 <<< ozkans: bir ogrenciye ait bir mapping olsa daha iyi >>>
[X] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 4/5 , test: 0/5 <<< ozkans: bir ogrenciye ait bir mapping olsa daha iyi >>> 
[X] - Generic Kullanimi ve Duzgun Test: 5/10

Bonus:
- Exception kontrolu: 5/5
- Clean/Kod Duzenli Kod: 2/5
- Test kod mantigi: 0/5

SONUC: 61/115
 */
// ODEV 6
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
		 islemlerGeneric = new Odev6Islemler();
		
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