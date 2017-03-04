package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev1;


public class Galeri {
	public static void main(String[] args)
	{
		Car audi = new Car("Audi","A Serisi","A8",
				"Benzin","Otomatik","Sedan","6299 cc",2017);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+audi.TeknikOzellikler());
		
		Car mercedes = new Car("Mercedes-Benz","Maybach S Serisi","S 600",
				"Benzin","Otomatik","Sedan","5980 cc",2016);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+mercedes.TeknikOzellikler());
		
		Car ford = new Car("Ford","Focus","1.5 TDCi Trend X",
				"Dizel","Yar� Otomatik","Sedan","1499 cc",2015);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+ford.TeknikOzellikler());
		
		Car opel = new Car("Opel","Insignia","2.0 CDTI Cosmo",
				"Dizel","Otomatik","Sedan","1956 cc",2015);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+opel.TeknikOzellikler());
		
		Car renault = new Car("Renault","Clio","1.5 DCI Icon",
				"Dizel","Yar� Otomatik","Hatchback","1461 cc",2016);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+renault.TeknikOzellikler());
		
		Car volkswagen = new Car("Volkswagen","VW Serisi","CC 2.0 TDI", 
				"Dizel", "Yar� Otomatik","Coupe","1968 cc",2016);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+volkswagen.TeknikOzellikler());
		
		Car jaguar = new Car("Jaguar","XJ Serisi","3.0 D LWB Portfolio",
				"Dizel","Otomatik","Sedan","2993 cc",2015);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+jaguar.TeknikOzellikler());
		
		Car bmw = new Car("BMW","4 Serisi","418i Ultimate Sport",
				"Benzin","Otomatik","Coupe","1499 cc",2015);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+bmw.TeknikOzellikler());
		
		Car nissan = new Car("Nissan","X-Trail","1.6 dCi Platinum",
				"Dizel","Otomatik","SUV","1598 cc",2016);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+nissan.TeknikOzellikler());
		
		Car maserati = new Car("Maserati","Quattroporte","3.0 D",
				"Dizel","Yar� Otomatik","Sedan","2987 cc",2016);
		System.out.println("Araban�n Teknik �zellikleri:\n"
				+maserati.TeknikOzellikler());
		
	}

}
