package tr.edu.medipol.odevler.tugce_guneysu.odev1;

/*-
Odev 1
En az 10 Matematiksel iþlem için 10 ayrý metod içeren Hesaplama sýnýfý yazýlacak. 
Bu 10 Matematikel iþlemin her biri için de 10 ayrý JUnit test metodu yazýlacak. 
Uygulama Maven projesi þeklinde geliþtirilecek ve Maven test ve install komutlarýn çalýþmasý kontrol edilecek. 
 */

// Maven degil: -25
// JUnit yok: -25
// Derlenmeyen Kod: -20
// Metodlar Yok: -20

// Betül Guneysu ile ayni: Direkt -25

public class Matematiksel_islemler {
	public static void main(String[] args) {/*ozkans main metodu eklendi*/
		double sayi1 = -124.23;
	    String Mutlak = Double.toString(Math.abs(sayi1));
	    System.out.println("Mutlak: " + Mutlak);
	    
	    double sayi = 99;
	    String Karekok = Double.toString(Math.sqrt(sayi));
	    System.out.println("Karekok: " + Karekok);
	    
	    String Yuvarlama = Double.toString(Math.round(28.88));
	    System.out.println("Yuvarlama: " + Yuvarlama);
	    
	    int taban = 3;
	    int us = 4;
	    String Kuvvet = "Kuuveti: " + Double.toString(Math.pow(taban, us));
	    System.out.println("Taban: " + taban + " us: " + us + " Sonuc: " + Kuvvet);
	    
	    int s1 = 89;
	    int s2 = 88;
	    String Maksimum = "Maksimum: " + Integer.toString(Math.max(s1, s2));
	    String Minimum = "Minimum: " + Integer.toString(Math.min(s1, s2));
	    System.out.println("Maksimum: " +  Maksimum); 
	    System.out.println("Minimum: " + Minimum);
	    
	    double sayi6 = Math.log10(10);
	    String Log10 = Double.toString(sayi6);
	    System.out.println("Log 10: " + Log10);
	    
	    double sayi5 = Math.log(10);
	    String LogE = Double.toString(sayi5);
	    System.out.println("Log E: " + LogE);
	    
	    double sayi4 = Math.floor(28.98);
	    String AsagiYuvarla = Double.toString(sayi4);
	    System.out.println("Asaðý Yuvarla: " + AsagiYuvarla);
	    
	    double sayi3 = Math.exp(1);
	    String EUstel = Double.toString(sayi3);
	    System.out.println("EUstel: " + EUstel);
	    
	    //ozkans hatali: int toplam_sonuc = Hesaplama.topla(22, 22);
	    //ozkans hatali: System.out.println("Toplama Sonucu: " + toplam_sonuc);
	}/*ozkans main metodu eklendi*/
	
}