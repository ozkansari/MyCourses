package tr.edu.medipol.vize1.dogankoc;

public class SatisSorumlusu extends SahaPersoneli{
	public String id,ad,soyad,tc,yas,maas,bolum="Sat�� Sorumlusu";
	public SatisSorumlusu(String id, String ad, String soyad, String tc,String yas, String maas) {
		super(id,getBolum(),ad,soyad,tc);
		this.ad=ad; this.soyad=soyad; this.tc =tc; this.yas=yas; this.maas=maas;
	}
	private static String getBolum(){
		return "Sat�� Sorumlusu";
	}

}
