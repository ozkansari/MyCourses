package tr.edu.medipol.hafta09;

import java.io.*;
import java.net.*;

public class TCPSunucu1 {
   
    public static void main(String[] args) {

        try {
            ServerSocket sunucuSoketi = new ServerSocket(1234); // 0 rastgele port
            int sunucuPortu = sunucuSoketi.getLocalPort();
            System.out.println("Sunucu portu basariyla acildi: " + sunucuPortu);

            while (true) {

                System.out.println("Istemciden baglanti bekleniyor.");
                Socket istemciBaglantisi = sunucuSoketi.accept();
                System.out.println("Istemci baglandi: " + istemciBaglantisi.getRemoteSocketAddress());

                // Istemciye mesaj gonderimi icin
                OutputStream out = istemciBaglantisi.getOutputStream();
                PrintWriter yazici = new PrintWriter(out);

                // Istemciden mesaj almak icin
                InputStream in = istemciBaglantisi.getInputStream();
                InputStreamReader inReader = new InputStreamReader(in);
                BufferedReader okuyucu = new BufferedReader(inReader);

                String mesaj = null;
                do {
                    System.out.println("Istemciden mesaj bekleniyor");
                    mesaj = okuyucu.readLine();
                    System.out.println("Istemci mesaji: " + mesaj);

                    yazici.println("Tamam kanka: " + mesaj);
                    yazici.flush();
                } while (mesaj != null && !mesaj.equals("bye"));

            } // while(true) sonu

        } catch (IOException ex) {
            System.out.println("Sunucu hatasi. Port mesgul olabilir." + ex.getMessage());
        }
    }
}
