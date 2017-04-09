package tr.edu.medipol.ogrenciler.batinarslan.odev3;

import java.util.Arrays;
import java.util.Scanner;

public class sinif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner snc = new Scanner(System.in);
		String[] ogranciAdSoyad = new String[10];
		int [] OgrenciNot= new int[10];
		
		
		for(int i=0 ; i<ogranciAdSoyad.length; i++) {
			System.out.println(i+1+ ".)��renci Ad� : ");
			ogranciAdSoyad[i]=snc.nextLine();	
		}
		
		for(int j =0;j<OgrenciNot.length;j++) {
			System.out.println(j+1+".)" +ogranciAdSoyad[j] + " S�nav Notu : ");
			OgrenciNot[j]=snc.nextInt();
		}
		
	
		for(int j =0;j<ogranciAdSoyad.length;j++){
			System.out.println(ogranciAdSoyad[j]+" : "+OgrenciNot[j]);
			
		}
	}

}
