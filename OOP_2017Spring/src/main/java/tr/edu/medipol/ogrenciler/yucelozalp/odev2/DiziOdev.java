/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.medipol.ogrenciler.yucelozalp.odev2;

import java.util.*;
/**
 *
 * @author yucel.ozalp
 */
public class DiziOdev {

    public static void main(String[] args) {

        ArrayList <Integer> nots = new ArrayList <Integer> ();           
        
        Integer[] notlar =  new Integer[] {100, 85, 60, -504, 70, 100, -1, 60, 70, 200, 80, 90, 100, 50, 60, 70, 80, 55, 80, 120, 150, 160};
        nots.addAll(Arrays.asList(notlar)); // ozkans: Arrays.asList zaten liste cevirir, addAll gereksiz
        int[] sonuc = new int[50];
        int sayac = 0, say = 0;
        
         
        for (int i = 0; i < nots.size(); i++) {

            if (nots.get(i) > 100 || nots.get(i) < 0) {

                System.out.println("TANIMSIZ = " + nots.get(i));
                nots.remove(i);

            } else {

            }

        }
        for (int b = 0; b < nots.size(); b++) {
            boolean isDistinct = false;
            for (int j = 0; j < b; j++) {
                if (nots.get(b) == nots.get(j)) { // ozkans: bu kontrolu array ile de yapabilirdin.
                    isDistinct = true;
                    break;
                }
            }
            if (!isDistinct) {
                sonuc[sayac++] = nots.get(b);
            }
        }
        for (int b = 0; b < sayac; b++) {
            say = 0;
            for (int j = 0; j < nots.size(); j++) {
                if (sonuc[b] == nots.get(j)) {
                    say++;
                }

            }
            System.out.println(sonuc[b] + " Sayısından = " + say + " Tane var");

        }
    }
}
