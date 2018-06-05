package tr.edu.medipol.odevler1ve2.numan_gungor.odev2;

import java.io.*;
import java.util.*;
import java.util.Scanner;

// DERLENMIYOR
// 30

public class OgrenciBilgi {

	public static void main(String[] args) {

		// OKUMA ISLEMI
		File F = new File("C:\\kitap\\scanner.txt");
		try {

			FileOutputStream yazdir = new FileOutputStream(F);

			Scanner scan = new Scanner(F);
			while (scan.hasNextLine()) {

			}
			String veri = scan.nextLine();
			System.out.println(veri);
		} catch (FileNotFoundException e) {
			System.out.println("dosyaya bağlanirken hata olustu");
		}
	} /* ozkans duzeltme */

	// YAZMA ISLEMI
	// ozkans hatali satir:private  static String OgrenciAdSoyad
	private  static String OgrenciAdSoyad()
	{
		String kullaniciGirdi = "";
		Scanner consoleScanner = new Scanner(System.in);
		do {
			System.out.print("Eklenecek ogrenciyi gir: ");
			kullaniciGirdi = consoleScanner.nextLine();
			if (kullaniciGirdi == null || kullaniciGirdi.trim().isEmpty() || kullaniciGirdi.equals("*")) {
				break;
			} else {
				// ozkans hatali satir: OgrenciAdSoyad.add(kullaniciGirdi);
			}
		} while (true);
		consoleScanner.close();
		return null; /* ozkans duzeltme */
	}

	// ozkans duzeltme }
}
