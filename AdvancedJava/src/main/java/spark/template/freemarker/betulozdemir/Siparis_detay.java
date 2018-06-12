package spark.template.freemarker.betulozdemir;

/**
 * @author 
 *
 */
public class Siparis_detay {
	private String isim;
	private String email;
	private String adres;

	/**
	 * @param isim siparis detayi icin isim alinir
	 * @param email siparis detayi icin email alinir
	 * @param adres siparis detayi icin adres alinir
	 */
	public Siparis_detay(String isim, String email, String adres) {
		this.isim = isim;
		this.email = email;
		this.adres = adres;
	}

	/**
	 * @return string veri tipinde dondurur 
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
	 * @return string veri tipinde dondurur 
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
	 * @return string veri tipinde dondurur 
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
