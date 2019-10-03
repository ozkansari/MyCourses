package tr.edu.medipol.ilerijava.ders01.ornek1;

public class Ornek1 {

	/**
	 * Parametreden aldigi iki sayiyi toplayan basit bir java programi
	 * 
	 * @param parametreler 0. ve 1. indiste iki adet sayi icerir.
	 */
	public static void main(String [] parametreler ) {
		
		/*--
		SayiIslemleri degisken1 = new SayiIslemleri(5,3);
		int sonuc1A = degisken1.topla();
		System.out.println(sonuc1A); 
		int sonuc1B = SayiIslemleri.topla(20, 21);
		System.out.println(sonuc1B); 
		
		SayiIslemleri degisken2 = new SayiIslemleri(50,6);
		int sonuc2A = degisken2.topla();
		System.out.println(sonuc2A); 
		*/
		
		int sayi1 = Integer.valueOf( parametreler[0] );
		int sayi2 = Integer.valueOf( parametreler[1] );
		
		
		SayiIslemleri degisken3 = new SayiIslemleri(sayi1, sayi2);
		System.out.println( sayi1 + "+" + sayi2 + "=" 
		   + degisken3.topla() );
		System.out.println("Yapilan islem sayisi: " 
		   + SayiIslemleri.islemSayisi);
		
		// System.out.println(parametreler[0] + parametreler[1]);
	}
	
	

}
