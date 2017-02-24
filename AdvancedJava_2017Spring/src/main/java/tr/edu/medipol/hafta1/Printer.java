package tr.edu.medipol.hafta1;

/**
 * Printer ekrana yazdirir
 * 
 * @author ozkansari
 *
 */
//Javada her sinif otomatik olarak Object sinifindan turer
public class Printer /* extends Object */ { 

	private static boolean yazmaIslemiMevcut = false;
	private int bekleyenIslem = 0;
	private String marka;
	
	// CONSTRUCTOR(S) -------------
	public Printer(String marka) {
		super();
		this.marka = marka;
	}

	/**
	 * Ekrana yazdirir
	 * @param mesaj  yazdirilacak mesaj
	 * @return yazdirma islemi basarili mi
	 */
	public boolean print(String mesaj){
		bekleyenIslem += 1;
		while(yazmaIslemiMevcut) {
			System.out.println(marka + ": Bekliyor ..");
		}
		yazmaOperasyonu(mesaj);
		bekleyenIslem -= 1;
		return true;
	}
	/**
	 * @param mesaj
	 */
	private void yazmaOperasyonu(String mesaj) {
		yazmaIslemiMevcut = true;
		System.out.print(marka+":");
		System.out.println(mesaj);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		yazmaIslemiMevcut = false;
	}
	// GETTER(S) AND SETTER(S) -------------
	public String getMarka() {
		return marka;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Printer arg0printer = (Printer) arg0;
		// return this.getMarka().equals(arg0printer.getMarka());
		return this.getMarka() == arg0printer.getMarka();
	}

	@Override
	public String toString() {
		return "My tostring: Printer [bekleyenIslem=" + bekleyenIslem + ", marka=" + marka + "]";
	}

}
