package tr.edu.medipol.ogrenciler.erdemakturan.odev2;

public class OgrenciSinifi {

	public static void main(String[] args) {

		int[] SinavSonucu = { 40, 100, 100, 20, 10, 10, 15, 100, 55 };

		// 101 farkli not olabilir

		int[] notlar = new int[101];

		for (int i = 0; i < SinavSonucu.length; i++) {

			notlar[SinavSonucu[i]]++;
		}

		// forech denedim olmuyor...

		for (int i = 0; i < notlar.length; i++) {
			int notAlanSayisi = notlar[i];

			if (notAlanSayisi > 0) {

				System.out.println(i + " : " + notAlanSayisi);

			}

		}

		// Program ornek ciktisi:

		// 15 : 1

		// 20 : 1

		// 65 : 3

		// 70 : 1

		// 80 : 3

	}

}
