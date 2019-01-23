package spark.template.freemarker.batuhankizil.finalproje.model;

import java.math.BigDecimal;

public class Siparis {
    private int siparis_id;
    private String kullanici_adi;
    private String urun_idler;
    private Double toplam_ucret;
    
    public Siparis(String kullanici_adi, String urun_idler, Double toplam_ucret) {
		super();
		this.kullanici_adi = kullanici_adi;
		this.urun_idler = urun_idler;
		this.toplam_ucret = toplam_ucret;
	}
    
    

	public Siparis(int siparis_id, String kullanici_adi, String urun_idler, Double toplam_ucret) {
		super();
		this.siparis_id = siparis_id;
		this.kullanici_adi = kullanici_adi;
		this.urun_idler = urun_idler;
		this.toplam_ucret = toplam_ucret;
	}



	public int getSiparis_id() {
        return siparis_id;
    }

    public void setSiparis_id(int siparis_id) {
        this.siparis_id = siparis_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getUrun_idler() {
        return urun_idler;
    }

    public void setUrun_idler(String urun_idler) {
        this.urun_idler = urun_idler;
    }

    public Double getToplam_ucret() {
        return toplam_ucret;
    }

    public void setToplam_ucret(Double toplam_ucret) {
        this.toplam_ucret = toplam_ucret;
    }
}
