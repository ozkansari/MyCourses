package tr.edu.medipol.odevler1ve2.anil_bal.odev1;

import java.util.ArrayList;

// 30
// HATALI KOD, derlenmiyor. txt dosyasi olarak gonderim.
// Derlenmesi icin bir cok duzeltme yapildi. Kod formatlandi.

public class odev {
	public static void main(String[] args) {

		Hayvan kedi = new Kedi();
		kedi.sesCikart();

		Hayvan serce = new Serce();
		serce.sesCikart();

		/* ozkans duzeltildi */ Hayvan kopek = new Kopek();
		kopek.sesCikart();

		ArrayList<Hayvan> hayvanListesi = new ArrayList<Hayvan>();
		hayvanListesi.add(kedi);
		hayvanListesi.add(serce);
		hayvanListesi.add(kopek);

		for (Hayvan hayvan : hayvanListesi) {
			/* ozkans duzeltildi */ ozelFonksiyonlariniCagir(hayvan);
		}

	}

	public static class Hayvan { /* ozkans duzeltildi */ 
		public void sesCikart() {
			System.out.println("Sesim yok!");
		}
	}/* ozkans duzeltildi */

	public static void ozelFonksiyonlariniCagir(Hayvan hayvan) {
		if (hayvan instanceof Kedi) {
			((Kedi) hayvan).sesCikart();
		} else if (hayvan instanceof Serce) {
			((Serce) hayvan).sesCikart();
			/* ozkans duzeltildi */ } else if (hayvan instanceof Kopek) {
			/* ozkans duzeltildi */ ((Kopek) hayvan).sesCikart();
		}
		/* ozkans duzeltildi */
	}

	public static class Kedi extends Hayvan { /* ozkans duzeltildi */ 
		@Override
		public void sesCikart() {
			System.out.println("Miyav miyav");
		}
	}

	public static class Serce extends Hayvan {/* ozkans duzeltildi */ 
		@Override
		public void sesCikart() {
			System.out.println("Cik Cik");
		}
	}

	public static class Kopek extends Hayvan {/* ozkans duzeltildi */ 
		@Override
		public void sesCikart() {
			System.out.println("Hav Hav");
		}
	}
}/* ozkans duzeltildi */