package spark.template.freemarker.aysenur_yildiz;

public class Siparis {
	private String isim;
	private String email;
	private String adress;
	/**
	 * @param isim 
	 * @param email 
	 * @param adres
	 */
	public Siparis(String isim, String email, String adress) {
		this.isim = isim;
		this.email = email;
		this.adress = adress;
	}
	/**
	 * @return string  
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
	 * @return string 
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
	 * @return string 
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
}
