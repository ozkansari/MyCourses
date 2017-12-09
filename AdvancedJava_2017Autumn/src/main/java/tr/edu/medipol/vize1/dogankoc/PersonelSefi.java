package tr.edu.medipol.vize1.dogankoc;

public class PersonelSefi extends Personel{
    public String id,ad,soyad,tc,yas,maas,bolum="Personel �efi";
	
	public PersonelSefi(String id,String ad,String soyad,String tc,String yas,String maas) {
		super(id,"Personel �efi",ad,soyad,tc);
		this.ad=ad; this.soyad=soyad; this.tc =tc; this.yas=yas; this.maas=maas;
	}
	@Override
	public void finalize() {};



}
