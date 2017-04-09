package tr.edu.medipol.ogrenciler.cihangunacti.odev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Listele {

	public static class Ogrenci {

		public String adSoyad;
		public int not;

		public Ogrenci(String adSoyad, int not) {
			this.adSoyad = adSoyad;
			this.not = not;
		}

		public String Notlar() {
			return "Ad Soyad:" + adSoyad + "\nNot:" + not;
		}

	}

	public static void main(String[] args) {

		List<Ogrenci> ogr = new ArrayList<Ogrenci>();
		Scanner ekranoku3 = new Scanner(System.in);
		System.out.println("L�tfen ��renci Say�s�n�z Giriniz");
		int ogrenci = ekranoku3.nextInt();

		for (int i = 0; i < ogrenci; i++) {
			Scanner ekranoku = new Scanner(System.in);
			System.out.println("Ad Soyad Giriniz:");
			String adSoyad = ekranoku.nextLine();
			Scanner ekranoku2 = new Scanner(System.in);
			System.out.println("L�tfen Notunuzu Giriniz:");
			int not = ekranoku2.nextInt();
			ogr.add(new Ogrenci(adSoyad, not));

		}

		for (int i = 0; i < ogr.size(); i++) {
			Ogrenci n = ogr.get(i);
			System.out.println("Ad� Soyad�: " + n.adSoyad + " Notu:" + n.not);
		}

	}
}


