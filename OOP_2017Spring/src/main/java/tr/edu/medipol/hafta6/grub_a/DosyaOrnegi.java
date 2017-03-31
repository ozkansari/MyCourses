package tr.edu.medipol.hafta6.grub_a;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DosyaOrnegi {

	public static void main(String[] args) {
		
		File ogrencilerDosyasi = new File(".\\config\\Ogrenciler.txt");
		Scanner dosyaOkuyucu = null;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosyasi);
		} catch(FileNotFoundException e) {
			System.out.println("Dosya bulunamadi");
			System.exit(0);
		}
		
		while(dosyaOkuyucu.hasNextLine()) { // dosya sonuna gelince false doner
			
			String mevcutSatir = dosyaOkuyucu.nextLine();
			System.out.println(mevcutSatir);
			
		}
		
	}

}
