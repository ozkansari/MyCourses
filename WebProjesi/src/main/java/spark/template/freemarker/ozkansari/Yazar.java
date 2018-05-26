package spark.template.freemarker.ozkansari;

public class Yazar {
	private String yazarAdi;
	private String yazarSoyadi;
	
	public Yazar(String yazarAdi, String yazarSoyadi) {
		this.yazarAdi = yazarAdi;
		this.yazarSoyadi = yazarSoyadi;
	}
	
	public String getYazarAdi() {
		return yazarAdi;
	}
	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
	}
	public String getYazarSoyadi() {
		return yazarSoyadi;
	}
	public void setYazarSoyadi(String yazarSoyadi) {
		this.yazarSoyadi = yazarSoyadi;
	}
}
