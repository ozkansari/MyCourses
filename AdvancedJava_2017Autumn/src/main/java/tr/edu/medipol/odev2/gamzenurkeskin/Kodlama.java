package tr.edu.medipol.odev2.gamzenurkeskin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

//85

//Cagla Oz ile cok benzer (-20)

//Logger ve BufferedReader kullanimini gostermedim. Nereden ogrendin? (-5)
//Menu bonus (+10)

public class Kodlama {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long startTime = System.currentTimeMillis();
        int islem,adet;
        String format = "";
        String adsoyad="";
        String ryer="";

        double sure;
        System.out.println("RANDEVU PROGRAMINA HOŞGELDİNİZ");
        System.out.print("\nProgramda toplam kaç randevu bulunacaktır? : ");
        try {
            adet = input.nextInt();
            List<Date> rlist = new ArrayList<Date>();
            String AdSoyad[]=new String[adet];
            String Ryeri[]=new String[adet];

            do {
                System.out.println("\n\nMenümüz\n");
                System.out.print("Randevu kaydı için: 1 \nRandevuları görmek için: 2\nÇıkış yapmak için: 0   basınız.\n");
                System.out.print("\nİşleminizi seçiniz: ");
                islem = input.nextInt();
                switch (islem) {
                    case 1:
                        System.out.println("\n\nNot: Tarih formatımız şöyledir: \" \"dd/MM/yyyy hh:mm:ss\" \" ");
                        System.out.println("\n\nBilgileriniz");
                        try {
                            for (int i = 0; i < adet; i++) {
                                System.out.print("\nAd Soyad: ");
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
                            System.out.println("\nRandevularınız kayıt edilmiştir. ");

                        } catch (Exception e) {
                            System.out.println("\nHatalı giriş yaptınız. \nSizi menüye yönlendiriyorum");
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
                            System.out.println("\nHiç randevu kaydınız bulunmamaktadır.\nSizi menüye yönlendiriyorum");
                        }
                        continue;

                    case 0:
                        try {
                            System.out.println("\nProgramdan çıktınız.");

                            long endTime = System.currentTimeMillis();
                            long estimatedTime = endTime - startTime;
                            sure = (double) estimatedTime / 1000;
                            System.out.println("Programın çalışma süresi: " + sure);
                            System.exit(0);
                        } catch (Exception e) {
                            System.out.println("\nBöyle bir seçenek bulunmamaktadır.\nSizi menüye yönlendiriyorum");
                        }
                        continue;

                    default:
                        try {
                            System.out.println("\nBöyle bir seçenek bulunmamaktadır.");
                        }
                        catch (InputMismatchException e){
                            System.out.println("\nBöyle bir seçenek bulunmamaktadır.");
                        }
                        continue;
                }
            }
            while (true);
        }
        catch(InputMismatchException e){
            System.out.println("\nBöyle bir seçenek bulunmamaktadır.");
        }

    }
}