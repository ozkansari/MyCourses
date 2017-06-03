package tr.edu.medipol.ogrenciler.dogankoc.odev6;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

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
[ ] - Generic Kullanimi ve Duzgun Test: 10/10

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5
- Test kod mantigi: 0/5

SONUC: 100/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
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
		
		System.out.println("--------Benim Testlerim-------");
		Ogrenci kayit2 = new OgrenciLisans("22222","Ogrenci 2");
		eklemeBasarili=islemlerGeneric.kayitEkle(kayit2);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci kayit3 = new OgrenciYuksekLisans("33333","Ogrenci 3");
		eklemeBasarili = islemlerGeneric.kayitEkle(kayit3);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci kayit4 = new OgrenciLisans("44444","Ogrenci 4");
		islemlerGeneric.kayitEkle(kayit4);
		
		silmeBasarili = islemlerGeneric.kayitSil("22222");
		System.out.println("silmeBasarili true olmali: " + silmeBasarili);
				
		Ogrenci bulunanKayit3 = islemlerGeneric.kayitBul("33333");
		System.out.println("bulunanKayit3 true olmali : " + kayit3.getNo().equals(bulunanKayit3.getNo()));
		
		System.out.println("----List ile-----");
		List<Ogrenci> ogrList=islemlerGeneric.kayitList();
		for(Ogrenci o: ogrList){
			System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n");
		}
		System.out.println("----LinkedList ile-----");
		LinkedList<Ogrenci> ogrLinkedList=islemlerGeneric.kayitLinkedList();
		ogrLinkedList.forEach(o->System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n"));
		System.out.println("----Set ile(HashSet)-----");
		Set<Ogrenci> ogrSet=islemlerGeneric.kayitSet();
		ogrSet.forEach((o)->System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n"));
		System.out.println("----SortedSet ile-----");
		SortedSet<Ogrenci> ogrenciSortedSet=islemlerGeneric.kayitSortedSet();
		for(Ogrenci o: ogrenciSortedSet){
			System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n");
		}
		System.out.println("----Map ile(HashMap)-----");
		 Map<String,Ogrenci> ogrMap=islemlerGeneric.kayitMap();
		 for(Entry<String,Ogrenci> entrySetOgr: ogrMap.entrySet()){
			 System.out.println(entrySetOgr.getKey()+"\n"+entrySetOgr.getValue().getAdSoyad()+"\n"+entrySetOgr.getValue().ogrenciTipi());
		 }
		 System.out.println("----SortedMap ile----");
		 SortedMap<String,Ogrenci> ogrSortedMap=islemlerGeneric.kayitSortedMap();
		 ogrSortedMap.forEach((k,v) -> System.out.println(k+v.getAdSoyad()+"\n"+v.ogrenciTipi()));
	}
}