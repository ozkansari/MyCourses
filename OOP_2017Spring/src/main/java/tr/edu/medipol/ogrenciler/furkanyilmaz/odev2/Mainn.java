package tr.edu.medipol.ogrenciler.furkanyilmaz.odev2;

import java.util.Arrays;
import java.util.Scanner;

public class Mainn {

	public static void main(String[] args) {

		Scanner veriAl = new Scanner(System.in);

		String[] ogrenci = new String[5];
		int[] not = new int[5];
		int[] istatistik = new int[101];

		for (int i = 0; i < ogrenci.length; i++) {

			System.out.println(i + 1 + ".) ��rencinin �smini Giriniz = ");

			ogrenci[i] = veriAl.nextLine();
		}

		System.out.println("---------------------------------------");

		for (int i = 0; i < ogrenci.length; i++) {

			System.out.println(i + 1 + ".)" + ogrenci[i] + " notunu giriniz = ");

			not[i] = veriAl.nextInt();

		}

		System.out.println("---------------------------------------");

		for (int i = 0; i < ogrenci.length; i++) {

			System.out.println(i + 1 + ".) " + ogrenci[i] + " = " + not[i]);

		}



		for (int i = 0; i < not.length; i++) { 
			int sayac=0;
			for (int j = 0; j < not.length; j++) {
				  
				if (not[i]==not[j]) {
					sayac++;
					istatistik[not[i]]=sayac;;
				}
			}
		}
		
		System.out.println("---------------------------------------");
		
		for (int i = 0; i < istatistik.length; i++) {
			 
			if (istatistik[i]> 0) {
				
					System.out.println(i + " Notunu alan " + istatistik[i]+ " Ki�i var.");
			}
			
		
		}
		
	}
}
