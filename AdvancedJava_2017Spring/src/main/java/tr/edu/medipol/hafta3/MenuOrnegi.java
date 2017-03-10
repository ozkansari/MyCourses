package tr.edu.medipol.hafta3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOrnegi {

	private static Scanner ekranOkuyucu = new Scanner(System.in);
	
	private static List<String> ogrenciListesi = new ArrayList<>();
	
	public static void main(String[] args) {
		
		while(true) {
			ekranaMenuyuBas();
			
			System.out.println("Secim yapiniz: ");
			int kullaniciSecimi = Integer.valueOf( ekranOkuyucu.nextLine() );
			
			System.out.println(kullaniciSecimi + " sectiniz.");
			
			switch (kullaniciSecimi) {
			case 1: // (1) Ogrenci Ekle
				ogrenciEklemeIslemi();
				break;
			case 2: // (2) Ogrenci Sil
				ogrenciSilmeIslemi();
				break;
			case 3: // (3) Ogrencileri Listele
				ogrenciListelemeIslemi();
				break;
			case 0: // (0) Cikis
				System.out.println("Program sonlaniyor.");
				ekranOkuyucu.close();
				System.exit(0);
				break;
			default:
				System.out.println("Gecersiz secim");
				break;
			}
		}
		
	}
	
	private static void ogrenciEklemeIslemi() {
		System.out.println("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = ekranOkuyucu.nextLine();
		ogrenciListesi.add(adSoyad);
		System.out.println(adSoyad + " isimli ogrenci eklendi.");
	}

	private static void ogrenciSilmeIslemi() {

		
	}
	
	private static void ogrenciListelemeIslemi() {

		
	}

	private static void ekranaMenuyuBas() {
		System.out.println("************************");
		System.out.println("MENU");
		System.out.println("(1) Ogrenci Ekle");
		System.out.println("(2) Ogrenci Sil");
		System.out.println("(3) Ogrencileri Listele");
		System.out.println("(0) Cikis");
		System.out.println("************************");
	}
	
	
	
	
	
	
	
	
	
	
}
