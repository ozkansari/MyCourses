package tr.edu.medipol.hafta8.urettuket;

import java.util.PriorityQueue;

public class UrunStokKutusu extends PriorityQueue<String> {
	private static final long serialVersionUID = 1L;
	public UrunStokKutusu(int maksUrun){
		super(maksUrun);
	}
	@Override
	public synchronized boolean add(String e) {
		return super.add(e);
	}
	@Override
	public synchronized String poll() {
		return super.poll();
	}	
}
