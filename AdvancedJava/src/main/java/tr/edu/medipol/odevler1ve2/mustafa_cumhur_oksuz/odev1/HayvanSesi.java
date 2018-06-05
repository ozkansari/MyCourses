package tr.edu.medipol.odevler1ve2.mustafa_cumhur_oksuz.odev1;
import java.util.ArrayList;
import java.util.Iterator;

//BENZER ODEV: Aysenur Yildiz, Betul Ozdemir -20

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan siniflarina metod da tanimlanabilir.

//GEC GONDERIM: -20

//SONUC: 20

public class HayvanSesi {
    public HayvanSesi() {
    }

    public static void main(String[] args) {
        Kuzu kuzu = new Kuzu();
        kuzu.sesCikart();
        Inek inek = new Inek();
        inek.sesCikart();
        Horoz horoz = new Horoz();
        horoz.sesCikart();
        Karga karga = new Karga();
        karga.sesCikart();
        Kopek kopek = new Kopek();
        kopek.sesCikart();
        ArrayList hayvanListesi = new ArrayList();
        hayvanListesi.add(kuzu);
        hayvanListesi.add(karga);
        hayvanListesi.add(kopek);
        hayvanListesi.add(horoz);
        hayvanListesi.add(inek);
        Iterator var = hayvanListesi.iterator();

        while(var.hasNext()) {
            Hayvan hayvan = (Hayvan)var.next();
            Hayvan.ozelFonksiyonlariniCagir(hayvan);
        }

    }
}