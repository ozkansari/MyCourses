package tr.edu.medipol.ogrenciler.melissatemelli.odev3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Odev {
	public static void main(String[] args) {
		List<Ogrenci> ogr = new ArrayList<>();
		int ogrSay;
		Scanner ekranOku = new Scanner(System.in);
		Scanner ekranOku2 = new Scanner(System.in);
		Scanner ekranOku3 = new Scanner(System.in);
		System.out.println("Ogrenci Sayisini Girin:");
		ogrSay = ekranOku3.nextInt();

		for (int i = 0; i < ogrSay; i++) {
			System.out.println("Ogrencinin Ad ve Soyadini Girin:");
			String ogrenciAdi = ekranOku.nextLine();

			System.out.println("Ogrencinin Notunu Girin:");
			Integer ogrenciNotu = ekranOku2.nextInt();

			ogr.add(new Ogrenci(ogrenciAdi, ogrenciNotu));
		}
		for (int i = 0; i < ogrSay; i++) {
			Ogrenci o = ogr.get(i);
			System.out.println("Ad Soyad: " + o.adSoyad + "   Not: " + o.ogrenciNotu);

		}
	}
}
