package tr.edu.medipol.odev;

public class OgrenciLisans extends Ogrenci {

	public OgrenciLisans(String ogrenciNo, String ogrenciAd) {
		super(ogrenciNo, ogrenciAd);
	}

	@Override
	public String ogrenciTipi() {
		return "Lisans";
	}

}
