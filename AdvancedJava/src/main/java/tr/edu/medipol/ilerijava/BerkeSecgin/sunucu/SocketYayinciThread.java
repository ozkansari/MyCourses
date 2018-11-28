package tr.edu.medipol.ilerijava.BerkeSecgin.sunucu;

import java.io.*;
import java.net.*;
import java.util.*;

import tr.edu.medipol.ilerijava.BerkeSecgin.ortak.EkranUstSinif2;
import tr.edu.medipol.ilerijava.BerkeSecgin.ortak.SocketYardimciAraclari3;

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