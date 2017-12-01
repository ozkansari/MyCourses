package tr.edu.medipol.odev2.musasoysal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

// 80

// Havva Gamze Akbas ile cok benzer (-25)
// Tr encoding problemi (-5)
// Menu bonus (+10)

public class RandevuKonsolUyg {

    String randevuAdi;
    String randevuYeri;
    String randevuSaati;
    Date randevuTarihi;

    static Scanner kullaniciGirdisi = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        List<RandevuKonsolUyg> randevuListesi = new ArrayList<RandevuKonsolUyg>();

        int secim = 0;

        while(true){
            menuyuGoruntule();

            System.out.println("Seciminizi giriniz: ");
            secim = kullaniciGirdisi.nextInt();

            switch (secim) {
                case 1:
                    randevuEkle(randevuListesi);
                    break;

                case 2:
                    randevuListele(randevuListesi);
                    break;

                case 3:
                    System.out.println("Program sonlaniyor.");
                    kullaniciGirdisi.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Gecersiz giris.");
                    break;
            }
        }
    }

    public static void menuyuGoruntule() {
        System.out.println("*Menu*");
        System.out.println("1-Randevu Ekleme");
        System.out.println("2-Randevulari Listele");
        System.out.println("3-Cikis");
    }

    public static void randevuEkle(List<RandevuKonsolUyg> sistemRandevuListesi) {
        int randevuSayisi = 0;
        kullaniciGirdisi = new Scanner(System.in);
        System.out.println("Almak istediginiz Randevu Sayisini Giriniz: ");
        randevuSayisi = kullaniciGirdisi.nextInt();
        String randevuYeriFormatsiz;
        if(randevuSayisi > 5) {
            System.out.println("En fazla 5 Adet Randevu girebilirsiniz. Tekrar Deneyin.");
            return;
   }
        
        else {

            for (int i = 0; i < randevuSayisi; i++) {

                RandevuKonsolUyg randevu = new RandevuKonsolUyg();

                kullaniciGirdisi = new Scanner(System.in);
                System.out.println(+i + 1 + ". Randevu ad�n� giriniz: ");
                randevu.randevuAdi = kullaniciGirdisi.nextLine();
                System.out.println(+i + 1 + ". Randevu YYYY-MM-DD �eklinde giriniz: ");
                randevuYeriFormatsiz = kullaniciGirdisi.nextLine();
                SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
                try {
                    randevu.randevuTarihi = ft.parse(randevuYeriFormatsiz);
                } catch (ParseException e) {
                    System.out.println("Randevu tarihi formati uygun degil menuye geri donuyorsunuz");
                    sistemRandevuListesi.clear();
                    return;
                }
                System.out.println(+i + 1 + ". Randevu saatini SS:DD saatini giriniz: ");
                randevu.randevuSaati = kullaniciGirdisi.nextLine();
                System.out.println(+i + 1 + ". Randevu yerini giriniz: ");
                randevu.randevuYeri = kullaniciGirdisi.nextLine();

                sistemRandevuListesi.add(randevu);
            }
        }

        randevuListele(sistemRandevuListesi);

    }

    public static void randevuListele(List<RandevuKonsolUyg> sistemRandevuListesi) {
        int i = 1;
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        for (RandevuKonsolUyg randevu : sistemRandevuListesi) {
            System.out.println( i + ". Randevu: ");
            System.out.println(randevu.randevuAdi + " " + DATE_FORMAT.format(randevu.randevuTarihi) + " " +
                    randevu.randevuSaati + " " + randevu.randevuYeri);
            i++;
        }
    }
}