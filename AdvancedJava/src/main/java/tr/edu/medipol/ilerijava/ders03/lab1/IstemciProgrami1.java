package tr.edu.medipol.ilerijava.ders03.lab1;

import java.net.*;
import java.io.*;

public class IstemciProgrami1 {
    private static final String SERVER_IP = "10.201.64.221";
    private static final int SERVER_PORT = 8182;
	public static void main(String[] args) {
		
		// 1-) Sunucu Baglantisi Kur
		Socket sunucuBaglantisi = sunucuyaBaglan();
		
		// 2-) Sunucuyla mesaj alisverisi
		sunucuylaMesajlas(sunucuBaglantisi);
	}
	
	private static Socket sunucuyaBaglan() {
		Socket sunucuBaglantisi = null;
		try {
			sunucuBaglantisi = new Socket(SERVER_IP,SERVER_PORT);
		} catch (IOException e) {
			System.out.println("Sunucuya baglanirken hata: " );
			e.printStackTrace();
			System.exit(0);
		}
		return sunucuBaglantisi;
	}
	
	private static void sunucuylaMesajlas(Socket sunucuBaglantisi) {
		try {
			OutputStream clientOut = sunucuBaglantisi.getOutputStream();
			DataOutputStream dataOut = new DataOutputStream(clientOut);
			dataOut.writeUTF("Merhaba ben Ozkan");
			
			InputStream clientIn = sunucuBaglantisi.getInputStream();
			DataInputStream dataIn = new DataInputStream(clientIn);
			String messageIn = dataIn.readUTF();
			System.out.println(messageIn);
			
		} catch (IOException e) {
			System.out.println("Client ile mesajlasmada hata olustu " 
					+ e.getMessage());
			e.printStackTrace();
		}
	}
}
