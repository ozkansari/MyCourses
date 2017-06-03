package tr.edu.medipol.ogrenciler.melissatemelli.odev6;

import java.util.Map;
import java.util.SortedMap;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

/*
 9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - TYPE kayitBul(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - List<TYPE> kayitList() -> kod= 5/5 , test: 5/5
[ ] - LinkedList<TYPE> kayitLinkedList() -> kod= 4/5 , test: 5/5
[ ] - Set<TYPE> kayitSet() -> kod= 1/5 , test: 5/5
[ ] - SortedSet<TYPE> kayitSortedSet() -> kod= 1/5 , test: 5/5
[ ] - Map<KEY, TYPE> kayitMap() -> kod= 1/5 , test: 5/5
[ ] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 1/5 , test: 5/5
[ ] - Generic Kullanimi ve Duzgun Test: 10/10

Yorum:
- Gec gonderim: -25 puan
- Test kismi Cihandan aynen kopya: -15 puan 
- Emek: +17 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 3/5
- Test kod mantigi: 0/5

SONUC: 63/115
 */
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
		
		Ogrenci kayit2=new OgrenciYuksekLisans("2", "C�HAN");
		boolean eklemeBasarili2=islemlerGeneric.kayitEkle(kayit2);
		Ogrenci kayit3=new OgrenciYuksekLisans("3", "�BRAH�M");
		boolean eklemeBasarili3=islemlerGeneric.kayitEkle(kayit3);
		Ogrenci kayit4=new OgrenciLisans("4", "DO�AN");
		boolean eklemeBasarili4=islemlerGeneric.kayitEkle(kayit4);
		Ogrenci kayit5=new OgrenciLisans("5", "Y�CEL");
		boolean eklemeBasarili5=islemlerGeneric.kayitEkle(kayit5);
		Ogrenci kayit6=new OgrenciLisans("6", "MUHAMMET");
		boolean eklemeBasarili6=islemlerGeneric.kayitEkle(kayit6);
		
	}
}
