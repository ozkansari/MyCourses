package tr.edu.medipol.ogrenciler.didemlaloglu.odev1;

/*
Araba Classında km,model,renk,vitesTipi,fiyat,karOrani özellikleri var. 
SatisFiyati diye bir fonksiyonu var bu fonksiyon aracın kar oranı ve satış fiyatını çarparak gerçek fiyatı döndürüyor.
Altta da main e sahip bir class var o class da 10 tane araba tanımladım ve konsola arabanın modelini, 
rengini ve satış fiyatını yazdırdım, 
 */
public class Main {
	public static void main(String[] args) {
		// Araba 1
		Araba arabam = new Araba();
		arabam.marka = "Ford";
		arabam.renk = "Mavi";
		arabam.fiyat = 10000;
		arabam.vitesTipi = "Otomatik";
		System.out
				.println("Marka " + arabam.marka + " Renk " + arabam.renk + " Aracin fiyati :" + arabam.satisFiyati());
		// Araba 2
		Araba arabam2 = new Araba();
		arabam2.marka = "Honda";
		arabam2.renk = "Gri";
		arabam2.fiyat = 15000;
		arabam2.vitesTipi = "Otomatik";
		System.out.println(
				"Marka " + arabam2.marka + ", Renk " + arabam2.renk + ", Aracin fiyati :" + arabam2.satisFiyati());
		// Araba 3
		Araba arabam3 = new Araba();
		arabam3.marka = "Mercedes";
		arabam3.renk = "Beyaz";
		arabam3.fiyat = 19000;
		arabam3.vitesTipi = "Otomatik";
		System.out.println(
				"Marka " + arabam3.marka + ", Renk " + arabam3.renk + ", Aracin fiyati :" + arabam3.satisFiyati());
		// Araba 4
		Araba arabam4 = new Araba();
		arabam4.marka = "BMW";
		arabam4.renk = "Bordo";
		arabam4.fiyat = 150000;
		arabam4.vitesTipi = "Manuel";
		System.out.println(
				"Marka " + arabam4.marka + ", Renk " + arabam4.renk + ", Aracin fiyati :" + arabam4.satisFiyati());
		// Araba 5
		Araba arabam5 = new Araba();
		arabam5.marka = "Ford";
		arabam5.renk = "Mavi";
		arabam5.fiyat = 10000;
		arabam5.vitesTipi = "Otomatik";
		System.out.println(
				"Marka " + arabam5.marka + ", Renk " + arabam5.renk + ", Aracin fiyati :" + arabam5.satisFiyati());
		// Araba 6
		Araba arabam6 = new Araba();
		arabam6.marka = "Honda";
		arabam6.renk = "Gri";
		arabam6.fiyat = 15000;
		arabam6.vitesTipi = "Otomatik";
		System.out.println(
				"Marka " + arabam6.marka + ", Renk " + arabam6.renk + ", Aracin fiyati :" + arabam6.satisFiyati());
		// Araba 7
		Araba arabam7 = new Araba();
		arabam7.marka = "Mercedes";
		arabam7.renk = "Mor";
		arabam7.fiyat = 19000;
		arabam7.vitesTipi = "Otomatik";
		System.out.println(
				"Marka " + arabam7.marka + ", Renk " + arabam7.renk + ", Aracin fiyati :" + arabam7.satisFiyati());
		// Araba 8
		Araba arabam8 = new Araba();
		arabam8.marka = "BMW";
		arabam8.renk = "Bordo";
		arabam8.fiyat = 150000;
		arabam8.vitesTipi = "Manuel";
		System.out.println(
				"Marka " + arabam8.marka + ", Renk " + arabam8.renk + ", Aracin fiyati :" + arabam8.satisFiyati());
		// Araba 9
		Araba arabam9 = new Araba();
		arabam9.marka = "Toyota";
		arabam9.renk = "Beyaz";
		arabam9.fiyat = 190000;
		arabam9.vitesTipi = "Otomatik";
		System.out.println(
				"Marka " + arabam9.marka + ", Renk " + arabam9.renk + ", Aracin fiyati :" + arabam9.satisFiyati());
		// Araba 10
		Araba arabam10 = new Araba();
		arabam10.marka = "Nissan";
		arabam10.renk = "Yeşil";
		arabam10.fiyat = 150000;
		arabam10.vitesTipi = "Manuel";
		System.out.println(
				"Marka " + arabam10.marka + ", Renk " + arabam10.renk + ", Aracin fiyati :" + arabam10.satisFiyati());
	}
}
