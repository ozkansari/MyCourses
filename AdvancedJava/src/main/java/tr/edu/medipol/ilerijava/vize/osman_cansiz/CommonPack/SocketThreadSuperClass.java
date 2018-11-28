package tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack;

import java.net.Socket;

public abstract class SocketThreadSuperClass extends Thread {
	
	/**
	 * Istemci ya da sunucu socket baglantisi
	 */
	protected Socket socketBaglantisi;
	
	/**
	 * Baglantinin sunucudan mi istemciden mi yapildigini gosterir
	 */
	protected boolean sunucu;
	
	protected String socketIsmi;
	
	public SocketThreadSuperClass(Socket socketBaglantisi, boolean sunucu) {
		this.socketBaglantisi = socketBaglantisi;
		this.sunucu = sunucu;
		String socketTipi = sunucu ? "sunucu" : "istemci";
		this.socketIsmi = "(" + socketBaglantisi.getInetAddress() + " " + socketTipi + ")";
	}
	
}
