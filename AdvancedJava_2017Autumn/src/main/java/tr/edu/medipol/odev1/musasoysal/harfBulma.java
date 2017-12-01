package tr.edu.medipol.odev1.musasoysal;

import java.util.Scanner;

// 75

// Harfin bulundugu tum indeksleri gostermeli (-20)
// tr encoding sorunlari (-5)
// formatlama sorunlari

/* -- Ornek Test
 Bir c�mle giriniz: 
aeeeese
C�mlede aramak istediginiz harfi girin(B�y�k K���k Harf Fark Eder): 
e
Arad���n�z harf var. Bulundu�u index:2

 */
public class harfBulma {

public static void main(String[] args) {
		
        Scanner kullaniciGirdisi = new Scanner(System.in);
        
        System.out.println("Bir c�mle giriniz: ");
        String cumle = kullaniciGirdisi.nextLine();
        System.out.println("C�mlede aramak istediginiz harfi girin(B�y�k K���k Harf Fark Eder): ");
        char harf = kullaniciGirdisi.next().charAt(0);
        int sonuc = 0;
        for (int i = 0 ; i<cumle.length() ; i++) {
            if (cumle.charAt(i) == harf) {
            	sonuc = 1;
                i =i+1;
                System.out.println("Arad���n�z harf var. Bulundu�u index:" + i);
                break;
            }

            
            }
        if(sonuc == 0){
        	System.out.println("Arad���n�z harf hi�bir index de yoktur");

        }
       
        }
}



