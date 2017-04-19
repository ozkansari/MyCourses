package tr.edu.medipol.ogrenciler.omerfaruksonmez.odev3;
import java.util.Scanner;
import java.util.*;

public class Ogrenci {

	static List<String> isimler = new ArrayList<String>();
	static List<String> notlar = new ArrayList<String>();
	private static Scanner adi;
	private static Scanner notu;
	private static Scanner sayi;
	
	public static void setOgrenci(String adi){
		isimler.add(adi);
	}
	
	public static void setNotu(String notu){
		notlar.add(notu);
	}
	
	
	
	public static void main(String []args)
    {
		adi = new Scanner(System.in);
		notu = new Scanner(System.in);
		sayi = new Scanner(System.in);
		
		System.out.println("Kaç öğrenci girmek istiyorsunuz ?");
		int sayisi = sayi.nextInt();
		int sonsayi = 0;
		
		while(sonsayi < sayisi){
			
			sonsayi++;
			
		    
		    
		}
		
	    
		
	    for(int i=0 ; i < isimler.size(); i++){
	    	
	    	System.out.println("----------Öğrenci Listesi----------");
	    	System.out.println("Adı: " + isimler.get(i) + " ----- Notu: " + notlar.get(i));
	    	
	    }		
		
	    
    }
	
}
