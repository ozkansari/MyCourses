package tr.edu.medipol.odev1.havvagamzeakbas;

import java.util.Scanner;

// 95

// Tr econding sorunlari (-5)

public class harfBulma {

	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while(true) {
            System.out.println("Bir metin giriniz: ");

            String metin = scn.nextLine();
            System.out.println("Aramak istediginiz harfi girin: ");
            char arananHarf = scn.next().charAt(0);

            boolean harfKontrol = false;

            for (int i = 0 ; i<metin.length() ; i++) {
                if (metin.charAt(i) == arananHarf) {
                    harfKontrol = true;
                    i = i+1;
                    System.out.println("Arad���n�z harf var. Bulundu�u index:" + i);
                    
                }
            }

            if(harfKontrol == true) {
                break;
            }
            else {
                System.out.println("Harf yok");
                break;
            }
        }
	}
}