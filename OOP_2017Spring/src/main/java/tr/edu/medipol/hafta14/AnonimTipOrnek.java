package tr.edu.medipol.hafta14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** INTERFACE */
interface IFonksiyon {
    int hesapla(int sayi1, int sayi2);
}

/** INTERFACEDEN TUREYEN SINIF */
class ToplamaFonksiyonu implements IFonksiyon {
    public int hesapla(int sayi1, int sayi2) {
        return sayi1+sayi2;
    }
}
class CikarmaFonksiyonu implements IFonksiyon {
    public int hesapla(int sayi1, int sayi2) {
        return sayi1-sayi2;
    }
}


public class AnonimTipOrnek {
     
    /** PARAMETRE OLARAK IFonksiyon INTERFACEINDEN 
     * TUREYEN BIR NESNE ALAN METOD.
     */
    public static void calistir(IFonksiyon fonk, int sayi1, int sayi2) {
        // IFonksiyon interfaceindeki hesapla metodunu cagirir.
        System.out.println(fonk.hesapla(sayi1, sayi2));
    }
    
    /** MAIN METHOD */
    public static void main(String[] args) {
        
        // 1. Yontem:
        ToplamaFonksiyonu fonksiyon1 = new ToplamaFonksiyonu();
        calistir(fonksiyon1, 4, 2);
        
        // 2. Yontem: Anonim tipten tureyen
        IFonksiyon fonksiyon2 = new IFonksiyon() {     
            public int hesapla(int sayi1, int sayi2) { // mod alma fonk.
                return sayi1%sayi2;
            }
        };
        calistir(fonksiyon2, 4, 2);
        
        // 3. Yontem: Lambda ile : Yukaridakiyle ayni isi yapiyor
        IFonksiyon mod = (sayi1,sayi2) -> sayi1%sayi2;
        calistir(mod, 4, 2);
        
	    // Carpma
        IFonksiyon carpma = (sayi1,sayi2) -> sayi1*sayi2;
        calistir(carpma, 4, 2);
        
	    // Bolme
        IFonksiyon bolme = (sayi1,sayi2) -> sayi1/sayi2;
        calistir(bolme, 4, 2);
        
	    // Us alma
        IFonksiyon usAlma = (sayi1,sayi2) -> (int) Math.pow(sayi1, sayi2);
        calistir(usAlma, 4, 2);
        
        
        // --------- NOTLAR -----------------------------
        
        // NOT 1: Hepsi IFonksiyon interface'inden turediginden calistir 
        // fonksiyonuna parametre olarak gonderilebiliyor.
        
        // NOT 2: 12 . Hafta Hatırla
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        };
        List<String> stringListe = new ArrayList<String>();
        stringListe.sort(comp);
    }
 
}
