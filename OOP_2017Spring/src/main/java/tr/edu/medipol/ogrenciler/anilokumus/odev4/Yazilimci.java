package tr.edu.medipol.ogrenciler.anilokumus.odev4;


public class Yazilimci extends Calisan {
	
	public Yazilimci(String CalisanAd,String CalisanYil){
		super(CalisanAd,CalisanYil);
	}
	
	@Override
	public String calisanTipi(){
		return "Yazilimci";
		
	}

}
