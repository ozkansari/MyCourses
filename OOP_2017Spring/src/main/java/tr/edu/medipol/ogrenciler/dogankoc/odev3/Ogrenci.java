package tr.edu.medipol.ogrenciler.dogankoc.odev3;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Ogrenci {
	private String ogrAdSoyad;
	private int ogrNotlar;

	public Ogrenci(String ogr, int Not) {
		ogrAdSoyad = ogr;
		ogrNotlar = Not;
	}

	public static void main(String[] args) {
		String AdSoyad;
		int Notlar;
		List<Ogrenci> Ogrenciler = new ArrayList<>();
		Scanner scn = new Scanner(System.in);
		Scanner scn1 = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			System.out.println((i + 1) + ".Öğrenci:");
			System.out.println("Ad Soyad: ");
			AdSoyad = scn.nextLine();

			System.out.println("Not: ");
			Notlar = scn.nextInt();
			Ogrenciler.add(new Ogrenci(AdSoyad, Notlar));
		}
		for (int i = 0; i < Ogrenciler.size(); i++) {
			Ogrenci n = Ogrenciler.get(i);
			System.out.println("Ad Soyad: " + n.ogrAdSoyad + " Not:" + n.ogrNotlar);
		}

	}

}
