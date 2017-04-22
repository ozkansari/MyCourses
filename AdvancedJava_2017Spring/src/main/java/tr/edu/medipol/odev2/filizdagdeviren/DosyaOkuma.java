package tr.edu.medipol.odev2.filizdagdeviren;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DosyaOkuma {

	public static void main(String[] args)  throws FileNotFoundException  {
		File ogrencilerDosya = new File("Ogrenciler.txt"); 
		Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);
		
		File ciktiDosyasi = new File("Ogrenciler_cikti.txt");
		PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);
		

		
		for(int i=0; dosyaOkuyucu.hasNextLine(); i++) {
			String mevcutSatir = dosyaOkuyucu.nextLine();
			System.out.println(mevcutSatir);
			dosyaYazici.println("Satir " + (i+1) + ": " + mevcutSatir);
		}
		
		dosyaYazici.close();
		dosyaOkuyucu.close();
	}

}
