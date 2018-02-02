package spark.template.freemarker.mertcanarici;
/**
 * Bu siniff urun �zellikleri tanimlar.
 * 
 * @author Mertcan Arici
 *
 */
public class Urun {
	/**
	 * @param id
	 * @param urunAdi
	 * @param fiyat
	 * @param ID = 1
	 * 
	 */
	private int id;
	private String urunAdi;
	private int fiyat;

	public static int ID = 1;

	/**
	 * Alanlar kullanilarak urun yapisi tanimlanir.
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
	 * Id icin getter tanimlanir.
	 * 
	 * @return id
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Id icin setter tanimlanir.
	 * 
	 * @param id
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * UrunAdi icin getter tanimlanir.
	 * 
	 * @return urunAdi
	 * 
	 */
	public String getUrunAdi() {
		return urunAdi;
	}

	/**
	 * UrunAdi icin setter tanimlanir.
	 * 
	 * @param urunAdi
	 * 
	 */
	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	/**
	 * Fiyat icin getter tanimlanir.
	 * 
	 * @return fiyat
	 * 
	 */
	public int getFiyat() {
		return fiyat;
	}

	/**
	 * 
	 * fiyat icin setter tanimlanir.
	 * 
	 * @param fiyat
	 * 
	 */
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}
}