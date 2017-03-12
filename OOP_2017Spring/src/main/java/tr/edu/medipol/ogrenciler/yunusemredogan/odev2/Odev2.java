package tr.edu.medipol.ogrenciler.yunusemredogan.odev2;

public class Odev2 {
	public static void main(String[] args) {

		int[] notlar = { 75, 26, 43, 43, 95, 26, 78, 57, 75, 43, 95 };

		sayac(notlar);

	}

	private static void sayac(int[] notlar) {
		int[] sayac = new int[101];
		for (int i = 0; i < notlar.length; i++) {
			int notDegeri = notlar[i];
			sayac[notDegeri]++;
		}

		for (int notDegeri = 0; notDegeri < sayac.length; notDegeri++) {
			int notAlanSayisi = sayac[notDegeri];
			if (notAlanSayisi > 0) {
				System.out.println(notDegeri + " : " + notAlanSayisi);
			}

		}
	}

}
