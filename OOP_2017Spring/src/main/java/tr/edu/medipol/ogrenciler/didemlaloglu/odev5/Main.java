package tr.edu.medipol.ogrenciler.didemlaloglu.odev5;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev5.*;

/* OZKANS DEGERLENDIRME

10 operasyon var, 10 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean ogrenciEkle(Ogrenci ogrenci) -> kod= 5/5 , test: 5/5
[X] - boolean ogrenciSil(String ogrenciNo) -> kod= 1/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[X] - Ogrenci ogrenciBul(String ogrenciNo) -> kod= 1/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[ ] - List<Ogrenci> ogrenciList() -> kod= 5/5 , test: 0/5
[X] - List<Ogrenci> ogrenciSiraliList() -> kod= 4/5 , test: 0/5
[ ] - LinkedList<Ogrenci> ogrenciLinkedList() -> kod= 5/5 , test: 0/5
[X] - Set<Ogrenci> ogrenciSet() -> kod= 4/5 , test: 0/5 <<< ozkans: hashset olsa daha iyi >>>
[ ] - SortedSet<Ogrenci> ogrenciSortedSet() -> kod= 5/5 , test: 0/5
[X] - Map<String, Ogrenci> ogrenciMap() -> kod= 4/5 , test: 0/5 <<< ozkans: bir ogrenciye ait bir mapping olsa daha iyi >>> 
[ ] - SortedMap<String, Ogrenci> ogrenciSortedMap() -> kod= 4/5 , test: 0/5 <<< ozkans: bir ogrenciye ait bir mapping olsa daha iyi >>> 

Testte generic sinif kullanilsa daha iyi -2 puan

Bonus:
- Exception kontrolu: 5/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 0/5
- displayOgrenci metodu: +5
- ilk gonerim: +10 puan

SONUC: 75/115

 */
public class Main {
	public static void main(String[] args){
	    // ozkans generic sinif kullanilsa daha iyi -2 puan
		IslemlerOgrenciExtends ioe = new IslemlerOgrenciExtends();
		OgrenciLisans ogr = new OgrenciLisans("392", "Didem LALO�LU");
		ioe.ogrenciEkle(ogr);
		ioe.ogrenciSil("395");
		ioe.ogrenciBul("398");
		ioe.displayOgrenci(ioe.ogrenciler);
	}
}
