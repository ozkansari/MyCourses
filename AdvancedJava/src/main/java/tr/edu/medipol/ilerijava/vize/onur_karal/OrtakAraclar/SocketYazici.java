package tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar;



import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;
public class SocketYazici  extends SocketUstSinif{
    private static final Logger LOGGER = Logger.getLogger(SocketYazici.class.getName());
    private PrintWriter SocketMesaGonderici;
    private EkranSinifi ekran;

    public SocketYazici(Socket SocketBaglantisi) {
        super(SocketBaglantisi, false);
        init(SocketBaglantisi);
    }
    public SocketYazici(Socket SocketBaglantisi, boolean Sunucu){
        super(SocketBaglantisi, Sunucu);
        init(SocketBaglantisi);
    }
    public SocketYazici(Socket SocketBaglantisi, boolean Sunucu, EkranSinifi ekran){
        super(SocketBaglantisi, Sunucu);
        init(SocketBaglantisi);
        this.ekran = ekran;
    }
    //Yazıcı Thread Oluşturma!!
    public void init(Socket SocketBaglantisi){
        SocketMesaGonderici = tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketAraclari.SocketYaziciOlustur(SocketBaglantisi);
        LOGGER.info("Yazıcı Thread Oluşturuldu." + SocketIsmi);
    }
    @Override
    public void run(){
        LOGGER.info("Yazıcı Thread çalışıyor." + SocketIsmi);
        while (true){
            String SiradakiMesaj = ekran.getMesajKuyruğu().poll();
            if (SiradakiMesaj != null){
                SocketeMesajGonder(SiradakiMesaj);
            }else{
                tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketAraclari.ThreadBekle(1000);
            }
        }
    }
    public void RastgeleMesajGonder(){
        int BeklemeSuresi = 5000;
        int i = 1;
        do{
            String mesaj = SocketIsmi + ">Mesaj " + i;
            SocketeMesajGonder(mesaj);
            tr.edu.medipol.ilerijava.vize.onur_karal.OrtakAraclar.SocketAraclari.ThreadBekle(BeklemeSuresi);
            i++;
        }while (true);
    }
    public void SocketeMesajGonder(String mesaj){
        if(mesaj !=null){
            System.out.println(mesaj + "Gönderiliyor..");
            SocketMesaGonderici.println(mesaj);
            SocketMesaGonderici.flush();
        }
    }

    }

