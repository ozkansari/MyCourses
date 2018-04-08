package tr.edu.medipol.odevler.numan_gungor.odev1;

import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.scene.media.SubtitleTrack;

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan sınıflarına metod da tanımlanabilir.

// ORJINALLIK: +15

public class Main {

    public static void main(String[] args) {

    Kopek ko =new Kopek();
    Kedi ke= new Kedi();
    Fare Fa = new Fare();

        System.out.println( "Kopek");

        ko.SesCıkar();
        ko.YemekYe();
        ko.Uyu();

        System.out.println("--------");
        System.out.println("Kedi");
        ke.SesCıkar();
        ke.YemekYe();
        ke.Uyu();

        System.out.println("-----");
        System.out.println("Fare");
        Fa.SesCıkar();
        Fa.YemekYe();
        Fa.Uyu();
    }
}
