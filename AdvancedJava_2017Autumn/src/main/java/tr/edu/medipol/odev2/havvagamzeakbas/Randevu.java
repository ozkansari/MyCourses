package tr.edu.medipol.odev2.havvagamzeakbas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

//80

// Musa Soysal ile cok benzer (-25)
//Tr encoding problemi (-5)
//Menu bonus (+10)

public class Randevu {

    String randevuAdi;
    String randevuYeri;
    Date randevuTarihi;
    String randevuSaati;

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        List<Randevu> randevuListesi = new ArrayList<Randevu>();


        int secim = 0;

        while(true){
            menuyuGoruntule();

            System.out.println("Seciminizi giriniz");
            secim = scan.nextInt();

            switch (secim) {
                case 1:
                    randevuEkle(randevuListesi);
                    break;

                case 2:
                    randevuListele(randevuListesi);
                    break;

                case 3:
                    System.out.println("Program sonlaniyor.");
                    scan.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Gecersiz islem");
                    break;
            }
        }
    }

    public static void menuyuGoruntule() {
        System.out.println("**");
        System.out.println("*Menu*");
        System.out.println("1-Randevu Ekleme");
        System.out.println("2-Randevu Listele");
        System.out.println("3-Cikis");
    }

    public static void randevuEkle(List<Randevu> sistemRandevuListesi) {
        int randevuSayisi = 0;
        scan = new Scanner(System.in);
        System.out.println("Ka� adet randevu gireceksiniz?");
        randevuSayisi = scan.nextInt();

        String randevuYeriFormatsiz;

        if(randevuSayisi > 5) {
            System.out.println("Randevu sayisi besten fazla, menuye geri donuyor.");
            return;
        }
        else {

            for (int i = 0; i < randevuSayisi; i++) {

                Randevu randevu = new Randevu();

                scan = new Scanner(System.in);

                System.out.println(+i + 1 + ". Randevu ad�n� giriniz: ");
                randevu.randevuAdi = scan.nextLine();

                System.out.println(+i + 1 + ". Randevu YYYY-MM-DD �eklinde giriniz: ");
                randevuYeriFormatsiz = scan.nextLine();
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                try {
                    randevu.randevuTarihi = ft.parse(randevuYeriFormatsiz);
                } catch (ParseException e) {
                    System.out.println("Randevu tarihi formati uygun degil, menuye geri donuyorsunuz");
                    sistemRandevuListesi.clear();
                    return;
                }

                System.out.println(+i + 1 + ". Randevu saatini hh:mm saatini giriniz: ");
                randevu.randevuSaati = scan.nextLine();

                System.out.println(+i + 1 + ". Randevu yerini giriniz: ");
                randevu.randevuYeri = scan.nextLine();

                sistemRandevuListesi.add(randevu);
            }
        }

        randevuListele(sistemRandevuListesi);

    }

    public static void randevuListele(List<Randevu> sistemRandevuListesi) {
        int i = 1;
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        for (Randevu randevu : sistemRandevuListesi) {
            System.out.println( i + ". Randevu: ");
            System.out.println(randevu.randevuAdi + " " + DATE_FORMAT.format(randevu.randevuTarihi) + " " +
                    randevu.randevuSaati + " " + randevu.randevuYeri);
            i++;
        }
    }
}