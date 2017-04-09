package tr.edu.medipol.ogrenciler.mucahiddeniz.odev3;


import java.util.ArrayList;
import java.util.List;
public class Ogrenci {
	
	String adSoyad;
	String not;
	public static List<Ogrenci> cocuklar = new ArrayList<>();
	
	public Ogrenci(String adSoyad, String not){
		this.adSoyad = adSoyad;
		this.not = not;
	}
	
	public static void ogrenciListele(){
		int i=0;
		while(i<cocuklar.size()){
			Ogrenci n = cocuklar.get(i);
			System.out.println("Ad� ve Soyad�: "+n.adSoyad+" - Notu: "+n.not);
			i++;
		}
	}

}
