
package tr.edu.medipol.ogrenciler.yucelozalp.odev1;

/**
 *
 * @author yucel.ozalp
 */
public class Araba {
	private static final String NESNE_ADI = "ARABA";
	public String Marka;
	public String Model;
	public String Renk;
	public int Yil;
	public String YakitTuru;
	public int Fiyat;

	/**
	 * 
	 * @param Marka
	 * @param Model
	 * @param Renk
	 * @param Yil
	 * @param YakitTuru
	 * @param Fiyat
	 */

	public Araba(String Marka, String Model, String Renk, int Yil, String YakitTuru, int Fiyat) {
		super();
		this.Marka = Marka;
		this.Model = Model;
		this.Renk = Renk;
		this.Yil = Yil;
		this.YakitTuru = YakitTuru;
		this.Fiyat = Fiyat;

	}

	/**
	 * @param Mesaj
	 */

	public void ekranaYaz(String Mesaj) {
		System.out.print(
				NESNE_ADI + " " + Marka + " " + Model + " " + Renk + " " + Yil + " " + YakitTuru + " " + Fiyat + ": ");
		System.out.println(Mesaj);
		System.out.println("-------------");
	}

}
