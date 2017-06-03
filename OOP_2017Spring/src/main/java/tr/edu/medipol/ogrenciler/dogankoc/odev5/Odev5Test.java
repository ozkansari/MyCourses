package tr.edu.medipol.ogrenciler.dogankoc.odev5;

import java.util.*;
import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/* OZKANS DEGERLENDIRME
 
10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[X] - boolean ogrenciSil(String ogrenciNo) -> kod= 1/5 , test: 5/5 <<< ozkans: else break hatali sonuc verdirir >>>
[ ] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 5/5 , test: 5/5
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 5/5
[X] - List<Ogrenci> ogrenciSiraliList() -> kod= 4/5 , test: 5/5 <<< ozkans: kendin siralamissin guzel ama biraz karisik >>>
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 5/5 , test: 5/5
[ ] - Set<Ogrenci> ogrenciSet() -> kod= 5/5 , test: 5/5
[ ] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 5/5 , test: 5/5
[ ] - Map<String, Ogrenci> ogrenciMap() -> kod= 5/5 , test: 5/5
[ ] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 5/5 , test: 5/5

Bonus:
- Exception kontrolu: 5/5
- Clean/Kod Duzenli Kod: 1/5
- Test kod mantigi: 0/5

SONUC: 100/115
 */
public class Odev5Test{

	@SuppressWarnings("null")
	public static void main(String[] args)  {
		
		IslemlerOgrenci islemlerOgrenci = null ;

		islemlerOgrenci = new Odev5Islemler();
		
		Ogrenci ogrenci = new OgrenciYuksekLisans("1","Ogrenci 1");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		
		Ogrenci bulunanOgrenci = islemlerOgrenci.ogrenciBul("1");
		System.out.println("Karsilastirma true olmali: " + ogrenci.getNo().equals(bulunanOgrenci.getNo()));
		
		Ogrenci bulunanOgrenci2 = islemlerOgrenci.ogrenciBul("2");
		System.out.println("bulunanOgrenci2 null olmali: " + bulunanOgrenci2);
		
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("11111");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);

		Ogrenci ogrenci5 = new OgrenciLisans("521","Ogrenci 5");
		eklemeBasarili= islemlerOgrenci.ogrenciEkle(ogrenci5);
		Ogrenci ogrenci2 = new OgrenciLisans("243","Ogrenci 2");
		eklemeBasarili= islemlerOgrenci.ogrenciEkle(ogrenci2);
		Ogrenci ogrenci3 = new OgrenciLisans("123","Ogrenci 3");
		eklemeBasarili= islemlerOgrenci.ogrenciEkle(ogrenci3);
		Ogrenci ogrenci4 = new OgrenciYuksekLisans("412","Ogrenci 4");
		eklemeBasarili= islemlerOgrenci.ogrenciEkle(ogrenci4);
		
		System.out.println("Ekleme S�ras�na g�re List<Ogrenci> ...");
		List<Ogrenci> ogrenciler=islemlerOgrenci.ogrenciList();
		ogrenciler.forEach(o->System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n"));
		
		System.out.println("-----No lara g�re K���kten b�y��e S�ral� List<Ogrenci>-----");
		List<Ogrenci> ogrSiraliList=islemlerOgrenci.ogrenciSiraliList();
		for(Ogrenci o: ogrSiraliList){
			System.out.println(o.getNo()+" "+o.getAdSoyad()+" "+o.ogrenciTipi());
		}		
		System.out.println("-----------LinkedList ile -----------");
		LinkedList<Ogrenci> ogr=islemlerOgrenci.ogrenciLinkedList();
		// toString i Ogrenci s�n�f�nda ezdi�im  i�in  bu �ekilde kullanabilirim
		//ogr.forEach(System.out::println);
		//System.out.println(islemlerOgrenci.ogrenciLinkedList());
		ogr.forEach(o->System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n"));
		System.out.println("-----------Set ile(HashSet) -----------");
		Set<Ogrenci> setogr=islemlerOgrenci.ogrenciSet();
		setogr.forEach(o->System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n"));
		
		System.out.println("-----------SortedSet ile -----------");
		SortedSet<Ogrenci> ogrSortedSet=islemlerOgrenci.ogrenciSortedSet();
		for(Ogrenci o: ogrSortedSet)
		System.out.println(o.getNo()+"\n"+o.getAdSoyad()+"\n"+o.ogrenciTipi()+"\n");
		
		System.out.println("-----------Map ile -----------");
		Map<String, Ogrenci> ogrMap=islemlerOgrenci.ogrenciMap();
		ogrMap.forEach((key,value)->System.out.printf("%s\n%s\n%s\n\n",key,value.getAdSoyad(),value.ogrenciTipi()));
		
		System.out.println("-----------SortedMap ile -----------");	
		SortedMap<String,Ogrenci> sortedMapOgr= islemlerOgrenci.ogrenciSortedMap();
		sortedMapOgr.forEach((key,value)->System.out.printf("%s\n%s\n%s\n\n",key,value.getAdSoyad(),value.ogrenciTipi()));
		
	}


}