package tr.edu.medipol.odevler.didem_laloglu.odev1;

/*-
Odev 1
En az 10 Matematiksel iþlem için 10 ayrý metod içeren Hesaplama sýnýfý yazýlacak. 
Bu 10 Matematikel iþlemin her biri için de 10 ayrý JUnit test metodu yazýlacak. 
Uygulama Maven projesi þeklinde geliþtirilecek ve Maven test ve install komutlarýn çalýþmasý kontrol edilecek. 
 */

// Maven degil: -25
// JUnit yok: -25
// Metodlar Yok: -20

public class MatematikOperatorler 
{
 
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
         
        //Abs       Sayýnýn mutlak deðerini bulur. 
        double sayi1 = -124.23;
        String Mutlak = Double.toString(Math.abs(sayi1));
        System.out.println("Mutlak: " + Mutlak);
 
        //Ceiling   Sayýyý yukarý doðru yuvarlar. 
        double sayi2 = Math.ceil(sayi1);
        String YukariYuvarla  =  Double.toString(sayi2);
        System.out.println("YukariYuvarla: " + YukariYuvarla);
 
        //Exp       e üst deðerini (üstel) hesaplamak için kullanýlýr. 
        double sayi3 = Math.exp(1);
        String EUstel = Double.toString(sayi3);
        System.out.println("EUstel: " + EUstel);
 
        //Floor     Sayýyý aþaðý doðru yuvarlar. 
        double sayi4 = Math.floor(28.98);
        String AsagiYuvarla = Double.toString(sayi4);
        System.out.println("Asaðý Yuvarla: " + AsagiYuvarla);
 
        //Log       e tabanýndaki logaritmayý hesaplar.
        double sayi5 = Math.log(10);
        String LogE = Double.toString(sayi5);
        System.out.println("Log E: " + LogE);
 
        //Log10     Sayýnýn 10 tabanlý logaritmasýný hesaplar 
        double sayi6 = Math.log10(10);
        String Log10 = Double.toString(sayi6);
        System.out.println("Log 10: " + Log10);
 
         
        //Max       Ýki sayýdan büyük olanýný bulur.
        //Min       Ýki sayýdan küçük olaný bulur.
        int s1 = 99;
        int s2 = 88;
        String Maksimum = "Maksimum: " + Integer.toString(Math.max(s1, s2));
        String Minimum = "Minimum: " + Integer.toString(Math.min(s1, s2));
        System.out.println("Maksimum: " +  Maksimum); 
        System.out.println("Minimum: " + Minimum);
         
        //Pow       Sayý üst alma iþlemini yapmak için kullanýlýr. 
        int taban = 3;
        int us = 4;
        String Kuvvet = "Kuuveti: " + Double.toString(Math.pow(taban, us));
        System.out.println("Taban: " + taban + " us: " + us + " Sonuc: " + Kuvvet);
 
        //Round     Sayýyý en yakýn tamsayýya çevirir, 
        String Yuvarlama = Double.toString(Math.round(28.88));
        System.out.println("Yuvarlama: " + Yuvarlama);
       
       //Sqrt   Karakökönü alýr.
        double sayi = 99;
        String Karekok = Double.toString(Math.sqrt(sayi));
        System.out.println("Karekok: " + Karekok);
         
    }
}