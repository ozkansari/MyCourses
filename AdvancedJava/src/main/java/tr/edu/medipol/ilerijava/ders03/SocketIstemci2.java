package tr.edu.medipol.ilerijava.ders03;

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
		
		PrintWriter sunucuMesajGonderici = SocketYardimciAraclari.socketYaziciOlustur(sunucuBaglantisi);
		
		int i = 1;
		do  {
			String mesaj = "Mesaj " + i;
			System.out.println(mesaj + " godneriliyor.");
			sunucuMesajGonderici.println(mesaj);
			sunucuMesajGonderici.flush();
			i++;
			Thread.sleep(5000); // 5000 ms = 5 sn bekle
		} while(true);

	}

	

}
