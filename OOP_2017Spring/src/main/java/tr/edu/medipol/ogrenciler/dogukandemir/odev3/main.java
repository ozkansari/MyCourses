package tr.edu.medipol.ogrenciler.dogukandemir.odev3;
import java.util.Scanner;

import javax.swing.JSpinner.ListEditor;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static List<ogrenci> liste = new ArrayList<>();
	
	public static void main(String[] args) {
		ogrenci ogr = new ogrenci("",0);
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<10; i++){
			System.out.println("Öğrencinin adını ve soyadını girin: ");
			String ad = sc.nextLine();
			sc.nextLine();
			System.out.println("Öğrencinin numarasını girin: ");
			int not = sc.nextInt();
			liste.add(new ogrenci(ad,not));
		}

		for(int j=0;j<liste.size();j++){
			ogrenci o=liste.get(j);
			System.out.println("Ad Soyad: "+o.adSoyad+"  Not: "+o.not);
		}
	}

}
