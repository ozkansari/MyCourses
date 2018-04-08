package tr.edu.medipol.hafta05;
import java.io.*;
import java.util.*;

public class DosyaOkumaYazma3 {
	public static void main(String[] args) throws FileNotFoundException {
		List<String> ogrenciListesi = dosyaOkumaOrnegi();
		consoleYazdirmaOrnegi(ogrenciListesi);
		
		ogrenciListesi = kullanicidanGirdiAl(ogrenciListesi);
		consoleYazdirmaOrnegi(ogrenciListesi);
		
		dosyaYazmaOrnegi(ogrenciListesi);
	}

	private static List<String> kullanicidanGirdiAl(List<String> ogrenciListesi) {
		String kullaniciGirdi = "";
		Scanner consoleScanner = new Scanner(System.in);
		do {
			System.out.print("Eklenecek ogrenciyi gir: ");
			kullaniciGirdi = consoleScanner.nextLine();
			if (kullaniciGirdi == null || kullaniciGirdi.trim().isEmpty() || kullaniciGirdi.equals("*") ) { 
				break;
			} else {
				ogrenciListesi.add(kullaniciGirdi); // null ya da bos degilse
			}
		} while(true); 
		consoleScanner.close();
		return ogrenciListesi;
	}
	
	private static List<String> dosyaOkumaOrnegi() {
		List<String> ogrenciListesi = new ArrayList<>();
		
		File ogrencilerDosya = new File(".\\config\\Ogrenciler_Program22222222.txt"); // Mac: "./config/Ogrenciler_Program.txt"
		/*
		if (ogrencilerDosya.exists() == false) {
			System.out.println("Dosya mevcut degil");
			return ogrenciListesi;
		}
		*/
		Scanner dosyaOkuyucu = null;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
			
			// while(dosyaOkuyucu.hasNext()) {
			for(int satirSayisi=1;dosyaOkuyucu.hasNext();satirSayisi++) {
				System.out.println(satirSayisi + " inci satir okunuyor.");
				String satir = dosyaOkuyucu.nextLine();
				ogrenciListesi.add(satir);	
			}
		
		} catch (FileNotFoundException | NullPointerException e) {
			System.out.println("Dosya bulunamadi" + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Bilinmeyen bir hata " + e.getMessage());
		} finally {
			if (dosyaOkuyucu != null) {
				dosyaOkuyucu.close();
			}
		}
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
		System.out.println("Mevcut Ogrenciler --------------------");
		for (int i = 0; i < ogrenciListesi.size(); i++) {
			System.out.println(ogrenciListesi.get(i));
		}
		System.out.println("-------------------------------------");
	}
}
