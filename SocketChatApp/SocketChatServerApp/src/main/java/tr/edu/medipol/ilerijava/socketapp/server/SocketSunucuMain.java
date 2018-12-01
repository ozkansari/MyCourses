package tr.edu.medipol.ilerijava.socketapp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import tr.edu.medipol.ilerijava.socketapp.common.CommonConstants;
import tr.edu.medipol.ilerijava.socketapp.common.EkranUstSinif;
import tr.edu.medipol.ilerijava.socketapp.common.SocketOkuyucuThread;
import tr.edu.medipol.ilerijava.socketapp.common.SocketYaziciThread;

public class SocketSunucuMain {

	public static void main(String[] args) {
		
		EkranUstSinif sunucuEkrani = new SunucuEkrani("SUNUCU EKRANI");
		sunucuEkrani.setVisible(true);

		try {
			ServerSocket sunucuSocketi = new ServerSocket(CommonConstants.SERVER_PORT);
			
			System.out.println("Istemciler bekleniyor." + 
					sunucuSocketi.getLocalPort());
			
			SocketYayinciThread yayinciOrtakThread = new SocketYayinciThread(sunucuEkrani);
			yayinciOrtakThread.start();
			
			while(true) {
			
				// Istemciden baglanti gelene kadar bekle
				Socket istemciBaglantisi = sunucuSocketi.accept();
				
				String ip = istemciBaglantisi.getInetAddress().toString();
				System.out.println("Istemci baglandi: " + ip);
				
				yayinciOrtakThread.socketEkle(ip, istemciBaglantisi);
				
				SocketOkuyucuThread t1 = 
						new SocketOkuyucuThread(istemciBaglantisi, true, 
								sunucuEkrani);
				t1.start();
			}
			
			
		} catch (IOException e) {
			System.out.println(CommonConstants.SERVER_PORT + 
					" Ustunden sunucu socketi acarken hata olustu");
			e.printStackTrace();
		}
		
	}
}
