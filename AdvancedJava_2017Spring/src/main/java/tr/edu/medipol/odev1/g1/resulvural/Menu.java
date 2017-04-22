package tr.edu.medipol.odev1.g1.resulvural;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** ozkans Degerlendirme
Muzaffer Anlas, Ahmet Selçuk Ozdemir, Bayram Ozkan Mutlu, Sefa Okuyucu ile cok benzer.
Arkadaslari kodu resulun yazdigini ifade etti. 

Ogrencileri ekrana basarken dosyadan okuyor ama eklerken listeye ekliyor.
Dosyaya cikarken yaziyor.

Menu: 5/5
Ogrenci Islemleri: 15/15
Polimorphism: 15/15
Dosyadan Okuma: 10/25 (Ogrencileri ekrana basarken dosyadan okuyor ama eklerken listeye ekliyor.)
Dosyaya Yazma:  15/25 (Nesne yazma mantigi yok, tostring yaziliyor.)
Genel Program: 5/15
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20
Benzer Kod Yazma Nedeniyle: -10
-----------------------------------
Sonuc: 55
 */

/**
 * Created by Rsl on 9.04.2017.
 */

public class Menu {
    public static Scanner MenuSec = new Scanner(System.in);

    public static void MenuGoster()
    {
        System.out.println("1-) Öğrenci Ekleme");
        System.out.println("2-) Öğrenci Silme");
        System.out.println("3-) Öğrenci Listeleme");
        System.out.println("0-) Çıkış");


    }
    public static void main(String[] args)

    {
        while(true){


            MenuGoster();
            System.out.println("Lütfen Seçim Yapınız: ");
            int kullaniciSecimi = kullaniciIntegerGirdiAl();
            MenuSecimi menuSecimi = MenuSecimi.enumaCevir(kullaniciSecimi);
            switch (menuSecimi) {
                case OGRENCI_EKLEME:
                    OgrenciEkleme();

                    break;
                case OGRENCI_SILME:
                    ogrenciSilme();

                    break;

                case OGRENCI_LISTELE:
                    ogrencileriEkranaBas(0);
                    break;
                case CIKIS:

                    System.out.println("Dosya yazılıyor lütfen bekleyin.");
                    System.out.println("Dosya yazıldı.");
                    System.out.println("Çıkış yapıldı.");
                    dosyaYaz();
                    MenuSec.close();
                    System.exit(0);

                    break;

                default:
                    break;
            }

        }
    }
    public static void OgrenciEkleme()
    {
        System.out.println("Lütfen Ad ve Soyad giriniz: ");
        String adSoyad = MenuSec.nextLine();

        System.out.println("Öğrenci tipini Griniz (MYO/Lisans/YL/Doktora");
        String ogrenciTip =  MenuSec.nextLine();

        System.out.println("Ogrenci bölüm Giriniz: (Mühendislik,İşletme,Hukuk.. vs.. )");
        String bolum = MenuSec.nextLine();
        Ogrenci yeniOgrenci = null;
        if (ogrenciTip.equals("YL")) {
            yeniOgrenci = new YuksekLisansOgrencisi("Ozkan", adSoyad, bolum);
        } else if (ogrenciTip.equals("Doktora")) {
            yeniOgrenci = new DoktoraOgrencisi(adSoyad, bolum);
        }
        else if(ogrenciTip.equals("MYO")){

            yeniOgrenci=new MyoOgrencisi(adSoyad,bolum);
        }
        else if (ogrenciTip.equals("Lisans")) {
            yeniOgrenci = new LisansOgrencisi(adSoyad, bolum);
        }

        if (yeniOgrenci != null) {
            OgrenciListesi.add(yeniOgrenci);
            System.out.println(adSoyad + " isimli ögrenci eklendi.Dosyaya yazma işlemi için programdan çıkış yapınız.");
        }

        else
        {
            System.out.println("Gecersiz ögrenci bölümü");
        }

    }
    private static void ogrenciSilme() {


        System.out.println("Silmek istediginiz ögrenciyi seçiniz: ");
        ogrencileriEkranaBas(0);
        System.out.print("Seciminiz: ");
        int kullaniciSecimi = kullaniciIntegerGirdiAl();
        System.out.println(OgrenciListesi.get(kullaniciSecimi-1)
                + " isimli öğrenci siliniyor.");
        OgrenciListesi.remove(kullaniciSecimi-1);

    }
    private static Integer kullaniciIntegerGirdiAl() {
        String kullaniciGirisi = "";
        int girdi = -1;
        try {
            kullaniciGirisi = MenuSec.nextLine();
            girdi = Integer.valueOf( kullaniciGirisi );
        }
        catch(Exception e) {
            System.out.println("Geçerli bir değer giriniz. Girdiğiniz değer: "
                    + kullaniciGirisi);
        }
        return girdi;
    }

    public static List<Ogrenci> OgrenciListesi = new ArrayList<>();

    public static void ogrencileriEkranaBas(int yontem) {

        try {
            FileReader fos2 = new FileReader(new File("ogrenciler.txt"));
            Scanner out2 = new Scanner(fos2);

            for (int i = 0; out2.hasNextLine(); i++) {
                String mevcutSatir = out2.nextLine();
                System.out.println(mevcutSatir);

            }

                out2.close();
        } catch (IOException exed ) {
            System.out.println("Okuma Hatası");
            exed.printStackTrace();
        }



        if (yontem == 0) {
            int no = 1;
            for (Ogrenci ogrenci : OgrenciListesi) {
                System.out.println(no + " -) " + ogrenci.ogrenciBilgileriAl());
                no++;
            }
        } else if (yontem == 1) {
            System.out.println(OgrenciListesi);
        } else {
            for (int i = 0; i < OgrenciListesi.size(); i++) {
                System.out.println(i + " -) " + OgrenciListesi.get(i));
            }
        }
    }
    public static void ogrenciListeleme() {
        ogrencileriEkranaBas(0);
    }

    public static void dosyaYaz() {

        if (OgrenciListesi.isEmpty()) {
            System.out.println("<< Sisteme yeni öğrenci girilmedi. Kayıt başarısızdır ! >>");
            return;
        } else {

            try {

                //dosyaya veri yazdırma
                FileWriter fos = new FileWriter("ogrenciler.txt");
                PrintWriter out = new PrintWriter(fos);

                for (int i = 0; i < OgrenciListesi.size(); i++) {

                    out.write(String.valueOf(OgrenciListesi.get(i)));
                    String selectedText = OgrenciListesi.toString();
                    File f = new File("ogrenciler.txt");
                    FileWriter fw=new FileWriter(f);
                    fw.write(selectedText);
                    fw.close();
                    out.write(",");

                }
                out.close();

            } catch (Exception e) {

            }
        }

    }
}
