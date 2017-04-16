package tr.edu.medipol.odev1.firattarhan;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class EkrandaOkuma {
	
	public static void main(String[] args) {
		
		Scanner ekranOkuyucu = new Scanner(System.in);
		System.out.println("Ekrana bir rakam girin: ");
		int kullaniciGirdisi = ekranOkuyucu.nextInt();
		
		System.out.println("Ekrana girdiginiz rakam: " + kullaniciGirdisi);
		
		switch (kullaniciGirdisi) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("Yilin ilk yarisi");
			break;
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
			System.out.println("Yilin ikinci yarisi");
			break;
		default:
			System.out.println("Gecersiz giris");
			break;
		}
		
		ekranOkuyucu.close();
	}
	
	
	 
	public class DosyadanOku {
	 
		// ozkans duzeltme
		/*
	    public static void main(String[] args) throws IOException {
	 
	        File file = new File("Ogrenci.txt");
	        BufferedReader reader = null;
	        reader = new BufferedReader(new FileReader(file));
	        String satir = reader.readLine();
	 
	            while (satir!=null) {
	                System.out.println(satir);
	                satir = reader.readLine();
	            }
	 
	        }*/}
		
}
