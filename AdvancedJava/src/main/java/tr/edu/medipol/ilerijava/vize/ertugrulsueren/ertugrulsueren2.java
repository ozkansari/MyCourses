package tr.edu.medipol.ilerijava.vize.ertugrulsueren;

import java.net.*;
import java.io.*;
import java.util.*;

public class ertugrulsueren2 extends Thread {

	public double sonuc = 0;

	String[] ertu = new String[4];

	private Socket istembag;

	public ertugrulsueren2(Socket istembagla) {

		this.istembag = istembagla;

	}
	@Override

	public void run() {

		BufferedReader istoku = null;

		try {

			InputStream gir = this.istembag.getInputStream();

			InputStreamReader girokuyucu = new InputStreamReader(gir);

			istoku = new BufferedReader(girokuyucu);

			istoku = new BufferedReader(

			    new InputStreamReader(

			        istembag.getInputStream()

					)

			);
		} catch (IOException e) {

			System.out.println("istoku acilirken hata "

			    + e.getMessage());

		}
		int i = 0;

		while (true) {

			try {

				ertu[i] = istoku.readLine();

				if (ertu[i] == null) {

					break;

				}
				System.out.println(ertu[i]);

				i++;

			} catch (IOException e) {

				break;

			}
		}

		if (ertu[2].equals("+")) {

			sonuc = (Integer.valueOf(ertu[0]) + Integer.valueOf(ertu[1]));

		} else if (ertu[2].equals("-")) {

			sonuc = (Integer.valueOf(ertu[0]) - Integer.valueOf(ertu[1]));

		} else if (ertu[2].equals("*")) {

			sonuc = (Integer.valueOf(ertu[0]) * Integer.valueOf(ertu[1]));

		} else if (ertu[2].equals("/")) {

			sonuc = (Integer.valueOf(ertu[0]) / Integer.valueOf(ertu[1]));

		}

		System.out.println(sonuc);

	}

}