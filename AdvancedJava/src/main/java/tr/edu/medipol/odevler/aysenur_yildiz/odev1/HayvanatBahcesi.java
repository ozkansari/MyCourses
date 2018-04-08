package tr.edu.medipol.odevler.aysenur_yildiz.odev1;

/* ozkans importlar eklendi */
import java.util.ArrayList;
import java.util.Iterator;

// DERLENMIYORDU - import eklendi

// BENZER ODEV: Betul Ozdemir -20

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan sınıflarına metod da tanımlanabilir.

// SONUC: 40

public class HayvanatBahcesi {
	
    public static void main(String[] args) {
        Kedi kedi = new Kedi();
        kedi.sesCikart();
        Zurafa zurafa  = new Zurafa();
        zurafa.sesCikart();
        Kopek kopek = new Kopek();
        kopek.sesCikart();
        ArrayList hayvanListesi = new ArrayList();
        hayvanListesi.add(kedi);
        hayvanListesi.add(zurafa);
        hayvanListesi.add(kopek);
        Iterator var7 = hayvanListesi.iterator();

        while(var7.hasNext()) {
            Hayvan hayvan = (Hayvan)var7.next();
            Hayvan.ozelFonksiyonlariniCagir(hayvan);
        }

    }

}
