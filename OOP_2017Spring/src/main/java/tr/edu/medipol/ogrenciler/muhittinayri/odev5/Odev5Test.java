package tr.edu.medipol.ogrenciler.muhittinayri.odev5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/*
 10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[ ] - boolean ogrenciSil(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 3/5
[X] - List<Ogrenci> ogrenciSiraliList() -> kod= 2/5 , test: 3/5
[X] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 3/5 , test: 3/5
[X] - Set<Ogrenci> ogrenciSet() -> kod= 3/5 , test: 3/5
[X] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 3/5 , test: 3/5
[X] - Map<String, Ogrenci> ogrenciMap() -> kod= 2/5 , test: 3/5
[X] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 3/5 , test: 3/5

Yorum:
- Gec gonderim: -15 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5 (Tr karakter kullanimi)
- Test kod mantigi: 0/5 

SONUC: 57/115
 */
public class Odev5Test extends Odev5Islemler{

	

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		islemlerOgrenci = new Odev5Islemler();
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerOgrenci sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerOgrenci = new Odev5Islemler();

		Ogrenci ogrenci = new OgrenciYuksekLisans("11111","Ogrenci 1");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("ekleme Basarili true olmali: " + eklemeBasarili);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("1");
		System.out.println("silme Basarili false olmali: " + silmeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("11111");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("22222");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		
	
        
        List<Ogrenci> List = new ArrayList<Ogrenci>();
        islemlerOgrenci.ogrenciList();
        List.forEach(System.out::println);
        System.out.println("list1: " + List + "Ogrenci No: " + ogrenci.getNo() +" Adi Soyadi: " + ogrenci.getAdSoyad() + " Ogrenci Tipi: " + ogrenci.ogrenciTipi() );
        
        
		List<Ogrenci> OgrenciListeleSirali = new ArrayList<Ogrenci>();
		islemlerOgrenci.ogrenciList();
		Collections.sort(OgrenciListeleSirali);
		System.out.println("Sirali List: " + OgrenciListeleSirali + "Ogrenci No: " + ogrenci.getNo() +" Adi Soyadi: " + ogrenci.getAdSoyad() + " Ogrenci Tipi: " + ogrenci.ogrenciTipi() );
		
		
		
        LinkedList<Ogrenci> linkedlist = new LinkedList<Ogrenci>();
        islemlerOgrenci.ogrenciLinkedList();
        linkedlist.forEach(System.out::println);
        System.out.println("Linkedlist: " + linkedlist + "Ogrenci No: " + ogrenci.getNo() +" Adi Soyadi: " + ogrenci.getAdSoyad() + " Ogrenci Tipi: " + ogrenci.ogrenciTipi() );
       
        
        
        
        Set<Ogrenci> SET = new HashSet<Ogrenci>();
        islemlerOgrenci.ogrenciSet();
        SET.forEach(System.out::println);
        System.out.println("SET: " + SET + "Ogrenci No: " + ogrenci.getNo() +" Adi Soyadi: " + ogrenci.getAdSoyad() + " Ogrenci Tipi: " + ogrenci.ogrenciTipi() );
		
        
       
        SortedSet<Ogrenci> sortedSet1 = new TreeSet<Ogrenci>();
        islemlerOgrenci.ogrenciSortedSet();
        sortedSet1.forEach(System.out::println);
        System.out.println("sortedSet1: " + sortedSet1 + "Ogrenci No: " + ogrenci.getNo() +" Adi Soyadi: " + ogrenci.getAdSoyad() + " Ogrenci Tipi: " + ogrenci.ogrenciTipi() );
		
        
        
        Map<String, Ogrenci> map = new TreeMap<String, Ogrenci>();
        islemlerOgrenci.ogrenciMap();
        map.put("1" , ogrenci);
        for (Map.Entry<String, Ogrenci> entry : map.entrySet()) {
            System.out.println("Map: " + ogrenci.getNo()  + " - " + ogrenci.getAdSoyad()+  " - "  + ogrenci.ogrenciTipi());
        }
    
          
       
        
        Map<String, Ogrenci> sortedMAP = new TreeMap<String, Ogrenci>();
        islemlerOgrenci.ogrenciSortedMap();
        sortedMAP.put("1",ogrenci);
        for(Entry<String,Ogrenci> mapData : sortedMAP.entrySet()) {
            System.out.println("SortedMap: " + ogrenci.getNo() + " - " + ogrenci.getAdSoyad()+  " - "  + ogrenci.ogrenciTipi());
            }
        
     

		

		// YAPILACAKLAR - 2 **************************************************
		// islemlerOgrenci sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
	}

}