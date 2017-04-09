package tr.edu.medipol.ogrenciler.anilokumus.odev4;


	public abstract class Calisan{
		protected String adSoyad;
		protected String calisanYil;
		
		public Calisan(String CalisanAd,String CalisanYil) {
			adSoyad = CalisanAd;
			calisanYil=CalisanYil;
		}
		public abstract String calisanTipi();
	}