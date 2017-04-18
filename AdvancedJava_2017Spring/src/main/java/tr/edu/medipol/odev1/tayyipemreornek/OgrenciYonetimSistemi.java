package tr.edu.medipol.odev1.tayyipemreornek;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/** ozkans Degerlendirme

Gecersiz Bugra Emin Burunguz ile ayni

*/

/**
 * Created by teornek on 05/04/2017.
 */
public class OgrenciYonetimSistemi {

    public Scanner okuyucu;
    public PrintWriter yazici;

    public ArrayList<String> ogrenciListesi;
    public String dosyaIsmi = "ogrenciler.txt";


    public OgrenciYonetimSistemi() {
        ogrenciListesi = new ArrayList<String>();
    }

    public void basla() {
        islemleriYukle();
        System.out.println("Ogrenci Yonetim Sistemine Hosgeldiniz..");
        System.out.println("- - - - - - - - - - - - - - - - - - - - -");
        islemler();
    }

    public void islemler() {

        System.out.println("Yapmak Istediginiz İslemi Yaziniz.");
        System.out.println("1 -> Ekle");
        System.out.println("2 -> Sil");
        System.out.println("3 -> Listele");
        System.out.println("4 -> Kaydet Cik");

        okuyucu = new Scanner(System.in);
        String komut = okuyucu.nextLine();

        switch (komut) {

            case "1":
                ogrenciEkle();
                break;

            case "2":
                ogrenciSil();
                break;

            case "3":
                ogrenciListele();
                break;

            case "4":
                islemleriKaydet();
                break;

            default:
                System.out.println("!!! Yanlis Bir Deger Girdiniz !!!");
                islemler();
        }

    }

    public void ogrenciEkle() {

        //System.out.println("! - - Ogrenci Ekleme Alani - - ! \n");

        //System.out.println("Ogrenci Adini Giriniz");
        //String ad = "";
        String ad = okuyucu.nextLine();

        //System.out.println("Ogrenci Numarasini Giriniz");
        String numara = "";
        //String numara = okuyucu.nextLine();

        //System.out.println("Ogrenci Bolumu Giriniz");
        String bolum = "";
        //String bolum = okuyucu.nextLine();

        //System.out.println("Egitim Duzeyini Giriniz");
        String duzey = "";
        //String duzey = okuyucu.nextLine();

        ogrenciListesi.add(ad + " - " + numara + " - " + bolum + " - " + duzey);

        //System.out.println(String.format("%s isimli %s numarali %s bolumunu %s duzeyindeki ogrenci sisteme eklendi..",
          //      ad, numara, bolum, duzey));

        islemler();
    }

    public void ogrenciSil() {

        System.out.println("! - - Ogrenci Silme Alani - - !\n");

        System.out.println("Ogrenci Adini Giriniz");
        String ad = okuyucu.nextLine();

        System.out.println("Ogrenci Numarasini Giriniz");
        String numara = okuyucu.nextLine();

        System.out.println("Ogrenci Bolumu Giriniz");
        String bolum = okuyucu.nextLine();

        System.out.println("Egitim Duzeyini Giriniz");
        String duzey = okuyucu.nextLine();

        ogrenciListesi.remove(ad + " - " + numara + " - " + bolum + " - " + duzey);

        System.out.println(String.format("%s isimli %s numarali %s bolumunu %s duzeyindeki ogrenci sistemden silindi..",
                ad, numara, bolum, duzey));

        islemler();
    }

    public void ogrenciListele() {
        if (ogrenciListesi.size() == 0) {
            System.out.println("Ogrenci Listesi Bos");
        }
        else {
            System.out.println("! - - Ogrenci Listesi Alani - - !\n");
            for (int i = 0; i < ogrenciListesi.size(); i++) {
                System.out.println(String.format("%d - %s", i + 1, ogrenciListesi.get(i)));
            }
        }
        islemler();
    }

    public void islemleriKaydet() {
        try {
            yazici = new PrintWriter(new File(dosyaIsmi));
            for (String ogrenci : ogrenciListesi) {
                yazici.println(ogrenci);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            yazici.close();
        }

        System.out.println("Ogrenci Sistemi Basari Ile Kayıt Edildi..");
        System.out.println("Sistemden Cikiliyor...");
    }

    public void islemleriYukle() {
        try {
            okuyucu = new Scanner(new File(dosyaIsmi));
            while (okuyucu.hasNext()) {
                String ogrenci = okuyucu.nextLine();
                ogrenciListesi.add(ogrenci);
            }
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } finally {
            if (okuyucu != null) {
                okuyucu.close();
            }
        }
    }
}
