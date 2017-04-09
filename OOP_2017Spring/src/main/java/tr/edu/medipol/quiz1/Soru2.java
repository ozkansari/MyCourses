package tr.edu.medipol.quiz1;

public class Soru2 {
	public static void main(String[] args) {
		int sayac = 1;
		for(int i=0;i<10;i++)
			sayac = sayacYukselt(sayac);
		System.out.print(sayac + " ");
	}
	private static int sayacYukselt(int sayac) {
		sayac = sayac + 1;
		return sayac;
	}
}

