package tr.edu.medipol.ogrenciler.selahattinbozat.odev6.ikincigonderim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import tr.edu.medipol.odev.Ogrenci;
import tr.edu.medipol.odev.OgrenciYuksekLisans;
import tr.edu.medipol.odev.odev6.*;

/*
 9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 5/5 , test: 5/5
[X] - TYPE kayitBul(KEY kayitNo) -> kod= 4/5 , test: 5/5
[ ] - List<TYPE> kayitList() -> kod= 2/5 , test: 5/5
[X] - LinkedList<TYPE> kayitLinkedList() -> kod= 1/5 , test: 3/5
[X] - Set<TYPE> kayitSet() -> kod= 1/5 , test: 3/5
[X] - SortedSet<TYPE> kayitSortedSet() -> kod= 1/5 , test: 3/5
[X] - Map<KEY, TYPE> kayitMap() -> kod= 1/5 , test: 3/5
[X] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 1/5 , test: 3/5
[ ] - Generic Kullanimi ve Duzgun Test: 10/10

Yorum:
- Test kısmı Muhittin Ayrı ile aynı: -15 puan 

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5
- Test kod mantigi: 0/5

SONUC: 51/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		islemlerGeneric = new Odev6Islemler();
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerGeneric = new Odev6Islemler();
		
		Ogrenci kayit = new OgrenciYuksekLisans("160016","Ogrenci 1");
		boolean eklemeBasarili = islemlerGeneric.kayitEkle(kayit);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		boolean silmeBasarili = islemlerGeneric.kayitSil("1");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);
		
		Ogrenci bulunanKayit = islemlerGeneric.kayitBul("11111");
		System.out.println("Karsilastirma true olmali: " + kayit.getNo().equals(bulunanKayit.getNo()));
		
		Ogrenci bulunanKayit2 = islemlerGeneric.kayitBul("22222");
		System.out.println("bulunanKayit2 null olmali: " + bulunanKayit2);
	
		
		 List<Ogrenci> List = new ArrayList<Ogrenci>();
	     islemlerGeneric.kayitList();
	     List.forEach(System.out::println);
	     System.out.println("list1: " + List + "Ogrenci No: " + kayit.getNo() +" Ad� Soyad�: " + kayit.getAdSoyad() + " Ogrenci Tipi: " + kayit.ogrenciTipi() );
		
	
	     LinkedList<Ogrenci> linkedlist = new LinkedList<Ogrenci>();
	     islemlerGeneric.kayitLinkedList();
	     linkedlist.forEach(System.out::println);
	     System.out.println("Linkedlist: " + linkedlist + "Ogrenci No: " + kayit.getNo() +" Ad� Soyad�: " + kayit.getAdSoyad() + " Ogrenci Tipi: " + kayit.ogrenciTipi() );

	     Set<Ogrenci> SET = new HashSet<Ogrenci>();
	     islemlerGeneric.kayitSet();
	     SET.forEach(System.out::println);
	     System.out.println("SET: " + SET + "Ogrenci No: " + kayit.getNo() +" Ad� Soyad�: " + kayit.getAdSoyad() + " Ogrenci Tipi: " + kayit.ogrenciTipi() );
		
	   
	        
		// YAPILACAKLAR - 2 **************************************************
		// islemlerGeneric sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
	}
}