package tr.edu.medipol.hafta9;

public class OzyinelemeOrnek {

	public static void main(String[] args) {
		String metin = "merhaba";
		System.out.println(yildizlandirDongusel(metin));
		System.out.println(yildizlandirOzyinelemeli(metin));
	}
	
	/**
	 * Parametre aldigi String'in her bir karakterinden sonra '*' ekleyerek yeni bir String olusturur ve sonucu doner.
	 * @param metin Parametre alinan karakter dizisi Or. "ahmet"
	 * @return her bir karakterden sonra yildiz eklenmis halini doner Or. "a*h*m*e*t"
	 */
	public static String yildizlandirDongusel(String metin) {
		String yeniMetin = "";
		for (int i = 0; i < metin.length(); i++) {
			yeniMetin += metin.charAt(i) + "*";
		}
		return yeniMetin;
	}
	
	/**
	 * Parametre aldigi String'in her bir karakterinden sonra '*' ekleyerek yeni bir String olusturur ve sonucu doner.
	 * @param metin Parametre alinan karakter dizisi Or. "ahmet"
	 * @return her bir karakterden sonra yildiz eklenmis halini doner Or. "a*h*m*e*t"
	 */
	public static String yildizlandirOzyinelemeli(String metin) {
		if (metin.length()<=0) {
			return "";
		}
		return metin.charAt(0) + "*" + yildizlandirOzyinelemeli(metin.substring(1));
	}
	
	
}
