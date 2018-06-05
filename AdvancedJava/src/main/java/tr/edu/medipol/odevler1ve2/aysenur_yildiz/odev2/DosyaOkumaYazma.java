package tr.edu.medipol.odevler1ve2.aysenur_yildiz.odev2;
import java.io.*;
import java.util.*;

// DERLENMIYOR

// 30

public class DosyaOkumaYazma {
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
				// ozkans hatali satir: OgrenciBilgi ogrenci new = OgrenciBilgi(kullaniciGirdi);
				/* ozkans duzeltme */ OgrenciBilgi ogrenci = new OgrenciBilgi(kullaniciGirdi);
				ogrenciListesi.add(ogrenci); 
			}
		} while(true); 
		consoleScanner.close();
		return ogrenciListesi;
	}
	
	private static List<OgrenciBilgi> dosyaOkumaOrnegi() {
		List<OgrenciBilgi> ogrenciListesi = new ArrayList<>();
		
		File ogrencilerDosya = new File(".\\config\\bilgiOgrenc.txt"); 
		if (ogrencilerDosya.exists() == false) {
			System.out.println("Dosya mevcut degil");
			return ogrenciListesi;
		}
		
		Scanner dosyaOkuyucu = null;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
			
		
			for(int satirSayisi=1;dosyaOkuyucu.hasNext();satirSayisi++) {
				System.out.println(satirSayisi + " inci satir okunuyor.");
				OgrenciBilgi satir = OgrenciBilgi.nextLine();
				ogrenciListesi.add(satir);	
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
		return ogrenciListesi;
	}
	
	private static void dosyaYazmaOrnegi(
			/* List<String> */ List<OgrenciBilgi>
			ogrenciListesi) throws FileNotFoundException {
		File ciktiDosyasi = new File(".\\config\\Ogrenciler_Program.txt");
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		for (OgrenciBilgi o : ogrenciListesi) {
			dosyaYazici.println(o);
		}
		dosyaYazici.close();
	}
	
	private static void consoleYazdirmaOrnegi(
			/* List<String> */ List<OgrenciBilgi>
			ogrenciListesi) {
		// Hatali satir: Collections.sort(ogrenciListesi);
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
