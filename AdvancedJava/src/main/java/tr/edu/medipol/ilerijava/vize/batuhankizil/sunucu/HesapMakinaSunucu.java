package tr.edu.medipol.ilerijava.vize.batuhankizil.sunucu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HesapMakinaSunucu extends Thread{
    private static final int PORT = 8091;
    EkranUstSinif sunucuEkrani; 
    private ServerSocket serverSocket;
  
    public HesapMakinaSunucu(final int port) throws IOException {
    	sunucuEkrani = new SunucuEkrani("SUNUCU EKRANI");
		sunucuEkrani.setVisible(true);
    	serverSocket = new ServerSocket(port);
    	serverSocket.setSoTimeout(1000000);
    }
    
    @Override
	public void run() {
    	while(true) {		
    		try {
    			final Socket socket = serverSocket.accept();
    			 final Hesapla hesaplama = new Hesapla(socket, this);
    			 synchronized (hesaplama) {
    				 hesaplama.run();
				 }
    			 
    		}catch(final Exception ex) {
    			ex.printStackTrace();	 
    		}
    	}
    }

    public static void main(final String[] args) throws IOException {
    	
    	final Thread t = new HesapMakinaSunucu(PORT);
    	t.start();
    	
    }
    
    public void yazdir(final String yapilanIslem) {
    	 sunucuEkrani.ekranaYazdir(yapilanIslem);
    }

}