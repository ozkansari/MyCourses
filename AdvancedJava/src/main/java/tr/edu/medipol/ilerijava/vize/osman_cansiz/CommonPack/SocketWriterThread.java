package tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;
import tr.edu.medipol.ilerijava.vize.osman_cansiz.CommonPack.ProcessClass;

public class SocketWriterThread extends SocketThreadSuperClass {

	private static final Logger LOGGER = Logger.getLogger(SocketWriterThread.class.getName());

	private PrintWriter socketMessageSender;

	private PageSuperClass screen;

	public SocketWriterThread(Socket socketBaglantisi) {
		super(socketBaglantisi, false);
		init(socketBaglantisi);
	}

	public SocketWriterThread(Socket socketBaglantisi, boolean sunucu) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
	}

	public SocketWriterThread(Socket socketBaglantisi, boolean sunucu, PageSuperClass ekran) {
		super(socketBaglantisi, sunucu);
		init(socketBaglantisi);
		this.screen = ekran;
	}

	public void init(Socket socketBaglantisi) {
		socketMessageSender = SocketHelperClass.createSocketWriter(socketBaglantisi);
		LOGGER.info("Yazici Thread olusturuldu" + socketIsmi);
	}

	@Override
	public void run() {
		LOGGER.info("Yazici Thread calisiyor" + socketIsmi);

		while (true) {
			String nextMes = screen.getMessageQueue().poll();
			if (nextMes != null) {
				sendMessageToSocket(nextMes);
			} else {
				SocketHelperClass.waitForThread(1000);
			}
		}

	}

	public void sendMessageToSocket(String message) {
		if (message != null) {
			System.out.println(message + " gonderiliyor.");
			ProcessClass setValue = new ProcessClass();
			socketMessageSender.println(setValue.processGoinUp(message));
			socketMessageSender.flush();
		}
	}

}
