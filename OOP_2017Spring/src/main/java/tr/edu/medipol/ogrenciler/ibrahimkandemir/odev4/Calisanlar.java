package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev4;

public abstract class Calisanlar {
	protected String calisaninAdi;
	protected String calisanTC;
	protected String calisanSicilNo;	 
	protected String calisaninIseBas;
	protected String calisanTipi;
	protected String calisanMaas;
	
	public Calisanlar (String calisanAd,String calisanTc, String calisanSicil,String calisanIsBas,String calisanTipi, String calisanMaas){
		this.calisaninAdi=calisanAd;
		this.calisanTC=calisanTc;
		this.calisanSicilNo=calisanSicil;
		this.calisaninIseBas=calisanIsBas;
		this.calisanTipi=calisanTipi;
		this.calisanMaas=calisanMaas;

	}

}

