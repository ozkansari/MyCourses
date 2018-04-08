package tr.edu.medipol.odevler.yucel_ozalp.odev1;

// GEC GONDERIM: -20

// EKSIK: -40
// 3-) HayvanatBahcesi sinifi icine sesCikar isimli bir metod yapilacak. Bu metod sesSeviyesi ve Hayvan siniflarini parametre alacak. Bu metod icerisinde parametre alinan hayvan nesnesinin tipine gore (Kedi,Kopek,Zurafa vb.) uygun ses ekrana yazilacak. Uygun sesin ekrana yazilmasi icin ilgili hayvan sınıflarına metod da tanımlanabilir.


// SONUC: 40

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    System.out.println("* DARICA HAYVANAT BAH�ES� * \n");

	    Hayvan.kedi vanKedisi = new Hayvan().new kedi(1,"Van","Mavi",3,3);
        vanKedisi.ekranaYaz();
        
        Hayvan.kopek sivasKangali = new Hayvan().new kopek(2,"Kangal","Gri",6,3);
        sivasKangali.ekranaYaz();
        
        Hayvan.zurafa zurafa = new Hayvan().new zurafa(3,"Z�rafa","Benekli",2,3);
        zurafa.ekranaYaz();
        
       
	}
}