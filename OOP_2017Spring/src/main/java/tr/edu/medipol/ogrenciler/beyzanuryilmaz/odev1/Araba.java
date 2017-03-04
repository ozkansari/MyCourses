package tr.edu.medipol.ogrenciler.beyzanuryilmaz.odev1;
public class Araba {
	
	public String marka;
	public String seri;
	public String renk;
	public String tip;
	
	public Araba(String mrk,String sr,String rnk,String tip)
	{
		this.marka=mrk;
		this.seri=sr;
		this.renk=rnk;
		this.tip=tip;
		
	}
	
	public String Ozellikler(){
		return "Markasi: "+marka
				+"/nSeri:"+seri
				+"/nRenk:"+renk
				+"/nTip:" +tip;
	}

}
