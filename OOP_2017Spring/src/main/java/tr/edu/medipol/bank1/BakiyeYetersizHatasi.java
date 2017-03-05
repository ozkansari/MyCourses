package tr.edu.medipol.bank1;

public class BakiyeYetersizHatasi extends Exception {

	private static final long serialVersionUID = 1L;
	
	private int mevcutBakiye;
	private int cekilmekIstenenMiktar;

	public BakiyeYetersizHatasi(int bal, int w_amt) {
		mevcutBakiye = bal;
		cekilmekIstenenMiktar = w_amt;
	}

	public String toString() {
		return "Cekmek istediginiz miktar (" + cekilmekIstenenMiktar + ") bakiyenizden daha fazla (" + mevcutBakiye
				+ "). Islem gerceklestirilemedi.";
	}
}
