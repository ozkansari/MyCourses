package tr.edu.medipol.ogrenciler.muhammetaktas.odev6;

import java.util.Map;
import java.util.SortedMap;

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
[ ] - Generic Kullanimi ve Duzgun Test: 3/10

Yorum:
- TODO'lari silsen iyiydi.
- Gec gonderim: -25 puan
- Cihan Gunactiya cok benzer: -25 puan

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 0/5
- Test kod mantigi: 0/5

SONUC: 42/115
 */
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		
		// YAPILACAKLAR - 1 **************************************************
		// IslemlerGeneric sinifini extends eden sinifiniz ile new'leyiniz.
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
		
		
		// YAPILACAKLAR - 2 **************************************************
		// islemlerGeneric sinifinin diger metodlarini da ayni sekilde test edin
		// .......................
		
		Ogrenci kayit2=new OgrenciLisans("2", "Song�l Solmaz");
		boolean eklemeBasarili2=islemlerGeneric.kayitEkle(kayit2);
		
		Ogrenci kayit3=new OgrenciYuksekLisans("3", "�lkay Ocak");
		boolean eklemeBasarili3=islemlerGeneric.kayitEkle(kayit3);
		
		Ogrenci kayit4=new OgrenciLisans("4","Bilgi Sayar");
		boolean eklemeBasarili4=islemlerGeneric.kayitEkle(kayit4);
		
		Ogrenci kayit5=new OgrenciLisans("5","�etin Ceviz");
		boolean eklemeBasarili5=islemlerGeneric.kayitEkle(kayit5);
		
		System.out.println("\n");
		System.out.println("-----Kay�t List-----");
		for (Ogrenci ogr : islemlerGeneric.kayitList()) {
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		
		System.out.println("");
		
		System.out.println("-----Kay�t LinkedList-----");
		for (Ogrenci ogr : islemlerGeneric.kayitLinkedList()) {
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		
		System.out.println("");
		
		System.out.println("-----Kay�t Set-----");
		for (Ogrenci ogr : islemlerGeneric.kayitSet()) {
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		
		System.out.println("");
		
		System.out.println("-----Kay�t SortedSet-----");
		for (Ogrenci ogr : islemlerGeneric.kayitSortedSet()) {
			System.out.println(ogr.getNo()+" "+ogr.getAdSoyad()+" "+ogr.ogrenciTipi());
		}
		
		System.out.println("");
		
		System.out.println("-----Kay�t Map-----");
		Map<String, Ogrenci> map=islemlerGeneric.kayitMap();
		map.forEach((k, v) -> System.out.printf("%s %s %s\n", v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
		
		System.out.println("");
		
		System.out.println("-----Kay�t SortedMap-----");
		SortedMap<String, Ogrenci> sortedMap=islemlerGeneric.kayitSortedMap();
		sortedMap.forEach((k, v) -> System.out.printf("%s  %s  %s\n", v.getNo(),v.getAdSoyad(),v.ogrenciTipi()));
		System.out.println("");
		
	}
}