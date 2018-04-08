package tr.edu.medipol.odevler.ali_yumac.odev1;

import java.util.Scanner;

/*-
Odev 1
En az 10 Matematiksel islem icin 10 ayri metod iceren Hesaplama sinifi yazilacak. 
Bu 10 Matematikel islemin her biri icin de 10 ayri JUnit test metodu yazilacak. 
Uygulama Maven projesi seklinde gelistirilecek ve Maven test ve install komutlarin calismasi kontrol edilecek. 
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
		
		System.out.println("Çıkarma sonucu: "+cikarma_sonuc);
		
		System.out.println("Çarpma sonucu: "+carpma_sonuc);
		
		System.out.println("Bölme sonucu: "+bolme_sonuc);
		
		System.out.println("Alan sonucu: "+alan_sonuc);
		
		System.out.println("Kare Prizma Alan sonucu: "+kare_prizma_alani_sonuc);
		
		System.out.println("Çevre sonucu: "+cevre_sonuc);
		
		System.out.println("Kalan sonucu: "+kalan_sonuc);
		
		System.out.println("Küçük Sayı sonucu: "+kucukDeger_sonuc);
		
		// ozkans hatali: System.out.println("Büyük Sayı sonucu: "+buyukDeger_sonuc);
		
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
