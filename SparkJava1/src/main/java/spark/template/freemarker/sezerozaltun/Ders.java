package spark.template.freemarker.sezerozaltun;

public class Ders {
	public String dersAdi;
	public String dersTipi;
	public String dersNo;
	
	public Ders(String dersNo , String dersAdi, String dersTipi )
	{
		this.dersAdi = dersAdi;
		this.dersTipi = dersTipi;
		this.dersNo = dersNo;
		
	}
	public String dersBilgileriniAl() {
		return this.dersNo + " - " + this.dersAdi + " - " + this.dersTipi;
	};
	public String dersBilgileriniAl(boolean ekstraBilgi) {
		return "";
	}

}
