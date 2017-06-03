package tr.edu.medipol.ogrenciler.canerucar.odev5;

import java.util.Map;
import java.util.SortedMap;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/*
 10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[ ] - boolean ogrenciSil(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 0/5
[ ] - List<Ogrenci> ogrenciSiraliList() -> kod= 2/5 , test: 0/5
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 3/5 , test: 0/5
[ ] - Set<Ogrenci> ogrenciSet() -> kod= 0/5 , test: 0/5
[ ] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 0/5 , test: 0/5
[ ] - Map<String, Ogrenci> ogrenciMap() -> kod= 3/5 , test: 0/5
[ ] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 2/5 , test: 0/5

Yorum:
- Gec gonderim: -25 puan
- Derlenmeyen Kod: -10 puan
- Emek: +25 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5
- Test kod mantigi: 0/5

SONUC: 35/115
 */
public class Odev5Test 
{

	public static void main(String[] args) 
	{
		
		IslemlerOgrenci islemlerOgrenci = null;
		
		
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
		

		}

	}