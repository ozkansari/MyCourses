package tr.edu.medipol.odev1.koraycomert;

import java.util.*;// 30 (gonderdigin icin)
// Kod calismiyor// KorayCömertÖdev1.c olarak gonderilmis// Fatih diye degiskenin biri koray olarak degistirilmis digeri fatih kalmis ; kopya cekilmis gorunuyor.
public class JavaApplication24 {

    public void bul() {

        Scanner klavye = new Scanner(System.in);

        String kelime;
        System.out.println("Kelime Giriniz");
        kelime = klavye.nextLine();

        int boy = kelime.length();

        int i, sayac = 0;

        for (i = 0; i < boy; i++) {

            if (kelime.charAt(i) == 'a') {
                if (kelime.charAt(i + 1) == 'l') {
                    if (kelime.charAt(i + 2) == 'i') {
                        System.out.println("Dizide ali vard�r ve yeri " + i + ". karakterdir.");
                        sayac++;
                    }
                }
            }

        }
        System.out.println("Dizide " + sayac + " tane ali vard�r");

    }

    public static void main(String[] args) {

        JavaApplication24 fatih = new JavaApplication24();

        // OZKANS DUZELTME koray.bul();        fatih.bul();
    }

}

