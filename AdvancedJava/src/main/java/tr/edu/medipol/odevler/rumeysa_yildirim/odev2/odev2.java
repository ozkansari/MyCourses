package tr.edu.medipol.odevler.rumeysa_yildirim.odev2;

// ozkans IMPORTLAR EKLENDI
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//DERLENMIYOR, HATALI. DUZELTILDI

// GEC GONDERIM 

// 30

/* public */  class OgrenciBilgi
{
	private String ogrenciAdSoyad;
	
	public void SetAdSoyad(String adSoyad) 
	{
		ogrenciAdSoyad = adSoyad;
	}
	
	public String GetAdSoyad()
	{
		return ogrenciAdSoyad;
	}
}

public class /*O*/odev2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		List<OgrenciBilgi> ogrenciListesi = dosyaOkumaOrnegi();
		consoleYazdirmaOrnegi(ogrenciListesi);
		
		ogrenciListesi = kullanicidanGirdiAl(ogrenciListesi);
		consoleYazdirmaOrnegi(ogrenciListesi);
		
		dosyaYazmaOrnegi(ogrenciListesi);
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
				OgrenciBilgi ogrenci = new OgrenciBilgi();
				ogrenci.SetAdSoyad(kullaniciGirdi);				
				ogrenciListesi.add(ogrenci); // null ya da bos degilse
			}
		} while(true); 
		consoleScanner.close();
		return ogrenciListesi;
	}
	
	private static List<OgrenciBilgi> dosyaOkumaOrnegi() {
		List<OgrenciBilgi> ogrenciListesi = new ArrayList<>();
		
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
				OgrenciBilgi ogrenci = new OgrenciBilgi()/*ek:*/;
				ogrenci.SetAdSoyad(satir);
				ogrenciListesi.add(ogrenci);	
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
	
	private static void dosyaYazmaOrnegi(List<OgrenciBilgi> ogrenciListesi) throws FileNotFoundException {
		File ciktiDosyasi = new File(".\\config\\Ogrenciler_Program.txt");
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		for (OgrenciBilgi o : ogrenciListesi) {
			dosyaYazici.println(o.GetAdSoyad());
		}
		dosyaYazici.close();
	}
	
	private static void consoleYazdirmaOrnegi(List<OgrenciBilgi> ogrenciListesi) {
		// ozkans hatali satir: Collections.sort(ogrenciListesi);
		// for (String o : ogrenciListesi) {
		// 	System.out.println(o);
		// }
		System.out.println("Mevcut Ogrenciler --------------------");
		for (int i = 0; i < ogrenciListesi.size(); i++) {
			System.out.println(ogrenciListesi.get(i).GetAdSoyad());
		}
		System.out.println("-------------------------------------");
	}
}