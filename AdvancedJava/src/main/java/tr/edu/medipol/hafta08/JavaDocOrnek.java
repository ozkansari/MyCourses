package tr.edu.medipol.hafta08;

/**
 * Sinif aciklamalari.... </br>
 * Ek  aciklamalar .....
 * 
 * @author OZKAN SARI
 *
 */
public class JavaDocOrnek {

	public static void main(String[] args) {
		JavaDocOrnek nesne = new JavaDocOrnek();
		
		nesne.islemYap("", 2);
	}
	
	/**
	 * Belirli islemleri sirasiyla gerceklestirir
	 * 
	 * @param parametre1 ... bilgisi
	 * @param parametre2 ... ikinci ek bilgi
	 * 
	 * @return islem basarili olduysa true doner, olmadiysa false doner
	 */
	public boolean islemYap(String parametre1, int parametre2) {
		// ....
		
		return true;
	}
	
}
