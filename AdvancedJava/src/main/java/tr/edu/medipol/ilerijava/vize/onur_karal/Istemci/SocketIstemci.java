package tr.edu.medipol.ilerijava.vize.onur_karal.Istemci;

import tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.EkranSinifi;
import tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketOkuyucu;
import tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketYazici;
import tr.edu.medipol.ilerijava.vize.onur_karal.Sunucu.SocketSunucu;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketIstemci {
    private static final String sunucuIp = "localhost";
    private static final int sunucuPort = SocketSunucu.SERVER_PORT;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("İstemci açılıyor..");

        EkranSinifi IstemciEkrani = new IstemciEkrani("İstemci Ekranı");
        IstemciEkrani.setVisible(true);




        boolean BaglantiBasarili = true;
        Socket SunucuBaglantisi = null;
        try {
            SunucuBaglantisi = new Socket(sunucuIp, sunucuPort);
        }catch (UnknownHostException e) {
            System.out.println("Sunucu IP hatalı:" + e.getMessage());
            BaglantiBasarili = false;
        }catch (IOException e) {
            System.out.println("Sunucuya bağlanırken hata alındı:" + e.getMessage());
            BaglantiBasarili = false;
        }catch(Exception e) {
            System.out.println("Sunucuya baglanirken bilinmeyen bir hata alındı:" +
                    e.getMessage());
            BaglantiBasarili = false;
        } finally {
            if (!BaglantiBasarili) {
                System.out.println("Program sonlandırılıyor");
                System.exit(-1);
            }
        }
        SocketOkuyucu t = new SocketOkuyucu(SunucuBaglantisi, false, IstemciEkrani);
        t.start();
        SocketYazici t2 = new SocketYazici(SunucuBaglantisi, false, IstemciEkrani);
        t2.start();
    }
}