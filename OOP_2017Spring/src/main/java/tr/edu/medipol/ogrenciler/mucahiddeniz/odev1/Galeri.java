package tr.edu.medipol.ogrenciler.mucahiddeniz.odev1;


public class Galeri {
	public static void main(String[] args){
		
		Araba a1 = new Araba("Audi", "A6", "K�rm�z�", "Otomatik", "Benzin", 2016, 4, 15);
		Araba a2 = new Araba("BMW", "X3", "Beyaz", "Manuel", "Dizel", 2015, 4, 30);
		Araba a3 = new Araba("Citroen", "SaXo", "Mavi", "Manuel", "Benzin", 2009, 2, 25);
		Araba a4 = new Araba("Alfa Romeo", "4C", "Gri", "Manuel", "Benzin", 2009, 2, 25);
		Araba a5 = new Araba("Honda", "Civic", "Beyaz", "Otomatik", "Benzin", 2016, 4, 5);
		Araba a6 = new Araba("Isuzu", "Gemini", "Sar�", "Manuel", "Benzin", 2001, 4, 100);
		Araba a7 = new Araba("Jaguar", "XE", "Gri", "Otomatik", "Dizel", 2015, 4, 8);
		Araba a8 = new Araba("Mercedes", "GLS", "Siyah", "Otomatik", "Dizel", 2016, 4, 30);
		Araba a9 = new Araba("Seat", "Toledo", "Turuncu", "Manuel", "Benzin", 2012, 4, 5);
		Araba a10 = new Araba("Toyota", "CH-R", "Beyaz", "Manuel", "Benzin", 2017, 4, 0);
			System.out.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
		,a1.marka,a1.model,a1.renk,a1.vites,a1.yakitTipi,a1.yil,a1.kapiSayisi,a1.km);
		System.err.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a2.marka,a2.model,a2.renk,a2.vites,a2.yakitTipi,a2.yil,a2.kapiSayisi,a2.km);
		System.out.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a3.marka,a3.model,a3.renk,a3.vites,a3.yakitTipi,a3.yil,a3.kapiSayisi,a3.km);
		System.err.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a4.marka,a4.model,a4.renk,a4.vites,a4.yakitTipi,a4.yil,a4.kapiSayisi,a4.km);
		System.out.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a5.marka,a5.model,a5.renk,a5.vites,a5.yakitTipi,a5.yil,a5.kapiSayisi,a5.km); 
		System.err.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a6.marka,a6.model,a6.renk,a6.vites,a6.yakitTipi,a6.yil,a6.kapiSayisi,a6.km);
		System.out.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a7.marka,a7.model,a7.renk,a7.vites,a7.yakitTipi,a7.yil,a7.kapiSayisi,a7.km);
		System.err.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a8.marka,a8.model,a8.renk,a8.vites,a8.yakitTipi,a8.yil,a8.kapiSayisi,a8.km);
		System.out.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a9.marka,a9.model,a9.renk,a9.vites,a9.yakitTipi,a9.yil,a9.kapiSayisi,a9.km);
		System.err.printf("Marka: %s - Model : %s - Renk: %s - Vites Tipi : %s - Yak�t Tipi: %s - Y�l: %d - Kap� Say�s�: %d, KM: %f\n"
				,a10.marka,a10.model,a10.renk,a10.vites,a10.yakitTipi,a10.yil,a10.kapiSayisi,a10.km);
	
	a1.calistir();
	a1.stopEttir();
	
	}
}
