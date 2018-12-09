package tr.edu.medipol.ilerijava.ders04;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketYaziciThread3 extends SocketThreadUstSinif2 {

	private static final Logger LOGGER = Logger.getLogger(SocketYaziciThread3.class.getName());
	
	private PrintWriter socketMesajGonderici;
	
	private EkranUstSinif ekran;
	
	public SocketYaziciThread3(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		init(socketBaglantisi);
	}

	public SocketYaziciThread3(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
	}

	public SocketYaziciThread3(Socket socketBaglantisi, boolean sunucu, EkranUstSinif ekran) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
		this.ekran = ekran;
	}
	
	public void init(Socket socketBaglantisi) {
		socketMesajGonderici = SocketYardimciAraclari2.socketYaziciOlustur(socketBaglantisi);
		LOGGER.info("Yazici Thread olusturuldu" + socketIsmi);
	}
	
	@Override
	public void run() {
		LOGGER.info("Yazici Thread calisiyor" + socketIsmi);
		
		// rastgeleMesajGonder();
		
		while(true) {
			String siradakiMesaj = ekran.getMesajKuyrugu().poll();
			if (siradakiMesaj != null) {
				socketeMesajGonder(siradakiMesaj);
			} else {
				threadBekle(10000);
			}
		}
		
	}

	public void rastgeleMesajGonder() {
		int beklemeSuresi = 5000;// 5000 ms = 5 sn bekle
		int i = 1;
		do  {
			String mesaj = socketIsmi + ">Mesaj " + i;
			socketeMesajGonder(mesaj); 
			threadBekle(beklemeSuresi);
			i++;
		} while(true);
	}

	public void socketeMesajGonder(String mesaj) {
		if (mesaj != null) {
			System.out.println(mesaj + " gonderiliyor.");
			socketMesajGonderici.println(mesaj);
			socketMesajGonderici.flush();
		} 
	}

	public void threadBekle(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			LOGGER.warning("Thread beklerken hata olsutu: " + e.getMessage());
		}
	}

	
}
