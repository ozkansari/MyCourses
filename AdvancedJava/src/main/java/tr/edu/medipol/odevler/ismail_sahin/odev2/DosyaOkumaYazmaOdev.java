package tr.edu.medipol.odevler.ismail_sahin.odev2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DosyaOkumaYazmaOdev {
	
	public static void main(String[] args) throws FileNotFoundException {
		List<OgrenciBilgi> ogrenciListesi = new ArrayList<>();
		
		ogrenciListesi = DosyadanOkumaYap();
		ekranaYazdir(ogrenciListesi);
		
		ogrenciListesi = kullanicidanGirdiAl(ogrenciListesi);
		ekranaYazdir(ogrenciListesi);
			
		DosyayaYaz(ogrenciListesi);
	}
	
	private static List<OgrenciBilgi> kullanicidanGirdiAl(List<OgrenciBilgi> ogrenciListesi) {
		String kullaniciGirdi = "";
		Scanner consoleScanner = new Scanner(System.in);
		do {
			System.out.print("Eklenecek ogrenciyi gir: ");
			kullaniciGirdi = consoleScanner.nextLine();
			if (kullaniciGirdi == null || kullaniciGirdi.trim().isEmpty() || kullaniciGirdi.equals("*") ) { 
				break;
			} else {
				ogrenciListesi.add(new OgrenciBilgi(kullaniciGirdi));
			}
		} while(true); 
		consoleScanner.close();
		return ogrenciListesi;
	}
	
	private static void DosyayaYaz(List<OgrenciBilgi> ogrenciListesi){
		File ciktiDosyasi = new File(".\\config\\Ogrenciler_Program.txt");
		PrintWriter dosyaYazici = null;
		try {
			dosyaYazici = new PrintWriter(ciktiDosyasi);
			
			for (OgrenciBilgi ogrenciBilgi : ogrenciListesi) {
				dosyaYazici.println(ogrenciBilgi.getOgrenciAdSoyad());
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (dosyaYazici != null) {
				dosyaYazici.close();
			}
		}
	}
	
	private static List<OgrenciBilgi> DosyadanOkumaYap() {
		List<OgrenciBilgi> ogrenciListesi = new ArrayList<>();
		File ogrencilerDosya = new File(".\\config\\Ogrenciler_Program.txt");
		
		Scanner dosyaOkuyucu = null;
		
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
			while (dosyaOkuyucu.hasNext()) {
				ogrenciListesi.add(new OgrenciBilgi(dosyaOkuyucu.next()));
			}
		} catch (FileNotFoundException | NullPointerException e) {
			System.out.println("Dosya bulunamad� \n" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (dosyaOkuyucu != null) {
				dosyaOkuyucu.close();
			}
		}
		
		return ogrenciListesi;
	}
	
	private static void ekranaYazdir(List<OgrenciBilgi> ogrenciListesi) {
		if(ogrenciListesi.size() == 0) {
			System.out.println("Liste bo�...");
			return;
		}
		System.out.println("----------------------");
		for (OgrenciBilgi ogrenciBilgi : ogrenciListesi) {
			System.out.println(ogrenciBilgi.getOgrenciAdSoyad());
		}
		System.out.println("----------------------");
	}
}
