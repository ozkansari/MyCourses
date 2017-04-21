package tr.edu.medipol.hafta9.soket2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import tr.edu.medipol.hafta9.Utils;

class TCPIstemci1 {
	
	private static Socket sunucuBaglantisi = null;
	private static PrintWriter sunucuMesajGonderici = null;
	private static BufferedReader sunucuMesajOkuyucu = null;
	private static Scanner konsolOkuyucu = null;
	
	public static void main(String args[]) {

		try {
			
			
			// SUNUCU BAGLANTISI DENENIYOR ------------------------
			try {
				// Sunucuya baglan
				sunucuBaglantisi = new Socket("10.200.144.46", 49695);
			
				// Sunucuya mesaj gondermek icin yazici uretilir
				sunucuMesajOkuyucu = new BufferedReader(new InputStreamReader(sunucuBaglantisi.getInputStream()));

				// Sunucuya mesaj gondermek icin yazici uretilir
				sunucuMesajGonderici = new PrintWriter(sunucuBaglantisi.getOutputStream(), true);
	
			} catch (UnknownHostException e) {
				System.err.println("Sunucu bulunamadı");
				System.exit(1);
			}
			System.out.println("Sunucuya baglanildi.");
			
			
			
			// SUNUCUYA MESAJ GONDER VE MESAJ OKU ------------------
			konsolOkuyucu = new Scanner(System.in);
			String kullaniciMesaji;
			do {
				System.out.println("Sunucuya gondereceginiz mesaji giriniz: ");
				kullaniciMesaji = konsolOkuyucu.nextLine();
				sunucuMesajGonderici.println(kullaniciMesaji);
				System.out.println("Sunucudan gelen: " + sunucuMesajOkuyucu.readLine());
			} while (!kullaniciMesaji.equals("bye"));
			
			
			
		} catch (Exception e) {
			System.out.println("Beklenmeyen bir hata olustu!");
			e.printStackTrace();
		} finally {
			baglantilariKapat();
		}
	}

	private static void baglantilariKapat() {
		System.out.println("Baglanti kesiliyor...");
		Utils.baglantiKapat(konsolOkuyucu);
		Utils.baglantiKapat(sunucuMesajOkuyucu);
		Utils.baglantiKapat(sunucuMesajGonderici);
		Utils.baglantiKapat(sunucuBaglantisi);
	}
}
