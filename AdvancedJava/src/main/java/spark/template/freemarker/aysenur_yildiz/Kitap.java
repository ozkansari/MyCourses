package spark.template.freemarker.aysenur_yildiz;

/**
 * @author 
 *
 */
public class Kitap {
	private int id;
	private String kitapAdi;
	private int fiyat;
	private String kitapDetayi;
	public static int ID = 1;
	/**
	 * @param id 
	 * @param urunAdi 
	 * @param fiyat
	 * @param urunDetayi
	 */
	public Kitap(int id, String urunlerAdi, int fiyat, String urunlerDetayi) {
		this.id = id;
		this.kitapAdi = urunlerAdi;
		this.fiyat = fiyat;
		this.kitapDetayi = urunlerDetayi;
	}
	/**
	 * @return integer 
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return string 
	 */
	public String getkitapAdi() {
		return kitapAdi;
	}

	/**
	 * @param urunAdi
	 */
	public void setkitapAdi(String urunAdi) {
		this.kitapAdi = urunAdi;
	}
	/**
	 * @return integer 
	 */
	public int getFiyat() {
		return fiyat;
	}
	/**
	 * @param fiyat
	 */
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
	/**
	 * @return string 
	 */
	public String getkitapDetayi() {
		return kitapDetayi;
	}
	/**
	 * @param urunDetayi
	 */
	public void setkitapDetayi(String urunDetayi) {
		this.kitapDetayi = kitapDetayi;
	}
}
