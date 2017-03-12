package tr.edu.medipol.ogrenciler.yusufucar.odev2;

public class ll {

	public static void main(String[] args) {

		int[] ogrenciSinavSonuclari = { 95, 84, 14, 26, 95, 36, 67, 74, 84, 54 };

		int not1 = 0, not2 = 0, not3 = 0, not4 = 0, not5 = 0, not6 = 0, not7 = 0, not8 = 0, not9 = 0, not10 = 0;

		String not01 = "", not02 = "", not03 = "", not04 = "", not05 = "", not06 = "", not07 = "", not08 = "",
				not09 = "", not010 = "";

		for (int n = 0; n < ogrenciSinavSonuclari.length; n++) {

			if (0 == ogrenciSinavSonuclari[n]) {
				not1++;
				not01 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not2++;
				not02 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not3++;
				not03 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not4++;
				not04 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not5++;
				not05 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not6++;
				not06 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not7++;
				not07 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not8++;
				not08 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not9++;
				not09 += "*";
			} else if (0 == ogrenciSinavSonuclari[n]) {
				not10++;
				not010 += "*";
			}

		}

		System.out.println("Not 1 :" + not1 + " " + not01);
		System.out.println("Not 2 :" + not2 + " " + not02);
		System.out.println("Not 3 :" + not3 + " " + not03);
		System.out.println("Not 4 :" + not4 + " " + not04);
		System.out.println("Not 5 :" + not5 + " " + not05);
		System.out.println("Not 6 :" + not6 + " " + not06);
		System.out.println("Not 7 :" + not7 + " " + not07);
		System.out.println("Not 8 :" + not8 + " " + not08);
		System.out.println("Not 9 :" + not9 + " " + not09);
		System.out.println("Not 10 :" + not10 + " " + not010);

	}

}
