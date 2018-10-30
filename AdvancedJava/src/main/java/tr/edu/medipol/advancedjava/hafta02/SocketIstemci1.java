package tr.edu.medipol.advancedjava.hafta02;

import java.io.*;
import java.net.*;

public class SocketIstemci1 {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Istemci aciliyor.");

		PrintWriter sunucuMesajGonderici = null;
		try {
			Socket sunucuBaglantisi = new Socket("10.200.144.11", 
					SocketSunucu1.SERVER_PORT);

			sunucuMesajGonderici = 
					new PrintWriter(sunucuBaglantisi.getOutputStream());

		} catch (UnknownHostException e) {
			System.out.println("Sunucu IP hatali" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Sunucuya baglanirken hata alindi:" + 
					e.getMessage());
		}
		
		int i = 1;
		do  {
			String mesaj = "Mesaj " + i;
			System.out.println(mesaj + " godneriliyor.");
			sunucuMesajGonderici.println(mesaj);
			sunucuMesajGonderici.flush();
			i++;
			Thread.sleep(5000);
		} while(true);

	}

}
