package tr.edu.medipol.odevler1ve2.ismail_sahin.odev1;

import java.util.Scanner;

public class HayvanatBahcesi {

	public static void main(String[] args) {
		Hayvan kedi = new Kedi("Minno�", 3);
		Hayvan kopek = new Kopek("�oban", 5);
		Hayvan at = new At("Taylan", 7);
		Hayvan ordek = new Ordek("Zaz", 2);
		Hayvan tavuk = new Tavuk("Tavuk", 1);
		
		sesCikar(2, kedi);
		sesCikar(5, kopek);
		sesCikar(5, at);
		sesCikar(2, ordek);
		sesCikar(4, tavuk);
	}

	public static void sesCikar(int sesSeviyesi, Hayvan hayvan) {
		System.out.println("Ses seviyesi: " + sesSeviyesi);

		if (hayvan instanceof Kedi) {
			((Kedi) hayvan).miyavla();
		} else if (hayvan instanceof Kopek) {
			((Kopek) hayvan).havla();
		} else if (hayvan instanceof Ordek) {
			((Ordek) hayvan).vakVakSesiCikar();
		} else if (hayvan instanceof Tavuk) {
			((Tavuk) hayvan).gidakla();
		} else if (hayvan instanceof At) {
			((At) hayvan).kisne();
		}
		
	}

}
