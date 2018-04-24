package tr.edu.medipol.odevler.onur_colak.odev1;

/*-
Odev 1
En az 10 Matematiksel islem icin 10 ayri metod iceren Hesaplama sinifi yazilacak. 
Bu 10 Matematikel islemin her biri icin de 10 ayri JUnit test metodu yazilacak. 
Uygulama Maven projesi seklinde gelistirilecek ve Maven test ve install komutlarin calismasi kontrol edilecek. 
 */

// Maven degil: -25
// JUnit yok: -25
// Metodlar Yok: -20
// 7 Mat. islem: -10
// Emre Babuz'la benzer odev: -10

// SONUC: 10

public class MatematikOperatorleri
{

    public static void main(String[] args)
    {



        double sayi4 = Math.floor(32.56);
        String AsagiYuvarla = Double.toString(sayi4);
        System.out.println("Asağı Yuvarla: " + AsagiYuvarla);


        double sayi3 = Math.exp(1);
        String EUstel = Double.toString(sayi3);
        System.out.println("EUstel: " + EUstel);




        int taban = 4;
        int us = 3;
        String Kuvvet = "Kuuveti: " + Double.toString(Math.pow(taban, us));
        System.out.println("Taban: " + taban + " us: " + us + " Sonuc: " + Kuvvet);


        double sayi1 = -56.32;
        String Mutlak = Double.toString(Math.abs(sayi1));
        System.out.println("Mutlak: " + Mutlak);


        int s1 = 66;
        int s2 = 32;
        String max = "Max: " + Integer.toString(Math.max(s1, s2));
        String min = "Min: " + Integer.toString(Math.min(s1, s2));
        System.out.println("max: " +  max);
        System.out.println("min: " + min);




        String Yuvarlama = Double.toString(Math.round(28.88));
        System.out.println("Yuvarlama: " + Yuvarlama);


        double sayi = 64;
        String Karekok = Double.toString(Math.sqrt(sayi));
        System.out.println("Karekok: " + Karekok);

    }
}