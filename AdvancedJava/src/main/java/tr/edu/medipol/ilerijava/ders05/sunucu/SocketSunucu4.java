package tr.edu.medipol.ilerijava.ders05.sunucu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import tr.edu.medipol.ilerijava.ders05.ortak.EkranUstSinif2;
import tr.edu.medipol.ilerijava.ders05.ortak.SocketOkuyucuThread4;
import tr.edu.medipol.ilerijava.ders05.ortak.SocketYaziciThread4;

public class SocketSunucu4 {

	public static final int SERVER_PORT = 7777;
	
	public static void main(String[] args) {
		
		EkranUstSinif2 sunucuEkrani = new SunucuEkrani2("SUNUCU EKRANI");
		sunucuEkrani.setVisible(true);
		
		try {
			ServerSocket sunucuSocketi = new ServerSocket(SERVER_PORT);
			
			System.out.println("Istemciler bekleniyor." + 
					sunucuSocketi.getLocalPort());
			
			while(true) {
			
				// Istemciden baglanti gelene kadar bekle
				Socket istemciBaglantisi = sunucuSocketi.accept();
				
				System.out.println("Istemci baglandi: " + 
						istemciBaglantisi.getInetAddress());
				
				SocketOkuyucuThread4 t1 = 
						new SocketOkuyucuThread4(istemciBaglantisi, true, 
								sunucuEkrani);
				t1.start();
				
				SocketYaziciThread4 t2 = 
						new SocketYaziciThread4(istemciBaglantisi, true, sunucuEkrani);
				t2.start();
			
			}
			
			
		} catch (IOException e) {
			System.out.println(SERVER_PORT + 
					" Ustunden sunucu socketi acarken hata olustu");
			e.printStackTrace();
		}
		
	}
}
