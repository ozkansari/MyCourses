package tr.edu.medipol.hafta5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DosyaOkumaOrnegiSade {

    public static void main(String[] args) throws FileNotFoundException {
        File ogrencilerDosya = new File(".\\config\\Ogrenciler.txt"); 
        // Mac: "./config/Ogrenciler.txt"
        
        if(!ogrencilerDosya.exists() || !ogrencilerDosya.canRead()
                || !ogrencilerDosya.isFile() ) {
            System.out.println("Dosya yok ya da okuma hakkı yok." 
                    + ogrencilerDosya.getAbsolutePath() );
            return;
        }
        
        Scanner dosyaOkuyucu = new Scanner(ogrencilerDosya);

        File ciktiDosyasi = new File(".\\config\\Ogrenciler_cikti.txt"); 
        // Mac: "./config/Ogrenciler_cikti.txt"
        
        if (!ciktiDosyasi.canWrite()) {
            System.out.println("Yazma hakki yok");
            return;
        }
        
        PrintWriter dosyaYazici = new PrintWriter(ciktiDosyasi);

        // Dosyaya ek yapmak icin:
        // FileOutputStream fos = new FileOutputStream(ciktiDosyasi);
        // PrintWriter dosyaYazici2 = new PrintWriter(fos, true);
        for (int i = 0; dosyaOkuyucu.hasNextLine(); i++) {
            String mevcutSatir = dosyaOkuyucu.nextLine();
            System.out.println(mevcutSatir);
            dosyaYazici.println("Satir " + (i + 1) + ": " + mevcutSatir);
        }

        dosyaYazici.close();
        dosyaOkuyucu.close();
    }

}
