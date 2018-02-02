package spark.template.freemarker.caglaoz;

/**
 * @author �a�la
 *
 */
public class Urun {
	private int id;
	private String urunAdi;
	private int fiyat;
	private String urunDetayi;

	public static int ID = 1;

	// Source>Generate Constructor using fields
	/**
	 * @param id �r�n ekle i�in id al�n�r
	 * @param urunAdi �r�n ekle i�in urunadi al�n�r
	 * @param fiyat �r�n ekle i�in fiyat al�n�r
	 * @param urunDetayi �r�n ekle i�in urundetayi al�n�r
	 */
	public Urun(int id, String urunAdi, int fiyat, String urunDetayi) {
		this.id = id;
		this.urunAdi = urunAdi;
		this.fiyat = fiyat;
		this.urunDetayi = urunDetayi;
	}

	// Source>Generate getters and setters
	/**
	 * @return sonu� integer veri tipinde d�nd�r�r 
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
	 * @return string veri tipinde d�nd�r�r 
	 */
	public String getUrunAdi() {
		return urunAdi;
	}

	/**
	 * @param urunAdi
	 */
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	/**
	 * @return integer veri tipinde d�nd�r�r 
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
	 * @return string veri tipinde d�nd�r�r 
	 */
	public String getUrunDetayi() {
		return urunDetayi;
	}

	/**
	 * @param urunDetayi
	 */
	public void setUrunDetayi(String urunDetayi) {
		this.urunDetayi = urunDetayi;
	}
	
}