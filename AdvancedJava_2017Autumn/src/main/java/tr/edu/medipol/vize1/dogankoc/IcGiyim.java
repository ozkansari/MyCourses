package tr.edu.medipol.vize1.dogankoc;

public class IcGiyim extends Giyim {

	public String urunKodu,fiyat,marka,beden,renk,cinsi;
	
	public IcGiyim(String id,String  urunKodu,String fiyat,String marka ,String beden,String renk,String cinsi) {
		super(id, "�� Giyim", urunKodu);
		this.urunKodu=urunKodu;
		this.fiyat=fiyat;
		this.marka=marka;
		this.beden=beden;
		this.renk=renk;
		this.cinsi=cinsi;
	}

}
