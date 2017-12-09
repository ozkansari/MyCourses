package tr.edu.medipol.vize1.dogankoc;

public class Firin extends Elektronik{

	public String seriNo,fiyat,marka,model,ozellikler;
	
	public Firin(String id,String seriNo,String fiyat,String marka,String model, String ozellikler) {
		super(id,seriNo ,"F�r�n", fiyat);
		this.fiyat=fiyat;
		this.seriNo=seriNo;
		this.ozellikler=ozellikler;
		this.marka=marka;
		this.model=model;
	}

}
