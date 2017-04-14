package tr.edu.medipol.hafta8.urettuket;

import java.util.Date;

public class UreticiThread implements Runnable {
	private UrunStokKutusu stok = null;
	private int donguSayisi;
	public UreticiThread(UrunStokKutusu stok, int donguSayisi) {
		this.donguSayisi = donguSayisi;
		this.stok = stok;
	}
	public void run() {
		
		for(int i=0;i<donguSayisi;i++) {
			
			while(stok.size() > TuketUretProgrami.MAKS_BOYUT) {
				try {
					synchronized (stok) {
						System.out.println("Uretici bekliyor.... Stok dolu.");
						stok.wait();
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			String item = new Date().toString();
			uret();
			System.out.println("Uretti: " + item); 
			
			try {
				synchronized (stok) {
					stok.add(item);
					stok.notifyAll();
				}					
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		System.out.println("Uretici Thread tamamlandi...");
		
	}

	/**
	 * 
	 */
	private void uret() {
		try {
			System.out.println("Uretici uretiyor...");
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
