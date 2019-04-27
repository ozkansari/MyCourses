package tr.edu.medipol.ilerijava.proje1.ahmet_simsak;

import java.io.*;
import java.net.*;

public class ServerApp {
	public static final int SERVER_PORT = 8082;
	private static ServerSocket sunucuSocketi;

	public static void main(String[] args) throws UnknownHostException , IOException {

		try {
			sunucuSocketi = new ServerSocket(SERVER_PORT);
			System.out.println("Istemciler bekleniyor." + sunucuSocketi.getLocalPort());

			while (true) {
				Socket istemcibaglantisi = sunucuSocketi.accept();
				System.out.println("Istemci baðlantýsý baþarýlý. " +

						istemcibaglantisi.getInetAddress());

				ahmetsimsak1 bal =

						new ahmetsimsak1(istemcibaglantisi);

				bal.start();
			}
		} catch (IOException e) {
			System.out.println(SERVER_PORT +

					" Ustunden sunucu socketi acarken hata olustu");

			e.printStackTrace();
		}

	}
}