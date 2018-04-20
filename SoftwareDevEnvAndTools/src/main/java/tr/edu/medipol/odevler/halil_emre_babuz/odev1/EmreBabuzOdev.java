package tr.edu.medipol.odevler.halil_emre_babuz.odev1;

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

// SONUC: 20

public class EmreBabuzOdev
{

    public static void main(String[] args)
    {

        double sayi1 = -332;
        String Mutlak = Double.toString(Math.abs(sayi1));
        System.out.println("Mutlak: " + Mutlak);

        double sayi6 = Math.log10(10);
        String Log10 = Double.toString(sayi6);
        System.out.println("Log 10: " + Log10);

        double sayi2 = Math.ceil(sayi1);
        String YukariYuvarla  =  Double.toString(sayi2);
        System.out.println("YukariYuvarla: " + YukariYuvarla);

        double sayi3 = Math.exp(1);
        String EUstel = Double.toString(sayi3);
        System.out.println("EUstel: " + EUstel);

        double sayi4 = Math.floor(13);
        String AsagiYuvarla = Double.toString(sayi4);
        System.out.println("Asağı Yuvarla: " + AsagiYuvarla);

        double sayi = 121;
        String Karekok = Double.toString(Math.sqrt(sayi));
        System.out.println("Karekok: " + Karekok);

        double sayi5 = Math.log(10);
        String LogE = Double.toString(sayi5);
        System.out.println("Log E: " + LogE);







}
}