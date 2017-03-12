package tr.edu.medipol.ogrenciler.furkansametkeles.odev1;

public class araba {
	int model;
	int fiyat;
	String marka;

	public araba(int model, int fiyat, String marka) {
		this.model = model;
		this.fiyat = fiyat;
		this.marka = marka;
	}

	public int modeli() {

		return model;
	}

	public int fiyati() {
		return fiyat;
	}

	public String markasi() {
		return marka;
	}

}