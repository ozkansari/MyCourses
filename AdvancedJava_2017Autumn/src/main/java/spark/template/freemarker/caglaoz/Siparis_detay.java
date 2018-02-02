package spark.template.freemarker.caglaoz;

/**
 * @author �a�la
 *
 */
public class Siparis_detay {
	private String isim;
	private String email;
	private String adres;

	/**
	 * @param isim sipari� detay� i�in isim al�n�r
	 * @param email sipari� detay� i�in email al�n�r
	 * @param adres sipari� detay� i�in adres al�n�r
	 */
	public Siparis_detay(String isim, String email, String adres) {
		this.isim = isim;
		this.email = email;
		this.adres = adres;
	}

	/**
	 * @return string veri tipinde d�nd�r�r 
	 */
	public String getIsim() {
		return isim;
	}

	/**
	 * @param isim
	 */
	public void setIsim(String isim) {
		this.isim = isim;
	}

	/**
	 * @return string veri tipinde d�nd�r�r 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return string veri tipinde d�nd�r�r 
	 */
	public String getAdres() {
		return adres;
	}

	/**
	 * @param adres
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

}