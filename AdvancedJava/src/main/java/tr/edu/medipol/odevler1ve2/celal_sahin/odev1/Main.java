package tr.edu.medipol.odevler1ve2.celal_sahin.odev1;

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan siniflarina metod da tanimlanabilir.

//Koyun, kopek, kedi gibi metotlar anlamsiz: -10

// AHMET ÇİLOĞLU ile ÇOK BENZER: -20

//SONUC: 30

public class Main {
	public static void main(String[]args) {
		
		Kopek dog = new Kopek();
		Kus bird= new Kus();
		Inek cow = new Inek();
		
		
		dog.kopek();
		bird.kus();
		cow.inek();
		
	}

}
