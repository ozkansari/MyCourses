package tr.edu.medipol.ogrenciler.cihangunacti.odev1;


public class Galeri {

	public static void main(String[] args) {
		Cars bmw=new Cars("BMW","316i M Sport","1598 cc","Yaro Otomotik","Benzin",2014);
		System.out.println("1.Arabanon Teknik ozellikleri:\n"+bmw.ozellikler());
		
		Cars audi=new Cars("Audi","3.0 TDI Quattro Long ","2501 - 3000 cm3","Otomotik","Dizel",2012);
		System.out.println("\n2.Arabanon Teknik ozellikleri:\n"+audi.ozellikler());
		
		Cars mercedes=new Cars("Mercedes","  S 350 BlueTEC 4Matic 7G-Tronic ","2987 cc","Yaro Otomatik","Dizel",2016);
		System.out.println("\n3.Arabanon Teknik ozellikleri:\n"+mercedes.ozellikler());
		
		Cars bugatti=new Cars("Bugatti","18/4 Veyron ","6001 cm3 ve ozeri","Otomatik","Benzin",2016);
		System.out.println("\n4.Arabanon Teknik ozellikleri:\n"+bugatti.ozellikler());
		
		Cars porsche=new Cars("Porsche 911","Turbo","3501 - 4000 cm3","Otomatik","Benzin",2010);
		System.out.println("\n5.Arabanon Teknik ozellikleri:\n"+porsche.ozellikler());
		
		Cars ferrari=new Cars("Ferrari","F430","4308 cc","Otomatik","Benzin",2019);
		System.out.println("\n6.Arabanon Teknik ozellikleri:\n"+ferrari.ozellikler());
		
		Cars gt=new Cars("Ford","5.0 GT","4501 - 5000 cm3","Manuel","Benzin",2011);
		System.out.println("\n7.Arabanon Teknik ozellikleri:\n"+gt.ozellikler());
		
		Cars tofas=new Cars("Tofao","SLX","1581 cc","Manuel","Benzin",1994);
		System.out.println("\n8.Arabanon Teknik ozellikleri:\n"+tofas.ozellikler());
		
		Cars fiat=new Cars("Fiat","1.3 Multijet Pop","1248 cc","Manuel","Dizel",2015);
		System.out.println("\n9.Arabanon Teknik ozellikleri:\n"+fiat.ozellikler());
		
		Cars volkswagen=new Cars("Volkswagen","1.6 TDi BlueMotion Comfortline","1598 cc","Manuel","Dizel",2014);
		System.out.println("\n10.Arabanon Teknik ozellikleri:\n"+volkswagen.ozellikler());
		
		
		
		
		}
	
		

}
