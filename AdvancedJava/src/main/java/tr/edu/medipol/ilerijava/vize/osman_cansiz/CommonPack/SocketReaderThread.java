package tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack;

import java.net.*;
import java.io.*;
import java.util.logging.Logger;

public class SocketReaderThread extends SocketThreadSuperClass {

	private static final Logger LOGGER = Logger.getLogger(SocketReaderThread.class.getName());

	private BufferedReader socketReader;

	private PageSuperClass screen;

	public SocketReaderThread(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		init(socketBaglantisi);
	}

	public SocketReaderThread(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
	}

	public SocketReaderThread(Socket socketBaglantisi, boolean sunucu, PageSuperClass ekran) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
		this.screen = ekran;
	}

	public void init(Socket socketBaglantisi) {
		// Istemci okuyucu ac
		socketReader = SocketHelperClass.createSocketReader(socketBaglantisi);
		LOGGER.info("Okuyucu Thread olusturuldu" + socketIsmi);
	}

	@Override
	public void run() {

		LOGGER.info("Okuyucu Thread calisiyor" + socketIsmi);

		int i = 1;
		String message = "";

		do {
			try {
				// istemciden mesaj gelene kadar bekler
				message = socketReader.readLine();

				if (message == null) {
					continue;
				}

				LOGGER.info("[" + socketIsmi + " " + i + "]" + message);

				if (screen != null) {
					String messageAndSender = "";
					if (sunucu) {
						messageAndSender = socketBaglantisi.getInetAddress() + ">>  " + message;
						screen.getMessageQueue().offer(messageAndSender);
					} else {
						messageAndSender += "" + message;
					}
					screen.addMessage(messageAndSender);
				}
				i++;

			} catch (IOException e) {
				LOGGER.severe("Okuma hata: " + e.getMessage());
				break;
			}
		} while (!message.equals("Bye"));

	}

}
