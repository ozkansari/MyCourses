package spark.template.freemarker.yeslyuzemre;

public class Kitap {
	private String kitapAdi;
	private Yazar yazar;
	
	public Kitap(String kitapAdi, 
			String yazarAdi, String yazarSoyadi) {
		this.kitapAdi = kitapAdi;
		this.yazar = new Yazar(yazarAdi, yazarSoyadi);
	}
	
	public String getKitapAdi() {
		return kitapAdi;
	}
	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}
	public Yazar getYazar() {
		return yazar;
	}
	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}
}
