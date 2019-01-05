package tr.edu.medipol.ilerijava.ders04;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class SocketOkuyucuThread3 extends SocketThreadUstSinif2 {
	
	private static final Logger LOGGER = Logger.getLogger(SocketOkuyucuThread3.class.getName());

	private BufferedReader socketOkuyucu;
	
	private EkranUstSinif ekran;
	
	public SocketOkuyucuThread3(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		init(socketBaglantisi);
	}
	
	public SocketOkuyucuThread3(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
	}

	public SocketOkuyucuThread3(Socket socketBaglantisi, boolean sunucu, 
			EkranUstSinif ekran) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
		this.ekran = ekran;
	}

	public void init(Socket socketBaglantisi) {
		// Istemci okuyucu ac
		socketOkuyucu = SocketYardimciAraclari2.
				socketOkuyucuOlustur(socketBaglantisi);
		LOGGER.info("Okuyucu Thread olusturuldu" + socketIsmi);
	}

	@Override
	public void run() {
		
		LOGGER.info("Okuyucu Thread calisiyor" + socketIsmi);

		int i=1;
		String mesaj = "";
		do {
			try {
				// istemciden mesaj gelene kadar bekler
				mesaj = socketOkuyucu.readLine(); 
				LOGGER.info("[" + socketIsmi +  " " + i + "]" + mesaj);
				if (ekran != null) {
					ekran.mesajEkle(socketBaglantisi.getInetAddress() + ">" + mesaj);
				}
				i++;
			} catch (IOException e) {
				LOGGER.severe("Okuma hata: " + e.getMessage());
				break;
			}
		} while(!mesaj.equals("Bye"));
		
	}

	

}
