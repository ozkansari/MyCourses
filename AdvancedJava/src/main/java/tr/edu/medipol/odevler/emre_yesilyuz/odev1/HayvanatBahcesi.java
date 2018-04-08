package tr.edu.medipol.odevler.emre_yesilyuz.odev1;
import java.util.ArrayList;
import java.util.Iterator;

//GEC GONDERIM: -20

//BENZER ODEV: Aysenur Yildiz, Betul ozdemir -20

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan sınıflarına metod da tanımlanabilir.

//SONUC: 20

    public class HayvanatBahcesi {
        public HayvanatBahcesi() {
        }

        public static void main(String[] args) {
            Kedi kedi = new Kedi();
            kedi.sesCikart();
            Inek inek = new Inek();
            inek.sesCikart();
            Yılan yılan = new Yılan();
            yılan.sesCikart();
            Serce serce = new Serce();
            serce.sesCikart();
            Kopek kopek = new Kopek();
            kopek.sesCikart();
            ArrayList hayvanListesi = new ArrayList();
            hayvanListesi.add(kedi);
            hayvanListesi.add(serce);
            hayvanListesi.add(kopek);
            hayvanListesi.add(yılan);
            hayvanListesi.add(inek);
            Iterator var7 = hayvanListesi.iterator();

            while(var7.hasNext()) {
                Hayvan hayvan = (Hayvan)var7.next();
                Hayvan.ozelFonksiyonlariniCagir(hayvan);
            }

        }
    }

