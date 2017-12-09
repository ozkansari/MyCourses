package tr.edu.medipol.vize1.dogankoc;

public class Stajyer extends Personel{

	public String id,ad,soyad,tc,yas,maas,bolum="Stajyer";
	
	public Stajyer(String id,String ad,String soyad,String tc,String yas,String maas){
		 super(id, "Stajyer",ad,soyad,tc);
		 this.id=id;this.ad=ad;this.soyad=soyad;this.tc=tc;this.yas=yas;this.maas=maas;
	}

}
