package tr.edu.medipol.vize1.dogankoc;

public class ReyonPersoneli extends SahaPersoneli{
	
	public String ad, soyad, tc, yas, maas,bolum="Reyon Personeli";
	public ReyonPersoneli(String id,String ad,String soyad,String tc,String yas,String maas){
		 super(id,"Reyon Personeli",ad, soyad, tc);
		 this.ad=ad; this.soyad=soyad; this.tc =tc; this.yas=yas; this.maas=maas;
	}
	
	public   String getBolum(){
		return "Reyon Personeli";
	}
}
