package tr.edu.medipol.odevler.asim_emre_tutkun.odev1;

// TR karakter - encoding sorunlari: -10
// Derlenmeyen kod: -40
// Hatali bir adet test: -5

public class hesaplama {
	public static int kareAlma(int sayi) {
		return sayi*sayi;
		
	}
	public static int toplama(int sayi,int sayi2) {
		return sayi+sayi2;
		
	}
	public static int carpma(int sayi,int sayi2) {
		return sayi*sayi2;
		
	}
	public static int cikarma(int sayi,int sayi2) {
		return sayi-sayi2;
		
	}
	public static int ortalama(int sayi,int sayi2) {
		return (sayi+sayi2)/2;
		
	}
	public static int bolme(int sayi,int sayi2) {
		return sayi/sayi2;
		
	} 	
	// duzeltme: public static int ussuAlma(double sayi,double sayi2) {
	public static double ussuAlma(double sayi,double sayi2) {
		return Math.pow(sayi,sayi2);
		
	}
	// duzeltme: public static int kareKok(double sayi) {
	public static double kareKok(double sayi) {
		return Math.sqrt(sayi);
		
	}
	public static int kareAlan(int sayi) {
		return (sayi*sayi)/2;
		
	}
	public static int kareCevre(int sayi) {
		return sayi*4;
		
	}	
	

}
