package tr.edu.medipol.hafta6;

import java.io.*;
import java.util.Scanner;

public class DosyaOkumaOrnegi {

	public static void main(String[] args) {
		String mesaj = " \"Dosya okuma ornegi\" ";
		
		Scanner konsolOkuyucu = new Scanner(System.in);
		
		// ADIM 1- DOSYA (File) NESNESI OLUSTUR
		String windowsDosyaYolu = ".\\config\\Ogrenciler.txt";
		String macDosyaYolu = "./config/Ogrenciler.txt";
		String tamYolu = "C:\\Users\\medipol\\git\\MyCourses\\AdvancedJava_2017Spring\\config\\Ogrenciler.txt";
		// ----------------------------------------------------
		File ogrencilerDosya = new File(windowsDosyaYolu);
		// ----------------------------------------------------
		System.out.println("Dosya adi: " + ogrencilerDosya.getName());
		System.out.println("Dosya yolu: " + ogrencilerDosya.getAbsolutePath());
		if (ogrencilerDosya.exists()) {
			System.out.println("Dosya mevcut");
		}
		
		// ADIM 2 - KONSOL OKUYUCU OLUSTUR (Scanner, FileReader, FileInputStream)
		Scanner dosyaOkuyucu = null;
		try {
			dosyaOkuyucu = new Scanner(ogrencilerDosya);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Dosya " + windowsDosyaYolu + "'nda bulunamadi.");
		} catch (Exception e) {
			System.out.println("Bilinmeyen hata.");
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
