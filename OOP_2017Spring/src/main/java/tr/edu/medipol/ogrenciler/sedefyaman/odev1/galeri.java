package tr.edu.medipol.ogrenciler.sedefyaman.odev1;

public class galeri {
	public static void main(String[] args){
		araba bmw=new araba("BMW", "2002", "Beyaz", "Z4", "Cabriolet");
		System.out.println("Araban�n �zellikleri: \n"+bmw.Ozellikler());
		
		araba audi=new araba("AUDI", "2013", "Mavi", "RS5", "Coupe");
		System.out.println("Araban�n �zellikleri: \n"+audi.Ozellikler());

		araba honda=new araba("HONDA", "2003", "Gri", "That S", "Minivan");
		System.out.println("Araban�n �zellikleri: \n"+honda.Ozellikler());

		araba toyota=new araba("TOYOTA", "1995", "Sar�", "Mega Cruiser", "Jeep");
		System.out.println("Araban�n �zellikleri: \n"+toyota.Ozellikler());
		
		araba jaguar=new araba("JAGUAR", "1994", "Beyaz", "XJS Coupe", "Coupe");
		System.out.println("Araban�n �zellikleri: \n"+jaguar.Ozellikler());
		
		araba mercedes=new araba("MERCEDES", "2015", "Siyah", "Benz G", "Jeep - Cabriolet");
		System.out.println("Araban�n �zellikleri: \n"+mercedes.Ozellikler());
		
		araba opel=new araba("OPEL", "1977", "Kahverengi", "Manta", "Hatchback");
		System.out.println("Araban�n �zellikleri: \n"+opel.Ozellikler());
		
		araba ford=new araba("FORD", "1975", "Mavi", "Taunus", "Sedan");
		System.out.println("Araban�n �zellikleri: \n"+ford.Ozellikler());
		
		araba volkswagen=new araba("WOLKSWAGEN", "2008", "Siyah", "Passat CC", "Coupe");
		System.out.println("Araban�n �zellikleri: \n"+volkswagen.Ozellikler());
		
		araba mini=new araba("M�N�", "2003", "Pembe", "Coupe", "Hatchback");
		System.out.println("Araban�n �zellikleri: \n"+mini.Ozellikler());
		
	}
	

}
