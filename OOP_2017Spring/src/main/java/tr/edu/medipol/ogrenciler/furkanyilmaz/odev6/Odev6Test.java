package tr.edu.medipol.ogrenciler.furkanyilmaz.odev6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import tr.edu.medipol.odev.Ogrenci;
import tr.edu.medipol.odev.OgrenciYuksekLisans;
import tr.edu.medipol.odev.odev6.IslemlerGeneric;

/*
9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - TYPE kayitBul(KEY kayitNo) -> kod= 5/5 , test: 5/5
[ ] - List<TYPE> kayitList() -> kod= 5/5 , test: 5/5
[X] - LinkedList<TYPE> kayitLinkedList() -> kod= 3/5 , test: 3/5
[X] - Set<TYPE> kayitSet() -> kod= 3/5 , test: 3/5
[X] - SortedSet<TYPE> kayitSortedSet() -> kod= 3/5 , test: 3/5
[X] - Map<KEY, TYPE> kayitMap() -> kod= 3/5 , test: 3/5
[X] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 3/5 , test: 3/5
[ ] - Generic Kullanimi ve Duzgun Test: 10/10

Yorum:
- Gec Gonderim: -25 puan
- Muhittin Ayri'nın (65) ödeviyle neredeyse aynı.
- Benzerlik: -25

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5 (Tr karakter)
- Test kod mantigi: 0/5

SONUC: 30/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		islemlerGeneric = new Odev6Islemler();
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerGeneric = new Odev6Islemler();
		
		Ogrenci kayit = new OgrenciYuksekLisans("11111","Ogrenci 1");
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
			
	        
	       
	     SortedSet<Ogrenci> sortedSet1 = new TreeSet<Ogrenci>();
	     islemlerGeneric.kayitSortedSet();
	     sortedSet1.forEach(System.out::println);
	     System.out.println("sortedSet1: " + sortedSet1 + "Ogrenci No: " + kayit.getNo() +" Ad� Soyad�: " + kayit.getAdSoyad() + " Ogrenci Tipi: " + kayit.ogrenciTipi() );
			
	        
	        
	     Map<String, Ogrenci> map = new TreeMap<String, Ogrenci>();
	     islemlerGeneric.kayitMap();
	     map.put("1" , kayit);
	     for (Map.Entry<String, Ogrenci> entry : map.entrySet()) 
	     {
	        System.out.println("Map: " + kayit.getNo()  + " - " + kayit.getAdSoyad()+  " - "  + kayit.ogrenciTipi());
	     }
	    
	          
	       
	        
	     Map<String, Ogrenci> sortedMAP = new TreeMap<String, Ogrenci>();
	     islemlerGeneric.kayitSortedMap();
	     sortedMAP.put("1" , kayit);
	     for(Entry<String,Ogrenci> mapData : sortedMAP.entrySet()) 
	     {
	        System.out.println("SortedMap: " + kayit.getNo() + " - " + kayit.getAdSoyad()+  " - "  + kayit.ogrenciTipi());
	     }
	        
		// YAPILACAKLAR - 2 **************************************************
		// islemlerGeneric sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
	}
}