package tr.edu.medipol.ogrenciler.yunusemredogan.odev3.eski;

import java.util.*;

public class Odev3 {
	public String ogrenci;
	public int not;
	private static Scanner arama;

	public Odev3(String ogr, int ogrNot) {
		ogrenci = ogr;
		not = ogrNot;
	}

	public static void main(String[] args) {
		String ogrenci;
		int not;

		arama = new Scanner(System.in);
		List<Odev3> SinifListesi = new ArrayList<Odev3>();

		for (int i = 0; i < 3; i++) {
			System.out.println("Ogrenci Adini Giriniz");
			ogrenci = arama.next();

			System.out.println("Ogrenci Notunu Giriniz");
			not = arama.nextInt();

			SinifListesi.add(new Odev3(ogrenci, not));
		}
		for (int i = 0; i < SinifListesi.size(); i++) {
			Odev3 ogr = SinifListesi.get(i);
			System.out.println("Ogrenci adi:" + ogr.ogrenci);
			System.out.println("Ogrenci notu:" + ogr.not);
		}
	}
}
