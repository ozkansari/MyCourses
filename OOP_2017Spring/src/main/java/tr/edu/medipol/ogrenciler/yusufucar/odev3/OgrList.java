package tr.edu.medipol.ogrenciler.yusufucar.odev3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OgrList {

	public static void main(String[] args) {
		
		List<Ogrenci> ogrenciList = new ArrayList<Ogrenci>();
		
		Scanner al = new Scanner(System.in);
		
		while (true) {
		
			System.out.println("��renci Ad�n� Giriniz :");
			String ad = al.next();
			
			if(!(ad.equals("*"))) {
				
				System.out.println("��renci Soyad�n� Giriniz:");
				String soyAd = al.next();
				
				System.out.println("��renci S�nav Notunu Giriniz: ");
				int sinav = al.nextInt();
				
				ogrenciList.add(new Ogrenci(ad, soyAd, sinav));
			} else {
			
				for (int i = 0; i < ogrenciList.size(); i++) {
					System.out.println(ogrenciList.get(i).ogrenciAdi + " " + ogrenciList.get(i).soyAdi + ": "+ ogrenciList.get(i).sinavNotu);
				    
				}
				
				System.out.println("Biti�.");
				
				break;
				
				
			}
			
		}
			
			
		}

	
	}


