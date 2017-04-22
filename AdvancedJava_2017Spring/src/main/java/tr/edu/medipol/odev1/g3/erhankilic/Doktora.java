package tr.edu.medipol.odev1.g3.erhankilic;

public class Doktora extends Ogrenci{

	public Doktora(String adSoyad, String tc, String bolum) {
		super(adSoyad, tc, bolum);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String ogrenciTipi() {
		// TODO Auto-generated method stub
		return "Doktora";
	}

}
