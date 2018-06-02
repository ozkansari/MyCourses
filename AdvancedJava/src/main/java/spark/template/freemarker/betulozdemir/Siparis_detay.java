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
	 * @param isim sipariş detayı için isim alınır
	 * @param email sipariş detayı için email alınır
	 * @param adres sipariş detayı için adres alınır
	 */
	public Siparis_detay(String isim, String email, String adres) {
		this.isim = isim;
		this.email = email;
		this.adres = adres;
	}

	/**
	 * @return string veri tipinde döndürür 
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
	 * @return string veri tipinde döndürür 
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
	 * @return string veri tipinde döndürür 
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
