package tr.edu.medipol.odevler.rumeysa_yildirim.odev1;

// DERLENMIYOR, HATALI. DUZELTILDI
// GEC GONDERIM: -20

// SONUC: 25

/* public */ interface Hayvan {}
/* public */  class Kedi /* extends */ implements  Hayvan{}
/* public */  class Kopek /* extends */ implements  Hayvan{}
/* public */  class Zurafa /* extends */ implements  Hayvan{}

public class /*Duzeltildi*/HayvanatBahcesi
{
	private static void main() 
	{
		Kedi kedi = new Kedi();
		Kopek kopek = new Kopek();
		Zurafa zurafa = new Zurafa();
		
		sesCikart(6, kedi);
		sesCikart(10, kopek);
		sesCikart(8, zurafa);
	}
	
	private static int sesCikart(int sesSeviyesi, Hayvan hayvan)
	{
		if (hayvan instanceof Kedi) {
			System.out.println("Kedi ses seviyesi: " + sesSeviyesi + " db");
		}
		else if (hayvan instanceof Kopek) {
			System.out.println("Kopek ses seviyesi: " + sesSeviyesi + " db");
		}
		else if (hayvan instanceof Zurafa) {
			System.out.println("Zurafa ses seviyesi: " + sesSeviyesi + " db");
		}		
		return sesSeviyesi;
	}
}
