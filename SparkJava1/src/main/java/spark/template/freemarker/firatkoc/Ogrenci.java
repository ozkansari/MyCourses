package spark.template.freemarker.firatkoc;


public class Ogrenci {

	public String adSoyad;
	public String bolum;

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public Ogrenci(String adSoyad, String bolum) {
		this.adSoyad = adSoyad;
		this.bolum = bolum;

	}
	public String ogrenciBilgileriAl() {
		return this.adSoyad + " - " + this.bolum;
	};
 }


