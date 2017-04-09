package tr.edu.medipol.ogrenciler.erdemakturan.odev3;

import java.util.ArrayList;
import java.util.Scanner;

public class OgrenciSinifi {

	public static void main(String[] args) {

		// String [ ] ogrenciIsimleri;
		ArrayList<String> ogrenciIsimleri = new ArrayList<String>();
		// String [] ogrenciIsimleri = new String [10];
		// List<String> ogrenciIsimleri = new ArrayList<String>();

		ArrayList<String> ogrenciNotlari = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {

			Scanner scan = new Scanner(System.in);
			System.out.println("Ogrencinin ismini giriniz : ");
			String isimler = scan.nextLine();

			Scanner scan2 = new Scanner(System.in);
			System.out.println("Notunu giriniz : ");
			String notlar = scan.nextLine();

			ogrenciIsimleri.add(isimler);
			ogrenciNotlari.add(notlar);
		}

		// System.out.println(ogrenciIsimleri + " : " + ogrencinotlar�);

		System.out.println("ogrenci ismi :" + ogrenciIsimleri);
		System.out.println("ogrenci notu :" + ogrenciNotlari);
	}

}
