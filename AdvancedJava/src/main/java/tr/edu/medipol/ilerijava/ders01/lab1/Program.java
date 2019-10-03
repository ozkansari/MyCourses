package tr.edu.medipol.ilerijava.ders01.lab1;

public class Program {

	public static void main(String[] args) {
		
		Ogrenci ogr1 = new Ogrenci(20,"ahmet");
		System.out.println(ogr1.getOgrenciAd());
		System.out.println(ogr1);
		
		Adres adres = new Adres("FSM mah", "Hercai sokak");
		Ogrenci ogr2 = new Ogrenci(22,"neslihan", adres );
		System.out.println(ogr2);
		
		System.out.println(Ogrenci.ogrenciSayisi);
		
	}

}
