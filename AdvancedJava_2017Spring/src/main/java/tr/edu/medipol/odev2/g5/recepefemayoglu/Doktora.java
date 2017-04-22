package tr.edu.medipol.odev2.g5.recepefemayoglu;

public class Doktora extends Ogrenci {

	public Doktora(String ad, String soyad) {
		super(ad, soyad);
		// TODO Auto-generated constructor stub
	
	}
	public Doktora(String ad, String soyad,String bolum) {
		super(ad, soyad,bolum);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String ogrenciTipi() {
		// TODO Auto-generated method stub
		return "Doktora";
	}

}
