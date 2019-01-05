package tr.edu.medipol.ilerijava.vize.ertugrulsueren;

import java.io.*;
import java.net.*;
import java.util.*;
public class ErtugrulSueren1 {

	public static final int SERVER_PORT = 1234;

	private static ServerSocket sunucusoc;

	public static void main(String[] args)
	    throws UnknownHostException, IOException {

		try {

			sunucusoc = new ServerSocket(SERVER_PORT);

			System.out.println("Istemci..." +

			    sunucusoc.getLocalPort());

			while (true) {

				Socket istembag = sunucusoc.accept();

				System.out.println("Ýstemci Baðlandý " +

				    istembag.getInetAddress());

				ertugrulsueren2 her =

				    new ertugrulsueren2(istembag);

				her.start();
			}
		} catch (IOException e) {

			System.out.println(SERVER_PORT +

			    " Hata");

			e.printStackTrace();
		}
	}
}