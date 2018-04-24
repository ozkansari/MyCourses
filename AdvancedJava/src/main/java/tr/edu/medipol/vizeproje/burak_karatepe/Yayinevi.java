package tr.edu.medipol.vizeproje.burak_karatepe;

public class Yayinevi {
	private String ad="";
	private String eposta="";
	private int id=1;
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
	public String getEposta() {
		return eposta;
	}
	public void setEposta(String eposta) {
		this.eposta = eposta;
	}
	public String toString() {
        return this.ad;
    }
}

