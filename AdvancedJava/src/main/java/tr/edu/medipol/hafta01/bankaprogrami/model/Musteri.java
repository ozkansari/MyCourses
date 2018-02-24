package tr.edu.medipol.hafta01.bankaprogrami.model;

public class Musteri {

	public final static String MILLET =
			"TURKIYE";
	
	private String ad;
	private BankaHesabi bh;
	public Musteri() {
		this.ad = "Yonetici";
	}
	
	public Musteri(String ad) {
		this.ad = ad;
		this.bh = new BankaHesabi();
	}
	public String getAd() {
		return ad;
	}
	
}
class BankaHesabi {
	
}

