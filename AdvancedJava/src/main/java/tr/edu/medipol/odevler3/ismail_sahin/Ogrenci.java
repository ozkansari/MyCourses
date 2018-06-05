package tr.edu.medipol.odevler3.ismail_sahin;

/**
 * ��renci bilgisini tutan s�n�f..
 * @author bilgisayar
 *
 */
public class Ogrenci {
	private int id,girisYili;
	private String OgrenciAdiSoyadi,Bolumu;
	
	/**
	 * Ogrenci s�n�f� constructor'�.
	 * @param id - ogrenciId
	 * @param girisYili - giris y�l�
	 * @param ogrenciAdiSoyadi - ad� ve soyad�
	 * @param bolumu - bolumu
	 */
	public Ogrenci(int id, int girisYili, String ogrenciAdiSoyadi, String bolumu) {
		this.id = id;
		this.girisYili = girisYili;
		this.OgrenciAdiSoyadi = ogrenciAdiSoyadi;
		this.Bolumu = bolumu;
	}
	
	/**
	 * Ogrenci �d'sini d�ner.
	 * @return ogrenciId
	 */
	public int getId() {
		return id;
	}
	/**
	 * Giris yilini d�ner.
	 * @return girisYili
	 */
	public int getGirisYili() {
		return girisYili;
	}
	
	/**
	 * Ogrenci Ad� ve soyad�n� doner.
	 * @return ogrenciAdiSoyadi
	 */
	public String getOgrenciAdiSoyadi() {
		return OgrenciAdiSoyadi;
	}
	
	/**
	 * Ogrenci bolumu doner.
	 * @return Bolumu
	 */
	public String getBolumu() {
		return Bolumu;
	}
	
}
