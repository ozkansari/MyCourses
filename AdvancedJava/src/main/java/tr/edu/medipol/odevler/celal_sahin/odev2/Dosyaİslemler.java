package tr.edu.medipol.odevler.celal_sahin.odev2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// EKSIK: List kullanımı ile hafta 5'te yapılan örneği , List seklinde String yerine tanımlayacağınız OgrenciBilgi sinifi kullanarak yapınız.
// List icinde OgrenciBilgi kullanilmamis -50

public class Dosyaİslemler {
	
		public static void main(String[] args) throws FileNotFoundException {
			List<String> ogrenciler = dosyaOkumaOrnegi();
			
			
			ogrenciler.add("Ekle");
			String kullaniciGirdi="";
			Scanner scn = new Scanner(System.in);
			do {
				kullaniciGirdi = scn.nextLine();
				if(kullaniciGirdi !=null  || !kullaniciGirdi.trim().isEmpty()) {
					ogrenciler.add(kullaniciGirdi);
				}else {
					break;
				}
				
			}while(true);
			scn.close();
			
			yazdir(ogrenciler);
			dosyaYazma(ogrenciler);
		}
		
		public static List<String> dosyaOkumaOrnegi() throws FileNotFoundException {
			List<String> ogrenciListesi = new ArrayList<>();
			
			File ogrencilerDosya = new File("C:\\Users\\celal\\Desktop\\ogrenciler.txt"); 
			if (ogrencilerDosya.exists() == false) {
				System.out.println("Dosya mevcut degil");
				return ogrenciListesi;
			}
			Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);
			
			for(int satirSayisi=1;dosyaOkuyucu.hasNext();satirSayisi++) {
				String satir = dosyaOkuyucu.nextLine();
				ogrenciListesi.add(satir);	
				System.out.println(satir);
			}
			dosyaOkuyucu.close();
			
			return ogrenciListesi;
		}
		
		public static void dosyaYazma(List<String> ogrenciListesi) throws FileNotFoundException {
			File ciktiDosyasi = new File("C:\\\\Users\\\\celal\\\\Desktop\\\\ogrenciler.txt");
			PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
			for (String o : ogrenciListesi) {
				dosyaYazici.println(o);
			}
			dosyaYazici.close();
		}
		
		public static void yazdir(List<String> ogrenciler) {
			Collections.sort(ogrenciler);
			
			for (int i = 0; i < ogrenciler.size(); i++) {
				System.out.println(ogrenciler.get(i));
			}
		}
	}

