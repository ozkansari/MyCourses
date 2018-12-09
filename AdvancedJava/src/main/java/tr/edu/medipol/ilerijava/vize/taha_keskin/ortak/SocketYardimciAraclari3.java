package tr.edu.medipol.ilerijava.vize.taha_keskin.ortak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public final class SocketYardimciAraclari3 {

	private SocketYardimciAraclari3() {
		// bu obje newlenmeyecek, static kullanilicak
	}
	
	public static BufferedReader socketOkuyucuOlustur(Socket istemciRef) {
		BufferedReader istemciOkuyucu = null;
		try {
			InputStream girdi = istemciRef.getInputStream();
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
		return istemciOkuyucu;
	}
	
	public static PrintWriter socketYaziciOlustur(Socket sunucuBaglantisi) {
		PrintWriter sunucuMesajGonderici = null;
		try {
			OutputStream outputStream = sunucuBaglantisi.getOutputStream();
			sunucuMesajGonderici = 
					new PrintWriter(outputStream);
		} catch (IOException e) {
			System.out.println("Sunucuya yazma akisi olustururken hata alindi:" + 
					e.getMessage());
		}
		return sunucuMesajGonderici;
	}
	
	public static void threadBekle(int ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("Thread beklerken hata olustu: " + e.getMessage());
		}
	}
}