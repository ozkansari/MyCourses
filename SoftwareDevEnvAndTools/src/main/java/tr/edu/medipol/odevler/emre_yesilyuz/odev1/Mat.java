package tr.edu.medipol.odevler.emre_yesilyuz.odev1;

/*-
Odev 1
En az 10 Matematiksel iþlem için 10 ayrý metod içeren Hesaplama sýnýfý yazýlacak. 
Bu 10 Matematikel iþlemin her biri için de 10 ayrý JUnit test metodu yazýlacak. 
Uygulama Maven projesi þeklinde geliþtirilecek ve Maven test ve install komutlarýn çalýþmasý kontrol edilecek. 
 */

// Maven degil: -25
// JUnit yok: -25
// Metodlar Yok: -20

public class Mat
{

    public static void main(String[] args)
    {
        double sayi1 = -135.23;
        String Mutlak = Double.toString(Math.abs(sayi1));
        System.out.println("Mutlak: " + Mutlak);


        double sayi2 = Math.ceil(sayi1);
        String YukariYuvarla  =  Double.toString(sayi2);
        System.out.println("YukariYuvarla: " + YukariYuvarla);


        double sayi3 = Math.exp(5);
        String EUstel = Double.toString(sayi3);
        System.out.println("EUstel: " + EUstel);


        double sayi4 = Math.floor(28.98);
        String AsagiYuvarla = Double.toString(sayi4);
        System.out.println("AsaÄŸÄ± Yuvarla: " + AsagiYuvarla);


        double sayi5 = Math.log(10);
        String LogE = Double.toString(sayi5);
        System.out.println("Log C: " + LogE);


        double sayi6 = Math.log10(20);
        String Log10 = Double.toString(sayi6);
        System.out.println("Log 10: " + Log10);



        int s1 = 59;
        int s2 = 81;
        String Maksimum = "Maksimum: " + Integer.toString(Math.max(s1, s2));
        String Minimum = "Minimum: " + Integer.toString(Math.min(s1, s2));
        System.out.println("Maksimum: " +  Maksimum);
        System.out.println("Minimum: " + Minimum);


        int taban = 5;
        int us =6;
        String Kuvvet = "Kuuveti: " + Double.toString(Math.pow(taban, us));
        System.out.println("Taban: " + taban + " : " + us + " Sonuc: " + Kuvvet);


        String Yuvarlama = Double.toString(Math.round(23.88));
        System.out.println("Yuvarlama: " + Yuvarlama);


        double sayi = 100;
        String Karekok = Double.toString(Math.sqrt(sayi));
        System.out.println("Karekok: " + Karekok);

    }
}

