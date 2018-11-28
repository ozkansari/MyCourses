package tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar;
import java.net.Socket;

public abstract class SocketUstSinif  extends Thread{
    protected Socket socketBaglantisi;
    protected boolean Sunucu;
    protected String SocketIsmi;

    public SocketUstSinif(Socket socketBaglantisi, boolean sunucu) {
        this.socketBaglantisi = socketBaglantisi;
        this.Sunucu = sunucu;
        String socketTipi = sunucu ? "Sunucu" : "İstemci";
        this.SocketIsmi = "(" + socketBaglantisi.getInetAddress() + " " + socketTipi + ")";


    }
}
