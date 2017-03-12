package tr.edu.medipol.ogrenciler.ismailsahin.odev2;


public class MedipolNYP2017BaharOdev2 {
	public static void main(String[] args) {
		int[] ogrenciSinavSonuclari = { 65, 80, 80, 20, 65, 65, 15, 80, 70 };
		int[] notlarIstatistik = new int[101];
		
		for (int i = 0; i < ogrenciSinavSonuclari.length; i++) {
			int notDegeri = ogrenciSinavSonuclari[i];
			notlarIstatistik[notDegeri]++;
		}
		
		for (int n = 0; n < notlarIstatistik.length; n++) {
			int notAlanSayisi = notlarIstatistik[n];
			if (notAlanSayisi > 0) {
				System.out.println(n + " : " + notAlanSayisi);
			}
			
		}
	}
}
