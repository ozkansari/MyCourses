package tr.edu.medipol.hafta8.urettuket;

public class TuketUretProgrami {

	public static int MAKS_BOYUT = 10;
	public static int DONGU_SAYISI = 100;
	
	public static void main(String args[]) {
		UrunStokKutusu stokKutusu = new UrunStokKutusu(MAKS_BOYUT);
		
		UreticiThread producer = new UreticiThread(stokKutusu, DONGU_SAYISI);
		TuketiciThread consumer = new TuketiciThread(stokKutusu, DONGU_SAYISI);
		
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		
		t1.start();
		t2.start();
	}

}
