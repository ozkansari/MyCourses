package tr.edu.medipol.ogrenciler.yusufucar.odev6;

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
- Biraz gec gonderim: -25 puan
- Ismail Sahin ile tamamen aynı: -25 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5 <<< ozkans: tr karakter sorunu >>>
- Test kod mantigi: 0/5

SONUC: 47/115
 */
public class Odev6Test {
	public static void main(String[] args) {
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = new Odev6Islemler();
		
		Ogrenci kayit1 = new OgrenciYuksekLisans("123","Ogrenci-1");
		Ogrenci kayit2 = new OgrenciYuksekLisans("456","Ogrenci-2");
		Ogrenci kayit3 = new OgrenciLisans("789","Ogrenci-3");
		
		boolean eklemeBasarili = islemlerGeneric.kayitEkle(kayit1);
		System.out.println("Ba�ar�yla eklendi mi: " + "=>" + " " + eklemeBasarili);
		
		islemlerGeneric.kayitEkle(kayit2);
		islemlerGeneric.kayitEkle(kayit3);
	
		Ogrenci bulunankayit = islemlerGeneric.kayitBul("123");
		System.out.println("Kar��la�t�rma ba�ar�l� oldu mu: " + "=>"+ " "  + kayit3.getNo().equals(bulunankayit.getNo()));
		
		Ogrenci bulunanKayit2 = islemlerGeneric.kayitBul("458");
		System.out.println("Ogrenci-2 null m� de�il mi: "+ "=>"+ " "  + bulunanKayit2);
		
		boolean silmeBasarili = islemlerGeneric.kayitSil("789");
		System.out.println("Silme durumu oldu mu: " + "=>"+ " "  + silmeBasarili);
		
		List<Ogrenci> list1 = islemlerGeneric.kayitList();
		ekranaBas(list1);
		
		LinkedList<Ogrenci> ll = islemlerGeneric.kayitLinkedList();
		System.out.println(ll.size()>0);
		
		Map<String, Ogrenci> map = islemlerGeneric.kayitMap();
		System.out.println("Do�ru mu de�il mi: " + (map.size()>0));
		
		SortedMap<String, Ogrenci> srtmap = islemlerGeneric.kayitSortedMap();
		System.out.println("Do�ru mu de�il mi: " + (srtmap.size()>0));
		
		Set<Ogrenci> st = islemlerGeneric.kayitSet();
		System.out.println("Do�ru mu de�il mi: " + (st.size()>0));
		
		SortedSet<Ogrenci> st2 = islemlerGeneric.kayitSortedSet();
		System.out.println("Do�ru mu de�il mi: " + (st2.size()>0));
	}
	
	static void ekranaBas(List<Ogrenci> list){
		for(int i = 0; i<list.size(); i++){
			System.out.println(list.get(i).getAdSoyad());
		}
	}
}
