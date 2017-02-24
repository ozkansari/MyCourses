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
	
	// OBJECT METODLARI -------------
	
	@Override
	public boolean equals(Object otherObj) {
		
		if (otherObj instanceof Printer) { // 
			
			Printer otherPrinter = (Printer) otherObj;
			//  return this.getMarka() == otherPrinter.getMarka(); // == nesnelerin memoryde ayni yeri tutup tutmadigini kontrol eder.
			return this.getMarka().equals(otherPrinter.getMarka()); 
			
		} else {
			return this.equals(otherObj);
		}
		
		
	}

	@Override
	public String toString() {
		return "My tostring: Printer [bekleyenIslem=" + bekleyenIslem + ", marka=" + marka + "]";
	}
	
	// GETTER VE SETTER METODLARI -------------
	public String getMarka() {
		return marka;
	}
}
