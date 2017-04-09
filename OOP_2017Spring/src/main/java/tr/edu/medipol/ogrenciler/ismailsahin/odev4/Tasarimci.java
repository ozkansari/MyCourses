package tr.edu.medipol.ogrenciler.ismailsahin.odev4;

public class Tasarimci extends Calisan {
	public Tasarimci(String adSoyad,String calisanMaas){
		super(adSoyad,calisanMaas);
	}

	@Override
	public String calisanTipi() {
		return "Tasarimci";
	}
	
}
