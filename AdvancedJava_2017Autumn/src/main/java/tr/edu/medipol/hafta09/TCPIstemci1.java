package tr.edu.medipol.hafta09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPIstemci1 {

    public static void main(String[] args) {

        try {
            Socket sunucuBaglantisi = new Socket("10.201.36.209", 1234);
            System.out.println("Sunucuya baglanildi.");

            // Istemciye mesaj gonderimi icin
            OutputStream out = sunucuBaglantisi.getOutputStream();
            PrintWriter yazici = new PrintWriter(out);

            // Istemciden mesaj almak icin
            InputStream in = sunucuBaglantisi.getInputStream();
            InputStreamReader inReader = new InputStreamReader(in);
            BufferedReader okuyucu = new BufferedReader(inReader);

            Scanner konsolOkuyucu = new Scanner(System.in);
            
            String mesaj = null;
            do {
                System.out.println("Sunucuya gondereceginiz mesaji giriniz:");
                mesaj = konsolOkuyucu.nextLine();
                System.out.println("mesaj: " + mesaj);
                yazici.println(mesaj);
                yazici.flush();
                
                mesaj = okuyucu.readLine();
                System.out.println("Sunucu mesaji: " + mesaj);
                
            } while (mesaj != null && !mesaj.equals("bye"));

        } catch (IOException ex) {
            System.out.println("Sunucuya baglanamadi.");
        }

    }
}
