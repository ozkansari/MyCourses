package tr.edu.medipol.hafta04;
import java.io.*;
import java.util.*;

public class DosyaOkumaOrnegiSade {

	public static void main(String[] args) throws FileNotFoundException {
		List<String> ogrenciListesi = dosyaOkumaOrnegi();
		Collections.sort(ogrenciListesi);
		for (String o : ogrenciListesi) {
			System.out.println(o);
		}
		
		File ciktiDosyasi = new File(".\\config\\CiktiDosyasi.txt");
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		for (String o : ogrenciListesi) {
			dosyaYazici.println(">> " + o);
		}
		dosyaYazici.close();

	}

	private static List<String> dosyaOkumaOrnegi() throws FileNotFoundException {
		List<String> ogrenciListesi = new ArrayList<>();
		
		File ogrencilerDosya = new File(".\\config\\Ogrenciler.txt"); // Mac: "./config/Ogrenciler.txt"
		Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);
		while(dosyaOkuyucu.hasNext()) {
			String satir = dosyaOkuyucu.nextLine();
			ogrenciListesi.add(satir);
			
		}
		dosyaOkuyucu.close();
		
		return ogrenciListesi;
	}
}
