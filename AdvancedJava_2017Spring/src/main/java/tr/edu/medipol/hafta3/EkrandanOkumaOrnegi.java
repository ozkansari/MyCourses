package tr.edu.medipol.hafta3;

import java.util.Scanner;

public class EkrandanOkumaOrnegi {

	public static void main(String[] args) {
		
		Scanner ekranOkuyucu = new Scanner(System.in);
		System.out.println("Ekrana bir rakam girin: ");
		int kullaniciGirdisi = ekranOkuyucu.nextInt();
		
		System.out.println("Ekrana girdiginiz rakam: " + kullaniciGirdisi);
		
		switch (kullaniciGirdisi) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("Yilin ilk yarisi");
			break;
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			System.out.println("Yilin ikinci yarisi");
			break;
		default:
			System.out.println("Gecersiz giris");
			break;
		}
		
		ekranOkuyucu.close();
	}
}
