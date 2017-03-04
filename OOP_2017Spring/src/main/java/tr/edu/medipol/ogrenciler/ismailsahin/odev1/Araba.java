package tr.edu.medipol.ogrenciler.ismailsahin.odev1;

public class Araba {

	int model;
	int fiyat;
	String marka;

	public Araba(int model, int fiyat, String marka) {
		this.model = model;
		this.fiyat = fiyat;
		this.marka = marka;
	}

	public int modelAl() {
		return model;
	}

	public int fiyatAl() {
		return fiyat;
	}

	public String markaAl() {
		return marka;
	}
}
