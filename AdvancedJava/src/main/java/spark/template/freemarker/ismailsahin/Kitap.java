package spark.template.freemarker.ismailsahin;

/**
 * Kitap bilgisi verileri tutar.
 * @author bilgisayar
 *
 */
public class Kitap {
	private String kitapAdi;
	private String yazar;
	private int id, fiyat,sayfaSayisi;
	
	/**
	 * Kitap objesi constructor�
	 * @param id kitap id
	 * @param kitapAdi kitap adi
	 * @param yazar yazar adi
	 * @param fiyat fiyat
	 * @param sayfaSayisi sayfa sayisi
	 */
	public Kitap(int id, String kitapAdi, String yazar, int fiyat, int sayfaSayisi) {
		super();
		this.id = id;
		this.kitapAdi = kitapAdi;
		this.yazar = yazar;
		this.fiyat = fiyat;
		this.sayfaSayisi = sayfaSayisi;
	}

	/**
	 * Kitap adi doner
	 * @return kitap
	 */
	public String getKitapAdi() {
		return kitapAdi;
	}

	/**
	 * Kitap adi ayarlar
	 * @param kitapAdi kitap adi
	 */
	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	/**
	 * Yazar adi doner
	 * @return
	 */
	public String getYazar() {
		return yazar;
	}

	/**
	 * Yazar adi ayarlar
	 * @param yazar
	 */
	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	/**
	 * Fiyat bilgisi doner
	 * @return
	 */
	public int getFiyat() {
		return fiyat;
	}

	/**
	 * Fiyat bilgisi ayarlar
	 * @param fiyat
	 */
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

	/**
	 * Sayfa say�s� doner
	 * @return
	 */
	public int getSayfaSayisi() {
		return sayfaSayisi;
	}

	/**
	 * Sayfa say�s� ayarlar
	 * @param sayfaSayisi
	 */
	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}

	/**
	 * Kitap Id doner..
	 * @return
	 */
	public int getId() {
		return id;
	}
	
}