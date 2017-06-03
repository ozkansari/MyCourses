package tr.edu.medipol.ogrenciler.berkaydusmez.odev6;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/*
 9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 2/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 2/5 , test: 5/5
[ ] - TYPE kayitBul(KEY kayitNo) -> kod= 2/5 , test: 5/5
[ ] - List<TYPE> kayitList() -> kod= 2/5 , test: 0/5
[ ] - LinkedList<TYPE> kayitLinkedList() -> kod= 2/5 , test: 0/5
[ ] - Set<TYPE> kayitSet() -> kod= 2/5 , test: 0/5
[ ] - SortedSet<TYPE> kayitSortedSet() -> kod= 2/5 , test: 0/5
[ ] - Map<KEY, TYPE> kayitMap() -> kod= 2/5 , test: 0/5
[ ] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 2/5 , test: 0/5
[ ] - Generic Kullanimi ve Duzgun Test: 0/10

Yorum:
- Gec gonderim : -25 puan
- Derlenmeyen Kod: -10 puan
- Emek: +25 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5
- Test kod mantigi: 0/5

SONUC: 23/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = new IslemlerGeneric<Ogrenci, String>() {
			
			@Override
			public SortedSet<Ogrenci> kayitSortedSet() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public SortedMap<String, Ogrenci> kayitSortedMap() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean kayitSil(String kayitNo) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Set<Ogrenci> kayitSet() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Map<String, Ogrenci> kayitMap() {
				
				return null;
			}
			
			@Override
			public List<Ogrenci> kayitList() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public LinkedList<Ogrenci> kayitLinkedList() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean kayitEkle(Ogrenci kayit) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Ogrenci kayitBul(String kayitNo) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerGeneric = new Odev6Islemler();
		
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