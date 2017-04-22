package tr.edu.medipol.odev2.g5.recepefemayoglu;

public class Lisans extends Ogrenci {

	public Lisans(String ad, String soyad) {
		super(ad, soyad);
		// TODO Auto-generated constructor stub
	}
	public Lisans(String ad, String soyad,String bolum) {
		super(ad, soyad,bolum);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String ogrenciTipi() {
		// TODO Auto-generated method stub
		return "Lisans";
	}

}
