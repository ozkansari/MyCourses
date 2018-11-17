package tr.edu.medipol.ilerijava.ders05.istemci;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import tr.edu.medipol.ilerijava.ders05.ortak.EkranUstSinif2;
import tr.edu.medipol.ilerijava.ders05.ortak.SocketOkuyucuThread4;
import tr.edu.medipol.ilerijava.ders05.ortak.SocketYaziciThread4;
import tr.edu.medipol.ilerijava.ders05.sunucu.SocketSunucu4;

public class SocketIstemci4 {
	
	private static final String sunucuIP = "10.200.144.11";
	private static final int sunucuPort = SocketSunucu4.SERVER_PORT;
			
	public static void main(String[] args) throws InterruptedException {

		System.out.println("Istemci aciliyor.");

		EkranUstSinif2 istemciEkrani = new IstemciEkrani2("ISTEMCI EKRANI");
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
		
		SocketOkuyucuThread4 t = new SocketOkuyucuThread4(sunucuBaglantisi, 
				false, istemciEkrani);
		t.start();
		
		SocketYaziciThread4 t2 = new SocketYaziciThread4(sunucuBaglantisi, false, istemciEkrani);
		t2.start();

	}

	

}
