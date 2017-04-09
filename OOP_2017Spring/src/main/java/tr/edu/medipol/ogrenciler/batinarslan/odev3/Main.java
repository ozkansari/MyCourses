package tr.edu.medipol.ogrenciler.batinarslan.odev3;

import java.util.Scanner;

public class Main {

	private static Scanner snc;

	public static void main(String[] args) {
		
		
		snc = new Scanner(System.in);
		
		Ogrenci a=new Ogrenci();
		
		for (int i = 0; i < 5; i++) {

			System.out.println(i + 1 + ".)��rencinin Ad� =  ");
			a.ogrenciAdiSoyadi=snc.nextLine();

			System.out.println(i + 1 + ".)" +a.ogrenciAdiSoyadi + " Not = ");
			a.not = snc.nextLine();

			a.ogrenciler.add(a.ogrenciAdiSoyadi);
			a.ogrenciler.add(a.not);
		}
		

		for (int i = 0; i <a.ogrenciler.size(); i++) {
			
			
			System.out.println(i + 1 + ".)" + a.ogrenciler);
		
		}

	}

}
