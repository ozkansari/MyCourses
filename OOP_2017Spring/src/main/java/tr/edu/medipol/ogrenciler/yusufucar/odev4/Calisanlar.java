package tr.edu.medipol.ogrenciler.yusufucar.odev4;


	public abstract class Calisanlar {
		protected String adSoyad;
			
			public Calisanlar(String calisanAd) {
				adSoyad = calisanAd;
			}
			
			public abstract String calisanTipi();
		}



