package tr.edu.medipol.odevler.ahmet_ciloglu.odev2;

import java.io.*;
import java.util.Scanner;

// TR karaklterli dosya ismi sorun cikarir. Kullanilmamali.: -10
// -10: OgrenciBilgi isimli bir class olusturun ve icine ogrenciAdSoyad isimli bir String nesne degiskeni ekleyin. Değiskenin private olmasina dikkat edin.
// -10: liste kullanimi yok
// -10: Sadece tek ogrenci okunuyor yaziliyor.

// 61

public class DosyaIslem { // ozkans sinif ismi duzeltildi

	public static void main(String[] args) throws IOException {
		try {
			OgrenciBilgi bilgi = new OgrenciBilgi();
			FileWriter fw = new FileWriter("C:\\Users\\Ahmet �ilo�lu\\Desktop\\blog.txt") ;
			PrintWriter pw = new PrintWriter(fw);
			pw.print(bilgi.ogrenciadsoyad);
			pw.close();
		}catch(IOException e)
		{
			System.out.print("Hata!!!");
		}
		try {
			OgrenciBilgi bilgi = new OgrenciBilgi();
			FileReader fr = new FileReader ("C:\\Users\\Ahmet �ilo�lu\\Desktop\\blog.txt") ;
			BufferedReader br = new BufferedReader(fr);
			while ((bilgi.ogrenciadsoyad=br.readLine())!=null) {
				System.out.print(bilgi.ogrenciadsoyad+ "\n" );
			}
			br.close();
		}
		catch(IOException e)
		{
			System.out.print("Hata!!!");
		}
		
		String girilen=" ";
		@SuppressWarnings("resource")
		Scanner yazma = new Scanner(System.in);
		do {
			System.out.print("veri gir: ");
			girilen = yazma.nextLine();
			if (girilen == null || girilen.trim().isEmpty() || girilen.equals("*") ) { 
				break;
			} else {			
				FileWriter fw = new FileWriter("C:\\Users\\Ahmet �ilo�lu\\Desktop\\blog.txt") ;
				PrintWriter pw = new PrintWriter(fw);
				pw.print(girilen);
				pw.close();
			}
		} while(true); 
		
}
}	

