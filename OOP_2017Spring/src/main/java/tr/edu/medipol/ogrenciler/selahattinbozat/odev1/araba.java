package tr.edu.medipol.ogrenciler.selahattinbozat.odev1;

public class araba {
	public String Marka;
	public String Model;
	public String Yol;
	public String Yakit;
	public String Vites;
	public String Km;
	public String Renk;
	public String KasaTipi;
	
	public araba(String Marka,String Model,String Yol,String Yakit,String Vites,String Km,String Renk,String KasaTipi  )
	
	{
		this.Marka=Marka;
		this.Model=Model;
		this.Yol=Yol;
		this.Yakit=Yakit;
		this.Vites=Vites;
		this.Km=Km;
		this.Renk=Renk;
		this.KasaTipi=KasaTipi;
		System.out.println(Marka+ " Marka \n"+Model+" Model \n"+Yol+" Yakit\n"+Yakit+" Yak�t \n"+Vites+" Vites \n"+Km+" Km \n"+Renk+" Renk \n"+KasaTipi+" Kasa Tipi \n");
	}
	
	public String ozellikler()
	{
		return "Marka :" + Marka + "Model :" + Model + "Yol :" + Yol + "Yakit :" + Yakit + " Vites :" + Vites +  " Km :" + Km + "Renk :" + Renk + "KasaTipi :" + KasaTipi ;
	}
	
	
}
