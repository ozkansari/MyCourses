package tr.edu.medipol.hafta3.grup_b;

import java.util.ArrayList;
import java.util.List;

public class SayiListesiOrnegi {

	public static void main(String[] args) {

		List<Integer> sayiListesi = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			sayiListesi.add(i);
		}
		
		List<Integer> ciftSayilar = new ArrayList<>();
		for(Integer mevcutDeger : sayiListesi) {
			if (mevcutDeger % 2 == 0) {
				ciftSayilar.add(mevcutDeger);
			}
		}
		sayiListesi.removeAll(ciftSayilar);
		
		System.out.println("Listedeki cift sayılar: ");
		for (Integer cift : ciftSayilar) {
			System.out.println(cift);
		}
		
		System.out.println("Listedeki ilk 10 tek sayı: ");
		List<Integer> ilk10eleman = sayiListesi.subList(0, 10);
		for (Integer tek : ilk10eleman) {
			System.out.println(tek);
		}
		
		
		if (ilk10eleman!=null && ilk10eleman.contains(5) ) {
			System.out.println("Listede 5 mevcut");
		}
		sayiListesi.addAll(2, ciftSayilar);
		System.out.println("1'in ilk gectigi yer: " + sayiListesi.indexOf(new Integer(1)));
		System.out.println("1'in son gectigi yer: " + sayiListesi.lastIndexOf(new Integer(1)));

		/*
		for (int i = 0; i < sayiListesi.size(); i++) {
			Integer mevcutDeger = sayiListesi.get(i);
			if (mevcutDeger % 2 == 0) {
				sayiListesi.remove(mevcutDeger);
			}
		}
		*/
		
		for(Integer mevcutDeger : sayiListesi) {
			System.out.println(mevcutDeger);
		}
		
	}

}
