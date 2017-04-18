package tr.edu.medipol.odev1.bugraeminburunguz;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/** ozkans Degerlendirme

Menu: 5/5
Ogrenci Islemleri: 10/15 (Ogrenci ekleme bos kontrolu yok)
Polimorphism: 0/15
Dosyadan Okuma: 20/25 (Bos kontrolu yok, veri objesi okuma yok)
Dosyaya Yazma:  20/25 (Bos kontrolu yok, veri objesi yazimi yok)
Genel Program: 0/15 ( Scanner input static olmadigindan derlenmeyen kod, TR karakter problemleri, main yok. )
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 5/20



 */
public class OgrenciBilgileri {


        private /*ozkans duzeltme*/ static /*ozkans duzeltme*/Scanner input;
        private PrintWriter reader;

        private ArrayList<String> ogrenciListesi;
        private String dosyaIsmi = "ogrenciler.txt";


        private void main_Menu() {

            System.out.println("İşlem Seçiniz");
            System.out.println("1 -> Ekle");
            System.out.println("2 -> Sil");
            System.out.println("3 -> Listele");
            System.out.println("4 -> Kaydet Cik");
            load_Document();
            input = new Scanner(System.in);
            String init = input.nextLine();

            switch (init) {

                case "1":
                    add_Student();
                    break;

                case "2":
                    remove_Student();
                    break;

                case "3":

                    student_List();
                    break;

                case "4":
                    save_Document();
                    break;

                default:
                    System.out.println("Lütfen Menüleri Doğru Seçiniz");
                    main_Menu();
            }


        }
         
    private static Integer kullaniciIntegerGirdiAl() {
        String kullaniciGirisi = "";
        int girdi = -1;
        try {
            kullaniciGirisi = input.nextLine();
            girdi = Integer.valueOf( kullaniciGirisi );
        } catch(Exception e) {
            System.out.println("Gecerli bir deger giriniz. Girdiginiz deger: "
                    + kullaniciGirisi);
        }
        return girdi;
    }

    private void add_Student() {

            System.out.println("- Öğrenci Kayıtı -");

            System.out.println("- Adı Soyadı -");
            String ad = input.nextLine();

            System.out.println("- Numarasini -");
            String numara = input.nextLine();

            System.out.println("- Bölümü -");
            String bolum = input.nextLine();


            ogrenciListesi.add(ad + " - " + numara + " - " + bolum + " - " );

            System.out.println(String.format("İsmi: %s  Numarası: %s Bölümü: %s olan öğrenci kayıt edildi.",
                    ad, numara, bolum));

            main_Menu();
        }


        private void remove_Student() {
            System.out.println("Silmek istediginiz Öğrencinin idsini seçin ");
            student_List();
            System.out.print("Seciminiz: ");
            int kullaniciSecimi = kullaniciIntegerGirdiAl();
            System.out.println(ogrenciListesi.get(kullaniciSecimi-1)
                    + " isimli ogrenci siliniyor.");
            ogrenciListesi.remove(kullaniciSecimi-1);
        }


    private void student_List() {
        if (ogrenciListesi.size() == 0) {
            System.out.println("Ogrenci Listesi Bos");
        }
        else {
            System.out.println("! - - Ogrenci Listesi Alani - - !\n");
            for (int i = 0; i < ogrenciListesi.size(); i++) {
                System.out.println(String.format("%d - %s", i + 1, ogrenciListesi.get(i)));
            }
        }
        main_Menu();
    }

        private void save_Document() {
            try {
                reader = new PrintWriter(new File(dosyaIsmi));
                for (String ogrenci : ogrenciListesi) {
                    reader.println(ogrenci);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                reader.close();
            }

            System.out.println("Ogrenci Sistemi Basari Ile Kayıt Edildi..");
            System.out.println("Sistemden Cikiliyor...");
        }

        private void load_Document() {
            try {
                input = new Scanner(new File(dosyaIsmi));
                while (input.hasNext()) {
                    String ogrenci = input.nextLine();
                    ogrenciListesi.add(ogrenci);
                }
            } catch (FileNotFoundException e) {
              e.printStackTrace();
            } finally {
                if (input != null) {
                    input.close();
                }
            }
        }
    }


