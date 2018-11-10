package tr.edu.medipol.ilerijava.ders04;

import java.net.Socket;

public abstract class SocketThreadUstSinif2 extends Thread {
	
	/**
	 * Istemci ya da sunucu socket baglantisi
	 */
	protected Socket socketBaglantisi;
	
	/**
	 * Baglantinin sunucudan mi istemciden mi yapildigini gosterir
	 */
	protected boolean sunucu;
	
	protected String socketIsmi;
	
	public SocketThreadUstSinif2(Socket socketBaglantisi, boolean sunucu) {
		this.socketBaglantisi = socketBaglantisi;
		this.sunucu = sunucu;
		String socketTipi = sunucu ? "sunucu" : "istemci";
		this.socketIsmi = "(" + socketBaglantisi.getInetAddress() + " " + socketTipi + ")";
	}
	
}
