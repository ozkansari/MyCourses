package tr.edu.medipol.ogrenciler.anilokumus.odev2;


public class SinavNotlar {

	public static void main(String[] args) {
		int[] SinavNotlari={12,81,0,76,17,7,81,0,1,3,97,6,0,100,9,3,17,1,76,0,7,3,12,9,1,17,81,91};
		int[] NotIstatistik=new int [101];
		
		NotIstatistik[1]=2;
		NotIstatistik[3]=3;
		NotIstatistik[6]=1;
		NotIstatistik[9]=2;
		NotIstatistik[12]=2;
		NotIstatistik[76]=2;
		NotIstatistik[17]=3;
		NotIstatistik[81]=3;
		NotIstatistik[97]=1;
		NotIstatistik[0]=4;
		NotIstatistik[7]=2;
		NotIstatistik[91]=1;
		NotIstatistik[100]=1;
		
		for (int i = 0; i < NotIstatistik.length; i++) {
			int KisiSayisi=NotIstatistik[i];
			if (KisiSayisi>0) {
				System.out.println(i+" : "+KisiSayisi);
				
			}
			
		}

	}

}
