package spark.template.freemarker.gamzenurkeskin;
/**
 * 
 * Bu s�n�f bir urunun alacagi �zellikleri olusturur.
 * 
 * @author Gamze Keskin
 *
 */
public class Urun {

	/**
	 * 
	 * @param id
	 * @param urunAdi
	 * @param fiyat
	 * 
	 */
	private int id;
	private String urunAdi;
	private int fiyat;

	/**
	 * 
	 * @param ID
	 * 
	 */
	public static int ID = 1;

	/**
	 * 
	 * Alanlari kullanarak bir urun olusturulur.
	 * 
	 * @param id
	 * @param urunAdi
	 * @param fiyat
	 * 
	 */
	public Urun(int id, String urunAdi, int fiyat) {
		this.id = id;
		this.urunAdi = urunAdi;
		this.fiyat = fiyat;
	}

	/**
	 * 
	 * Id getter olusturulur.
	 * 
	 * @return id
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * Id setter olusturulur.
	 * 
	 * @param id
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * UrunAdi getter olusturulur.
	 * 
	 * @return urunAdi
	 * 
	 */
	public String getUrunAdi() {
		return urunAdi;
	}

	/**
	 * 
	 * UrunAdi setter olusturulur.
	 * 
	 * @param urunAdi
	 * 
	 */
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	/**
	 * 
	 * Fiyat getter olusturulur.
	 * 
	 * @return fiyat
	 * 
	 */
	public int getFiyat() {
		return fiyat;
	}

	/**
	 * 
	 * fiyat setter olusturulur.
	 * 
	 * @param fiyat
	 * 
	 */
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
}