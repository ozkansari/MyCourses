package tr.edu.medipol.ilerijava.ders04;

import java.io.*;
import java.net.*;

public class SocketIstemci3 {
	
	private static final String sunucuIP = "10.200.144.11";
	private static final int sunucuPort = SocketSunucu3.SERVER_PORT;
			
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
		
		SocketOkuyucuThread3 t = new SocketOkuyucuThread3(sunucuBaglantisi, false);
		t.start();
		
		SocketYaziciThread3 t2 = new SocketYaziciThread3(sunucuBaglantisi, false);
		t2.start();

	}

	

}
