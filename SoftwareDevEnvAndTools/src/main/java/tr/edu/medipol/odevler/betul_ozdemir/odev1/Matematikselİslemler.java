package tr.edu.medipol.odevler.betul_ozdemir.odev1;
import org.junit.*;

/*-
Odev 1
En az 10 Matematiksel iþlem için 10 ayrý metod içeren Hesaplama sýnýfý yazýlacak. 
Bu 10 Matematikel iþlemin her biri için de 10 ayrý JUnit test metodu yazýlacak. 
Uygulama Maven projesi þeklinde geliþtirilecek ve Maven test ve install komutlarýn çalýþmasý kontrol edilecek. 
 */

public class MatematikselÝslemler {
	public static void main(String[]args) {
		int sonuc =Toplama(19,25);
		System.out.println(sonuc);
	}
	
	
	public static int KüpAlma(int sayi) {
		return sayi*sayi*sayi;
	}
	public static int Bölme(int sayi1,int sayi2) {
		return sayi1/sayi2;
	}
	public static int Toplama(int sayi1,int sayi2) {
		return sayi1+sayi2;
	}
	public static int Çýkarma(int sayi1,int sayi2) {
		return sayi1-sayi2;

    }
	public static int Çarpma(int sayi1,int sayi2) {
		return sayi1*sayi2;
}
	public static double KökAlma(double sayi) {
		return Math.sqrt(sayi);
	}
	public static int MutlakDeðer(int sayi) {
		return Math.abs(sayi);
	}
	public static int MinSayi(int sayi1,int sayi2) {
		return Math.min(sayi1,sayi2);
}
	public static int MaxSayi(int sayi1,int sayi2) {
		return Math.max(sayi1,sayi2);
	}
	public static int ModAlma(int sayi1,int sayi2) {
		return (sayi1%sayi2);
}
}