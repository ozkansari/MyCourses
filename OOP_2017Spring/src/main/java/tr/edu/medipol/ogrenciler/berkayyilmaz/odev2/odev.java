package tr.edu.medipol.ogrenciler.berkayyilmaz.odev2;

public class odev {

	public static void main(String[] args) 
	{
		int [] Notlar = new int[] { 65,75,76,90,90,90,34,56,75,75,75,75,34};
		int sayi = 0;
		int tekrarSayisi = 0;
		
		for (int i = 0; i < Notlar.length-1; i++)
		{
			if(Notlar[i] == Notlar[i+1])
				tekrarSayisi++;
			if(i==(Notlar.length-2) || Notlar[i]!= Notlar[i+1])
				sayi=Notlar[i];
		}
		
		
	System.out.println(sayi + " en çok bu not tekrar etmiştir. Ve bu not " + tekrarSayisi + "kez tekrar edilmiştir.");
	}

}
