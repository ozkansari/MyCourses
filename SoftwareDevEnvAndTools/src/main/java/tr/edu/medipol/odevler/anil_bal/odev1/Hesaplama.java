package tr.edu.medipol.odevler.anil_bal.odev1;

// DERLENMEYEN KOD: -40
// Hatali pom.xml: -10

public class Hesaplama {

	public static void main(String[] args){
		islemler(10, 5);
	
	}

	
	public static int islemler(int sayi1, int sayi2) {
		
		int sonuc1 = topla(sayi1, sayi2);
		int sonuc2 = carpma(sayi1, sayi2);
		int sonuc3 = cikarma(sayi1, sayi2);
		int sonuc4 = bolme(sayi1, sayi2);
		int sonuc5 = mod(sayi1,sayi2)/*duzeltme*/;
		// duzeltme: int sonuc6 = mutlak(sayi1)
		int sonuc7 = minimum(sayi1,sayi2)/*duzeltme*/;
		int sonuc8 = maksimum(sayi1,sayi2)/*duzeltme*/;
		// duzeltme: int sonuc9 = yukari_yuvarla(sayi1)/*duzeltme*/;
		// duzeltme: int sonuc10 = assagi_yuvarla(sayi1)/*duzeltme*/;
		
		// duzeltme: System.out.println(sonuc);
		// duzeltme: return sonuc;
		return sonuc1;
	}
	
	
	public static int topla(int sayi1,int sayi2)  {
		return sayi1+sayi2;
	}
	public static int carpma(int sayi1, int sayi2) {
		return sayi1 * sayi2;
	}
	
	public static int cikarma(int sayi1, int sayi2) {
		return sayi1 - sayi2;
	}
	
	public static int bolme(int sayi1, int sayi2) {
		return sayi1 / sayi2;
	}
	public static int mod(int sayi1, int sayi2) {
		return sayi1 % sayi2;
	}
	public static int mod(int sayi1) {
		// duzeltme: return Math.abs(int sayi1)
		return Math.abs(sayi1);
	}
	public static int minimum(int sayi1, int sayi2) {
		// duzeltme: return Math.min(int sayi1,int sayi2)
		return Math.min(sayi1,sayi2);
	}
	public static int maksimum(int sayi1, int sayi2) {
		// duzeltme: return Math.max(int sayi1,int sayi2)
		return Math.max(sayi1,sayi2);
	}
	// duzeltme: public static int yukari_yuvarla(int sayi1) {
	public static double yukari_yuvarla(int sayi1) {
		// duzeltme: return Math.ceil(int sayi1)
		return Math.ceil(sayi1);
	}
	// duzeltme: public static int assagi_yuvarla(int sayi1) {
	public static double assagi_yuvarla(int sayi1) {
		// duzeltme: return Math.floor(int sayi1)
		return Math.floor(sayi1);
	}
}
