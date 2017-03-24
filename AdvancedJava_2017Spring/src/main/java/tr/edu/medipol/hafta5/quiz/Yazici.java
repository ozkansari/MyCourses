package tr.edu.medipol.hafta5.quiz;
import java.util.*;
public class Yazici {
	public static void main(String[] args) {
		soru1();soru2();soru3(y3);
	}
	private static void soru1() {
		System.out.println(y1.equals(y2)); 
	}
	private static void soru2() {
		yazicilar.add(y1);
		yazicilar.add(new Yazici("dell"));
		System.out.println(yazicilar.contains(y1));
	}
	private static void soru3(Yazici eklenecek) {
		List<Yazici> yazicilar = new ArrayList<>();
		yazicilar.add(eklenecek);
		System.out.println(yazicilar.size());
	}
	private static List<Yazici> yazicilar = new ArrayList<>();
	private static Yazici y1 = new Yazici("hp");
	private static Yazici y2 = new Yazici("hp");
	private static Yazici y3 = new Yazici("samsung");
	private String ad;
	public Yazici(String ad){  
		this.ad = ad;
	}
	public boolean equals(Yazici diger) {
		return this.ad.equals(diger.ad);
	}
}
