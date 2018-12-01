package tr.edu.medipol.ilerijava.socketapp.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tr.edu.medipol.ilerijava.socketapp.common.CommonConstants;
import tr.edu.medipol.ilerijava.socketapp.common.EkranUstSinif;
import tr.edu.medipol.ilerijava.socketapp.common.SocketOkuyucuThread;
import tr.edu.medipol.ilerijava.socketapp.common.SocketYaziciThread;

public class SocketIstemciMain {
	
	private static final String sunucuIP = "10.200.144.11";
	private static final int sunucuPort = CommonConstants.SERVER_PORT;
			
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Istemci aciliyor.");

		EkranUstSinif istemciEkrani = new IstemciEkrani("ISTEMCI EKRANI");
		istemciEkrani.setVisible(true);
		
		boolean baglantiBasarili = true;
		Socket sunucuBaglantisi = null;
		try {
			sunucuBaglantisi = new Socket(sunucuIP, sunucuPort);
		} catch (UnknownHostException e) {
			System.out.println("Sunucu IP hatali" + e.getMessage());
			baglantiBasarili = false;
		} catch (IOException e) {
			System.out.println("Sunucuya baglanirken hata alindi:" + 
					e.getMessage());
			baglantiBasarili = false;
		} catch(Exception e) {
			System.out.println("Sunucuya baglanirken bilinmeyen bir hata alindi:" + 
					e.getMessage());
			baglantiBasarili = false;
		} finally {
			if (!baglantiBasarili) {
				System.out.println("Program sonlandiriliyor");
				System.exit(-1);
			}
		}
		
		SocketOkuyucuThread t = new SocketOkuyucuThread(sunucuBaglantisi, 
				false, istemciEkrani);
		t.start();
		
		SocketYaziciThread t2 = new SocketYaziciThread(sunucuBaglantisi, false, istemciEkrani);
		t2.start();

	}

	

}
