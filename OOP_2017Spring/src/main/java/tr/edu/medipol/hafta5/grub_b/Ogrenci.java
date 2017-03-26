package tr.edu.medipol.hafta5.grub_b;

public abstract class Ogrenci {
	protected String adSoyad;
	
	public Ogrenci(String ogrenciAd) {
		adSoyad = ogrenciAd;
	}
	
	public abstract String ogrenciTipi();
}
