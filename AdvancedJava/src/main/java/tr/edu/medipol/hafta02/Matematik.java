package tr.edu.medipol.hafta02;

class Matematik {
	private static final int PI = 3;
	private int sonToplam = 0;
	public static void main(String [] arguments) {
		
		int [] sayilar = {1,2,3,6,9,6765,44,32,33}; // 9
		
		int [] sayilar2 = new int[2];
		sayilar2[0] = 5;
		sayilar2[1] = 55;
		
		Matematik m = new Matematik();
		int toplam = m.topla(sayilar);

		System.out.println(toplam);
	}
	protected int topla(int[] sayilar) {
		int toplam = 0;
		for( int i=0;  i<sayilar.length; i++) {
			toplam += sayilar[i];
		}
		/*
		for (int sayi : sayilar) {
			toplam += sayi;
		}
		*/
		sonToplam = toplam;
		return toplam;
	}
}
