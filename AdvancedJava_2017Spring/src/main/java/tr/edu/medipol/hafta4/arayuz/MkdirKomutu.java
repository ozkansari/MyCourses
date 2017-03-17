package tr.edu.medipol.hafta4.arayuz;

public class MkdirKomutu implements Komut {

	@Override
	public void komutCalistir() {
		System.out.println(komutBilgisi());
	}

	@Override
	public String komutBilgisi() {
		return "mkdir";
	}

}
