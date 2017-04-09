package tr.edu.medipol.ogrenciler.dogankoc.odev4;
public class Saha extends Personel {

	public String adsoyad;
	public String tcno;
	public String girisYili;
	public String maas;
	public String aciklama;
 
  //!!constructer da ilk super olmassa hata...	
    

    public Saha(String sCn, String pSnf,String ads,String tcn,String grsyl,String mss,String acklm){
    	super(sCn,pSnf);
    	adsoyad=ads; tcno=tcn; girisYili=grsyl; maas=mss;  aciklama=acklm;
    }
	public String getEleman() {
		return  super.personelSinifi+"\n"+"1)Sicil no:"+super.sicilno+" "+
				"2)Ad Soyad:"+adsoyad+" 3)TC No:"+tcno+"\n"+
				"4)��e Giri� Tarihi:"+girisYili+"  5)Ayl�k �cret:"+
				maas+"\n"+aciklama+"\n";
	}
}
