package tr.edu.medipol.vize1.muhammedkerimkilicoz;

public class IsciAna {

	public String Ad,Pozisyon,Yas;
	
	
	IsciAna(String ad,String yas)
	{
		setAd(ad);
		setYas(yas);
	
	}
	IsciAna(String ad,String yas,String pozisyon)
	{
		setAd(ad);
		setYas(yas);
		setPozisyon(pozisyon);

	}
	public void setAd(String ad)
	 {
		 Ad=ad;
	 }
	 public String getAd()
	 {
		return Ad;
		 
	 }
	public void setYas(String yas)
	 {		 
		 Yas=yas;
  
	 }
	 public String getYas()
	 {
		return Yas;		 
	 }
	 public void setPozisyon(String pozisyon)
	 {
		 Pozisyon=pozisyon;		  		  
	 }
	 public String getPozisyon()
	 {
		return Pozisyon;
				 
	 }

	
}
