package tr.edu.medipol.ilerijava.ders04.socketornek2;

import java.net.*;
import java.io.*;

public class ServerMainSimpleWithThread {

	public static void main(String[] args) throws Exception {
		// 1-) Server Socket Olusturuluyor ...........................
		ServerSocket serverSocket = new ServerSocket(82);
		while(true) {
			try {
				// 2-) Istemci Baglantisi Saglaniyor ..........................
				Socket istemciBaglantisi = 
						serverSocket.accept();
				
				ServerClientHandleThread t = 
						new ServerClientHandleThread(istemciBaglantisi);
				t.start();
				
			} catch(Exception e) {
				System.out.println("Istemci baglantisinda hata olustu.");
			}

		}
	}

	

}
