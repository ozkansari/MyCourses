package tr.edu.medipol.odev1.filizdagdeviren;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/** ozkans Degerlendirme

Okuma ve yazmanin yapilan islemlerle bir alakasi yok.

Menu: 5/5
Ogrenci Islemleri: 5/15
Polimorphism: 5/15
Dosyadan Okuma: 5/25
Dosyaya Yazma:  5/25
Genel Program: 0/15
Derste Yapilan Ornegi farklilastirma/Eklentiler: Bonus 0/20

 */
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
