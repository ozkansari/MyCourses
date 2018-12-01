package tr.edu.medipol.ilerijava.socketapp.common;

import java.net.Socket;

public abstract class SocketThreadUstSinif extends Thread {
	
	/**
	 * Istemci ya da sunucu socket baglantisi
	 */
	protected Socket socketBaglantisi;
	
	/**
	 * Baglantinin sunucudan mi istemciden mi yapildigini gosterir
	 */
	protected boolean sunucu;
	
	protected String socketIsmi;
	
	public SocketThreadUstSinif(Socket socketBaglantisi, boolean sunucu) {
		this.socketBaglantisi = socketBaglantisi;
		this.sunucu = sunucu;
		String socketTipi = sunucu ? "sunucu" : "istemci";
		this.socketIsmi = "(" + socketBaglantisi.getInetAddress() + " " + socketTipi + ")";
	}
	
}
