package tr.edu.medipol.ogrenciler.sedefyaman.odev1;

public class araba {
	
	public String marka;
	public int yil;
	public String renk;
	public String model;
	public String tip;
	
	public araba(String marka, String yil, String renk, String model, String tip){
		this.marka=marka;
		this.yil=Integer.valueOf(yil);
		this.renk=renk;
		this.model=model;
		this.tip=tip;
	}
	public String Ozellikler(){
		return "Marka: "+marka
				+"\nY�l: "+yil
				+"\nRenk: "+renk
				+"\nModel: "+model
				+"\nTip: "+tip;
		 
	}
}
