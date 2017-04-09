package tr.edu.medipol.ogrenciler.yunusemredogan.odev1;

public class Araba {
	public String marka;
	public String model;
	public String renk;
	public String km;
	public int yil;

	public Araba(String marka, String model, String renk, String km, int yil) {
		this.marka = marka;
		this.model = model;
		this.renk = renk;
		this.km = km;
		this.yil = yil;
	}

	public String ozellikler() {
		return "Marka: " + marka + "\nModel: " + model + "\nRenk: " + renk + "\nKm:" + km + "\nYil: " + yil;
	}
}