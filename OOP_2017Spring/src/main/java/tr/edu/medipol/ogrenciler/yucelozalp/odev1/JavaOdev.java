package tr.edu.medipol.ogrenciler.yucelozalp.odev1;

public class JavaOdev {

	public static void main(String[] args) {

		System.out.println("* GALERİDE BULUNAN ARAÇLARIMIZ * \n");

		Araba bmw = new Araba("BMW", "i525", "Beyaz", 2017, "Benzin", 10000000);
		String BMW = "";
		bmw.ekranaYaz(BMW);

		Araba audi = new Araba("Audi", "A4", "Siyah", 2017, "Dizel", 20000000);
		String Audi = "";
		audi.ekranaYaz(Audi);

		Araba volvo = new Araba("Volvo", "S40", "Mavi", 2017, "Dizel", 2500000);
		String Volvo = "";
		volvo.ekranaYaz(Volvo);

		Araba as = new Araba("Aston Martin", "DB7", "Mavi", 2017, "Dizel", 2500000);
		String AS = "";
		volvo.ekranaYaz(AS);

		Araba bentley = new Araba("Bentley", "Arnage", "Mavi", 2017, "Dizel", 2500000);
		String Bentley = "";
		volvo.ekranaYaz(Bentley);

		Araba cadillac = new Araba("Cadillac", "BLS", "Mavi", 2017, "Dizel", 2500000);
		String Cadillac = "";
		volvo.ekranaYaz(Cadillac);

		Araba chevrolet = new Araba("Chevrolet", "Camaro", "Mavi", 2017, "Dizel", 2500000);
		String Chevrolet = "";
		volvo.ekranaYaz(Chevrolet);

		Araba chrysler = new Araba("Chrysler", "300 C", "Mavi", 2017, "Dizel", 2500000);
		String Chrysler = "";
		volvo.ekranaYaz(Chrysler);

		Araba ferrari = new Araba("Ferrari", "360", "Mavi", 2017, "Dizel", 2500000);
		String Ferrari = "";
		volvo.ekranaYaz(Ferrari);

		Araba avenger = new Araba("Dodge", "Avenger", "Mavi", 2017, "Dizel", 2500000);
		String Avenger = "";
		volvo.ekranaYaz(Avenger);
	}

}
