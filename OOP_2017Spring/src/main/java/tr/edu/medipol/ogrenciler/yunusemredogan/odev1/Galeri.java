package tr.edu.medipol.ogrenciler.yunusemredogan.odev1;

public class Galeri {

	public static void main(String[] args) {
		Araba Honda = new Araba("Honda", "Civic", "Mavi", "23.400", 2013);
		System.out.println("1.Arabanın ozellikleri:\n" + Honda.ozellikler());

		Araba Mercedes = new Araba("Mercedes", "Cla", "Siyah", "56.400", 2006);
		System.out.println("2.Arabanın ozellikleri:\n" + Mercedes.ozellikler());

		Araba Bmw = new Araba("Bmw", "M5", "Beyaz", "8.000", 2016);
		System.out.println("3.Arabanın ozellikleri:\n" + Bmw.ozellikler());

		Araba Audi = new Araba("Audi", "A3", "Füme", "37.500", 2009);
		System.out.println("4.Arabanın ozellikleri:\n" + Audi.ozellikler());

		Araba Ford = new Araba("Ford", "Focus", "Gri", "130.520", 2011);
		System.out.println("5.Arabanın ozellikleri:\n" + Ford.ozellikler());

	}

}