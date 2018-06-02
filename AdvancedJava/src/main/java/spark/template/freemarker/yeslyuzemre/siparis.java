package spark.template.freemarker.yeslyuzemre;

public class siparis{
	private String kitapAdi;
	private Yazar yazar;
	private String siparis;
	
	public siparis(int siparisid, 
			String siparisverenadı, String siparısverenadress) {
		this.siparis=siparis;
		this.yazar = new Yazar(siparisverenadı, siparısverenadress);
	}
	
	public String getsiparisıd() {
		return siparis;
	}
	public void setsiparis(String siparisıd) {
		this.siparis = siparis;
	}
	public Yazar getYazar() {
		return yazar;
	}
	public void setYazar(Yazar yazar) {
		this.yazar = yazar;
	}
		public String getKitapAdi() {
			return kitapAdi;
		}
		public void setKitapAdi(String kitapAdi) {
			this.kitapAdi = kitapAdi;
		}
}
