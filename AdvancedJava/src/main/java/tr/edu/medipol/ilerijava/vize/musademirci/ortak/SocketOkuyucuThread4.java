package tr.edu.medipol.ilerijava.vize.musademirci.ortak;
import javax.swing.JOptionPane;

import java.net.*;
import java.io.*;
import java.util.logging.Logger;

import javax.swing.JLabel;

public class SocketOkuyucuThread4 extends SocketThreadUstSinif3 {
	
	private static final Logger LOGGER = Logger.getLogger(SocketOkuyucuThread4.class.getName());

	private BufferedReader socketOkuyucu;
	
	private EkranUstSinif2 ekran;
	
	public SocketOkuyucuThread4(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		init(socketBaglantisi);
	}
	
	public SocketOkuyucuThread4(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
	}

	public SocketOkuyucuThread4(Socket socketBaglantisi, boolean sunucu, 
			EkranUstSinif2 ekran) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
		this.ekran = ekran;
	}

	public void init(Socket socketBaglantisi) {
		// Istemci okuyucu ac
		socketOkuyucu = SocketYardimciAraclari3.
				socketOkuyucuOlustur(socketBaglantisi);
		LOGGER.info("Okuyucu Thread olusturuldu" + socketIsmi);
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		
		LOGGER.info("Okuyucu Thread calisiyor" + socketIsmi);

		int i=1;
		String saybir = "";
		String sayiki = "";
		String hesap = "";
		
		
		do {
			try {
				saybir = socketOkuyucu.readLine(); 
				sayiki = socketOkuyucu.readLine(); 
				hesap = socketOkuyucu.readLine();				
				
				if (saybir == null && sayiki==null) {
					continue;
				}
				
				double s1 = Integer.parseInt(saybir);
				double s2 = Integer.parseInt(sayiki);
				double sonuc=0;
				String hata = "";
				
				switch (hesap) {
				case "+":
					sonuc=s1+s2;
					break;
				case "-":
					sonuc=s1-s2;
					break;
				case "*":
					sonuc=s1*s2;
					break;
				case "/":
					if (s2!=0);{
					sonuc=s1/s2;
					}
					if(s2==0)
					{
						hata="Sayi sifira bolunemez";
					};
				}
				//hata.substring(3,4);
				
				String mesaj = String.valueOf(sonuc);
				LOGGER.info("[" + socketIsmi +  " " + i + "]" + mesaj+hata);
				
				
				if (ekran != null) {
					String mesajVeGonderen = "";					
					if (sunucu) {
						mesajVeGonderen = socketBaglantisi.getInetAddress() + ">>  " + mesaj+hata;
						ekran.getMesajKuyrugu().offer(mesajVeGonderen);
					} else {
						mesajVeGonderen += "" +  mesaj+hata;
					}
					ekran.mesajEkle(mesajVeGonderen);
				}
				i++;
				
			} catch (IOException e) {
				LOGGER.severe("Okuma hata: " + e.getMessage());
				break;
			}
		} while(!saybir.equals("Bye") && !sayiki.equals("Bye"));
		
	}
	
	

}