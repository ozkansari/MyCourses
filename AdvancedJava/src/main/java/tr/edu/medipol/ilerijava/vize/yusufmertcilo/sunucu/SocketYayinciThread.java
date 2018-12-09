package tr.edu.medipol.ilerijava.vize.yusufmertcilo.sunucu;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tr.edu.medipol.ilerijava.vize.yusufmertcilo.ortak.EkranUstSinif2;
import tr.edu.medipol.ilerijava.vize.yusufmertcilo.ortak.SocketYardimciAraclari3;

public class SocketYayinciThread extends Thread {

	private Map<String,Socket> tumSocketlerMap;
	
	private Map<Socket,PrintWriter> tumSocketYaziciMap;
	
	private EkranUstSinif2 ekran;
	
	public SocketYayinciThread(EkranUstSinif2 ekran) {
		tumSocketlerMap = new HashMap<>();
		tumSocketYaziciMap = new HashMap<>();
		this.ekran = ekran;
	}
	
	public synchronized boolean socketEkle(String socketIsmi, Socket socket) {
		tumSocketlerMap.put(socketIsmi, socket);
		PrintWriter socketMesajGonderici = SocketYardimciAraclari3.socketYaziciOlustur(socket);
		tumSocketYaziciMap.put(socket, socketMesajGonderici);
		return true;
	}
	
	@Override
	public void run() {

		while(true) {
			
			// mesaji al
			String siradakiMesaj = ekran.getMesajKuyrugu().poll();
			
			if (siradakiMesaj == null) {
				SocketYardimciAraclari3.threadBekle(1000);
				continue;
			}
					
			float sonuc = 0;
			boolean hata = false;
			try {
				String[] gelenVeri = siradakiMesaj.split(" ");
				
				float sayi1 = Float.parseFloat(gelenVeri[2]); 
				String operator = gelenVeri[3];
				float sayi2 = Float.parseFloat(gelenVeri[4]);
				
				switch(operator) {
					case "+":
						sonuc = sayi1 + sayi2;
						break;
					case "-":
						sonuc = sayi1 - sayi2;
						break;
					case "/":
						sonuc = sayi1 / sayi2;
						break;
					case "*":
						sonuc = sayi1 * sayi2;
						break;
					default:
						throw new IllegalArgumentException();
				}
			}catch(Exception e) {
				hata = true;
			}
					
		
			// Tum istemcilere gonder
			Collection<PrintWriter> yaziciList = tumSocketYaziciMap.values();
			for (PrintWriter socketMesajGonderici : yaziciList) {
				if (hata) {
					socketMesajGonderici.println(siradakiMesaj + " => Girdiðiniz deðerleri kontrol ediniz.");
				}else {
					socketMesajGonderici.println(siradakiMesaj + " = " + sonuc);
				}
				socketMesajGonderici.flush();
			} // end-for
			
		} // -end-while-
		
	}
	
	@Override
	public void destroy() {
		Collection<PrintWriter> yaziciList = tumSocketYaziciMap.values();
		for (PrintWriter socketMesajGonderici : yaziciList) {
			socketMesajGonderici.close();
		}
	}
	
}
