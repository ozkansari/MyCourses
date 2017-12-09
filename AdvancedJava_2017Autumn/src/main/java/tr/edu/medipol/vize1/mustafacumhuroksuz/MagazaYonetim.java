package tr.edu.medipol.vize1.mustafacumhuroksuz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MagazaYonetim {
    private ArrayList<String> calisanListesi;
    private Scanner okuyucu;
    private PrintWriter yazici;
    private String dosyaIsmi = "liste.txt";

    public MagazaYonetim() {
        calisanListesi = new ArrayList<String>();
    }

    public void baslat() {
        varsaCalisanlariYukle();
        System.out.println("Magaza yonetim programina hosgeldiniz");
        komutAl();
    }

    private void komutAl() {
        System.out.println(String.format("Listenizde %d adet calisan var", calisanListesi.size()));
        System.out.println("Yapmak istediginiz komutu giriniz (ekle,sil,listele,sifirla,cikis)");

        okuyucu = new Scanner(System.in);
        String komut = okuyucu.nextLine();

        switch (komut) {
            case "cikis":
                calisanlariKaydet();
                System.out.println("Iyi gunler");
                break;
            case "ekle":
                calisanEkle();
                break;
            case "sil":
                calisanSil();
                break;
            case "listele":
                calisanlariListele();
                break;
            case "sifirla":
                listeyiTemizle();
                break;
            default:
                System.out.println("Lutfen gecerli bir komut giriniz");
                komutAl();
                break;

        }
    }

    private void calisanEkle() {
        System.out.println("Eklemek istediginiz calisanin ismini yaziniz");
        String urun = okuyucu.nextLine();
        calisanListesi.add(urun);
        System.out.println(String.format("%s isimli calisan listeye eklendi", urun));
        komutAl();
    }

    private void calisanSil() {
        System.out.println("Silmek calisanin urunun ismini yaziniz");
        String urun = okuyucu.nextLine();
        calisanListesi.remove(urun);
        System.out.println(String.format("%s isimli calisan listeden silindi", urun));
        komutAl();
    }

    private void calisanlariListele() {
        for (int i = 0; i < calisanListesi.size(); i++) {
            System.out.println(String.format("%d- %s", i + 1, calisanListesi.get(i)));
        }
        komutAl();
    }

    private void calisanlariKaydet() {
        try {
            yazici = new PrintWriter(new File(dosyaIsmi));
            for (String urunIsmi : calisanListesi) {
                yazici.println(urunIsmi);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            yazici.close();
        }

    }

    private void varsaCalisanlariYukle() {
        try {
            okuyucu = new Scanner(new File(dosyaIsmi));
            while (okuyucu.hasNext()) {
                String urunIsmi = okuyucu.nextLine();
                calisanListesi.add(urunIsmi);
            }
        } catch (FileNotFoundException e) {

        } finally {
            if (okuyucu != null) {
                okuyucu.close();
            }
        }
    }

    private void listeyiTemizle() {
        calisanListesi.clear();
        komutAl();
    }
}
