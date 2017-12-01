/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.medipol.odev2.emineaycicek;
 
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 90

// Cagla Oz ile cok benzer (-15)

//Logger ve BufferedReader kullanimini gostermedim. Nereden ogrendin? (-5)
// Menu bonus (+10)

/**
 *
 * @author Emine Ayçicek
 */
public class Randevu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Scanner input = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long startTime = System.currentTimeMillis();
        int islem;
        String format = "";
        String isim = "";
        String hastane = "";
        double sure;
        System.out.println("Programa hoş geldiniz.");
        List<Date> dates = new ArrayList<Date>(); 
        String [][] randevular = new String[5][3];
        
        while(true){
          System.out.print("Randevu kaydı için: 1 \n Randevuları görmek için: 0  \n Çıkmak için herhangi bir Sayıya basınız ");
            System.out.println("İşleminizi seçiniz: ");
                        islem = input.nextInt();

        if (islem == 1){    
                for (int i = 0; i < 5; i++){

                           System.out.println("İsminizi giriniz: ");
                          try {
                              isim = reader.readLine();
                              randevular[i][1] = isim;
                          } catch (IOException ex) {
                              Logger.getLogger(Randevu.class.getName()).log(Level.SEVERE, null, ex);
                          }
                            System.out.println("Hastane Adını giriniz: ");
                          try {
                              hastane = reader.readLine();
                              randevular[i][2] = hastane;
                          } catch (IOException ex) {
                              Logger.getLogger(Randevu.class.getName()).log(Level.SEVERE, null, ex);
                          }
                          

                      try {
                          System.out.println("Tarih formatımız şöyledir: \" yyyy-MM-dd hh:mm:ss \" ");
                          System.out.println("Randevu tarihi ve saatini giriniz: ");
                          try {
                              format = reader.readLine();
                              randevular[i][0] = format;
                          } catch (IOException ex) {
                              Logger.getLogger(Randevu.class.getName()).log(Level.SEVERE, null, ex);
                          }
                          SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                          Date randevu = dt.parse(format);
                          dates.add(randevu);
                          Collections.sort(dates);

                      } catch (ParseException ex) {
                          Logger.getLogger(Randevu.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }
             Arrays.sort(randevular, (String[] o1, String[] o2) -> {
                 //get the item ids which are at index 0 of the array
                 String itemIdOne = o1[0];
                 String itemIdTwo = o2[0];
                 // sort on item id
                 return itemIdOne.compareTo(itemIdTwo);
                });
         } else  if (islem == 0){
                System.out.println("Randevular.");
                 for (int i = 0; i < 5; i++) {
                  System.out.println(randevular[i][0]+" -  "+randevular[i][1]+" -  "+randevular[i][2]);

                }
             
            }
        else {
               break;
             
            }
        }
    
                 
           System.out.println("Randevular.");
                  for (int i = 0; i < 5; i++) {
                  System.out.println(randevular[i][0]+" -  "+randevular[i][1]+" -  "+randevular[i][2]);

                }
                 
        System.out.println("Programdan çıktınız.");
                long endTime = System.currentTimeMillis();
                long estimatedTime = endTime - startTime;
                sure = (double)estimatedTime/1000;
                System.out.println("Programın çalışma süresi: " + sure);
    
    }
    
}
