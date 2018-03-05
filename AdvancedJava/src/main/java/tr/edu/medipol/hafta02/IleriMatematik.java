package tr.edu.medipol.hafta02;

import java.util.Arrays;

public class IleriMatematik extends Matematik {

	public static void main(String [] arguments) {
		int [] sayilar = {1,2,3,6,9,6765,44,32,33};
		
		// polymorphism
		Matematik matematik = new IleriMatematik();
		int toplam = islemYap(sayilar, matematik);
		
		boolean pozitifMi = toplam > 0;
		boolean buyukMu100den = toplam > 100;
		
		boolean sonuc = pozitifMi || buyukMu100den;
		
		if(sonuc) {
			toplam += 5;
		} else {
			toplam-= 5;
		}
		toplam += sonuc ? 5 : -5;
		
	}
	private static int islemYap(int[] sayilar, Matematik matematik) {
		if (matematik instanceof IleriMatematik) {
			IleriMatematik gercekTip = (IleriMatematik) matematik;
			gercekTip.kare(5);
		}
		int toplam = matematik.topla(sayilar);
		return toplam;
	}
	public int kare(int sayi) {
		return sayi * sayi;
	}
	
	@Override
	protected int topla(int[] sayilar) {
		return Arrays.stream(sayilar).sum();
	}
}
