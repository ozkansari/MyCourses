package tr.edu.medipol.ogrenciler.mucahiddeniz.odev6;

import tr.edu.medipol.odev.*;
import tr.edu.medipol.odev.odev6.*;

/*
9 operasyon var, 9 da test olmali.
Her bir operayon ve test 5 puan.

[ ] - boolean kayitEkle(TYPE kayit) -> kod= 5/5 , test: 5/5
[ ] - boolean kayitSil(KEY kayitNo) -> kod= 4/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[ ] - TYPE kayitBul(KEY kayitNo) -> kod= 4/5 , test: 5/5 <<< ozkans: string karsilastirma equals olmali >>>
[ ] - List<TYPE> kayitList() -> kod= 3/5 , test: 5/5 <<< ozkans: geriye liste donmeli >>>
[ ] - LinkedList<TYPE> kayitLinkedList() -> kod= 4/5 , test: 5/5 <<< ozkans: geriye linked liste donmeli >>>
[ ] - Set<TYPE> kayitSet() -> kod= 4/5 , test: 5/5 <<< ozkans: geriye set donmeli >>>
[ ] - SortedSet<TYPE> kayitSortedSet() -> kod= 4/5 , test: 4/5 <<< ozkans: geriye set donmeli >>>
[ ] - Map<KEY, TYPE> kayitMap() -> kod= 1/5 , test: 0/5
[ ] - SortedMap<KEY, TYPE> kayitSortedMap() -> kod= 1/5 , test: 0/5
[ ] - Generic Kullanimi ve Duzgun Test: 10/10

Yorum:
- Gec gonderim: -25 puan
- Ekstra aciklamalar : +5 bonus

Bonus:
- Exception kontrolu: 0/5
- Clean/Kod Duzenli Kod: 5/5
- Test kod mantigi: 0/5

SONUC: 57/115
*/
public class Odev6Test {

	public static void main(String[] args) {
		
		IslemlerGeneric<Ogrenci, String> islemlerGeneric = null;
		

		 islemlerGeneric = new Odev6Islemler();
		
		    System.out.println("========[��RENC� EKLEME]==========");
			Ogrenci ogrenci = new OgrenciYuksekLisans("5858","Ogrenci 1");
			boolean eklemeBasarili = islemlerGeneric.kayitEkle(ogrenci);
			islemlerGeneric.kayitEkle(new OgrenciYuksekLisans("4545","��renci 2"));
			islemlerGeneric.kayitEkle(new OgrenciYuksekLisans("3434","��renci 3"));

			System.out.println("eklemeBasarili true olmali: " + eklemeBasarili);
			System.out.println("=======================\n");
			
			System.out.println("========[��RENC� S�LME]==========");
			boolean silmeBasarili = islemlerGeneric.kayitSil("4545");
			System.out.println("silmeBasarili false olmali: " + silmeBasarili);
			System.out.println("=======================\n");
			
			System.out.println("========[��RENC� BULMA]==========");
			islemlerGeneric.kayitBul("5858");
			System.out.println("=======================\n");
		
			System.out.println("========[��RENC� L�STELEME]==========");
			islemlerGeneric.kayitList();
			System.out.println("=======================\n");
			
			System.out.println("========[��RENC� LINKED L�STELEME]==========");
			islemlerGeneric.kayitLinkedList();
			System.out.println("=======================\n");
			
			System.out.println("========[��RENC� SET L�STELEME]==========");
			islemlerGeneric.kayitSet();
			System.out.println("=======================\n");
			
			System.out.println("========[��RENC� SORTEDSET L�STELEME]==========");
			//islemlerGeneric.kayitSortedSet();
			System.out.println("=======================\n");
			
		
		
	}
}