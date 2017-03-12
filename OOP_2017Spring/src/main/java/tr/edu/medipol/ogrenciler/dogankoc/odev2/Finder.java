package tr.edu.medipol.ogrenciler.dogankoc.odev2;

public class Finder {
	// findOfStringArray
	public int fosa(String[] ss, String a) {
		int sayac = 0;
		for (int i = 0; i < ss.length; i++) {
			if (ss[i] == a) // ozkans: ss[i].equals(a) daha dogru olur
				sayac++;
		}
		return sayac;
	}

	// ozkans:
	// degiskenlere daha iyi isim vermeli, ss? b?
	// method kendini aciklayici olmali
	public int fodsa(String[][] ss, String[] b) {
		int sayac2 = 0;
		for (int k = 0; k < b.length; k++) {
			for (int i = 0; i < ss.length; i++) {
				for (int j = 0; j < ss[i].length; j++) {
					if (b[k] == ss[i][j])
						sayac2++;
				}
			}
		}
		return sayac2;
	}
}