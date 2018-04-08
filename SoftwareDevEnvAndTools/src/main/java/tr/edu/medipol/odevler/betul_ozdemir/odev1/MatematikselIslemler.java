package tr.edu.medipol.odevler.betul_ozdemir.odev1;
import org.junit.*;

/*-
Odev 1
En az 10 Matematiksel islem icin 10 ayri metod iceren Hesaplama sinifi yazilacak. 
Bu 10 Matematikel islemin her biri icin de 10 ayri JUnit test metodu yazilacak. 
Uygulama Maven projesi seklinde gelistirilecek ve Maven test ve install komutlarin calismasi kontrol edilecek. 
 */

// Tr karakter sorunlari: -10

public class MatematikselIslemler {
	public static void main(String[]args) {
		int sonuc =Toplama(19,25);
		System.out.println(sonuc);
	}
	
	
	public static int KupAlma(int sayi) {
		return sayi*sayi*sayi;
	}
	public static int Bolme(int sayi1,int sayi2) {
		return sayi1/sayi2;
	}
	public static int Toplama(int sayi1,int sayi2) {
		return sayi1+sayi2;
	}
	public static int cikarma(int sayi1,int sayi2) {
		return sayi1-sayi2;

    }
	public static int carpma(int sayi1,int sayi2) {
		return sayi1*sayi2;
}
	public static double KokAlma(double sayi) {
		return Math.sqrt(sayi);
	}
	public static int MutlakDeger(int sayi) {
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