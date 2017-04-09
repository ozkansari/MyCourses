package tr.edu.medipol.ogrenciler.yusufucar.odev4;

public class Guvenlik extends Calisanlar {

	public Guvenlik(String calisanAd) {
		super(calisanAd);
	}

	@Override
	public String calisanTipi() {
		return "Guvenlik";
	}

}