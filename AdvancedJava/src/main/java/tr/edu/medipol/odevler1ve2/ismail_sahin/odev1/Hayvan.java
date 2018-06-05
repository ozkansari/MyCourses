package tr.edu.medipol.odevler1ve2.ismail_sahin.odev1;

public class Hayvan {
	private int yas;
	private String isim,cinsiyet;
	
	public Hayvan(String isim, int yas) {
		this.isim = isim;
		this.yas = yas;
	}
	
	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}
	
	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
}
