package tr.edu.medipol.hafta6;

import java.util.Scanner;

public class SayiArama {
	
	// "sayiDizisi" icinde "arananSayi"yi bulun
	public static int sayiArama(int[] sayiDizisi, int arananSayi) {
		for (int i = 0; i < sayiDizisi.length; i++) {
			if (sayiDizisi[i] == arananSayi) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner konsolOkuyucu = new Scanner(System.in);
		// kullanicidan 10 tane sayi input alin
		// okudugunuz degerleri bir int dizisine koyun
		System.out.println("10 adet sayi giriniz:");
		int[] dizi = new int[10];
		for (int i = 0; i < 10; i++) {
			dizi[i] = konsolOkuyucu.nextInt();
		}
		
		// kullanicidan aranacak sayiyi input alin
		System.out.println("Dizide aramak istediginiz sayiyi giriniz:");
		int aranan = konsolOkuyucu.nextInt();
		
		// mainden sayiArama'yi cagir (int dizisi ve aranan sayi ile)
		int bulunanIndis = sayiArama(dizi, aranan);
		if (bulunanIndis == -1) {
			System.out.println("Sayi bulunamadi");
		} else {
			System.out.println("Sayi bulundu. Indis: " + bulunanIndis);
		}

		int [] dizi2 = {21,1234,234234,343,43,3};
		int bulunanIndis2 = sayiArama(dizi2, aranan);
		
		konsolOkuyucu.close();
	}

}
