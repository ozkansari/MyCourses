package tr.edu.medipol.ilerijava.proje1.azizbirinci;

import java.net.*;
import java.io.*;
import java.util.*;

public class aziizbirinci extends Thread {
	public double sonuc = 0;
	String[] gel = new String[3];
	private Socket istembag;

	public aziizbirinci(Socket istembagl) {
		this.istembag = istembagl;
	}

	@Override
	public void run() {
		System.out.println("Thread calisiyor" +

				istembag.getInetAddress());
		BufferedReader istemciOkuyucu = null;

		try {
			InputStream girdi = this.istembag.getInputStream();
			InputStreamReader girdiOkuyucu = new InputStreamReader(girdi);
			istemciOkuyucu = new BufferedReader(girdiOkuyucu);
			istemciOkuyucu = new BufferedReader(new InputStreamReader(

					istembag.getInputStream()

			)

			);
		} catch (IOException e) {
			System.out.println("Istemci okuyucu acilirken hata: "

					+ e.getMessage());

		}
		int i = 0;
		do {
			try {
				gel[i] = istemciOkuyucu.readLine();
				System.out.println(gel[i]);
				i++;
			} catch (Exception e) {
				i=0;
				System.out.println("azzz");
				break;
			}
		} while (i<3);
		if (gel[2].equals("+")) {
			sonuc = (Integer.valueOf(gel[0]) + Integer.valueOf(gel[1]));
		} else if (gel[2].equals("-")) {
			sonuc = (Integer.valueOf(gel[0]) - Integer.valueOf(gel[1]));
		} else if (gel[2].equals("*")) {
			sonuc = (Integer.valueOf(gel[0]) * Integer.valueOf(gel[1]));
		} else if (gel[2].equals("/")) {
			sonuc = (Integer.valueOf(gel[0]) / Integer.valueOf(gel[1]));
		} else {
			System.out.println("Yanlýþ Giriþ");
		}
		System.out.println(sonuc);/*
		PrintWriter sunucuMesajGonderici = null;
		try {
			Socket sunucuBaglantisi = new Socket("localhost",3333);

			sunucuMesajGonderici = new PrintWriter(sunucuBaglantisi.getOutputStream());

		} catch (UnknownHostException e) {
			System.out.println("Sunucu IP hatali" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Sunucuya baglanirken hata alindi:" +

					e.getMessage());

		}
		sunucuMesajGonderici.println(sonuc);*/
	}
}