package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev6;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.IslemlerGeneric;

import java.awt.List;
import java.security.KeyStore.Entry;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/*
9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - TYPE kayitBul(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - List<TYPE> kayitList() -> kod= 5/5 , test: 5/5
[ ] - LinkedList<TYPE> kayitLinkedList() -> kod= 5/5 , test: 5/5
[ ] - Set<TYPE> kayitSet() -> kod= 5/5 , test: 5/5
[ ] - SortedSet<TYPE> kayitSortedSet() -> kod= 5/5 , test: 5/5
[ ] - Map<KEY, TYPE> kayitMap() -> kod= 5/5 , test: 5/5
[ ] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 5/5 , test: 5/5
[ ] - Generic Kullanimi ve Duzgun Test: 5/10

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 0/5

SONUC: 100/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerGeneric = new Odev6Islemler();
		
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

		// YAPILACAKLAR - 2 **************************************************
		// islemlerGeneric sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
		Ogrenci kayit2 = new OgrenciLisans("2","Ali");
		boolean eklemeBasarili1=islemlerGeneric.kayitEkle(kayit2);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili1);
		
		Ogrenci kayit3 = new OgrenciYuksekLisans("3","Mehmed");
		boolean eklemeBasarili2 = islemlerGeneric.kayitEkle(kayit3);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili2);
		
		Ogrenci kayit4 = new OgrenciLisans("4","Can");
		boolean eklemeBasarili4 = islemlerGeneric.kayitEkle(kayit4);
		
		silmeBasarili = islemlerGeneric.kayitSil("2");
		System.out.println("silmeBasarili true olmali: " + silmeBasarili);
				
		Ogrenci bulunanKayit3 = islemlerGeneric.kayitBul("3");
		System.out.println("bulunanKayit3 true olmali : " + kayit3.getNo().equals(bulunanKayit3.getNo()));
		
		
		System.out.println("\n" + "\n" 
		+ "--------------------------------");
		
		System.out.println("----- LIST OLARAK ------");
		for (Ogrenci ogrnc : islemlerGeneric.kayitList()) {
			System.out.println(ogrnc.getNo() + " " + ogrnc.getAdSoyad() 
			+ " " + ogrnc.ogrenciTipi());
		}
		
		System.out.println("");
		
		System.out.println("----- LINKEDLIST OLARAK ------");
		for (Ogrenci ogr : islemlerGeneric.kayitLinkedList()) {
			System.out.println(ogr.getNo() + " " + ogr.getAdSoyad()
			+ " " + ogr.ogrenciTipi());
		}
		
		System.out.println("");
		
		System.out.println("----- SET OLARAK ------");
		for (Ogrenci ogr : islemlerGeneric.kayitSet()) {
			System.out.println(ogr.getNo() +" " + ogr.getAdSoyad()
			+ " " + ogr.ogrenciTipi());
		}
		
		System.out.println("");
		System.out.println("----- SORTEDSET OLARAK ------");
		
		for (Ogrenci ogr : islemlerGeneric.kayitSortedSet()) {
			System.out.println(ogr.getNo() + " " + ogr.getAdSoyad()
			+ " " + ogr.ogrenciTipi());
		}
		System.out.println("");
		
		System.out.println("----- MAP OLARAK ------");
		Map<String, Ogrenci> map=islemlerGeneric.kayitMap();
		map.forEach((k, v) -> System.out.printf("%s %s %s\n", 
				v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
		
		System.out.println("");
		
		System.out.println("----- SORTEDMAP OLARAK ------");
		SortedMap<String, Ogrenci> sortedMap=islemlerGeneric.kayitSortedMap();
		sortedMap.forEach((k, v) -> System.out.printf("%s  %s  %s\n", 
				v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
		
		System.out.println("");
		System.out.println("");
		
		
	}
}