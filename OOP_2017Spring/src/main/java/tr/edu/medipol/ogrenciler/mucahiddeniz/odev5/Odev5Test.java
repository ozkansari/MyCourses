package tr.edu.medipol.ogrenciler.mucahiddeniz.odev5;

import java.util.List;
import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/**

10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[X] - boolean ogrenciSil(String ogrenciNo) -> kod= 2/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[X] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 2/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[X] - List<Ogrenci> ogrenciList() -> kod= 3/5 , test: 5/5 <<< ozkans: geriye liste donmeli >>>
[X] - List<Ogrenci> ogrenciSiraliList() -> kod= 0/5 , test: 0/5
[X] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 4/5 , test: 5/5 <<< ozkans: geriye linked liste donmeli >>>
[X] - Set<Ogrenci> ogrenciSet() -> kod= 4/5 , test: 5/5 <<< ozkans: geriye set donmeli >>>
[X] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 0/5 , test: 0/5
[X] - Map<String, Ogrenci> ogrenciMap() -> kod= 0/5 , test: 0/5
[X] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 0/5 , test: 0/5

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 0/5
- Ekstra aciklamalar : +5 bonus

SONUC: 60/115

 */
public class Odev5Test {

	public static void main(String[] args) {
		
		IslemlerOgrenci islemlerOgrenci = null;
		islemlerOgrenci = new Odev5Islemler();
		
		System.out.println("========[��RENC� EKLEME]==========");
		Ogrenci ogrenci = new OgrenciYuksekLisans("5858","Ogrenci 1");
		boolean eklemeBasarili = islemlerOgrenci.ogrenciEkle(ogrenci);
		islemlerOgrenci.ogrenciEkle(new OgrenciYuksekLisans("4545","��renci 2"));
		System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
		System.out.println("=======================\n");
		
		System.out.println("========[��RENC� S�LME]==========");
		boolean silmeBasarili = islemlerOgrenci.ogrenciSil("3232");
		System.out.println("silmeBasarili false olmali: " + silmeBasarili);
		System.out.println("=======================\n");
		
		System.out.println("========[��RENC� BULMA]==========");
		islemlerOgrenci.ogrenciBul("45455");
		System.out.println("=======================\n");
	
		System.out.println("========[��RENC� L�STELEME]==========");
		islemlerOgrenci.ogrenciList();
		System.out.println("=======================\n");
		
		System.out.println("========[��RENC� SIRALI L�STELEME]==========");
		islemlerOgrenci.ogrenciList();
		System.out.println("=======================\n");
		
		System.out.println("========[��RENC� L�NKED L�STELEME]==========");
		islemlerOgrenci.ogrenciLinkedList();
		System.out.println("=======================\n");
		
		System.out.println("========[��RENC� SET L�STELEME]==========");
		islemlerOgrenci.ogrenciSet();
		System.out.println("=======================\n");
		
	

	}
}