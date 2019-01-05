package tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class SocketOkuyucu extends SocketUstSinif{
    private static final Logger LOGGER = Logger.getLogger(SocketOkuyucu.class.getName());
    private BufferedReader SocketOkuyucu;
    private EkranSinifi ekran;

    public SocketOkuyucu(Socket SocketBaglantisi){
        super(SocketBaglantisi, false);
        init(SocketBaglantisi);
    }
    public SocketOkuyucu(Socket SocketBaglantisi, boolean Sunucu){
        super(SocketBaglantisi, Sunucu);
        init(SocketBaglantisi);
    }
    public SocketOkuyucu(Socket SocketBaglantisi, boolean Sunucu, EkranSinifi ekran){
        super(SocketBaglantisi, Sunucu);
        init(SocketBaglantisi);
        this.ekran = ekran;
    }

    //Okuyucu Thread Oluşturma!!
    public void init(Socket SocketBaglantisi){
        SocketOkuyucu = tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketAraclari.SocketOkuyucuOlustur(SocketBaglantisi);
        LOGGER.info("Okuyucu Thread Oluşturuldu." + SocketIsmi);
    }
    @Override
    public void run(){
        LOGGER.info("Okuyucu Thread çalışıyor.." + SocketIsmi);
        int i = 1;
        String mesaj = "";
        do{
            try {
                mesaj = SocketOkuyucu.readLine();
                if (mesaj == null){
                    continue;
                }
                LOGGER.info("[" + SocketIsmi + " " + i + "]" + mesaj);
                if (ekran != null){
                    String MesajGonderen = "";
                    if (Sunucu){
                        MesajGonderen = "Sayın  " + socketBaglantisi.getInetAddress() + "  İşlem Sonucu: " + mesaj;
                        ekran.getMesajKuyruğu().offer(MesajGonderen);
                    }else {
                        MesajGonderen += "" + mesaj;
                    }
                    ekran.mesajEkle(MesajGonderen);
                }
                i++;
            }catch (IOException e){
                LOGGER.severe("Okumada Hata Alındı: " + e.getMessage());
                break;
            }
        }while (!mesaj.equals("Görüşürüz"));



    }



}
