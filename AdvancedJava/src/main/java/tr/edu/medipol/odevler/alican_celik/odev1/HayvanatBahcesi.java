package tr.edu.medipol.odevler.alican_celik.odev1;

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan siniflarina metod da tanimlanabilir.

//BENZER ODEV: Ahmet Mustafa Tavar -20

//SONUC: 40

public class HayvanatBahcesi  {
    public static void main(String[] args) {
            Hayvan zurafa = new Zurafa();
            Hayvan koyun =  new Koyun();
            Hayvan aslan =  new Aslan();
            koyun.sesCikart();
            zurafa.sesCikart();
            aslan.sesCikart();

        }
    }

