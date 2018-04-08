package tr.edu.medipol.odevler.tugba_yildirim.odev1;

// Test paketi test drc altında degil: -10
// Formatsiz kod: -5

// SONUC: 85

public class Islem {
	public static int topla(int s1, int s2) {
		return s1 + s2;
	}

	public static int cikar(int s1, int s2) {
		return s1 - s2;
	}

	public static int carp(int s1, int s2) {
		return s1 * s2;
	}

	public static int bol(int s1, int s2) {
		return s1 / s2;
	}

	public static int kareal(int s1) {
		return s1 * s1;
	}

	public static int taban(double s1) {
		return (int) Math.floor(s1);
	}

	public static int tavan(double s1) {
		return (int) Math.ceil(s1);
	}

	public static int kuvvet(int s1, int s2) {
		return (int) Math.pow(s1, s2);
	}

	public static int mutlak(int s1) {
		return Math.abs(s1);
	}

	public static int enkucuk(int s1, int s2) {
		return Math.min(s1, s2);
	}

	public static void main(String[] args) {
		int sonuc = topla(25, 25);
		System.out.println(sonuc);
		System.out.println(cikar(25, 15));
		System.out.println(carp(2, 2));
		System.out.println(bol(100, 2));
		System.out.println(kareal(10));
		System.out.println(taban(12.2));
		System.out.println(tavan(8.3));
		System.out.println(kuvvet(5, 4));
		System.out.println(mutlak(-13));
		System.out.println(enkucuk(25, 5));

	}

}
