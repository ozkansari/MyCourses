package tr.edu.medipol.hafta04;
import java.io.*;
import java.util.*;

public class DosyaOkumaYazma2 {

	public static void main(String[] args) throws FileNotFoundException {
		List<OgrenciVeri> ogrenciListesi = dosyaOkumaOrnegi();
		for (OgrenciVeri o : ogrenciListesi) {
			System.out.println(o.ogrenciAdi);
		}
	}

	private static List<OgrenciVeri> dosyaOkumaOrnegi() throws FileNotFoundException {
		List<OgrenciVeri> ogrenciListesi = new ArrayList<>();
		File ogrencilerDosya = new File(".\\config\\Ogrenciler.txt"); // Mac: "./config/Ogrenciler.txt"
		Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);
		while(dosyaOkuyucu.hasNext()) {
			String satir = dosyaOkuyucu.nextLine();
			ogrenciListesi.add(new OgrenciVeri(satir));
			
		}
		dosyaOkuyucu.close();
		
		return ogrenciListesi;
	}
	
	static class OgrenciVeri {
		String ogrenciAdi;
		public OgrenciVeri(String ad) {
			this.ogrenciAdi = ad;
		}
	}
}
