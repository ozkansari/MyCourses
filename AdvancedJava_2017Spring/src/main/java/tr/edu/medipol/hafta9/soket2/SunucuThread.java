package tr.edu.medipol.hafta9.soket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SunucuThread extends Thread {

	private Socket istemciBaglantisi;
	private PrintWriter istemciMesajGonderici = null;
	private BufferedReader istemciMesajOkuyucu = null;
	
	public SunucuThread(Socket istemciBaglantisi) {
		this.istemciBaglantisi = istemciBaglantisi;
	}
	
	@Override
	public void run() {
		try {
			
			// SUNUCU ACILIYOR VE ISTEMCI BEKLENIYOR ------------------------
			try {
				System.out.println("Sunucu baglantisi saglandi! Istemci: " + istemciBaglantisi.getInetAddress());
				
				// Istemciye mesaj gondermek icin yazici uretilir
				istemciMesajGonderici = new PrintWriter(istemciBaglantisi.getOutputStream(), true);
	
				// Istemciden mesaj okumak icin okuyucu uretilir
				istemciMesajOkuyucu = new BufferedReader(new InputStreamReader(istemciBaglantisi.getInputStream()));
				
			} catch (UnknownHostException e) {
				System.err.println("Sunucu bulunamadı");
				System.exit(1);
			}
			
			// ISTEMCIDEN MESAJ OKU VE MESAJ GONDER -------------------------
			String istemciMesaji;
			do {
				System.out.println("Istemciden mesaj bekleniyor...");
				istemciMesaji = istemciMesajOkuyucu.readLine();
				System.out.println("Istemciden gelen: " + istemciMesaji);
				istemciMesajGonderici.println("Anladim: " + istemciMesaji);
			} while (istemciMesaji!= null && !istemciMesaji.equals("bye"));

			
		} catch (Exception e) {
			System.out.println("Beklenmeyen bir hata olustu!");
			e.printStackTrace();
		} finally {
			
		}
	}

}
