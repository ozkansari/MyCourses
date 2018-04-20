package tr.edu.medipol.vizeproje.ismail_sahin;

public class YayinEvi {
	private String yayinEviAdi;
	private String yayinEviEPosta;
	
	public YayinEvi() {
		
	}

	public YayinEvi(String yayinEviAdi) {
		this.yayinEviAdi = yayinEviAdi;
	}
	
	public YayinEvi(String yayinEviAdi, String yayinEviEPosta) {
		this.yayinEviAdi = yayinEviAdi;
		this.yayinEviEPosta = yayinEviEPosta;
	}
	
	public String getYayinEviAdi() {
		return yayinEviAdi;
	}
	public void setYayinEviAdi(String yayinEviAdi) {
		this.yayinEviAdi = yayinEviAdi;
	}
	public String getYayinEviEPosta() {
		return yayinEviEPosta;
	}
	public void setYayinEviEPosta(String yayinEviEPosta) {
		this.yayinEviEPosta = yayinEviEPosta;
	}
}
