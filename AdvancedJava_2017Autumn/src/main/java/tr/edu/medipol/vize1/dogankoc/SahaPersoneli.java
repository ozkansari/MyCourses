package tr.edu.medipol.vize1.dogankoc;

public class SahaPersoneli extends Personel{

	String maas,bolum,ad,soyad,tc;
	public SahaPersoneli(){};
	public SahaPersoneli(String id,String bolum,String ad,String soyad,String tc) {
		super(id,bolum,ad,soyad,tc);
		this.maas=maas; this.bolum=bolum; this.ad=ad; this.soyad=soyad; this.tc=tc;
	}
	@Override
	public void finalize() {};

	public String getMaas(){
		return maas;		
	}
	public  String bolum(){
		return bolum;
	}

}
