package tr.edu.medipol.ilerijava.ders04.socketornek1;

import java.net.*;
import java.io.*;

public class ServerMainSimple {

	public static final int SERVER_PORT = 80;

	public static void main(String[] args) throws Exception {
		// 1-) Server Socket Olusturuluyor ...........................
		ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
		while(true) {
			try {
				// 2-) Istemci Baglantisi Saglaniyor ..........................
				Socket istemciBaglantisi = serverSocket.accept();
				
				istemciyleMesajlas(istemciBaglantisi);
				
			} catch(Exception e) {
				System.out.println("Istemci baglantisinda hata olustu.");
			}

		}
	}

	private static void istemciyleMesajlas(Socket istemciBaglantisi) throws IOException {
		// 3-) Istemciden gelecek mesajlari okuyacak yapiyi olustur ....
		DataInputStream in = new DataInputStream( istemciBaglantisi.getInputStream() );
		// 4-) Istemciye mesaj gonderecek yapiyi olustur
		DataOutputStream out = new DataOutputStream( istemciBaglantisi.getOutputStream() );
		// 5-) Istemciden mesaj oku
		String mesaj = in.readUTF();
		// 6-) Istemciye mesaj gonder
		out.writeUTF("Mesaj alindi: " + mesaj);
	}

}
