package tr.edu.medipol.vize1;

import java.util.Scanner;

public class Soru5 {

	public static void main(String []args ) {
		Scanner konsolOkuyucu;
		konsolOkuyucu = new Scanner(System.in);
		
		System.out.println("Adiniz: ");
		String ad = konsolOkuyucu.next();
		
		System.out.println("Soyadiniz: ");
		String soyad = konsolOkuyucu.next();
		
		System.out.println("Ad ve Soyad: " + ad + " " + soyad);
	}
	

}
