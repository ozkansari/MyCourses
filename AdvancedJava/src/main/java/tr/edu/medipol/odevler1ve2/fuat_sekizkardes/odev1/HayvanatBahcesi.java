package tr.edu.medipol.odevler1ve2.fuat_sekizkardes.odev1;

//EKSIK: -40
//3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan siniflarina metod da tanimlanabilir.

// GEC GONDERIM: -20

// BONUS: +11

// SONUC: 61

public class HayvanatBahcesi {
	public static void main(String[] args) {
		
		   //Zurafa
	       Zurafa sesi = new Zurafa();
	       sesi.sesCikar();
	       Zurafa duzeyi = new Zurafa();
	       duzeyi.sesSeviyesi();
		   //At
	       At sesi3 = new At();
	       sesi3.sesCikart();
	       At duzeyi3 = new At();
	       duzeyi3.sesSeviyesi();
		   //Kedi
	       Kedi sesi2 = new Kedi();
	       sesi2.sesCikar();
	       Kedi duzeyi2 = new Kedi();
	       duzeyi2.sesSeviyesi();
		   //Kopek
	       Kopek sesi1 = new Kopek();
	       sesi1.sesCikar();
	       Kopek duzeyi1 = new Kopek();
	       duzeyi1.sesSeviyesi();

	}

}
