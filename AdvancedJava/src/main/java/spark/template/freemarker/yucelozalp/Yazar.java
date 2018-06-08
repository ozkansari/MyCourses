package spark.template.freemarker.yucelozalp;

// TODO: Auto-generated Javadoc
/**
 * The Class Yazar.
 */
public class Yazar {
	
	/** The yazar adi. */
	private String yazarAdi;
	
	/** The yazar soyadi. */
	private String yazarSoyadi;
	
	/**
	 * Instantiates a new yazar.
	 *
	 * @param yazarAdi the yazar adi
	 * @param yazarSoyadi the yazar soyadi
	 */
	public Yazar(String yazarAdi, String yazarSoyadi) {
		this.yazarAdi = yazarAdi;
		this.yazarSoyadi = yazarSoyadi;
	}
	
	/**
	 * Gets the yazar adi.
	 *
	 * @return the yazar adi
	 */
	public String getYazarAdi() {
		return yazarAdi;
	}
	
	/**
	 * Sets the yazar adi.
	 *
	 * @param yazarAdi the new yazar adi
	 */
	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}
	
	/**
	 * Gets the yazar soyadi.
	 *
	 * @return the yazar soyadi
	 */
	public String getYazarSoyadi() {
		return yazarSoyadi;
	}
	
	/**
	 * Sets the yazar soyadi.
	 *
	 * @param yazarSoyadi the new yazar soyadi
	 */
	public void setYazarSoyadi(String yazarSoyadi) {
		this.yazarSoyadi = yazarSoyadi;
	}
}
