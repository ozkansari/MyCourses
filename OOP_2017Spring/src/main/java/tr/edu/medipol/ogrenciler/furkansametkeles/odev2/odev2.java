package tr.edu.medipol.ogrenciler.furkansametkeles.odev2;

public class odev2 {
	public static void main(String[] args) {
		int[] ogrenciSinavSonuclari = { 65, 80, 80, 20, 65, 65, 15, 80, 70 };

		int[] notlarIstatistik = new int[101];
		for (int i = 0; i < ogrenciSinavSonuclari.length; i++) {
			notlarIstatistik[ogrenciSinavSonuclari[i]]++;
		}

		for (int i = 0; i < notlarIstatistik.length; i++) {
			int syc = notlarIstatistik[i];
			if (syc > 0) {
				System.out.println(i + " : " + syc);
			}
		}
	}

}
