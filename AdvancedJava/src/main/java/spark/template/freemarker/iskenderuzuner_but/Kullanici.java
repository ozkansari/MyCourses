package spark.template.freemarker.iskenderuzuner_but;

public class Kullanici {
	int id,yas;
	String adi,sifre,cinsiyet;
	public Kullanici(int id, int yas, String adi, String sifre, String cinsiyet) {
		super();
		this.id = id;
		this.yas = yas;
		this.adi = adi;
		this.sifre = sifre;
		this.cinsiyet = cinsiyet;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
}
