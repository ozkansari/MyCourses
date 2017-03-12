package tr.edu.medipol.ogrenciler.mucahiddeniz.odev2;

public class Odev2 {

	public static void main(String[] args) {

		int [] notlar = {10,10,20,65,65,65,10,20,100};
		int [] istatistik = new int [101];
		int i=0;
		while(i<notlar.length){
	
			int notDegeri = notlar[i];

			istatistik[notDegeri]++;
			i++;
		}
		int notDegeri = 0;
		while(notDegeri < istatistik.length){
			int notAlanSayisi = istatistik[notDegeri];
			if (notAlanSayisi>0) {

				System.out.printf("%d : %d\n",notDegeri, notAlanSayisi);
			}
			notDegeri++;
		}


	}

}
