package tr.edu.medipol.ilerijava.vize.taha_keskin.ortak;

import java.net.Socket;

public abstract class SocketThreadUstSinif3 extends Thread {
	
	/**
	 * Istemci ya da sunucu socket baglantisi
	 */
	protected Socket socketBaglantisi;
	
	/**
	 * Baglantinin sunucudan mi istemciden mi yapildigini gosterir
	 */
	protected boolean sunucu;
	
	protected String socketIsmi;
	
	public SocketThreadUstSinif3(Socket socketBaglantisi, boolean sunucu) {
		this.socketBaglantisi = socketBaglantisi;
		this.sunucu = sunucu;
		String socketTipi = sunucu ? "sunucu" : "istemci";
		this.socketIsmi = "(" + socketBaglantisi.getInetAddress() + " " + socketTipi + ")";
	}
	
}