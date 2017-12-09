package tr.edu.medipol.vize1.dogankoc;

public class Ceket extends Giyim{

	public String urunKodu,fiyat,marka,model,beden,renk;
	
	public Ceket(String id,String urunKodu  ,String fiyat,String marka,String model,String beden,String renk) {
		super(id, "Ceket", urunKodu);
		this.urunKodu=urunKodu;
		this.fiyat=fiyat;
		this.marka=marka;
		this.model=model;
		this.beden=beden;
		this.renk=renk;
	}

}
