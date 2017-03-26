package tr.edu.medipol.hafta5.grub_b;

public class YuksekLisansOgrencisi extends Ogrenci {

	public YuksekLisansOgrencisi(String ogrenciAd) {
		super(ogrenciAd);
	}

	@Override
	public String ogrenciTipi() {
		return "Yuksek L.";
	}

}
