package tr.edu.medipol.vize1.dogankoc;

public class Masa extends Mobilya{

	public String seriNo,fiyat,marka,model,renk,ozellikler;
	
	public Masa(String id, String seriNo, String fiyat,String marka,String model,String renk,String ozellikler) {
		super(id, "Masa", seriNo);
		this.seriNo=seriNo; this.fiyat=fiyat; this.marka=marka; this.model=model; this.renk=renk; this.ozellikler=ozellikler;
	}

}
