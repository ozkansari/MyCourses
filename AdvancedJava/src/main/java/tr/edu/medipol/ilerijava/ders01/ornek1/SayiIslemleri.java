package tr.edu.medipol.ilerijava.ders01.ornek1;

public class SayiIslemleri {
	
	int sayi1;
	
	int sayi2;
	
	static int islemSayisi;
	
	/**
	 *  Constructor
	 */
	SayiIslemleri(final int sayi1, 
			final int sayi2) {
		this.sayi1 = sayi1;
		this.sayi2 = sayi2;
	}
	
	public int topla() {
		// return sayi1 + sayi2;
		return SayiIslemleri
				.topla(sayi1, sayi2);
	}
	
	public static int topla(int s1, int s2) {
		SayiIslemleri.islemSayisi++;
		return s1 + s2;
	}
	
	
}
