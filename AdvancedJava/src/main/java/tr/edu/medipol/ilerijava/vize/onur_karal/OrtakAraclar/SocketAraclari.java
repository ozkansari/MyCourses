package tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketAraclari {
    private SocketAraclari(){
    }
    public static BufferedReader SocketOkuyucuOlustur(Socket IstemciRef){
        BufferedReader IstemciOkuyucu = null;
        try{
            InputStream girdi = IstemciRef.getInputStream();
            InputStreamReader girdiOkuyucu = new InputStreamReader(girdi);
            IstemciOkuyucu = new BufferedReader(girdiOkuyucu);
        }catch (IOException e){
            System.out.println("İstemci okuyucu açılırken hata alındı: " + e.getMessage());
        }
        return IstemciOkuyucu;
    }

    public static PrintWriter SocketYaziciOlustur(Socket SunucuBaglantisi) {
        PrintWriter SunucuMesajGonderici = null;
        try {
            OutputStream outputStream = SunucuBaglantisi.getOutputStream();
            SunucuMesajGonderici =
                    new PrintWriter(outputStream);
        } catch (IOException e) {
            System.out.println("Sunucuya yazma akışı olustururken hata alındı: " +
                    e.getMessage());
        }
        return SunucuMesajGonderici;
    }
    public static void ThreadBekle(int ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            System.out.println("Thread beklerken hata oluştu: " + e.getMessage());
        }
    }
}