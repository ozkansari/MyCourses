package tr.edu.medipol.ogrenciler.yunusemredogan.odev3;

import java.util.*;

public class Hafta3 {

	private static Scanner tarama;

	public static class ogrencilerimiz {
		String ogrenci;
		int not;

		public ogrencilerimiz(String ogr, int ogrnot) {
			ogrenci = ogr;
			not = ogrnot;
		}
	}

	public static void main(String[] args) {
		String ogrenci;
		int not;
		tarama = new Scanner(System.in);
		List<ogrencilerimiz> ogrenciListesi = new ArrayList<ogrencilerimiz>();

		System.out.println("Ogrenci sayisini giriniz:");
		int ogrenciSayi = tarama.nextInt();
		tarama.nextLine();
		
		for (int i = 0; i < ogrenciSayi; i++) {
			System.out.println("Ogrenci Adini Giriniz:");
			ogrenci = tarama.nextLine();

			System.out.println("Ogrenci Notunu Giriniz: ");
			not = tarama.nextInt();
			tarama.nextLine();
			ogrenciListesi.add(new ogrencilerimiz(ogrenci, not));
		}
		
		for (ogrencilerimiz o : ogrenciListesi) {
			System.out.println(o.ogrenci);
		}
	}

}
