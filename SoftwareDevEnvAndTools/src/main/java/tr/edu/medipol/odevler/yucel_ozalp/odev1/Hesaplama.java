package tr.edu.medipol.odevler.yucel_ozalp.odev1;

// GEC GONDERIM: -20

public class Hesaplama {

	public static void main(String[] args) {
		int toplamaSonuc = toplama(15, 3);
		int cikarmaSonuc = cikarma(100, 50);
		int carpmaSonuc = carpma(5, 5);
		int bolmeSonuc = bolme(1000, 10);
		
		System.out.println("Toplama: " + toplamaSonuc + "\n Çýkarma: " + cikarmaSonuc + "\n Çarpma: " + carpmaSonuc + "\n Bölme: " + bolmeSonuc);
				
	}
	
	public static int toplama(int s1, int s2) {
		return s1 + s2;
	}
	
	public static int cikarma(int s1, int s2) {
		return s1 - s2;
	}
	
	public static int carpma(int s1, int s2) {
		return s1 * s2;
	}
	
	public static int bolme(int s1, int s2) {
		return s1 / s2;
	}

}
