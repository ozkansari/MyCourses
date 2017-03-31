package tr.edu.medipol.hafta6.grub_b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DosyaIslemleri {

	public static void main(String[] args) {

		// Scanner konsolOkuyucu = new Scanner(System.in);

		File ogrencilerText = new File(".\\config\\Ogrenciler.txt");
		Scanner dosyaOkuyucu = null;

		try {
			dosyaOkuyucu = new Scanner(ogrencilerText);
		} catch (FileNotFoundException e1) {
			System.out.println("Dosya bulunamadi");
		}

		while(dosyaOkuyucu.hasNextLine()) { // dosya sonuna geldiginde false
			
			String mevcutSatir = dosyaOkuyucu.nextLine();
			System.out.println(mevcutSatir);
		}
		
		dosyaOkuyucu.close();

	}
}
