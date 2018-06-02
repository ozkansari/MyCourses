
package spark.template.freemarker.betulozdemir;

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

	// Source>Generate Constructor using fields
	/**
	 * @param id kitap ekle için id alınır
	 * @param urunAdi kitap ekle için urunadi alınır
	 * @param fiyat kitap ekle için fiyat alınır
	 * @param urunDetayi kitap ekle için urundetayi alınır
	 */
	public Kitap(int id, String urunAdi, int fiyat, String urunDetayi) {
		this.id = id;
		this.kitapAdi = urunAdi;
		this.fiyat = fiyat;
		this.kitapDetayi = urunDetayi;
	}

	// Source>Generate getters and setters
	/**
	 * @return sonuç integer veri tipinde döndürür 
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
	 * @return string veri tipinde döndürür 
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
	 * @return integer veri tipinde döndürür 
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
	 * @return string veri tipinde döndürür 
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

	public void add(Kitap kitap) {
		// TODO Auto-generated method stub
		

	
	}

}
