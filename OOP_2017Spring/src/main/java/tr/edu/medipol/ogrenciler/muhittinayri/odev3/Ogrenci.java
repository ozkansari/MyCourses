package tr.edu.medipol.ogrenciler.muhittinayri.odev3;

import java.util.Scanner;
import java.util.Arrays;

public class Ogrenci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String[] adSoyad = new String[1];
		int[] not = new int[1];
		for (int i = 0; i < adSoyad.length; i++) {
			System.out.println(i + 1 + ". ��rencinin Ad� Soyad�");
			adSoyad[i] = scn.nextLine();

			for (int j = 0; j < not.length; j++) {
				System.out.println(j + 1 + ". ��rencinin Notu");
				not[j] = scn.nextInt();

			}
		}

		for (int i = 0; i < adSoyad.length; i++) {
			System.out.println(i + 1 + ". ��rencinin Ad� Soyad�:" + adSoyad[i]);
			System.out.println(i + 1 + ". ��rencinin Notu:" + not[i]);
		}
	}
}
