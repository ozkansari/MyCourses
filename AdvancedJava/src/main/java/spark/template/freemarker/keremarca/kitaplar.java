package spark.template.freemarker.keremarca;

/**
 * 
 * Bu sinif kitaplar icin get set degerleri olusturur
 * 
 * @author Kerem Arca
 *
 */

public class kitaplar {

	private int id;
	private String ad;
	private String yazar_ad;
	private String yazar_soyad;
	private String yayinevi;
	private int fiyat;
	
	public kitaplar(int id, String ad, String yazar_ad, String yazar_soyad, String yayinevi, int fiyat) {
		this.id = id;
		this.ad = ad;
		this.yazar_ad = yazar_ad;
		this.yazar_soyad = yazar_soyad;
		this.yayinevi = yayinevi;
		this.fiyat = fiyat;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getYazar_ad() {
		return yazar_ad;
	}
	public void setYazar_ad(String yazar_ad) {
		this.yazar_ad = yazar_ad;
	}
	public String getYazar_soyad() {
		return yazar_soyad;
	}
	public void setYazar_soyad(String yazar_soyad) {
		this.yazar_soyad = yazar_soyad;
	}
	public String getYayinevi() {
		return yayinevi;
	}
	public void setYayinevi(String yayinevi) {
		this.yayinevi = yayinevi;
	}
	public int getFiyat() {
		return fiyat;
	}
	public void setFiyat(int fiyat) {
		this.fiyat = fiyat;
	}

}
