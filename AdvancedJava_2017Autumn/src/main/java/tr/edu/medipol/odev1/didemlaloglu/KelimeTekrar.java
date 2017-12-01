package tr.edu.medipol.odev1.didemlaloglu;

import java.util.Scanner;

// 90

// Text dosyasi gonderilmis
// Kod formatsiz
// Tr encoding sorunlari
// Indeksler yazilmamis

public class KelimeTekrar {







   



    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);



    String cumle,harf;



    int harfSayisi = 0;



    



    System.out.println("Bir c�mle giriniz: ");



    cumle = input.nextLine();



    



    System.out.println("Bir harf giriniz: ");



    harf = input.next();



    



    for(int i = 0; i < cumle.length() - 1;i++)



    {    



        if(cumle.substring(i,i+1).equals(harf))



            harfSayisi++;



    }



    System.out.println(harf + " harfi " + harfSayisi + " defa tekrar etmi�tir.");



}



    }
