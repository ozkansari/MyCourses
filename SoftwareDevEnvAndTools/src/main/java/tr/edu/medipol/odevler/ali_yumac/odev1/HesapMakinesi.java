package tr.edu.medipol.odevler.ali_yumac.odev1;

import java.util.Scanner;

/*-
Odev 1
En az 10 Matematiksel iþlem için 10 ayrý metod içeren Hesaplama sýnýfý yazýlacak. 
Bu 10 Matematikel iþlemin her biri için de 10 ayrý JUnit test metodu yazýlacak. 
Uygulama Maven projesi þeklinde geliþtirilecek ve Maven test ve install komutlarýn çalýþmasý kontrol edilecek. 
 */

// Maven degil: -25
// JUnit yok: -25
// Dosya ismi hatali, derlenmiyor: -10

// UMUTCAN MERIC ILE AYNI: Direkt -25

public class HesapMakinesi {

	public static void main(String[] args) {
	
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("iki sayi giriniz");
		
		System.out.println("sayi1 :");
		
		int sayi1= scanner.nextInt();
		
		System.out.println("sayi2 : ");
		
		int sayi2= scanner.nextInt();
		
		int toplam_sonuc=toplama(sayi1,sayi2);
		
		int cikarma_sonuc=cikarma(sayi1,sayi2);
		
		int carpma_sonuc=carpma(sayi1,sayi2);
		
		int bolme_sonuc=bolme(sayi1,sayi2);
		
		int alan_sonuc=alan(sayi1,sayi2);
		
		int kare_prizma_alani_sonuc=kare_prizma_alani(sayi1,sayi2);
		
		int cevre_sonuc=cevre(sayi1,sayi2);
		
		int kalan_sonuc=kalan(sayi1,sayi2);
		
		int kucukDeger_sonuc=kucukDeger(sayi1,sayi2);
		
		// ozkans hatali: int buyukDeger_sonuc=buyukDeger000(sayi1,sayi2);
		
		System.out.println("Toplama sonucu: "+toplam_sonuc);
		
		System.out.println("Ã‡Ä±karma sonucu: "+cikarma_sonuc);
		
		System.out.println("Ã‡arpma sonucu: "+carpma_sonuc);
		
		System.out.println("BÃ¶lme sonucu: "+bolme_sonuc);
		
		System.out.println("Alan sonucu: "+alan_sonuc);
		
		System.out.println("Kare Prizma Alan sonucu: "+kare_prizma_alani_sonuc);
		
		System.out.println("Ã‡evre sonucu: "+cevre_sonuc);
		
		System.out.println("Kalan sonucu: "+kalan_sonuc);
		
		System.out.println("KÃ¼Ã§Ã¼k SayÄ± sonucu: "+kucukDeger_sonuc);
		
		// ozkans hatali: System.out.println("BÃ¼yÃ¼k SayÄ± sonucu: "+buyukDeger_sonuc);
		
		scanner.close();
	}
public static int toplama(int sayi1,int sayi2) {

return sayi1+sayi2;
}

public static int cikarma(int sayi1,int sayi2) {

return sayi1-sayi2;
}

public static int carpma(int sayi1,int sayi2) {

return sayi1*sayi2;
}

public static int bolme(int sayi1,int sayi2) {

return sayi1/sayi2;
}

public static int alan(int sayi1,int sayi2) {

return sayi1*sayi2;
}

public static int kare_prizma_alani(int sayi1,int sayi2) {

return (4*sayi1*sayi2)+(sayi1*sayi1);
}

public static int cevre(int sayi1,int sayi2) {

return (sayi1*sayi2)*2;
}

public static int kalan(int sayi1,int sayi2) {

return sayi1%sayi2;
}

public static int kucukDeger(int sayi1,int sayi2) {

return Math.min(sayi1, sayi2);

}

public static int buyukDeger(int sayi1,int sayi2) {

return Math.max(sayi1,sayi2);

}

}
