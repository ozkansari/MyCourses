package tr.edu.medipol.ilerijava.ders01.lab1;

class Ogrenci /* extends Object */ {

	private String ogrenciAd;
	
	private int yas;
	
	private Adres adres;
	
	private String okul;
	
	public static int ogrenciSayisi = 0;

	public Ogrenci(int yas, String ogrenciAd, Adres adres) {
		super();
		this.yas = yas;
		this.ogrenciAd = ogrenciAd;
		this.adres = adres;
		this.okul = "MEDIPOL UNIVERSITESI";
		ogrenciSayisi++;
	}

	public Ogrenci(int yas, String ogrenciAd) {
		super();
		this.ogrenciAd = ogrenciAd;
		this.yas = yas;
		this.adres = new Adres("Kavacik", "gullu sokak");
		this.okul = "MEDIPOL UNIVERSITESI";
		ogrenciSayisi++;
	}

	public String getOgrenciAd() {
		return ogrenciAd;
	}
	
	public String getOgrenciAd(String etiket) {
		System.out.println(etiket + " " + ogrenciAd);
		return ogrenciAd;
	}

	@Override
	public String toString() {
		// return super.toString();
		return ogrenciAd + " " + yas + " " + adres;
	}
	
}
