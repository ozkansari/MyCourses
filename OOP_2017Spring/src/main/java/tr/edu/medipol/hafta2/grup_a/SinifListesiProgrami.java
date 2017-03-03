package tr.edu.medipol.hafta2.grup_a;

import java.math.BigInteger;

public class SinifListesiProgrami {

	private short kucukSayi = 21323;
	private int sayi = 1321312321;
	private long buyukSayi = 3213213213213321355L; 
	private BigInteger cokBuyukSayi = new BigInteger("234324234324324324324324324324324");
	
	private String metin = "Merhaba Dunya \n";
	private char harf = 'b';
	private int harfIndex = 'm' - 'a';
	private double kesikli = 0.5;
	private float kesikli2 = 32432;
	private boolean mantik = !true;
	
	
	public static void main(String[] args) {

		// ARRAY TANIMLAMA 1
		String [ ] ogrenciIsimleri;
		ogrenciIsimleri = new String [2];
		ogrenciIsimleri[0] = "Talha Karakaya";
		ogrenciIsimleri[1] = "Beyzanur Yilmaz";
		
		// ARRAY TANIMLAMA 2 - KISA YONTEM
		String [] ogrenciIsimleri2  = 
			{ 
				"Talha Karakaya", // ogrenciIsimleri2[0]
				"Beyzanur Yilmaz", // ogrenciIsimleri2[1]
				"Sedef Yaman", // ogrenciIsimleri2[2]
				"Caner Ucar", // ogrenciIsimleri2[3]
				"Emel Yaziiiici" // ogrenciIsimleri2[4]
			};
		
		System.out.print(ogrenciIsimleri2.length);
		
		// System.out.println(ogrenciIsimleri2[2]);
		ogrenciIsimleri2[4] = "Emel Yazici";
		// ogrenciIsimleri2[5] = ""; // HATA VERIR
		
		ogrenciYazdir1(ogrenciIsimleri2);
		
		ogrenciYazdir2(ogrenciIsimleri2);
		
		ogrenciYazdir3(ogrenciIsimleri2);
		
		// WHILE LOOP 1 -------------------------------------
		ogrenciyazdir4(ogrenciIsimleri2);
		
		// WHILE LOOP 2 -------------------------------------
		ogrenciYazdir5(ogrenciIsimleri2);
		
		// DO-WHILE LOOP 1 -------------------------------------
		ogrenciYazdir6(ogrenciIsimleri2);

	}

	/**
	 * @param ogrenciIsimleri2
	 */
	private static void ogrenciYazdir6(String[] ogrenciIsimleri2) {
		int index = 0;
		do {
			System.out.println( ogrenciIsimleri2[index]);
			index++; // index = index + 1;
		} while (index<ogrenciIsimleri2.length); // Kosulu saglamazsa donguden cik
	}

	/**
	 * @param ogrenciIsimleri2
	 */
	private static void ogrenciYazdir5(String[] ogrenciIsimleri2) {
		int index = 0;
		while (true) {
			System.out.println( ogrenciIsimleri2[index]);
			index++; // index = index + 1;
			if (index==ogrenciIsimleri2.length-1) {
				break;
			}
		}
	}

	/**
	 * @param ogrenciIsimleri2
	 */
	private static void ogrenciyazdir4(String[] ogrenciIsimleri2) {
		int index = 0;
		while (index<ogrenciIsimleri2.length) {
			System.out.println( ogrenciIsimleri2[index]);
			index++; // index = index + 1;
		}
	}

	/**
	 * @param ogrenciIsimleri2
	 */
	private static void ogrenciYazdir3(String[] ogrenciIsimleri2) {
		// FOR LOOP 3 -------------------------------------
		for (int i = 0; ; i++) {
			System.out.println( ogrenciIsimleri2[i]);
			if (i==ogrenciIsimleri2.length-1) {
				break;
			}
		}
	}

	/**
	 * @param ogrenciIsimleri2
	 */
	private static void ogrenciYazdir2(String[] ogrenciIsimleri2) {
		// FOR LOOP 2 -------------------------------------
		for (int i = ogrenciIsimleri2.length-1; i>0; i--) {
			System.out.println( ogrenciIsimleri2[i]);
		}
	}

	/**
	 * @param ogrenciIsimleri2
	 */
	private static void ogrenciYazdir1(String[] ogrenciIsimleri2) {
		for(int i=0; // donguye girerken bir kere cagrilir
			i<ogrenciIsimleri2.length; // false ise donguden cikar
			i++ // her defada cagrilir, ilerlemeyi takip icin
		) {
			String ogrenci =  ogrenciIsimleri2[i];
			
			if (ogrenci.equals("Sedef Yaman")) {
				continue; // kalan kismi isletme bir sonraki donguye gec
			}
			
			System.out.println( ogrenciIsimleri2[i]);
			
			if (ogrenci.equals("Caner Ucar")) {
				break; // donguyu kes
			}
		}
	}
	
	

}
