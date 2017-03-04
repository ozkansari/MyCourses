package tr.edu.medipol.ogrenciler.berkayyilmaz.odev1;


public class Araba {
	
	public String marka;
	public String model;
	public String kasa;
	public String motor;
	
	public Araba(String mrk,String model,String kasa,String motor)
	{
		this.marka=mrk;
		this.model=model;
		this.kasa=kasa;
		this.motor=motor;
		
	}
	
	public String Ozellikler(){
		return "Markasi: "+marka
				+"/nModel:"+model
				+"/nKasa:"+kasa
				+"/nMotor:" +motor;
	}

}

