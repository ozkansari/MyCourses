package tr.edu.medipol.odevler2.keremarca.setget;

public class ogrenciSetGet {

	private int id;
	private String adsoyad;
	private String bolum;
	private String girisyili;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdsoyad() {
		return adsoyad;
	}
	public void setAdsoyad(String adsoyad) {
		this.adsoyad = adsoyad;
	}
	public String getBolum() {
		return bolum;
	}
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	public String getGirisyili() {
		return girisyili;
	}
	public void setGirisyili(String girisyili) {
		this.girisyili = girisyili;
	}
	
	public String toString() {
		return adsoyad + " " + bolum + " " + girisyili + " ";
	}
	
}
