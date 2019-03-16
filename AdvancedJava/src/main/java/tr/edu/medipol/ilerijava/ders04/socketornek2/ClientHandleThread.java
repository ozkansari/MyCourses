package tr.edu.medipol.ilerijava.ders04.socketornek2;

import java.net.*;
import java.io.*;

public class ClientHandleThread extends Thread {

	private DataInputStream in;
	private DataOutputStream out;
	
	public ClientHandleThread(Socket istemciBaglantisi) throws IOException {
		// 3-) Istemciden gelecek mesajlari okuyacak yapiyi olustur ....
		in = new DataInputStream( istemciBaglantisi.getInputStream() );
		// 4-) Istemciye mesaj gonderecek yapiyi olustur
		out = new DataOutputStream( istemciBaglantisi.getOutputStream() );		
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				istemciyleMesajlas();
			} catch (Exception e) {
				System.out.println("Istemci mesajlasma hatasi");
				e.printStackTrace();
				return;
			}
		}
	}
	
	private void istemciyleMesajlas() throws IOException {
		// 5-) Istemciden mesaj oku
		String mesaj = in.readUTF();
		System.out.println("Mesaj > " + mesaj);
		// 6-) Istemciye mesaj gonder
		out.writeUTF("Mesaj alindi: " + mesaj);
	}

}
