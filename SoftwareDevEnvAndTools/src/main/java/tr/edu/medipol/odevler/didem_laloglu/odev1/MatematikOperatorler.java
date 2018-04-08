package tr.edu.medipol.odevler.didem_laloglu.odev1;

/*-
Odev 1
En az 10 Matematiksel islem icin 10 ayri metod iceren Hesaplama sinifi yazilacak. 
Bu 10 Matematikel islemin her biri icin de 10 ayri JUnit test metodu yazilacak. 
Uygulama Maven projesi seklinde gelistirilecek ve Maven test ve install komutlarin calismasi kontrol edilecek. 
 */

// Maven degil: -25
// JUnit yok: -25
// Metodlar Yok: -20

public class MatematikOperatorler 
{
 
    public static void main(String[] args) 
    {
        // TODO Auto-generated method stub
         
        //Abs       Sayinin mutlak deðerini bulur. 
        double sayi1 = -124.23;
        String Mutlak = Double.toString(Math.abs(sayi1));
        System.out.println("Mutlak: " + Mutlak);
 
        //Ceiling   Sayiyi yukari doðru yuvarlar. 
        double sayi2 = Math.ceil(sayi1);
        String YukariYuvarla  =  Double.toString(sayi2);
        System.out.println("YukariYuvarla: " + YukariYuvarla);
 
        //Exp       e ust deðerini (ustel) hesaplamak icin kullanilir. 
        double sayi3 = Math.exp(1);
        String EUstel = Double.toString(sayi3);
        System.out.println("EUstel: " + EUstel);
 
        //Floor     Sayiyi asaði doðru yuvarlar. 
        double sayi4 = Math.floor(28.98);
        String AsagiYuvarla = Double.toString(sayi4);
        System.out.println("Asaði Yuvarla: " + AsagiYuvarla);
 
        //Log       e tabanindaki logaritmayi hesaplar.
        double sayi5 = Math.log(10);
        String LogE = Double.toString(sayi5);
        System.out.println("Log E: " + LogE);
 
        //Log10     Sayinin 10 tabanli logaritmasini hesaplar 
        double sayi6 = Math.log10(10);
        String Log10 = Double.toString(sayi6);
        System.out.println("Log 10: " + Log10);
 
         
        //Max       Iki sayidan buyuk olanini bulur.
        //Min       Iki sayidan kucuk olani bulur.
        int s1 = 99;
        int s2 = 88;
        String Maksimum = "Maksimum: " + Integer.toString(Math.max(s1, s2));
        String Minimum = "Minimum: " + Integer.toString(Math.min(s1, s2));
        System.out.println("Maksimum: " +  Maksimum); 
        System.out.println("Minimum: " + Minimum);
         
        //Pow       Sayi ust alma islemini yapmak icin kullanilir. 
        int taban = 3;
        int us = 4;
        String Kuvvet = "Kuuveti: " + Double.toString(Math.pow(taban, us));
        System.out.println("Taban: " + taban + " us: " + us + " Sonuc: " + Kuvvet);
 
        //Round     Sayiyi en yakin tamsayiya cevirir, 
        String Yuvarlama = Double.toString(Math.round(28.88));
        System.out.println("Yuvarlama: " + Yuvarlama);
       
       //Sqrt   Karakokonu alir.
        double sayi = 99;
        String Karekok = Double.toString(Math.sqrt(sayi));
        System.out.println("Karekok: " + Karekok);
         
    }
}