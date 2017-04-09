package tr.edu.medipol.ogrenciler.dogukandemir.odev2;

public class Odev2 {

	public static void main(String[] args) {
		int[] notlar = { 10, 10, 20, 65, 65, 65, 10, 20, 100 };
		System.out.println("Yontem 1 - Array ile: ");
		hesaplaYontem1(notlar);
	}

	private static void hesaplaYontem1(int[] notlar) {
		int[] istatistik = new int[101];
		for (int i = 0; i < notlar.length; i++) {
			int notDegeri = notlar[i];
			istatistik[notDegeri]++;

		}

		for (int notDegeri = 0; notDegeri < istatistik.length; notDegeri++) {
			int notAlanSayisi = istatistik[notDegeri];
			if (notAlanSayisi > 0) {
				System.out.println(notDegeri + " : " + notAlanSayisi);
			}
		}
	}
}