package tr.edu.medipol.vize1.dogankoc;

public class DepoPersoneli extends SahaPersoneli{
	public String ad, soyad, tc, yas, maas="Depo Personeli";
	
	public DepoPersoneli(String id,String ad,String soyad,String tc,String yas,String maas){
		 super(id,getBolum(),ad,soyad,tc);
		 this.ad=ad; this.soyad=soyad; this.tc =tc; this.yas=yas; this.maas=maas;
	}
	
	public static String getBolum(){
		return "Depo Personeli";
	}
}
