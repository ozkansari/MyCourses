package tr.edu.medipol.odevler1ve2.anil_bal.odev2;
import java.io.*;
import java.util.*;

// DERLENMIYOR 
// TAMAMEN HATALI

//EKSIK: List kullanimi ile hafta 5'te yapilan orneği , List seklinde String yerine tanimlayacağiniz OgrenciBilgi sinifi kullanarak yapiniz.
//List icinde OgrenciBilgi kullanilmamis

// SONUC : 20

public class ListeOkuma {
	public static void main(String[] args) throws FileNotFoundException {
		// ozkans HATALI: List<OgrenciBilgi> ogrenciListesi = dosyaOkumaOrnegi();
		/* ozkans DUZELTME */ List<String> ogrenciListesi = dosyaOkumaOrnegi();
		
		// ozkans HATALI: consoleYazdirmaOrnegi(ogrenciBilgi);
		consoleYazdirmaOrnegi(ogrenciListesi);
		
		// ozkans HATALI: ogrenciListesi = kullanicidanGirdiAl(ogrenciBilgi);
		/* ozkans DUZELTME */ogrenciListesi = kullanicidanGirdiAl(ogrenciListesi);
		// ozkans HATALI:consoleYazdirmaOrnegi(ogrenciBilgi);
		/* ozkans DUZELTME */ consoleYazdirmaOrnegi(ogrenciListesi);
		
		// ozkans HATALI: dosyaYazmaOrnegi(ogrenciBilgi);
		/* ozkans DUZELTME */dosyaYazmaOrnegi(ogrenciListesi);
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
				OgrenciBilgi ogrenci = new OgrenciBilgi(kullaniciGirdi)/* ozkans DUZELTME */;/**/
				// ozkans HATALI:ogrenciBilgi.add(kullaniciGirdi); // null ya da bos degilse
				/* ozkans DUZELTME */ ogrenciListesi.add(kullaniciGirdi); // null ya da bos degilse
			}
		} while(true); 
		consoleScanner.close();
		return ogrenciListesi;
	}
	
	private static List<String> dosyaOkumaOrnegi() {
		List<String> ogrenciListesi = new ArrayList<>();
		
		File ogrencilerDosya = new File(".\\config\\Ogrenciler_Program.txt"); // Mac: "./config/Ogrenciler_Program.txt"
		/*
		if (ogrencilerDosya.exists() == false) {
			System.out.println("Dosya mevcut degil");
			return ogrenciBilgi;
		}
		*/
		Scanner dosyaOkuyucu = null;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
			
			// while(dosyaOkuyucu.hasNext()) {
			for(int satirSayisi=1;dosyaOkuyucu.hasNext();satirSayisi++) {
				System.out.println(satirSayisi + " inci satir okunuyor.");
				String satir = dosyaOkuyucu.nextLine();
				// ozkans HATALI: ogrenciBilgi.add(satir);	
				/* ozkans DUZELTME */ ogrenciListesi.add(satir);
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
		// ozkans HATALI:return ogrenciBilgi;
		/* ozkans DUZELTME */ return ogrenciListesi;
	}
	
	private static void dosyaYazmaOrnegi(List<String> ogrenciListesi) throws FileNotFoundException {
		File ciktiDosyasi = new File(".\\config\\Ogrenciler_Program.txt");
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		// ozkans HATALI: for (String o : ogrenciBilgi) {
		/* ozkans DUZELTME */	for (String o : ogrenciListesi) {
			dosyaYazici.println(o);
		}
		dosyaYazici.close();
	}
	
	private static void consoleYazdirmaOrnegi(List<String> ogrenciListesi) {
		// ozkans HATALI: Collections.sort(OgrenciBilgi);
		Collections.sort(ogrenciListesi);
		// for (String o : ogrenciBilgi) {
		// 	System.out.println(o);
		// }
		System.out.println("Mevcut Ogrenciler --------------------");
		// ozkans HATALI:for (int i = 0; i < ogrenciBilgi.size(); i++) {
		// ozkans HATALI:	System.out.println(ogrenciBilgi.get(i));
		/* ozkans DUZELTME */for (int i = 0; i < ogrenciListesi.size(); i++) {
			/* ozkans DUZELTME */	System.out.println(ogrenciListesi.get(i));
		}
		System.out.println("-------------------------------------");
	}
}