package tr.edu.medipol.hafta9;

public class Generics {
	
	public static <T> void diziIcerigiGeneric(T[] dizi) {
		for (T element : dizi) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void main(String args[]) {

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
		Long[] longArray = { 1L, 2L, 3L, 4L, 5L };

		System.out.println("Integer dizisinin icerigi:");
		diziIcerigiGeneric(intArray); // Integer dizisini parametre olarak ver

		System.out.println("Double dizisinin icerigi:");
		diziIcerigiGeneric(doubleArray); // Double dizisini parametre olarak ver

		System.out.println("Character dizisinin icerigi:");
		diziIcerigiGeneric(charArray); // Character dizisini parametre olarak ver
		
		System.out.println("Long dizisinin icerigi:");
		diziIcerigiGeneric(longArray); // Long dizisini parametre olarak ver
	}
	
	public static void diziIcerigi1(Integer[] dizi) {
		for (Integer element : dizi) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void diziIcerigi1(Double[] dizi) {
		for (Double element : dizi) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void diziIcerigi1(Character[] dizi) {
		for (Character element : dizi) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static void diziIcerigi1(Long[] dizi) {
		for (Long element : dizi) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

}
