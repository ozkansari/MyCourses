package tr.edu.medipol.hafta10;

import java.util.Arrays;

public class SiralamaAlgoritmalari {

	private static void diziYazdir(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int sayiDizisi [] = { 12, 93, 6, 27, 0, -42, 567, -2300, -1, 34 };

		SiralamaAlgoritmalari siralama = new SiralamaAlgoritmalari();

		System.out.println("Kabarcik Siralamasi: ");
		System.out.println("------------------------------");
		System.out.println("Sıralamadan onceki durum: ");
		diziYazdir(sayiDizisi);
		int siraliSayiDizisi [] = siralama.kabarcik(sayiDizisi);
		System.out.println("Sıralamadan sonraki durum: ");
		diziYazdir(siraliSayiDizisi);
		System.out.println();
		
		System.out.println("Araya Ekleme Siralamasi: ");
		System.out.println("------------------------------");
		System.out.println("Sıralamadan onceki durum: ");
		diziYazdir(sayiDizisi);
		int [] siraliSayiDizisi2 = siralama.arayaEkleme(sayiDizisi);
		System.out.println("Sıralamadan sonraki durum: ");
		diziYazdir(siraliSayiDizisi2);
		System.out.println();
	}

	public int[] kabarcik(int[] sayiDizisi) {
		
		// Orjinal dizi degismemeli, kopyasini olusturuyoruz
		int[] yeniSayiDizisi = Arrays.copyOf(sayiDizisi, sayiDizisi.length);
		
		boolean siralamaDevamEdiyor = true;

		for (int anaIndis = 1; siralamaDevamEdiyor; anaIndis++) {

			siralamaDevamEdiyor = false;

			for (int altIndis = 0; altIndis < yeniSayiDizisi.length - anaIndis; altIndis++) {

				// onceki eleman sonrakinden buyukse, yer degistir
				if (yeniSayiDizisi[altIndis] > yeniSayiDizisi[altIndis + 1]) {

					// yer degistir
					int yedek = yeniSayiDizisi[altIndis];
					yeniSayiDizisi[altIndis] = yeniSayiDizisi[altIndis + 1];
					yeniSayiDizisi[altIndis + 1] = yedek;

					// yer degistirme olduysa siralama devam ediyor demektir
					siralamaDevamEdiyor = true;
				}
			}
		}
		return yeniSayiDizisi;
	}

	public int[] arayaEkleme(int[] sayiDizisi) {
		
		// Orjinal dizi degismemeli, kopyasini olusturuyoruz
		int[] yeniSayiDizisi = Arrays.copyOf(sayiDizisi, sayiDizisi.length);
		
		int mevcutEleman;
		for (int anaIndis = 1; anaIndis < yeniSayiDizisi.length; anaIndis++) {
			
			mevcutEleman = yeniSayiDizisi[anaIndis];
			
			// Mevcut elemana kadar olanlari sirala
			int altIndis = anaIndis;
			while (true) {
				
				// Onceki eleman mevcut elemandan kucukse zaten mevcut elemana kadar siralidir
				// Sonraki elemana geceriz
				if (altIndis <= 0 || yeniSayiDizisi[altIndis - 1] <= mevcutEleman) {
					yeniSayiDizisi[altIndis] = mevcutEleman;
					break;
				}
				
				// sayiyi kaydir
				yeniSayiDizisi[altIndis] = yeniSayiDizisi[altIndis - 1];
				altIndis--;
			}
			
		}
		return yeniSayiDizisi;
	}

}
