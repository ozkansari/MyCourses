package tr.edu.medipol.ilerijava.ders03;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class SocketOkuyucuThread2 extends SocketThreadUstSinif {
	
	private static final Logger LOGGER = Logger.getLogger(SocketOkuyucuThread2.class.getName());

	public SocketOkuyucuThread2(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		LOGGER.info("Okuyucu Thread olusturuldu" + socketIsmi);
	}
	
	public SocketOkuyucuThread2(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		LOGGER.info("Okuyucu Thread olusturuldu" + socketIsmi);
	}

	@Override
	public void run() {
		
		LOGGER.info("Okuyucu Thread calisiyor" + socketIsmi);
		
		// Istemci okuyucu ac
		BufferedReader socketOkuyucu = 
				SocketYardimciAraclari.
				socketOkuyucuOlustur(socketBaglantisi);
		
		int i=1;
		String mesaj = "";
		do {
			try {
				// istemciden mesaj gelene kadar bekler
				mesaj = socketOkuyucu.readLine(); 
				LOGGER.info("[" + socketIsmi + 
						" " + i + "]" + mesaj);
				i++;
			} catch (IOException e) {
				LOGGER.severe("Okuma hata: " + e.getMessage());
				break;
			}
		} while(!mesaj.equals("Bye"));
		
	}

	

}
