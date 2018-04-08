package tr.edu.medipol.odevler.yucel_ozalp.odev2;
import java.io.*;
import java.util.*;

// GEC GODNERIM: -20

// DOSYA YAZMA Kısmında dosyaYazici.println(o); kullanılmış ama OgrenciBilgi.toString metodu ezilmemis. Bu dosyaya hatalı yazılmasına neden olur: -20

// SONUC: 60

public class test2 {

	static class OgrenciVeri {
		String ogrenciAdi;
		private OgrenciVeri(String ad) {
			this.ogrenciAdi = ad;
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		List<OgrenciVeri> ogrenciListesi = dosyaOkumaOrnegi();
		consoleYazdirmaOrnegi(ogrenciListesi);
		
		ogrenciListesi = kullanicidanGirdiAl(ogrenciListesi);
		consoleYazdirmaOrnegi(ogrenciListesi);
		
		dosyaYazmaOrnegi(ogrenciListesi);
	}

	
	private static List<OgrenciVeri> kullanicidanGirdiAl(List<OgrenciVeri> ogrenciListesi) {
		String kullaniciGirdi = "";
		Scanner consoleScanner = new Scanner(System.in);
		do {
			System.out.print("Eklenecek ogrenciyi gir: ");
			kullaniciGirdi = consoleScanner.nextLine();
			if (kullaniciGirdi == null || kullaniciGirdi.trim().isEmpty() || kullaniciGirdi.equals("*") ) { 
				break;
			} else {
				ogrenciListesi.add(new OgrenciVeri(kullaniciGirdi)); 
			}
		} while(true); 
		consoleScanner.close();
		return ogrenciListesi;
	}
	
	
	private static List<OgrenciVeri> dosyaOkumaOrnegi() throws FileNotFoundException {
		List<OgrenciVeri> ogrenciListesi = new ArrayList<>();
		File ogrencilerDosya = new File("d:\\veri2.txt"); 
		Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);
		while(dosyaOkuyucu.hasNext()) {
			String satir = dosyaOkuyucu.nextLine();
			ogrenciListesi.add(new OgrenciVeri(satir));
			
		}
		dosyaOkuyucu.close();
		
		return ogrenciListesi;
	}
	
	
	private static void dosyaYazmaOrnegi(List<OgrenciVeri> ogrenciListesi) throws FileNotFoundException {
		File ciktiDosyasi = new File("c:\\veri2.txt");
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		for (OgrenciVeri o : ogrenciListesi) {
			dosyaYazici.println(o); // toString metodu ezilmemis? Sadece class idsi dosyaya yazilir
		}
		dosyaYazici.close();
	}
	
	

	private static void consoleYazdirmaOrnegi(List<OgrenciVeri> ogrenciListesi) {
		
		System.out.println(" ------------ Mevcut Ogrenciler --------");
		for (OgrenciVeri o : ogrenciListesi) {
			System.out.println(o.ogrenciAdi);
		}
		System.out.println("-------------------------------------");
	}


}
