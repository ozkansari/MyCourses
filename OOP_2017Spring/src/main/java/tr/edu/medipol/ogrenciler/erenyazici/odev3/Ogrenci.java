package tr.edu.medipol.ogrenciler.erenyazici.odev3;

import java.util.ArrayList;
import java.util.Scanner;

public class Ogrenci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String adSoyad;
		int not;
		ArrayList<String> isimListe = new ArrayList<String>();
		ArrayList<Integer> notListe = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {

			System.out.println("�sminizi giriniz:");
			Scanner isimOku = new Scanner(System.in);
			adSoyad = isimOku.next();
			System.out.println("Notunuzu giriniz:");
			Scanner notOku = new Scanner(System.in);
			not = notOku.nextInt();

			isimListe.add(adSoyad);
			System.out.println("�sim :" + adSoyad);
			notListe.add(not);
			System.out.println("Not :" + not);
		}

	}

}
