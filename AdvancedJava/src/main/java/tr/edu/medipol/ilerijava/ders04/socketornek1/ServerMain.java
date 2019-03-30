package tr.edu.medipol.ilerijava.ders04.socketornek1;

import java.net.*;
import java.io.*;

public class ServerMain {

	public static final int SERVER_PORT = 80;

	public static void main(String[] args)  {
		// 1-) Server Socket Olusturuluyor ...........................
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(SERVER_PORT);
		} catch (IOException e) {
			System.out.println(
					SERVER_PORT + " portundan Sunucu Baglantisi Acilirken "
					+ "Hata Olustu." + e.getMessage() );
			e.printStackTrace();
		}
			
		while(true) {
					
			// 2-) Istemci Baglantisi Saglaniyor ..........................
			Socket istemciBaglantisi = null;
			try {
				System.out.println("Sunucu " + SERVER_PORT
						+ " portundan istemcileri bekliyor.");
				istemciBaglantisi = serverSocket.accept();
			} catch (IOException e) {
				System.out.println(
						"Istemci Baglantisi saglanirken hata olustu " +
				e.getMessage());
				e.printStackTrace();
				continue;
			}
			
			System.out.println("Istemci baglantisi saglandi. Istemci adresi: " 
					+ istemciBaglantisi.getRemoteSocketAddress() );
			
			
			// 3-) Istemciden gelecek mesajlari okuyacak yapiyi olustur ....
			DataInputStream in = null;
			try {
				in = new DataInputStream( istemciBaglantisi.getInputStream() );
			} catch (IOException e) {
				System.out.println("Istemciden mesaj alacak yapi olustururken hata olustu:"
						+ e.getMessage());
				e.printStackTrace();
				continue;
			}
			
			// 4-) Istemciye mesaj gonderecek yapiyi olustur
			DataOutputStream out = null;
			try {
				out = new DataOutputStream( istemciBaglantisi.getOutputStream() );
			} catch (IOException e) {
				System.out.println("Istemci mesaj gnderecek yapi olustururken hata olustu"
						+ e.getMessage());
				e.printStackTrace();
				continue;
			}
			
			// 5-) Istemciden mesaj oku
			String mesaj = null;
			try {
				mesaj = in.readUTF();
			} catch (IOException e) {
				System.out.println("Istemciden mesaj okunurken sorun olustu: " +
						e.getMessage());
				e.printStackTrace();
				continue;
			}
			System.out.println("Istemciden gelen mesaj " + mesaj);
			
			// 6-) Istemciye mesaj gonder
			try {
				out.writeUTF("Mesaj alindi: " + mesaj);
			} catch (IOException e) {
				System.out.println("Istemciye mesaj gonderirken sorun olustu");
				e.printStackTrace();
				continue;
			}
		
		}
	}

}
