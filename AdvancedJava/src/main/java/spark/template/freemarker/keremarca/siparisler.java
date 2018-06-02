package spark.template.freemarker.keremarca;

/**
 * 
 * Bu sinif siparisler icin get set degerleri olusturur
 * 
 * @author Kerem Arca
 *
 */

public class siparisler {
	
	private int id;
	private String siparis_veren;
	private int toplam_ucret;
	
	public siparisler(int id,String siparis_veren, int toplam_ucret) {
		this.id = id;
		this.siparis_veren = siparis_veren;
		this.toplam_ucret = toplam_ucret;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSiparis_veren() {
		return siparis_veren;
	}
	public void setSiparis_veren(String siparis_veren) {
		this.siparis_veren = siparis_veren;
	}
	public int getToplam_ucret() {
		return toplam_ucret;
	}
	public void setToplam_ucret(int toplam_ucret) {
		this.toplam_ucret = toplam_ucret;
	}

}
