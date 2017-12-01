package tr.edu.medipol.odev1.cihangunacti;

import java.util.Scanner;

// 95

// TR sinif ismi - encoding sorunu
// Kod formatlama sorunlari

// public class �dev1 {
public class Ödev1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int x=0;
		int fromIndex=0;
		Scanner scn=new Scanner(System.in);
		System.out.println("Bir Metin Giriniz:");
		String str=scn.nextLine();
		System.out.println("Aranacak Harfi Giriniz:");
		String ch=scn.next();
		while (x>=0) {
			x=str.indexOf(ch,fromIndex);
			fromIndex=x+1;
			if(x>=0)
			System.out.println(x);
			else if(str.indexOf(ch, fromIndex)<=fromIndex)
			{
				System.out.println("Aranan harf bulunamad�.");
			}
		}
	}

}
