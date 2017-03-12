package tr.edu.medipol.ogrenciler.selahattinbozat.odev2;

public class Odev2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] sinavlar={100,0,95,15,99,25,90,33,89,30,85,35,80,40,75,55,70,68,100,0,95,15,99,30,80,35,70,40,68,55,100,15,95,30,68,40,55,95,68,40,68,40};
		int[] not=new int[101];
		
		not[100]=3;
		not[95]=4;
		not[99]=2;
		not[90]=1;
		not[89]=1;
		not[85]=1;
		not[80]=2;
		not[75]=1;
		not[70]=2;
		not[68]=5;
		not[55]=3;
		not[40]=5;
		not[35]=2;
		not[30]=3;
		not[33]=1;
		not[25]=1;
		not[15]=3;
		not[0]=2;
		
		for (int notlar = 0; notlar < not.length; notlar++) {  
		     
		      int notAlanSayisi = not[notlar]; 
		      if (notAlanSayisi > 0) {
		        System.out.println(notlar + " : " + notAlanSayisi);
		      }
		}
		

	}

}
