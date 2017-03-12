package tr.edu.medipol.ogrenciler.erdemakturan.odev1;

public class Araba {

	int model;
	int ucret;

	String marka;

	public Araba(int model, int ucret, String marka) {

		this.model = model;
		this.ucret = ucret;
		this.marka = marka;
	}

	public int modelAlimi() {

		return model;
	}

	public int ucretAlimi() {

		return ucret;
	}

	public String markaAlimi() {

		return marka;
	}

}
