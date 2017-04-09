package tr.edu.medipol.ogrenciler.dogankoc.odev4;


public class Teknisyen extends Personel {

	public Teknisyen(String sCn, String pS,String ads,String tcn,String grsy,String m,String acklm) {
		super(sCn, pS);
		   adsoyad=ads;
		   tcno=tcn;
		   girisYili=grsy;
		   maas=m;
		   aciklama=acklm;
		   sicilNo=sCn;
		   sinif=pS;
	}
	public String getTeknisyen() {
		return  super.personelSinifi+"\n"+"1)Sicil no:"+super.sicilno+" "+
				"2)Ad Soyad:"+adsoyad+" 3)TC No:"+tcno+"\n"+
				"4)��e Giri� Tarihi:"+girisYili+"  5)Ayl�k �cret:"+
				maas+"\n"+aciklama+"\n";
	}
	private String adsoyad;
    private String tcno;
    private String girisYili;
    private String maas;
    private String aciklama;
    private String sicilNo;
    private String sinif;

}
