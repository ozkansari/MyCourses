package spark.template.freemarker.celal_sahin;

public class kitaplar {

	private int id;
	private String kitapAdi;
	private String yazarAdi;
	private String ySoyadi;
	private String yayinEvi;
	private int kitapFiyati;

	public static int ID = 1;

	// Source>Generate Constructor using fields
	public kitaplar(int id, String kitapAdi, String yazarAdi, String ySoyadi, String yayinEvi, int kitapFiyati) {
		this.setId(id);
		this.kitapAdi = kitapAdi;
		this.yazarAdi = yazarAdi;
		this.ySoyadi = ySoyadi;
		this.yayinEvi = yayinEvi;
		this.kitapFiyati = kitapFiyati;
	}
	// Source>Generate getters and setters

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getYazarAdi() {
		return yazarAdi;
	}

	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}

	public String getySoyadi() {
		return ySoyadi;
	}

	public void setySoyadi(String ySoyadi) {
		this.ySoyadi = ySoyadi;
	}

	public String getYayinEvi() {
		return yayinEvi;
	}

	public void setYayinEvi(String yayinEvi) {
		this.yayinEvi = yayinEvi;
	}

	public int getKitapFiyati() {
		return kitapFiyati;
	}

	public void setKitapFiyati(int kitapFiyati) {
		this.kitapFiyati = kitapFiyati;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
