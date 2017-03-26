package tr.edu.medipol.hafta5.grub_b;

public class LisansOgrencisi extends Ogrenci {

	public LisansOgrencisi(String ogrenciAd) {
		super(ogrenciAd);
	}

	@Override
	public String ogrenciTipi() {
		return "Lisans";
	}

}
