package tr.edu.medipol.vize1.dogankoc;

public class Mudur extends Personel{
	
	public String ad,soyad,tc,yas, maas,bolum="M�d�r";
	
	public Mudur(String id,String ad,String soyad,String tc,String yas,String maas){
		super(id,"M�d�r",ad,soyad,tc);
		this.ad=ad; this.soyad=soyad; this.tc =tc; this.yas=yas; this.maas=maas;
	}
	@Override
	public void finalize() {};

}
