package tr.edu.medipol.ogrenciler.yusufucar.odev2;

public class MedipolNYP2017BaharOdev2 {

	public static void main(String[] args) {

		int[] ogrenciSinavSonuclari = { 95, 84, 14, 26, 95, 36, 67, 74, 84, 54 };

		int[] notlarIstatistik = new int[101];

		for (int i = 0; i < ogrenciSinavSonuclari.length; i++) {

			int notlar = ogrenciSinavSonuclari[i];
			notlarIstatistik[notlar]++;

		}

		for (int n = 0; n < notlarIstatistik.length; n++) {

			int notAlanSayisi = notlarIstatistik[n];

			if (notAlanSayisi > 0) {

				System.out.println(n + " : " + notAlanSayisi);
			}
		}

	}

}
