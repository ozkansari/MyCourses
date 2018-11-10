package tr.edu.medipol.ilerijava.ders04;

import java.net.*;
import java.io.*;
import java.lang.System.LoggerFinder;
import java.util.*;
import java.util.logging.Logger;

public class SocketOkuyucuThread3 extends SocketThreadUstSinif2 {
	
	private static final Logger LOGGER = Logger.getLogger(SocketOkuyucuThread3.class.getName());

	public SocketOkuyucuThread3(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		LOGGER.info("Okuyucu Thread olusturuldu" + socketIsmi);
	}
	
	public SocketOkuyucuThread3(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		LOGGER.info("Okuyucu Thread olusturuldu" + socketIsmi);
	}

	@Override
	public void run() {
		
		LOGGER.info("Okuyucu Thread calisiyor" + socketIsmi);
		
		// Istemci okuyucu ac
		BufferedReader socketOkuyucu = 
				SocketYardimciAraclari2.
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
