package tr.edu.medipol.hafta4.arayuz;

public class DirKomutu implements Komut {

	@Override
	public void komutCalistir() {
		System.out.println(komutBilgisi());
	}

	@Override
	public String komutBilgisi() {
		return "dir";
	}

}
