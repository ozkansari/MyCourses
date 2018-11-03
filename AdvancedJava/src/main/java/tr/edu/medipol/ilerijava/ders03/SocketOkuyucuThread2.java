package tr.edu.medipol.ilerijava.ders03;

import java.net.*;
import java.io.*;
import java.util.*;

public class SocketOkuyucuThread2 extends Thread {
	private Socket istemciBaglantisi;
	public SocketOkuyucuThread2(Socket istemciBaglantisi) {
		this.istemciBaglantisi = istemciBaglantisi;
	}
	
	@Override
	public void run() {
		
		System.out.println("Thread calisiyor" + 
				istemciBaglantisi.getInetAddress());
		
		// Istemci okuyucu ac
		BufferedReader istemciOkuyucu = 
				SocketYardimciAraclari.
				socketOkuyucuOlustur(istemciBaglantisi);
		
		int i=1;
		String mesaj = "";
		do {
			try {
				// istemciden mesaj gelene kadar bekler
				mesaj = istemciOkuyucu.readLine(); 
				System.out.println("[" + istemciBaglantisi.getInetAddress() + 
						" " + i + "]" + mesaj);
				i++;
			} catch (IOException e) {
				System.out.println("Okuma hata: " + e.getMessage());
			}
		} while(!mesaj.equals("Bye"));
		
	}

	

}
