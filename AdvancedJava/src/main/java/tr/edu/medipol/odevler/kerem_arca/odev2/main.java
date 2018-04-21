package tr.edu.medipol.odevler.kerem_arca.odev2;
import java.io.*;
import java.util.*;

// DOSYA YAZMA Kisminda dosyaYazici.println(o); kullanilmis ama 
// OgrenciBilgi.toString metodu ezilmemis. Bu dosyaya hatali yazilmasina neden olur: -20

// SONUC: 80

public class main {
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
				OgrenciBilgi ogrenci = new OgrenciBilgi(kullaniciGirdi);
				ogrenciListesi.add(ogrenci); // null ya da bos degilse
			}
		} while(true); 
		consoleScanner.close();
		return ogrenciListesi;
	}
	
	private static List<OgrenciBilgi> dosyaOkumaOrnegi() {
		List<OgrenciBilgi> ogrenciListesi = new ArrayList<>();
		
		File ogrencilerDosya = new File(".\\config\\Ogrenciler_Program2.txt"); // Mac: "./config/Ogrenciler_Program.txt"
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
				OgrenciBilgi ogrenci = new OgrenciBilgi(satir);
				ogrenciListesi.add(ogrenci);	
			}
		
		} catch (FileNotFoundException | NullPointerException e) {
			System.out.println("Dosya bulunamad�" + e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("Bilinmeyen bir hata " + e.getMessage());
		} finally {
			if (dosyaOkuyucu != null) {
				dosyaOkuyucu.close();
			}
		}
		return (List<OgrenciBilgi>) ogrenciListesi;
	}
	
	private static void dosyaYazmaOrnegi(List<OgrenciBilgi> ogrenciListesi) throws FileNotFoundException {
		File ciktiDosyasi = new File(".\\config\\Ogrenciler_Program.txt");
		
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);

		for (OgrenciBilgi o : ogrenciListesi) {
			dosyaYazici.println(o);
		}
		dosyaYazici.close();
	}
	
	private static void consoleYazdirmaOrnegi(List<OgrenciBilgi> ogrenciListesi) {
		
		System.out.println("Mevcut Ogrenciler --------------------");
		//Collections.sort(ogrenciListesi);
		 for (OgrenciBilgi o : ogrenciListesi) {
		 	System.out.println(o.getOgrenciAdi());
		 }

//		for (int i = 0; i < ogrenciListesi.size(); i++) {
//			System.out.println(ogrenciListesi.get(i));
//		}
		System.out.println("-------------------------------------");
	}
}
