package tr.edu.medipol.hafta5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DosyaOkumaOrnegiSade {

	public static void main(String[] args) throws FileNotFoundException {
		File ogrencilerDosya = new File(".\\config\\Ogrenciler.txt"); // Mac: "./config/Ogrenciler.txt"
		Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);
		
		File ciktiDosyasi = new File(".\\config\\Ogrenciler_cikti.txt"); // Mac: "./config/Ogrenciler_cikti.txt"
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		
		// Dosyaya ek yapmak icin:
		// FileOutputStream fos = new FileOutputStream(ciktiDosyasi);
		// PrintWriter dosyaYazici2 = new PrintWriter(fos, true);
		
		for(int i=0; dosyaOkuyucu.hasNextLine(); i++) {
			String mevcutSatir = dosyaOkuyucu.nextLine();
			System.out.println(mevcutSatir);
			dosyaYazici.println("Satir " + (i+1) + ": " + mevcutSatir);
		}
		
		dosyaYazici.close();
		dosyaOkuyucu.close();
	}

}
