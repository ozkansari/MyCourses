package tr.edu.medipol.vize1;

public class OgrenciProgrami {
  public static void main(String[] args) {
    Ogrenci ogrenci1 = 
	  new LisansOgrencisi("Ali Demir");
	System.out.println(ogrenci1.ogrenciTipi());
  }
}
abstract class Ogrenci {
  protected String adSoyad;
  public Ogrenci(String ogrenciAd) {
    adSoyad = ogrenciAd;
  }
  public abstract String ogrenciTipi();
}
// Eksik LisansOgrencisi sinifini yaziniz.

class LisansOgrencisi extends Ogrenci {

	public LisansOgrencisi(String ogrenciAd) {
		super(ogrenciAd);
	}

	@Override
	public String ogrenciTipi() {
		return "Lisans";
	}
	
}

