package tr.edu.medipol.vize1.dogankoc;

public class Giyim extends Urun{

	String cinsi;
	
	public Giyim(String id,String cinsi,String urunKodu) {
		super(id, cinsi,urunKodu);
		this.cinsi=cinsi;
	}

}
