package tr.edu.medipol.odev1.mertcanarici;

import java.util.Scanner;

//70

//emine aycicek ve gamze nur keskin ile tamamen ayni (-30 puan)

public class odev1 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen metni giriniz: ");
        String metin = input.nextLine();
        System.out.print("Lütfen aramak istediğiniz harfi giriniz: ");
        String harf = input.nextLine();
        int sonuc=-1;
        do
        {
            sonuc=metin.indexOf(harf,sonuc+1);
            if(sonuc>=0)
                System.out.println("Index : " + sonuc);
        }
        while(sonuc>=0);

    }
}
