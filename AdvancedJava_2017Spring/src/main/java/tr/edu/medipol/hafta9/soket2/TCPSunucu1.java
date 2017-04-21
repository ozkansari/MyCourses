package tr.edu.medipol.hafta9.soket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
// Socket programlama siniflari java.net.* paketinde bulunur
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import tr.edu.medipol.hafta9.Utils;

class TCPSunucu1 {
	
	public static final int SUNUCU_PORT = 1234;
	private static ServerSocket sunucuSoketi = null;
	private static Socket istemciBaglantisi = null;
	private static PrintWriter istemciMesajGonderici = null;
	private static BufferedReader istemciMesajOkuyucu = null;
	
	public static void main(String args[]) {
		
		try {
			
			// SUNUCU ACILIYOR VE ISTEMCI BEKLENIYOR ------------------------
			try {
				// Belirtilen porttan bir soket acar. 0 ise bos bir port bulur.
				sunucuSoketi = new ServerSocket(SUNUCU_PORT); // (*)
				int sunucuPortu = sunucuSoketi.getLocalPort();
				System.out.println("Sunucu " + sunucuPortu + " portundan acildi. Baglanti bekleniyor!");
				
				// Istemciden baglanti gelene kadar bloklanmis sekilde bekler
				istemciBaglantisi = sunucuSoketi.accept(); 
				
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
			baglantilariKapat();
		}
	}

	private static void baglantilariKapat() {
		System.out.println("Baglanti kesiliyor...");
		Utils.baglantiKapat(istemciMesajGonderici);
		Utils.baglantiKapat(istemciMesajOkuyucu);
		Utils.baglantiKapat(istemciBaglantisi);
		Utils.baglantiKapat(sunucuSoketi);
	}
	
	// (*) Belli bir port üzerinden socket acmaya kalkarsak ve bu port da daha önce başka bir uygulama tarafindan kullaniliyorsa 
	//     java.net.BindException hatasi aliriz. Bunun önüne gecmek icin; ServerSocketi 0 parametresiyle yaratip boş olan portlardan 
	//     rastgele birisini kullanabiliriz. getLocalPort() methodu ile de hangi porttan acildigini ögrenebiliriz.
	
}