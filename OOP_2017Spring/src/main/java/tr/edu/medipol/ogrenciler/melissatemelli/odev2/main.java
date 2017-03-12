package tr.edu.medipol.ogrenciler.melissatemelli.odev2;

public class main {
	public static void main(String[]a){
		int[] ogrenciSinav =
			{ 65, 75, 80, 90, 65, 80, 90 };
		int[] notIstatistik = new int[101];
		int notsay = 0;
		for(int m=0; m<ogrenciSinav.length; m++) {
			if(m==ogrenciSinav[m]) {
				notsay++;
				notIstatistik[m]= notsay;
			}
		}
		for(int i= 0; i<ogrenciSinav.length; i++) {
			int notDegeri = ogrenciSinav[i];
			System.out.println(notDegeri);
		}
		for (int n= 0; n<notIstatistik.length; n++){
			int notAlanSayisi = notIstatistik[n];
			if(notAlanSayisi >0){
				System.out.println(n+ ":" + notsay);
			}
		}
	}
}
