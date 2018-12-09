package tr.edu.medipol.ilerijava.ders03;

import java.io.*;
import java.net.*;
import java.util.*;

public class SocketSunucu2 {

	public static final int SERVER_PORT = 7777;
	
	public static void main(String[] args) {
		
		try {
			ServerSocket sunucuSocketi = new ServerSocket(SERVER_PORT);
			
			System.out.println("Istemciler bekleniyor." + 
					sunucuSocketi.getLocalPort());
			
			while(true) {
			
				// Istemciden baglanti gelene kadar bekle
				Socket istemciBaglantisi = sunucuSocketi.accept();
				
				System.out.println("Istemci baglandi: " + 
						istemciBaglantisi.getInetAddress());
				
				SocketOkuyucuThread2 t1 = 
						new SocketOkuyucuThread2(istemciBaglantisi, true);
				t1.start();
				
				SocketYaziciThread2 t2 = 
						new SocketYaziciThread2(istemciBaglantisi, true);
				t2.start();
			
			}
			
			
		} catch (IOException e) {
			System.out.println(SERVER_PORT + 
					" Ustunden sunucu socketi acarken hata olustu");
			e.printStackTrace();
		}
		
	}
}
