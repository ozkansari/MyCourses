package tr.edu.medipol.hafta2.grub_b;

import java.math.BigInteger;

import tr.edu.medipol.hafta2.grub_b.veritipi.Araba;
import tr.edu.medipol.hafta2.grub_b.veritipi.Otobus;

public class Galeri {

	private int sayi = 1111111111;
	private long buyukSayi = 1111111111111111111L;
	private String s = "sasad"; 
	private BigInteger cokBuyukSayi = new BigInteger("21332131243123421343213341232132");
	
	public static void main(String[] args) {

		 Araba m = new Araba("Mercedes");
		 m.getMarka();
		 
		 //Sehir s = new Sehir();
		 Otobus o = new Otobus();
		 
		 int [] sayiDizisi;
		 sayiDizisi = new int[3];
		 
		 int [] sayiDizisi2 = new int[3]; 
		 sayiDizisi2[0] = 1;
		 sayiDizisi2[1] = 2341;
		 String snoopy = "�bo";
		 sayiDizisi2[2] = 123121;
		 
		 int [] sayiDizisi3 = {1,2,3,45,56754,657567,5676};
		 String [] ogrenciler = {"�brahim", "Snoopy", "Dogan", "Yucel"};
		 ogrenciler[1] = snoopy;
		 ogrenciler[2] = "Haluk";
		 // ogrenciler[5] = "Asli"; // Array Index Out Of Bounds Exception
		 
		 /*
		 for (int i = ogrenciler.length; i  ; i++) {
			String string = ogrenciler[i];
			String ogrenci = ogrenciler[i];
			System.out.println(ogrenci);
		 }
		 */
		 
		 
		 for (   int i = 0  ; // donguye girerken bir defa - ilk deger vermek icin
				 i > ogrenciler.length
				 ; i++ // her defa cagrilacak sayac degerini degistirmek icin
		) {
			 
			 
			String ogrenci = ogrenciler[i];
			System.out.println(ogrenci);
			
			if (i > ogrenciler.length) {
				break;
			} else {
				continue;
			}
			
		}
		 
		 int index = 0;
		 while(index < ogrenciler.length){
			 String ogrenci = ogrenciler[index];
		     System.out.println(ogrenci);
				
			 index++;
			 
		 }
		 
		 index = 0;  
		 do {
			 String ogrenci = ogrenciler[index];
		     System.out.println(ogrenci);
				
			 index++;
		 } while(index < ogrenciler.length);
		 
		
	}
}


