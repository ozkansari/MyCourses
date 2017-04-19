package tr.edu.medipol.hafta9;

public class Generics2 {

	public static void main(String[] args) {
		System.out.println(maksimum(3,4,5,6,7));
		System.out.println(maksimum(3,188));
		System.out.println(maksimum(3.2,188.2));
		System.out.println(maksimum(4L,8L));
		System.out.println(maksimum("1","8", "673232"));
		System.out.println(maksimum('a','b', '2'));
		
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		System.out.println(maksimum(intArray));
		
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		System.out.println(maksimum(doubleArray));
		
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		System.out.println(maksimum(charArray));
		
		Long[] longArray = { 1L, 2L, 3L, 4L, 5L };
		System.out.println(maksimum(longArray));
	}
	
	// <T> diyerek metodumuzu generic tip kabul edebilir hale getirdik
	// <T extends Comparable<T>> diyerek ise generic tipi sadece Comparable'dan türeyen tiplerle sinirladik
	// <T extends Comparable<T>> diyerek T tipinde nesnelerin Comparable'da tanimli metodlari cagirabilmesini sagladim.
	// "T ... nesne" diyerek her hangi bir sayida nesne parametre alabilmesini sagladik 
	// "T ... nesne" ifadesi tek tek parametre verilebilir ama dizi olarak algilar.
	public static <T extends Comparable<T>> T maksimum(T ... nesne) {
		T maks = nesne[0];
		for (int i = 0; i < nesne.length; i++) {
			if (nesne[i].compareTo(maks) > 0) {
				maks = nesne[i];
			}
		}
		return maks;
	}
}
