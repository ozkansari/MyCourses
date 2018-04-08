package tr.edu.medipol.odevler.betul_ozdemir.odev1;
import java.util.ArrayList;
import java.util.Iterator;

// GEC GONDERIM: -20

//BENZER ODEV: Aysenur Yildiz -20

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan siniflarina metod da tanimlanabilir.

//SONUC: 20

public class Odev1 {
	public static void main (String[]args) {
		Kedi kedi=new Kedi();
		kedi.sesCikart();
		Kopek kopek=new Kopek();
		kopek.sesCikart();
		Aslan aslan=new Aslan();
		aslan.sesCikart();
		ArrayList hayvanListesi=new ArrayList();
		hayvanListesi.add(kedi);
		hayvanListesi.add(aslan);
		hayvanListesi.add(kopek);
		Iterator var7=hayvanListesi.iterator();
		
		while(var7.hasNext()) {
			Hayvan hayvan=(Hayvan) var7.next();
			Hayvan.ozelFonksiyonlariCagir(hayvan);
		}
	}

}
