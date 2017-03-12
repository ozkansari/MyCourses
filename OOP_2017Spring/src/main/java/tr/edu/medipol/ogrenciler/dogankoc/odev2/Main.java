package tr.edu.medipol.ogrenciler.dogankoc.odev2;

public class Main {
	public static void main(String[] args) {
		String[] Text2 = new String[4];
		Text2[0] = "a";
		Text2[2] = "c";
		Text2[1] = "b";
		Text2[3] = "a";

		String a = "a";
		Finder o = new Finder();
		int sonuc = o.fosa(Text2, a);
		System.out.println(sonuc);

		String[][] Text = new String[][] { { "dasdas", "3213a2", "sasdcs", "123" },
				{ "brthrb", "cazxcz", "mnbbkl", "12", "snoopy" } };
		int i, j;
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 3; j++) {
				System.out.printf("[%d][%d]=%s   ", i, j, Text[i][j]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.print("Yukarıdaki İki boyutlu Dizi içinde,");

		String[] b = new String[] { "brthrb", "3213a2", "123", "12", "snoopy" };
		Finder o2 = new Finder();
		int sonuc2 = o2.fodsa(Text, b);
		System.out.printf("String[] b dizisi içindeki karakterler:%d kere vardır", sonuc2);

	}
}
