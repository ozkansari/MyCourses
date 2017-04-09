package tr.edu.medipol.ogrenciler.furkanyilmaz.odev3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner snc = new Scanner(System.in);
		String[] adSoyad = new String[/*ogrSayi*/5];
		int[] not = new int[/*ogrSayi*/5];
		

		for (int i = 0; i < adSoyad.length; i++) {
			System.out.println(i + 1 + ".)��rencinin Ad� =  ");
			adSoyad[i] = snc.nextLine();
		}
		
		for (int j = 0; j < not.length; j++) {
			System.out.println(j + 1 + ".)" + adSoyad[j] + " Not = ");	
			not[j] = snc.nextInt();			
		}
		
		for (int i = 0; i < adSoyad.length; i++) {
			System.out.println(adSoyad[i] + " = " + not[i]);
			System.out.println("------------------------");
		}
	}

}
