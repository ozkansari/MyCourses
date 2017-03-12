package tr.edu.medipol.ogrenciler.furkanyilmaz.odev2;

public class Main {

	public static void main(String[] args) {
		int[] ogrenciSinavSonuclari = { 65, 80, 80, 20, 65, 65, 15, 80, 70 };

		int[] notlarIstatistik = new int[101];

		for (int i = 0; i < ogrenciSinavSonuclari.length; i++) {
			int sayac = 0;
			for (int j = 0; j < ogrenciSinavSonuclari.length; j++) {

				if (ogrenciSinavSonuclari[i] == ogrenciSinavSonuclari[j]) {
					sayac++;
					notlarIstatistik[ogrenciSinavSonuclari[i]] = sayac;
					;
				}
			}
		}

		System.out.println("---------------------------------------");

		for (int i = 0; i < notlarIstatistik.length; i++) {

			if (notlarIstatistik[i] > 0) {

				System.out.println(i + " : " + notlarIstatistik[i]);
			}

		}

	}
}