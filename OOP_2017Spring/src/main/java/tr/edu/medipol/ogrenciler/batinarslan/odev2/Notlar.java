package tr.edu.medipol.ogrenciler.batinarslan.odev2;


public class Notlar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] Sinavlar={15,32,48,48,23,15,18,0,100,0,15,100,5,15,85,95,70,66,43,36};
		int[] notlar = new int[101];
		
		notlar[0]=2;
		notlar[5]=1;
		notlar[15]=4;
		notlar[18]=1;
		notlar[23]=1;
		notlar[32]=1;
		notlar[36]=1;
		notlar[43]=1;
		notlar[48]=2;
		notlar[66]=1;
		notlar[70]=1;
		notlar[85]=1;
		notlar[95]=1;
		notlar[100]=2;
		
		for (int n = 0; n < notlar.length; n++) {  
			 int kisiSayi = notlar[n]; 
		      if (kisiSayi > 0) {
		        System.out.println(n + " : " + kisiSayi);
		      }
		}
	}

}
