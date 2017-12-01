package tr.edu.medipol.odev1.caglaoz;

import java.util.Scanner;

// 75

/*-- Hatali sonuc 1 
Bir cümle giriniz: 
ayse
Bir harf giriniz: 
s
s harfi 2 defa tekrar etmiştir.
index :2

 */

/*
Bir cümle giriniz: 
aeees
Bir harf giriniz: 
e
e harfi 4 defa tekrar etmiştir.
index :1
index :2
index :3

 */


public class TextNo {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String cumle,harf;
        int harfSayisi = 1;
        int sonuc=0;

        System.out.println("Bir cümle giriniz: ");

        cumle = input.nextLine();

        System.out.println("Bir harf giriniz: ");

        harf = input.next();

        for(int i = 0; i < cumle.length() - 1;i++)

        {
            if(cumle.substring(i,i+1).equals(harf))

                harfSayisi++;

        }

        System.out.println(harf + " harfi " + (harfSayisi)+ " defa tekrar etmiştir.");
        do {
            sonuc = cumle.indexOf(harf, sonuc+1);
            if(sonuc>=0)
                System.out.println("index :" + sonuc);
        }
        while (sonuc>=0);
    }



}