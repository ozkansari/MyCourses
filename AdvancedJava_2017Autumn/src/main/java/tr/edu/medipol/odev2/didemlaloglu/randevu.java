package tr.edu.medipol.odev2.didemlaloglu;

import java.util.Scanner;

// 90

// formatlama sorunlari (-5)
// Basit string girisi (-5) 

public class randevu {

        public static void main(String[] args) {
        
                
                Scanner s= new Scanner(System.in);
                
                for (int i=0; i<=4; i++) {
                
                System.out.println("Adınızı ve Soyadınızı giriniz:");
                                
                                String ad=s.nextLine();
                                
                System.out.println("Randevu yerinizi giriniz:");
                                String yer=s.nextLine();

                System.out.println("Randevu Tarihinizi giriniz:");
                                String tarih=s.nextLine();
                
                System.out.println("Randevu Saatinizi");
                                String saat=s.nextLine();

                                
                String randevu1=" isim:  " +ad + ", yer: " +yer + ", tarih: " + tarih+", saat: "+saat;
                        System.out.println("Randevu Bilgileriniz: " + randevu1);        
                }
                

        }


        }
