package tr.edu.medipol.ilerijava.ders04;

import java.io.*;
import java.net.*;

public class SocketIstemci2 {
	
	private static final String sunucuIP = "10.200.144.11";
	private static final int sunucuPort = SocketSunucu2.SERVER_PORT;
			
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Istemci aciliyor.");

		Socket sunucuBaglantisi = null;
		try {
			
			sunucuBaglantisi = new Socket(sunucuIP, sunucuPort);
		} catch (UnknownHostException e) {
			System.out.println("Sunucu IP hatali" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Sunucuya baglanirken hata alindi:" + 
					e.getMessage());
		}
		
		SocketOkuyucuThread2 t = new SocketOkuyucuThread2(sunucuBaglantisi, false);
		t.start();
		
		SocketYaziciThread2 t2 = new SocketYaziciThread2(sunucuBaglantisi, false);
		t2.start();

	}

	

}
