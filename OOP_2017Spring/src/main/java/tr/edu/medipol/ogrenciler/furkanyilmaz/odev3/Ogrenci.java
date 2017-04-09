package tr.edu.medipol.ogrenciler.furkanyilmaz.odev3;

import java.util.Scanner;

public class Ogrenci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner snc = new Scanner(System.in);

		String[] adSoyad = new String[2];
		int[] not = new int[2];

		for (int i = 0; i < adSoyad.length; i++) {

			System.out.println(i + 1 + ".) Ogrencinin Ad� =  ");
			adSoyad[i] = snc.nextLine();

			System.out.println(i + 1 + ".)" + adSoyad[i] + " Not = ");
			not[i] = Integer.valueOf(snc.nextLine());

		}

		System.out.println("---------------------------------------");

		for (int i = 0; i < adSoyad.length; i++) {
			System.out.println(i + 1 + ".)" + adSoyad[i] + " = " + not[i]);
			System.out.println("------------------------");
		}
	}

}
