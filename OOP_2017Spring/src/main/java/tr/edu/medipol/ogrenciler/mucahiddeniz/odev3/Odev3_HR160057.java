package tr.edu.medipol.ogrenciler.mucahiddeniz.odev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Odev3_HR160057 {

	public static void main(String[] args) {
		final int ogrenciSayisi = 10;
		Scanner sc = new Scanner(System.in);
		Ogrenci ogres = new Ogrenci("", "");
		int i = 0;
		while (i < ogrenciSayisi) {
			try {
				String ad, not;
				System.out.println(i + 1 + ".ogrencinin ad�n� ve soyad�n� girin: ");
				ad = sc.nextLine();
				System.out.println(i + 1 + ".ogrencinin notunu girin: ");
				not = sc.nextLine();
				ogres.cocuklar.add(new Ogrenci(ad, not));
			} catch (Exception e) {
				System.out.println("Pro�ram d�zg�n olarak �al��mad�: " + e);
			}
			i++;
		}
		ogres.ogrenciListele();
	}
}
