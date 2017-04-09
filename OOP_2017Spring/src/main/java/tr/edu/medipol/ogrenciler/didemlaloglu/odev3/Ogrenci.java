package tr.edu.medipol.ogrenciler.didemlaloglu.odev3;

import java.util.Scanner;

public class Ogrenci {
    public static void main(String[] arguments){
        Scanner input = new Scanner(System.in);

        String adSoyad; 
        int not; 
      
        Scanner ad = new Scanner(System.in);
        System.out.println("ogrenci ismi:" );  
        adSoyad = ad.next(); 
   
        Scanner notu = new Scanner(System.in);
        System.out.println("Not:" );  
        not = notu.nextInt(); 
        
        System.out.println("ogrenci adi:" + adSoyad + " Notu: " + not );
    }
}
