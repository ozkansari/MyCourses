package tr.edu.medipol.ogrenciler.ismailsahin.odev4;

public abstract class Calisan {
	protected String adSoyad;
	protected String maas;

	public Calisan(String adSoyad, String calisanMaas) {
		this.adSoyad = adSoyad;
		this.maas = calisanMaas;
	}

	public abstract String calisanTipi();
}
