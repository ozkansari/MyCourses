package tr.edu.medipol.vizeproje.burak_karatepe;

public class Kitap {
    private String adi="";
    private String yazar="";
    private int sayfa=0;
    private Yayinevi yayinevi=new Yayinevi();
    
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getYazar() {
		return yazar;
	}
	public void setYazar(String yazar) {
		this.yazar = yazar;
	}
	public int getSayfa() {
		return sayfa;
	}
	public void setSayfa(int sayfa) {
		this.sayfa = sayfa;
	}
	public Yayinevi getYayinevi() {
		return yayinevi;
	}
	public void setYayinevi(Yayinevi yayinevi) {
		this.yayinevi = yayinevi;
	}
}
