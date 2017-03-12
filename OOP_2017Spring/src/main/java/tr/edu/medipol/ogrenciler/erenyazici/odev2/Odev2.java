package tr.edu.medipol.ogrenciler.erenyazici.odev2;

public class Odev2 {

	public static void main(String[] args) {

		int[] ogrenciSinavSonuclari = { 65, 80, 80, 20, 65, 65, 15, 80, 70 };

		int[] notlarIstatistik = new int[101];

		for (int notDegeri = 0; notDegeri < 100; notDegeri++) {

			for (int i = 0; i < ogrenciSinavSonuclari.length; i++) {

				if (notDegeri == ogrenciSinavSonuclari[i]) {
					int sayac = notlarIstatistik[notDegeri];
					sayac++;
					notlarIstatistik[notDegeri] = sayac;
				}
			}

		}

		for (int i = 0; i < notlarIstatistik.length; i++) {
			int sayacIst = notlarIstatistik[i];
			if (sayacIst > 0) {
				System.out.println(i + ": " + sayacIst);
			}
		}

	}

}
