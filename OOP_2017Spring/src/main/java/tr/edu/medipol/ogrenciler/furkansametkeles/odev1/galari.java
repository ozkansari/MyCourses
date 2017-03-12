package tr.edu.medipol.ogrenciler.furkansametkeles.odev1;

//ozkans Kod derlenmiyordu duzeltildi
public class galari {
	public static void main(String[] args) {

		araba araba_1 = new araba(2001, 25000, "bentley");
		araba araba_2 = new araba(1990, 3000, "murat 131");
		araba araba_3 = new araba(2016, 90000, "megane");
		araba araba_4 = new araba(1999, 4000, "Sahin");
		araba araba_5 = new araba(2010, 100000, "bmw");
		araba araba_6 = new araba(2016, 500000, "bugatti");
		araba araba_7 = new araba(2010, 20000, "chevrolet");
		araba araba_8 = new araba(2011, 10000, "dacia");
		araba araba_9 = new araba(1998, 42000, "dodge");
		araba araba_10 = new araba(2000, 12000, "cadillac");

		System.out.println(
				"araba marka:" + araba_1.markasi() + "Model:" + araba_1.modeli() + "fiyat:" + araba_1.fiyati());
		System.out.println(
				"araba marka:" + araba_2.markasi() + "Model:" + araba_2.modeli() + "fiyat:" + araba_2.fiyati());
		System.out.println(
				"araba marka:" + araba_3.markasi() + "Model:" + araba_3.modeli() + "fiyat:" + araba_3.fiyati());
		System.out.println(
				"araba marka:" + araba_4.markasi() + "Model:" + araba_4.modeli() + "fiyat:" + araba_4.fiyati());
		System.out.println(
				"araba marka:" + araba_5.markasi() + "Model:" + araba_5.modeli() + "fiyat:" + araba_5.fiyati());
		System.out.println(
				"araba marka:" + araba_6.markasi() + "Model:" + araba_6.modeli() + "fiyat:" + araba_6.fiyati());
		System.out.println(
				"araba marka:" + araba_7.markasi() + "Model:" + araba_7.modeli() + "fiyat:" + araba_7.fiyati());
		System.out.println(
				"araba marka:" + araba_8.markasi() + "Model:" + araba_8.modeli() + "fiyat:" + araba_8.fiyati());
		System.out.println(
				"araba marka:" + araba_9.markasi() + "Model:" + araba_9.modeli() + "fiyat:" + araba_9.fiyati());
		System.out.println(
				"araba marka:" + araba_10.markasi() + "Model:" + araba_10.modeli() + "fiyat:" + araba_10.fiyati());

	}
}