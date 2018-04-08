package tr.edu.medipol.odevler.ahmet_ciloglu.odev1;

// GEC GONDERIM: -20

// EKSIK: -40
// 3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan sınıflarına metod da tanımlanabilir.

// Koyun, kopek, kedi gibi siniflar anlamsiz: -10

// SONUC: 30

public class Main {

	public static void main(String[] args) {
		Kopek kucu = new Kopek();
		Koyun kuzu= new Koyun();
		Kedi pisi = new Kedi();
		Hayvan hepsi = new Hayvan();
		
		pisi.kedi();
		kuzu.koyun();
		hepsi.kopek();
		hepsi.kedi();
		kucu.kopek();

	}

}
