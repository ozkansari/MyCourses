package tr.edu.medipol.ogrenciler.ismailsahin.odev1;

public class Galeri {

	public static void main(String[] args) {
		Araba araba1 = new Araba(2009, 300000, "bmw");
		Araba araba2 = new Araba(1993, 3000, "tofaş");
		Araba araba3 = new Araba(2009, 100000, "ferrari");
		Araba araba4 = new Araba(2006, 17000, "citroen");
		Araba araba5 = new Araba(2016, 40000, "renault");
		Araba araba6 = new Araba(1999, 7000, "tofaş");
		Araba araba7 = new Araba(2015, 75000, "bmw");
		Araba araba8 = new Araba(2012, 30000, "volkswagen");
		Araba araba9 = new Araba(2000, 12000, "citroen");
		Araba araba10 = new Araba(2001, 17000, "dacia");

		System.out.println(
				"Araba Marka:" + araba1.markaAl() + " Model:" + araba1.modelAl() + " Fiyat:" + araba1.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba2.markaAl() + " Model:" + araba2.modelAl() + " Fiyat:" + araba2.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba3.markaAl() + " Model:" + araba3.modelAl() + " Fiyat:" + araba3.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba4.markaAl() + " Model:" + araba4.modelAl() + " Fiyat:" + araba4.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba5.markaAl() + " Model:" + araba5.modelAl() + " Fiyat:" + araba5.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba6.markaAl() + " Model:" + araba6.modelAl() + " Fiyat:" + araba6.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba7.markaAl() + " Model:" + araba7.modelAl() + " Fiyat:" + araba7.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba8.markaAl() + " Model:" + araba8.modelAl() + " Fiyat:" + araba8.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba9.markaAl() + " Model:" + araba9.modelAl() + " Fiyat:" + araba9.fiyatAl());
		System.out.println(
				"Araba Marka:" + araba10.markaAl() + " Model:" + araba10.modelAl() + " Fiyat:" + araba10.fiyatAl());
	}
}