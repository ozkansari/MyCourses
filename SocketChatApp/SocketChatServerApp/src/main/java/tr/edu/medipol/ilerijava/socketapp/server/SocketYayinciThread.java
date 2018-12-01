package tr.edu.medipol.ilerijava.socketapp.server;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tr.edu.medipol.ilerijava.socketapp.common.EkranUstSinif;
import tr.edu.medipol.ilerijava.socketapp.common.SocketYardimciAraclari;

public class SocketYayinciThread extends Thread {

	private Map<String,Socket> tumSocketlerMap;
	
	private Map<Socket,PrintWriter> tumSocketYaziciMap;
	
	private EkranUstSinif ekran;
	
	public SocketYayinciThread(EkranUstSinif ekran) {
		tumSocketlerMap = new HashMap<>();
		tumSocketYaziciMap = new HashMap<>();
		this.ekran = ekran;
	}
	
	public synchronized boolean socketEkle(String socketIsmi, Socket socket) {
		tumSocketlerMap.put(socketIsmi, socket);
		PrintWriter socketMesajGonderici = SocketYardimciAraclari.socketYaziciOlustur(socket);
		tumSocketYaziciMap.put(socket, socketMesajGonderici);
		return true;
	}
	
	@Override
	public void run() {

		while(true) {
			
			// mesaji al
			String siradakiMesaj = ekran.getMesajKuyrugu().poll();
			if (siradakiMesaj == null) {
				SocketYardimciAraclari.threadBekle(1000);
				continue;
			}
			// Tum istemcilere gonder
			Collection<PrintWriter> yaziciList = tumSocketYaziciMap.values();
			for (PrintWriter socketMesajGonderici : yaziciList) {
				socketMesajGonderici.println(siradakiMesaj);
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
