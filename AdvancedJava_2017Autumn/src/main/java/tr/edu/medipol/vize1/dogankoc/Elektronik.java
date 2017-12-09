package tr.edu.medipol.vize1.dogankoc;

public class Elektronik extends Urun{

	public String sinif,seriNo;
	
	public Elektronik(String id,String seriNo,String sinif,String fiyat) {
		super(id ,sinif,seriNo);
		this.sinif=sinif; 
		this.seriNo=seriNo;
	}
	
	

}
