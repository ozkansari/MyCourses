package tr.edu.medipol.ogrenciler.dogukandemir.odev1;


public class Galeri {

	public static void main(String[] args) {
		Cars Hy=new Cars("Hyundai","Tucson Elite Plus 1.6-T-GDI","205km/s","Otomatik","132 hp","12,1 saniye",2015);
		System.out.println("1.Arabanon ozellikleri:\n"+Hy.ozellikler());
		
		Cars Kia=new Cars("Kia","Sportage Concept Plus","170 km/s","Otomatik","132 hp","12,1 saniye",2014);
		System.out.println("\n2.Arabanon ozellikleri:\n"+Kia.ozellikler());
		
		Cars Toy=new Cars("Toyota","Corolla Touch 1.4","180 km/s","Otomatik","90 hp","14,7 saniye",2016);
		System.out.println("\n3.Arabanon ozellikleri:\n"+Toy.ozellikler());
		
		Cars Mazda=new Cars("Mazda","3 Sedan Soul","195 km/s","Manuel","120 hp","10,1 saniye",2016);
		System.out.println("\n4.Arabanon ozellikleri:\n"+Mazda.ozellikler());
		
		Cars Skoda=new Cars("Skoda","Superb Prestige 1.6","206 km/s","Otomatik","120 hp","11,0 saniye",2015);
		System.out.println("\n5.Arabanon ozellikleri:\n"+Skoda.ozellikler());
		
		Cars Volk=new Cars("Volkswagen","Passat Highline 1.6","206 km/s","Otomatik","120 hp","10,8 saniye",2015);
		System.out.println("\n6.Arabanon ozellikleri:\n"+Volk.ozellikler());
		
		Cars Reno=new Cars("Renault","Megane Sedan Icon 1.6","201 km/s","Manuel","130 hp","10,5 saniye",2016);
		System.out.println("\n7.Arabanon ozellikleri:\n"+Reno.ozellikler());
		
		Cars Ford=new Cars("Ford","Focus Titanium 1.6 ","201 km/s","Manuel","130 hp","10,9 saniye",2016);
		System.out.println("\n8.Arabanon ozellikleri:\n"+Ford.ozellikler());
		
		Cars Fiat=new Cars("Fiat","Egea Lounge 1.6","200 km/s","Otomatik","120 hp","9,8 saniye",2015);
		System.out.println("\n9.Arabanon ozellikleri:\n"+Fiat.ozellikler());
		
		Cars Toyota=new Cars("Toyota","Corolla Active 1.6","190 km/s","Otomatik","132 hp","10,0 saniye",2017);
		System.out.println("\n10.Arabanon ozellikleri:\n"+Toyota.ozellikler());
		
		}
	
		

}
