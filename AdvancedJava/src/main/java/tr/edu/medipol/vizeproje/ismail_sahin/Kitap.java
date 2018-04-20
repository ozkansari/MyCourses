package tr.edu.medipol.vizeproje.ismail_sahin;

public class Kitap {
	private YayinEvi kitapYayinEvi;
	private String kitapAdi;
	private String kitapYazari;
	private String kitapTuru;
	private int kitapSayfaSayisi;
	
	public Kitap() {
		
	}
	
	public Kitap(String kitapAdi, String kitapYazari, String kitapTuru, int kitapSayfaSayisi, YayinEvi kitapYayinEvi) {
		this.kitapAdi = kitapAdi;
		this.kitapYazari = kitapYazari;
		this.kitapTuru = kitapTuru;
		this.kitapSayfaSayisi = kitapSayfaSayisi;
		this.kitapYayinEvi = kitapYayinEvi;
	}
	
	public YayinEvi getKitapYayinEvi() {
		return kitapYayinEvi;
	}

	public void setKitapYayinEvi(YayinEvi kitapYayinEvi) {
		this.kitapYayinEvi = kitapYayinEvi;
	}

	public String getKitapAdi() {
		return kitapAdi;
	}

	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}

	public String getKitapYazari() {
		return kitapYazari;
	}

	public void setKitapYazari(String kitapYazari) {
		this.kitapYazari = kitapYazari;
	}

	public String getKitapTuru() {
		return kitapTuru;
	}

	public void setKitapTuru(String kitapTuru) {
		this.kitapTuru = kitapTuru;
	}

	public int getKitapSayfaSayisi() {
		return kitapSayfaSayisi;
	}

	public void setKitapSayfaSayisi(int kitapSayfaSayisi) {
		this.kitapSayfaSayisi = kitapSayfaSayisi;
	}
	
}
