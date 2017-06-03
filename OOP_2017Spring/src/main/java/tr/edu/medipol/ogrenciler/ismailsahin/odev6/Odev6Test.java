package tr.edu.medipol.ogrenciler.ismailsahin.odev6;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

/*
9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[X] - boolean kayitSil(KEY kayitNo) -> kod= 2/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[ ] - TYPE kayitBul(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - List<TYPE> kayitList() -> kod= 5/5 , test: 5/5
[ ] - LinkedList<TYPE> kayitLinkedList() -> kod= 5/5 , test: 5/5
[ ] - Set<TYPE> kayitSet() -> kod= 5/5 , test: 5/5
[ ] - SortedSet<TYPE> kayitSortedSet() -> kod= 5/5 , test: 5/5
[ ] - Map<KEY, TYPE> kayitMap() -> kod= 5/5 , test: 5/5
[ ] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 5/5 , test: 5/5
[ ] - Generic Kullanimi ve Duzgun Test: 10/10

Yorum:
- Biraz gec gonderim: -5 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 3/5 <<< ozkans: tr karakter sorunu >>>
- Test kod mantigi: 5/5

SONUC: 100/115
 */
public class Odev6Test {
	public static void main(String[] args) {
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = new Odev6Islemler();
		
		Ogrenci kayit1 = new OgrenciYuksekLisans("11111","Ogrenci 1");
		Ogrenci kayit2 = new OgrenciYuksekLisans("22222","Ogrenci 2");
		Ogrenci kayit3 = new OgrenciLisans("33333","Ogrenci 3");
		
		boolean eklemeBasarili = islemlerGeneric.kayitEkle(kayit1);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		islemlerGeneric.kayitEkle(kayit2);
		islemlerGeneric.kayitEkle(kayit3);
	
		Ogrenci bulunankayit = islemlerGeneric.kayitBul("33333");
		System.out.println("Karsilastirma true olmali: " + kayit3.getNo().equals(bulunankayit.getNo()));
		
		Ogrenci bulunanKayit2 = islemlerGeneric.kayitBul("22222hgjh");
		System.out.println("bulunanKayit2 null olmali: " + bulunanKayit2);
		
		boolean silmeBasarili = islemlerGeneric.kayitSil("33333");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);
		
		List<Ogrenci> list1 = islemlerGeneric.kayitList();
		ekranaBas(list1);
		
		LinkedList<Ogrenci> ll = islemlerGeneric.kayitLinkedList();
		System.out.println(ll.size()>0);
		
		Map<String, Ogrenci> map = islemlerGeneric.kayitMap();
		System.out.println("sonuc true olmal�: " + (map.size()>0));
		
		SortedMap<String, Ogrenci> srtmap = islemlerGeneric.kayitSortedMap();
		System.out.println("sonuc true olmal�: " + (srtmap.size()>0));
		
		Set<Ogrenci> st = islemlerGeneric.kayitSet();
		System.out.println("sonuc true olmal�: " + (st.size()>0));
		
		SortedSet<Ogrenci> st2 = islemlerGeneric.kayitSortedSet();
		System.out.println("sonuc true olmal�: " + (st2.size()>0));
	}
	
	static void ekranaBas(List<Ogrenci> list){
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i).getAdSoyad());
		}
	}
}
