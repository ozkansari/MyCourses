package tr.edu.medipol.odev2.caglaoz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.InputMismatchException;

// 80

// Gamze Nur Keskin ile cok benzer (-20)
// Logger ve BufferedReader kullanimini gostermedim. Nereden ogrendin? (-5)
// Menu bonus (+10)

public class Kodlama {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long startTime = System.currentTimeMillis();
        int islem, adet;
        String format = "";
        String adsoyad = "";
        String ryer = "";
        double sure;

        System.out.println("Randevu Kayıt Programına HOŞ GELDİNİZ.");
        System.out.print("Kaç adet randevu kaydı yapacaksınız: ");


        try{
        adet = input.nextInt();
        String AdSoyad[] = new String[adet];
        String Ryeri[] = new String[adet];
        List<Date> rlist = new ArrayList<Date>();

        for (int k = 0; ; k++) {
            System.out.print("\nRandevu kaydı için: 1 \nRandevuları görmek için: 2\nÇıkış yapmak için herhangi bir rakam değeri giriniz: .\n");
            System.out.print("İşleminizi seçiniz: ");
            islem = input.nextInt();

            switch (islem) {
                case 1:

                    try {
                        for (int i = 0; i < adet; i++) {
                            System.out.print("Ad Soyad: ");
                            try {
                                adsoyad = reader.readLine();
                            } catch (IOException ex) {
                                Logger.getLogger(Kodlama.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.print("Randevu Yeri: ");
                            try {
                                ryer = reader.readLine();
                            } catch (IOException ex) {
                                Logger.getLogger(Kodlama.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.out.println("Tarih formatımız şöyledir: \" \"dd/MM/yyyy hh:mm:ss\" \" ");
                            System.out.print("Randevu Tarih ve Saat: ");
                            try {
                                format = reader.readLine();
                            } catch (IOException ex) {
                                Logger.getLogger(Kodlama.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            AdSoyad[i] = adsoyad;
                            Ryeri[i] = ryer;
                            SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                            Date randevu = dt.parse(format);
                            rlist.add(randevu);

                        }
                        System.out.println("Randevularınız kayıt edilmiştir. ");

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    continue;
                case 2:
                    try {
                        System.out.println("\nRandevularınız");
                        for (int i = 0; i < adet; i++) {
                            System.out.println(rlist.get(i));
                            System.out.println(AdSoyad[i]);
                            System.out.println(Ryeri[i]);
                        }

                    } catch (Exception e) {
                        System.out.println("\nHiç randevu kaydınız bulunmamaktadır.");
                    }
                    break;

                default:

                    try {
                        System.out.println("\nProgramdan çıktınız.");
                        long endTime = System.currentTimeMillis();
                        long estimatedTime = endTime - startTime;
                        sure = (double) estimatedTime / 1000;
                        System.out.println("Programın çalışma süresi: " + sure);
                        System.exit(0);
                    } catch(InputMismatchException e) {
                        System.out.println("HATA : Lütfen Sadece Rakam Giriniz!");
                    } catch (Exception  e) {

                        System.out.println("Tahmin edilmeyen hata ile karşılaşıldı.");
                    }
                    break;
            }
        }
        } catch(InputMismatchException e){
            System.out.println("HATA : Lütfen Sadece Rakam Giriniz!");

        }
    }
}
