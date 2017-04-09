package tr.edu.medipol.ogrenciler.ahmetarslan.odev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ahmet {
	public static List<ogrenci> ahmetlist = new ArrayList<>();

	public static void main(String[] ahmet) {
		Scanner sc = new Scanner(System.in);
		ogrenci ogr = new ogrenci("", 0);

		for (int i = 0; i < 2; i++) {
			System.out.println("Kullan�c� ad� ve Soyad�n�z� girin:  ");
			String ad = sc.nextLine();
			System.out.println("L�tfen notunuzu giriniz : ");
			String nott = sc.nextLine();

			int not = Integer.parseInt(nott);

			ahmetlist.add(new ogrenci(ad, not));
		}

		for (int i = 0; i < ahmetlist.size(); i++) {
			ogrenci n = ahmetlist.get(i);
			System.out.println("��rencinin ad� ve Soyad�: " + n.adSoyad + " Numaras�: " + n.not);
		}
	}

}
