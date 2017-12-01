package tr.edu.medipol.odev1.ibrahimkandemir;

import java.util.Scanner;

// 100

public class SchoolWork_2 {
	
	public static void main(String[] args) {
		
		Scanner screenReader = new Scanner(System.in);
		
		System.out.print("Bir metin girin: ");
		String str = screenReader.nextLine();
		
		System.out.print("Aramak istediginiz karakteri girin: ");
		char ch = screenReader.next().charAt(0);
		
		int i = -1, index =0;
		
		str = str.toLowerCase();
		
		
		do {
			i = str.indexOf(ch,index);
			index = i + 1;
			if(i >= 0) {
				System.out.println("Aranan karakter " + index + ". index'de bulundu.");
			}
			else if(i == -1){
				//index -= index;
				System.out.println("Aranan karakter bulunamadi.");
			}
						
		} while (i >= 0);
		

	}

}
