package tr.edu.medipol.ogrenciler.ismailsahin.odev4;

public class Gorevli extends Calisan {
	public Gorevli(String adSoyad,String calisanMaas){
		super(adSoyad,calisanMaas);
	}

	@Override
	public String calisanTipi() {
		return "Gorevli";
	}
	
}
