package tr.edu.medipol.vize1.dogankoc;

public class Gomlek extends Giyim {

	public String urunKodu,fiyat,marka,model,beden,renk;
	
	public Gomlek(String id,String urunKodu,String fiyat,String marka,String model,String beden,String renk) {
		super(id, "G�mlek", urunKodu);
		this.urunKodu=urunKodu;
		this.fiyat=fiyat;
		this.marka=marka;
		this.model=model;
		this.beden=beden;
		this.renk=renk;
	}

}
