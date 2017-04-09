package tr.edu.medipol.ogrenciler.canerucar.odev3;
import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
public class odev3 {

	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Ogrenci Ad Soyad Giriniz: ");
		String adSoyad = scn.nextLine();
		System.out.println("Ogrenci Notunu Giriniz: ");
		int not = scn.nextInt();
		
		ArrayList list = new ArrayList();
		list.add(adSoyad);
		list.add(not);
		
		System.out.println("Ad Soyad: "+list.get(0));
		System.out.println("Not: "+list.get(1));

	}

}
