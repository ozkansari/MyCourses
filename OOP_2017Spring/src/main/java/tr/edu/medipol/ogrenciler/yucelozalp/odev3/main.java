package tr.edu.medipol.ogrenciler.yucelozalp.odev3;

import java.util.*;

/**
 *
 * @author yucel.ozalp
 */
public class main {
    
         public static void main(String[] args) {
             
             /* Variables */
             String Ad;
             String Soyad;
             String not;
             Scanner oku = new Scanner (System.in);
             
             String[][] Ogrenciler = new String[3][3];
             List<String> OgrencilerListe = new ArrayList(); 
             
            /*
                Normalde Çift boyutlu dizi ile yaptım fakat Listeye ekleyin dediğiniz için birde 
                Listeye ekledim hocam :)
             */
            
             for (int i = 0; i < 3; i++) {
                      System.out.print("Lütfen "+ (i+1) +" Kişinin Adını Giriniz: ");
                      Ad = oku.next();
                      Ogrenciler[i][0] = Ad;
                      
                      System.out.print("Lütfen "+ (i+1) +" Kişinin Soyadını Giriniz: ");
                      Soyad = oku.next();
                      Ogrenciler[i][1] = Soyad; 
                      
                      System.out.print("Lütfen "+ (i+1) +" Kişinin Notunu Giriniz: ");
                      not = oku.next();
                      Ogrenciler[i][2] = not;
                      
                      
                      OgrencilerListe.add(Ad + " " + Soyad + " " + not);
                      
             }
            
            
             
            //Array Listin Yazdırdığı
            System.out.println("Öğrenciler [ARRAYLİST-DÜZ]"); 
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                     System.out.print(Ogrenciler[i][j] + " ");
                }
                 System.out.println();
           }
             System.out.println("Öğrenciler [LİST]"); 
            //Normal Listenin Yazdırdığı
             for (int i = 0; i < OgrencilerListe.size(); i++) {
                        System.out.println(OgrencilerListe.get(i));   
             }
            
             
         }
    
}
