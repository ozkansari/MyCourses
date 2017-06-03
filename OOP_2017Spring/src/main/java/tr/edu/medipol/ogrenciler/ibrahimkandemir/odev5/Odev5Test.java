package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev5;

import java.util.Map;
import java.util.SortedMap;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.IslemlerOgrenci;

/**
 * OZKANS DEGERLENDIRME

10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[ ] - boolean ogrenciSil(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 5/5
[X] - List<Ogrenci> ogrenciSiraliList() -> kod= 0/5 , test: 0/5
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 5/5 , test: 5/5
[ ] - Set<Ogrenci> ogrenciSet() -> kod= 5/5 , test: 5/5
[ ] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 5/5 , test: 5/5
[ ] - Map<String, Ogrenci> ogrenciMap() -> kod= 5/5 , test: 5/5
[ ] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 5/5 , test: 5/5

Yorum:
- Erisim hatasi: -1

Bonus:
- Exception kontrolu: 5/5
- Clean/Kod Duzenli Kod: 5/5

SONUC: 99/110

 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerOgrenci sinifini extends eden sinifiniz ile new'leyiniz.
		// islemlerOgrenci = new Odev5Islemler();
		
		islemlerOgrenci = new Odev5Islemler();
		
		Ogrenci ogrenci = new OgrenciYuksekLisans("1","Ilk Ogrenci");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("1");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("2");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("2");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);

		
		Ogrenci ogrenci1 = new OgrenciYuksekLisans("2","Y.Lisans Ogrencisi");
		eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci1);		
		
		OgrenciLisans ogrenci2 = new OgrenciLisans("3","Lisans Ogrencisi 1");
		eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci2);
		
		Ogrenci ogrenci3 = new OgrenciLisans("4", "Lisans Ogrencisi 2");
		eklemeBasarili=islemlerOgrenci.ogrenciEkle(ogrenci3);
		
		Ogrenci ogrenci4 = new OgrenciLisans("5", "Lisans Ogrencisi 3");
		eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci4);
		
		Ogrenci ogrenci5 = new OgrenciLisans("6","Lisans Ogrencisi 4");
		eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci5);
		

		
		
		// YAPILACAKLAR - 2 **************************************************
		// islemlerOgrenci sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
	
		System.out.println("\n");
		
		System.out.println("------- LIST OLARAK -------");
		for (Ogrenci ogr : islemlerOgrenci.ogrenciList()) {
			System.out.println(ogr.getNo() + " " + ogr.getAdSoyad()
			+ " " + ogr.ogrenciTipi());
		}
		System.out.println("\n");
		System.out.println("-----------------------------");
		
		System.out.println("------- SIRALI LIST OLARAK -------");
		for(int i=0;i<islemlerOgrenci.ogrenciSiraliList().size();i++){
			// HATALI: Ogrenci o= islemlerOgrenci.tumOgrenciler.get(i);
		    /* ozkans */ Ogrenci o = islemlerOgrenci.ogrenciSiraliList().get(i);
			System.out.println(" " + o.getNo() + o.getAdSoyad() 
			+ o.ogrenciTipi());
		}
		
		System.out.println("\n");
		System.out.println("-----------------------------");
		
		System.out.println("------- LINKED LIST OLARAK -------");
		for (Ogrenci ogr : islemlerOgrenci.ogrenciLinkedList()) {
			System.out.println(ogr.getNo() + " "+ ogr.getAdSoyad() 
			+ " " + ogr.ogrenciTipi());
		}
		
		System.out.println("\n");
		System.out.println("-----------------------------");
		
		System.out.println("------- SET OLARAK -------");
		for(Ogrenci ogr:islemlerOgrenci.ogrenciSet()){
			System.out.println(ogr.getNo() + " " + ogr.getAdSoyad()
			+ " " + ogr.ogrenciTipi());
		}
		
		System.out.println("\n");
		System.out.println("-----------------------------");
		
		System.out.println("------- SORTED SET OLARAK -------");
		for (Ogrenci ogr: islemlerOgrenci.ogrenciSortedSet()) {
			System.out.println(ogr.getNo() + " " + ogr.getAdSoyad()
			+ " " + ogr.ogrenciTipi());


		System.out.println("\n");
		System.out.println("-----------------------------");
			
		System.out.println("------- MAP OLARAK -------");
		Map<String, Ogrenci> ogrmap=islemlerOgrenci.ogrenciMap();
		ogrmap.forEach( (k, v) -> System.out.printf("%s %s %s\n", v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
		
		System.out.println("\n");
		System.out.println("-----------------------------");
		
		System.out.println("------- SORTED MAP OLARAK -------");
		SortedMap<String, Ogrenci> sortedMap=islemlerOgrenci.ogrenciSortedMap();
		sortedMap.forEach((k, v) -> System.out.printf("%s  %s  %s\n", v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
	
	
	
		}

	}
}