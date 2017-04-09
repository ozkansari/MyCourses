package tr.edu.medipol.ogrenciler.muhammetaktas.odev1;

public class galeri {

	public static void main(String[] args) {
		cars audi=new cars("audi","a3",2014,"Siyah");
		cars bmw=new cars("bmw","a4",2015,"Beyaz");
		cars reno=new cars("reno","brodway",2000,"beyaz");
		cars fiat=new cars("fiat","egea",2010,"mavi");
		cars seat=new cars("seat","leon",2012,"beyaz");
		cars citroen=new cars("citroen","C4",2009,"lacivert");
		cars dacia=new cars("dacia","logan",2009,"beyaz");
		cars hyundai=new cars("hyundai","getz",2006,"beyaz");
		cars tofas=new cars("tofas","Sahin",2001,"beyaz");
		cars honda=new cars("honda","civic",2008,"beyaz");
		System.out.println("1.Arabanin ozellikleri:\n"+audi.arabaOzellikleri());
		System.out.println("2.Arabanin ozellikleri:\n"+bmw.arabaOzellikleri());
		System.out.println("3.Arabanin ozellikleri:\n"+reno.arabaOzellikleri());
		System.out.println("4.Arabanin ozellikleri:\n"+fiat.arabaOzellikleri());
		System.out.println("5.Arabanin ozellikleri:\n"+seat.arabaOzellikleri());
		System.out.println("6.Arabanin ozellikleri:\n"+citroen.arabaOzellikleri());
		System.out.println("7.Arabanin ozellikleri:\n"+dacia.arabaOzellikleri());
		System.out.println("8.Arabanin ozellikleri:\n"+hyundai.arabaOzellikleri());
		System.out.println("9.Arabanin ozellikleri:\n"+tofas.arabaOzellikleri());
		System.out.println("10.Arabanin ozellikleri:\n"+honda.arabaOzellikleri());

	}

}
