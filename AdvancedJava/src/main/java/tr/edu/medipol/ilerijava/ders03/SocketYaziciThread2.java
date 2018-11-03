package tr.edu.medipol.ilerijava.ders03;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class SocketYaziciThread2 extends SocketThreadUstSinif {

	private static final Logger LOGGER = Logger.getLogger(SocketYaziciThread2.class.getName());
	
	private PrintWriter socketMesajGonderici;
	
	public SocketYaziciThread2(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		socketMesajGonderici = SocketYardimciAraclari.socketYaziciOlustur(socketBaglantisi);
		LOGGER.info("Yazici Thread olusturuldu" + socketIsmi);
	}
	
	public SocketYaziciThread2(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		socketMesajGonderici = SocketYardimciAraclari.socketYaziciOlustur(socketBaglantisi);
		LOGGER.info("Yazici Thread olusturuldu" + socketIsmi);
	}

	@Override
	public void run() {
		LOGGER.info("Yazici Thread calisiyor" + socketIsmi);
		
		int i = 1;
		do  {
			String mesaj = socketIsmi + ">Mesaj " + i;
			System.out.println(mesaj + " gonderiliyor.");
			socketMesajGonderici.println(mesaj);
			socketMesajGonderici.flush();
			i++;
			threadBekle(5); // 5000 ms = 5 sn bekle
		} while(true);
		
	}

	public void threadBekle(int saniye){
		try {
			Thread.sleep(saniye*1000);
		} catch (InterruptedException e) {
			LOGGER.warning("Thread beklerken hata olsutu: " + e.getMessage());
		}
	}

	
}
