package tr.edu.medipol.ogrenciler.anilokumus.odev3;

import java.util.Arrays;
import java.util.Scanner;

public class Odev {

	public static void main(String[] args) {
		
		String[] OAdSoyad=new String[5];
		int[]not=new int[5];
		
		Scanner snc=new Scanner(System.in);
		
		for(int i=0; i<not.length;i++)
		{
			System.out.println(i+1 +".) Ogrenci Adini Giriniz: ");
			OAdSoyad[i]=snc.nextLine();
			
			System.out.println(i+1 +".)Aldigi notu giriniz: ");
			not[i]=Integer.valueOf(snc.nextLine());
			
		}
		for(int i=0; i<not.length;i++)
		{
			System.out.println(i+1 +".)Ogrenci Adi:"+OAdSoyad[i]+" Notu="+not[i]);
		}


	}

}
