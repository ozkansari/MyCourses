package tr.edu.medipol.hafta1;

/**
 * MAIN Metodu iceren Java Sinifi
 * @author ozkansari
 *
 */
public class AnaProgram {

	/**
	 * JAVA PROGRAMLARININ BASLANGIC NOKTASI
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Yazici evYazicisi = new Yazici("EV", 8999999999999999999L,1999999999);
		String mesajEv = "Merhaba ailem.";
		evYazicisi. ekranaYazdir(mesajEv);
		
		Yazici okulYazicisi = new Yazici("OKUL", 7999999999999999999L,1899999999);
		String mesajOkul = "Merhaba arkadaslar.";
		okulYazicisi. ekranaYazdir(mesajOkul);
	}
}
