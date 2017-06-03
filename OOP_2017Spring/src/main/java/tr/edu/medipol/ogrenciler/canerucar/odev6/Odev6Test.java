package tr.edu.medipol.ogrenciler.canerucar.odev6;


import java.awt.List;
import java.security.KeyStore.Entry;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

/*
 9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 4/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - TYPE kayitBul(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - List<TYPE> kayitList() -> kod= 5/5 , test: 0/5
[ ] - LinkedList<TYPE> kayitLinkedList() -> kod= 5/5 , test: 0/5
[ ] - Set<TYPE> kayitSet() -> kod= 5/5 , test: 0/5
[ ] - SortedSet<TYPE> kayitSortedSet() -> kod= 0/5 , test: 0/5
[ ] - Map<KEY, TYPE> kayitMap() -> kod= 5/5 , test: 0/5
[ ] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 0/5 , test: 0/5
[ ] - Generic Kullanimi ve Duzgun Test: 10/10

Yorum:
- Gec gonderim: -25 puan
- Derlenmeyen Kod: -10 puan
- Emek: +25 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5
- Test kod mantigi: 0/5

SONUC:49/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		
		
		islemlerGeneric = new Odev6Islemler();
		
		Ogrenci kayit = new OgrenciYuksekLisans("1"," Ilk Ogrenci");
		boolean eklemeBasarili = islemlerGeneric.kayitEkle(kayit);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanKayit = islemlerGeneric.kayitBul("1");
		System.out.println("Karsilastirma true olmali: " + kayit.getNo().equals(bulunanKayit.getNo()));
		
		Ogrenci bulunanKayit2 = islemlerGeneric.kayitBul("2");
		System.out.println("bulunanKayit2 null olmali: " + bulunanKayit2);
		
		boolean silmeBasarili = islemlerGeneric.kayitSil("3");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);

	}
}