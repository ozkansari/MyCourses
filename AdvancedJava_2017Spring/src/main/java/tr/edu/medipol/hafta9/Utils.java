package tr.edu.medipol.hafta9;

import java.io.Closeable;
import java.io.IOException;

public class Utils {
	
	/**
	 * Baglanti kapatmak icin yardimci metod
	 * 
	 * @param c
	 * @return
	 */
	public static boolean baglantiKapat(Closeable c) {
		try {
			c.close();
		} catch (IOException e) {
			System.out.println("Baglanti kapatilirken beklenmeyen bir hata olustu!");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
