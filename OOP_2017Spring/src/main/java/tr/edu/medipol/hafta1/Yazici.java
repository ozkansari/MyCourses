package tr.edu.medipol.hafta1;

/**
 * 
 * @author ozkansari
 *
 */
public class Yazici {
	
	private static final String NESNE_ADI = "YAZICI";
	private String yaziciAdi;
	private long seriNo;
	private int kapasite;

	/**
	 * 
	 * @param yaziciAdi
	 * @param seriNo
	 * @param kapasite
	 */
	public Yazici(String yaziciAdi, long seriNo, int kapasite) {
		super();
		this.yaziciAdi = yaziciAdi;
		this.seriNo = seriNo;
		this.kapasite = kapasite;
	}

	/**
	 * @param mesaj
	 */
	public void ekranaYazdir(String mesaj) {
		System.out.print(NESNE_ADI + " " + yaziciAdi + ": ");
		System.out.println(mesaj);
		System.out.println("Mesaj sonu .........");
	}

	/* ----------------------------------------------------- */
	/* DEGER VERICI METODLAR (SETTER & GETTER ) */
	/* ----------------------------------------------------- */
	
	public void setYaziciAdi(String yaziciAdi) {
		this.yaziciAdi = yaziciAdi;
	}

	public void setKapasite(int kapasite) {
		this.kapasite = kapasite;
	}

	public String getYaziciAdi() {
		return yaziciAdi;
	}

	public long getSeriNo() {
		return seriNo;
	}

	public int getKapasite() {
		return kapasite;
	}
}
