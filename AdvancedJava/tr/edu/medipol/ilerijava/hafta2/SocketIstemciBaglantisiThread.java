package tr.edu.medipol.ilerijava.hafta2;

import java.net.*;
import java.io.*;
import java.util.*;

public class SocketIstemciBaglantisiThread extends Thread {
	private Socket istemciBaglantisi;
	public SocketIstemciBaglantisiThread(Socket istemciBaglantisi) {
		this.istemciBaglantisi = istemciBaglantisi;
	}
	
	@Override
	public void run() {
		
		System.out.println("Thread calisiyor" + 
				istemciBaglantisi.getInetAddress());
		
		// Istemci okuyucu ac
		BufferedReader istemciOkuyucu = null;
		try {
			InputStream girdi = this.istemciBaglantisi.getInputStream();
			InputStreamReader girdiOkuyucu	= new InputStreamReader(girdi);
			istemciOkuyucu = new BufferedReader(girdiOkuyucu);
			/*
			istemciOkuyucu = new BufferedReader(
					new InputStreamReader(
							istemciBaglantisi.getInputStream()
					)
			);	
			*/
		} catch (IOException e) {
			System.out.println("Istemci okuyucu acilirken hata: "
					+ e.getMessage()) ;
		}
		
		int i=1;
		String mesaj = "";
		do {
			try {
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
