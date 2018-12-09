package tr.edu.medipol.ilerijava.vize.osman_cansiz.ServerPack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.PageSuperClass;
import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.SocketReaderThread;

public class SocketServer {

	public static final int SERVER_PORT = 7777;

	public static void main(String[] args) {

		PageSuperClass serverScreen = new ServerPage("SUNUCU EKRANI");
		serverScreen.setVisible(true);

		try {
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);

			System.out.println("Istemciler bekleniyor." + serverSocket.getLocalPort());

			SocketStreamerThread socketStreamerThread = new SocketStreamerThread(serverScreen);
			socketStreamerThread.start();

			while (true) {

				Socket clientConnection = serverSocket.accept();

				String ip = clientConnection.getInetAddress().toString();
				System.out.println("Istemci baglandi: " + ip);

				socketStreamerThread.addSocket(ip, clientConnection);

				SocketReaderThread t1 = new SocketReaderThread(clientConnection, true, serverScreen);
				t1.start();
			}

		} catch (IOException e) {
			System.out.println(SERVER_PORT + " Ustunden sunucu socketi acarken hata olustu");
			e.printStackTrace();
		}

	}
}
