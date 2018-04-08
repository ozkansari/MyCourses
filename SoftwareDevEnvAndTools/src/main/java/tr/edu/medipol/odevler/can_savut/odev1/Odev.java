package tr.edu.medipol.odevler.can_savut.odev1;

// DERLENMEYEN KOD: -40


// duzeltme : public class hesaplama {
public class Odev {
	public static int kareAlma(int sayi) {
		return sayi*sayi;
		
	}
	public static int cikar(int sayi,int sayi2) {
		return sayi-sayi2;
		
	}
	public static int topla(int sayi,int sayi2) {
		return sayi+sayi2;
		
	}
		public static int ortBulma(int sayi,int sayi2) {
		return (sayi+sayi2)/2;
		
	}
	public static int carp(int sayi,int sayi2) {
		return sayi*sayi2;
		
	}

	// duzeltme : public static int karekokBulma(int sayi) {
	public static double karekokBulma(int sayi) {
		return Math.sqrt(sayi);
		
	}
	public static int bol(int sayi,int sayi2) {
		return sayi/sayi2;
		
	} 	
	// duzeltme : public static int karekokBulma(int sayi) {
	public static double ussuAlma (int sayi,int sayi2) {
		return Math.pow(sayi,sayi2);
		
	}

	public static int dikdortgennAlan(int kisaKenar,int uzunKenar) {
		return (kisaKenar*uzunKenar)/2;
		
	}
	public static int dikdortgenCevre(int kisakenar,int uzunKenar) {
		return (kisakenar*2)+(uzunKenar*2);
		
	}	
	

}
