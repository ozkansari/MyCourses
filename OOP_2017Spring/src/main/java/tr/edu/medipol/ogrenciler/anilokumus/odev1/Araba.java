package tr.edu.medipol.ogrenciler.anilokumus.odev1;

public class Araba {

	public String Marka;
	public String Renk;
	public String Yakit;
	public int Yil;

	public Araba(String Marka, String Renk, int Yil, String Yakit) {
		this.Marka = Marka;
		this.Renk = Renk;
		this.Yil = Yil;
		this.Yakit = Yakit;

		System.out.print(Marka + " " + Renk + " " + Yil + " " + Yakit);

	}

	public String AOzellikler() {
		return "Marka: " + Marka + "Renk: " + Renk + "Yil: " + Yil + "Yakit :" + Yakit;
	}
}
