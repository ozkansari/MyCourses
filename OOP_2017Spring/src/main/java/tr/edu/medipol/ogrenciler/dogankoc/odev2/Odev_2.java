package tr.edu.medipol.ogrenciler.dogankoc.odev2;

public class Odev_2 {
	public static void main(String[] args) {
		// ozkans 20160510 Degisken ismi buyuk harfe baslamamali
		int[] Notlar = { 70, 45, 50, 30, 100, 65, 10, 95, 79, 92, 85, 95, 55, 77, 92, 30, 45, 85, 55, 66, 100, 100 };

		int[] notlarIstatistik = new int[101];
		for (int i = 0; i < notlarIstatistik.length; i++) {
			int sayac = 0;
			
			// ozkans 20160510 Icerişdeki for dongusu yerine soyle yapabilirdin:
			// notlarIstatistik[i]++;
			// ozkans 20160510 For dongusunu her zaman { } ile yazsan daha iyi
			for (int j = 0; j < Notlar.length; j++)
				if (i == Notlar[j]) {
					sayac++;
					notlarIstatistik[i] = sayac;
				}
		}
		for (int x = 0; x < Notlar.length; x++) {
			int not = Notlar[x];
			System.out.printf("%d. not=%d\n", x + 1, not);
		}

		for (int n = 0; n < notlarIstatistik.length; n++) {
			int notAlanSayisi = notlarIstatistik[n];
			if (notAlanSayisi > 0) {
				System.out.println(n + " : " + notAlanSayisi);
			}
		}

	}

}