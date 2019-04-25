package tr.edu.medipol.ilerijava.proje1.azizbirinci;

import java.io.*;
import java.net.*;

public class ServerApp {
	public static final int SERVER_PORT = 2222;
	private static ServerSocket sunucuSocketi;

	public static void main(String[] args) throws UnknownHostException, IOException {

		try {
			sunucuSocketi = new ServerSocket(SERVER_PORT);
			System.out.println("Istemciler bekleniyor." + sunucuSocketi.getLocalPort());

			while (true) {
				Socket istembag = sunucuSocketi.accept();
				System.out.println("Istemci baðlantýsý baþarýlý. " +

						istembag.getInetAddress());

				aziizbirinci bal =

						new aziizbirinci(istembag);

				bal.start();
			}
		} catch (IOException e) {
			System.out.println(SERVER_PORT +

					" Ustunden sunucu socketi acarken hata olustu");

			e.printStackTrace();
		}

	}
}