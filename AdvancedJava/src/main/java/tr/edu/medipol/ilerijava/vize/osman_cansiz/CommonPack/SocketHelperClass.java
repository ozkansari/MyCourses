package tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public final class SocketHelperClass {

	private SocketHelperClass() {
		
	}
	
	public static BufferedReader createSocketReader(Socket clientRef) {
		BufferedReader clientReader = null;
		try {
			InputStream entry = clientRef.getInputStream();
			InputStreamReader entryReader	= new InputStreamReader(entry);
			clientReader = new BufferedReader(entryReader);
		} catch (IOException e) {
			System.out.println("Istemci okuyucu acilirken hata: "
					+ e.getMessage()) ;
		}
		return clientReader;
	}
	
	public static PrintWriter createSocketWriter(Socket sunucuBaglantisi) {
		PrintWriter serverMessageSender = null;
		try {
			OutputStream outputStream = sunucuBaglantisi.getOutputStream();
			serverMessageSender = 
					new PrintWriter(outputStream);
		} catch (IOException e) {
			System.out.println("Sunucuya yazma akisi olustururken hata alindi:" + 
					e.getMessage());
		}
		return serverMessageSender;
	}
	
	public static void waitForThread(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("Thread beklerken hata olustu: " + e.getMessage());
		}
	}
}
