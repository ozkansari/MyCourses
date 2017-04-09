package tr.edu.medipol.ogrenciler.furkansametkeles.odev3;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
public class odev3 {
	public static void main(String [] args){
		
		ArrayList<String>Isimler= new ArrayList<String>();
		ArrayList<Integer>Notlar= new ArrayList<Integer>();
		
		for (int i = 0 ; i<5; i++)
		{
			Scanner oku = new Scanner(System.in);
			System.out.println("Isimleri giriniz:");
			String isim = oku.nextLine();
			
			Scanner oku2 = new Scanner(System.in);
			System.out.println("Notu Giriniz:");
			int not  = oku2.nextInt();
			
			Isimler.add(isim);
			Notlar.add(not);
		}
		System.out.println("Ogrenci ismi :"+Isimler);
		System.out.println("Ogrenci notu :"+Notlar);
	}

}
