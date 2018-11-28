package tr.edu.medipol.ilerijava.vize.onur_karal.Sunucu;
import tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.EkranSinifi;
import java.io.*;
import java.net.*;
import java.util.*;

public class BroadcasterThread extends Thread{
    private Map<String,Socket> TumSocketMap;
    private Map<Socket,PrintWriter> TumSocketYaziciMap;
    private EkranSinifi ekran;

    public BroadcasterThread(EkranSinifi ekran){
        TumSocketMap = new HashMap<>();
        TumSocketYaziciMap = new HashMap<>();
        this.ekran = ekran;
    }
    public synchronized boolean SocketEkle(String SocketIsmi, Socket Socket){
        TumSocketMap.put(SocketIsmi, Socket);
        PrintWriter SocketMesajGonderici = tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketAraclari.SocketYaziciOlustur(Socket);
        TumSocketYaziciMap.put(Socket, SocketMesajGonderici);
        return true;
    }
    @Override
    public void run(){
        //Mesajı Alan Kısım!!
        while (true){
            String SiradakiMesaj = ekran.getMesajKuyruğu().poll();
            if(SiradakiMesaj == null){
                tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketAraclari.ThreadBekle(1000);
                continue;
            }
            //Tüm İstemcilere Mesajı Gönderen Kısım!!
            Collection<PrintWriter> YaziciList = TumSocketYaziciMap.values();
            for (PrintWriter SocketMesajGonderici : YaziciList){
                SocketMesajGonderici.println(SiradakiMesaj);
                SocketMesajGonderici.flush();
            }
        }
    }
    //Kapama Kısmı!!
    @Override
    public void destroy(){
        Collection<PrintWriter> YaziciList = TumSocketYaziciMap.values();
        for (PrintWriter SocketMesajGonderici : YaziciList){
            SocketMesajGonderici.close();
        }
    }
}
