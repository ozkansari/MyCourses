package tr.edu.medipol.ilerijava.vize.osman_cansiz.ClientPack;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.PageSuperClass;
import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.SocketReaderThread;
import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.SocketWriterThread;
import tr.edu.medipol.ilerijava.vize.osman_cansiz.ServerPack.SocketServer;

public class ClientSocket {

	private static final String serverIP = "192.168.1.4";
	private static final int serverPORT = SocketServer.SERVER_PORT;

	public static void main(String[] args) throws InterruptedException {

		System.out.println("İstemci bağlantısı açılıyor...");

		PageSuperClass clientPage = new ClientPage("İstemci Ekranı");
		clientPage.setVisible(true);

		boolean connectionSuccessful = true;
		Socket serverConnection = null;
		try {
			serverConnection = new Socket(serverIP, serverPORT);
		} catch (UnknownHostException e) {
			System.out.println("Sunucuya Girilen IP Hatalı." + e.getMessage());
			connectionSuccessful = false;
		} catch (IOException e) {
			System.out.println("Sunucuya Bağlantısında Hata Meydana Geldi." + e.getMessage());
			connectionSuccessful = false;
		} catch (Exception e) {
			System.out.println("Sunucu Bağlantısında Bilinmeyen Hata Meydana Geldi." + e.getMessage());
			connectionSuccessful = false;
		} finally {
			if (!connectionSuccessful) {
				System.out.println("SocketProject Kapanıyor...");
				System.exit(-1);
			}
		}

		SocketReaderThread t = new SocketReaderThread(serverConnection, false, clientPage);
		t.start();

		SocketWriterThread t2 = new SocketWriterThread(serverConnection, false, clientPage);
		t2.start();

	}

}
