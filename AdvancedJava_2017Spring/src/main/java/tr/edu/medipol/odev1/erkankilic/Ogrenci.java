package tr.edu.medipol.odev1.erkankilic;

public abstract class Ogrenci {

	public String adSoyad,tc,bolum;
	public String getAdSoyad() {
		return adSoyad;
	}
	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getBolum() {
		return bolum;
	}
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	public  Ogrenci() {
		// TODO Auto-generated constructor stub
	}
	public Ogrenci(String adSoyad, String tc, String bolum) {
		super();
		this.adSoyad = adSoyad;
		this.tc = tc;
		this.bolum = bolum;
	}
	
	public abstract String ogrenciTipi();

}
