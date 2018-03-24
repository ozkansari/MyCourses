package tr.edu.medipol.hafta05;
import java.io.*;
import java.util.*;

public class DosyaOkumaYazma3 {
	public static void main(String[] args) throws FileNotFoundException {
		List<String> ogrenciListesi = dosyaOkumaOrnegi();
		
		// Kullanicidan ogrenci ismi al
		// Scanner ile consoldan deger okuyucağız
		// Listeye ekle
		ogrenciListesi.add("Deneme");
		
		consoleYazdirmaOrnegi(ogrenciListesi);
		dosyaYazmaOrnegi(ogrenciListesi);
	}
	
	private static List<String> dosyaOkumaOrnegi() throws FileNotFoundException {
		List<String> ogrenciListesi = new ArrayList<>();
		
		File ogrencilerDosya = new File(".\\config\\Ogrenciler_Program.txt"); // Mac: "./config/Ogrenciler_Program.txt"
		if (ogrencilerDosya.exists() == false) {
			System.out.println("Dosya mevcut degil");
			return ogrenciListesi;
		}
		Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);
		// while(dosyaOkuyucu.hasNext()) {
		for(int satirSayisi=1;dosyaOkuyucu.hasNext();satirSayisi++) {
			System.out.println(satirSayisi + " inci satir okunuyor.");
			String satir = dosyaOkuyucu.nextLine();
			ogrenciListesi.add(satir);	
		}
		dosyaOkuyucu.close();
		
		return ogrenciListesi;
	}
	
	private static void dosyaYazmaOrnegi(List<String> ogrenciListesi) throws FileNotFoundException {
		File ciktiDosyasi = new File(".\\config\\Ogrenciler_Program.txt");
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		for (String o : ogrenciListesi) {
			dosyaYazici.println(o);
		}
		dosyaYazici.close();
	}
	
	private static void consoleYazdirmaOrnegi(List<String> ogrenciListesi) {
		Collections.sort(ogrenciListesi);
		// for (String o : ogrenciListesi) {
		// 	System.out.println(o);
		// }
		for (int i = 0; i < ogrenciListesi.size(); i++) {
			System.out.println(ogrenciListesi.get(i));
		}
	}
}
