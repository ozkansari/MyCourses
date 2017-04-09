package tr.edu.medipol.ogrenciler.didemlaloglu.odev1;

public class Araba {
	String marka;
	String renk;
	String vitesTipi;
	double karOrani = 15;
	double fiyat;
	double km;

	public double satisFiyati() {
		double toplamFiyat;
		toplamFiyat = fiyat + fiyat * karOrani;
		return toplamFiyat;
	}
}
