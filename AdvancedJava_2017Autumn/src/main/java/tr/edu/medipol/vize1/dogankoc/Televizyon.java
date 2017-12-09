package tr.edu.medipol.vize1.dogankoc;

public class Televizyon extends Elektronik{

	public String seriNo,fiyat,marka,model,ozellikler;
	
	public Televizyon(String id,String seriNo, String fiyat,String marka,String model,String ozellikler) {
		super(id,seriNo ,"Televizyon", fiyat);
		this.seriNo=seriNo;
		this.fiyat=fiyat;
		this.ozellikler=ozellikler;
		this.marka=marka; 
		this.model=model; 
	}

}
