package tr.edu.medipol.odev;

public class OgrenciYuksekLisans extends Ogrenci {

	public OgrenciYuksekLisans(String ogrenciNo, String ogrenciAd) {
		super(ogrenciNo, ogrenciAd);
	}

	@Override
	public String ogrenciTipi() {
		return "Yuksek L.";
	}

}
