package tr.edu.medipol.hafta8;

public class Ozyineleme {

	public static void main(String[] args) {
		System.out.println(faktoriyel(4));
	}
	public static int faktoriyel(int n) {

		// Base case - taban/temel nokta
		// Recursion'in en dip noktasi
		if (n == 0)
			return 1;

		// 4 *     f(3)
		// 4 * ( 3 *   f(2) )
		// 4 * ( 3 * ( 2 * f(1) ) )
		// 4 * ( 3 * ( 2 * (  1 * f(0)    ) ) )
		// 4 * ( 3 * ( 2 * (  1 * 1    ) ) )
		return n * faktoriyel(n - 1);
		// n * (n-1)!
	}

	public static int basamakSayisi(int n) {
		
		int basamak = 1;
		int bolum = n;
		
		while(bolum<=9 || bolum>=-9) {
			bolum = bolum / 10;
			basamak++;
		}
		
		return basamak;
		
	}

	public static int basamakSayisiRec(int n) {
		if (n <= 9 || n >= -9) return 1;
		return 1 + basamakSayisiRec(n / 10);
	}
}
