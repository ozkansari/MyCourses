package tr.edu.medipol.odevler.aysenur_yildiz.odev1;

//Metodlar Yok: -20

public class Hesaplama {
	public static void main(String [] args) {
		int sonuc = Toplama(20,10);
		System.out.println(sonuc);
	}
	public static int KareAlma(int sayi) {
		return sayi*sayi;
	}
	public static int Toplama(int sayi1, int sayi2) {
		return sayi1+sayi2;
	}
	public static int Cikarma(int sayi1, int sayi2) {
		return sayi1-sayi2;
	}
	public static int Carpma(int sayi1, int sayi2) {
		return sayi1*sayi2;
	}
	public static int Bolme(int sayi1, int sayi2) {
		return sayi1/sayi2;
	}
	public static int KupAlma(int sayi) {
		return sayi*sayi*sayi;
	}
	public static int MinSayi(int sayi1, int sayi2) {
		return Math.min(sayi1, sayi2);
	}
	public static int MutlakDeger(int sayi) {
		return Math.abs(sayi);
	}
	public static double KokAlma(int sayi) {
		return Math.sqrt(sayi);
	}
	
}