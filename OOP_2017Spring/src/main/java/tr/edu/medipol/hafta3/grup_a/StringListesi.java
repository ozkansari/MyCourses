package tr.edu.medipol.hafta3.grup_a;

import java.util.ArrayList;
import java.util.List;

public class StringListesi {

	public static void main(String[] args) {
		
		String [ ] ogrenciIsimleri;
		ogrenciIsimleri = new String [2];
		ogrenciIsimleri[0] = "Talha Karakaya";
		ogrenciIsimleri[1] = "Beyzanur Yilmaz";
		ogrenciIsimleri[0] = "";
		for (String ogrenci : ogrenciIsimleri) {
			System.out.println(ogrenci);
		}		
		
		
		
		/*
		for (int i = 0; i < ogrenciIsimleri.length; i++) {
			System.out.println(ogrenciIsimleri[i]);
		}
		*/
		
		List<String> ogrenciListesi = new ArrayList<String>();
		ogrenciListesi.add("Mehmet Goksu");
		ogrenciListesi.add("Erdem Akturan");
		ogrenciListesi.add("Caner Ucar");
		ogrenciListesi.add("Berkay Dusmez");
		ogrenciListesi.add(3,"Eren Yazici");
		ogrenciListesi.add("Aynali Tahir");
		ogrenciListesi.remove(2);
		
		
		for (int i = 0; i < ogrenciListesi.size(); i++) {
			System.out.println(ogrenciListesi.get(i));
		}
		
		for (String ogrenci : ogrenciListesi) {
			System.out.println(ogrenci);
		}
		
		if (ogrenciListesi.contains("Caner Ucar")) {
			System.out.println("Caner sinifta");
		}
		
		List<String> ilkUcKisi = ogrenciListesi.subList(0, 3);

		ogrenciListesi.set(2, "Yeni Eleman");
		ogrenciListesi.clear(); // listeyi temizler, bosaltir
	}

}
