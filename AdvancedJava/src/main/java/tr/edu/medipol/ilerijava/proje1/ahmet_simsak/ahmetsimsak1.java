package tr.edu.medipol.ilerijava.proje1.ahmet_simsak;

import java.net.*;
import java.io.*;
import java.util.*;

public class ahmetsimsak1 extends Thread {
	
	public double sonuc = 0;
	String[] dizi = new String[3];
	private Socket istemcibaglantisi;

	public ahmetsimsak1(Socket istembagl) {
		
		this.istemcibaglantisi = istembagl;
		
	}

	@Override
	public void run() {
		System.out.println("Thread calisiyor" + istemcibaglantisi.getInetAddress());
		BufferedReader istemciOkuyucu = null;

		try {
			InputStream in = this.istemcibaglantisi.getInputStream();
			InputStreamReader read = new InputStreamReader(in);
			istemciOkuyucu = new BufferedReader(read);
			istemciOkuyucu = new BufferedReader(new InputStreamReader(
					istemcibaglantisi.getInputStream()
					)
			);
		} catch (IOException e) {
			System.out.println("Ýstemcide hata oluþtu : " + e.getMessage());

		}
		int i = 0;
		do {
			try {
				dizi[i] = istemciOkuyucu.readLine();
				System.out.println(dizi[i]);
				i++;
			} catch (Exception e) {
				i=0;
				System.out.println("aaaaa");
				break;
			}
		} while (i<3);
		if (dizi[2].equals("+")) {
			sonuc = (Integer.valueOf(dizi[0]) + Integer.valueOf(dizi[1]));
		} 
		else if (dizi[2].equals("-")) {
			sonuc = (Integer.valueOf(dizi[0]) - Integer.valueOf(dizi[1]));
		} 
		else if (dizi[2].equals("*")) {
			sonuc = (Integer.valueOf(dizi[0]) * Integer.valueOf(dizi[1]));
		} 
		else if (dizi[2].equals("/")) {
			sonuc = (Integer.valueOf(dizi[0]) / Integer.valueOf(dizi[1]));
		} 
		else {
			System.out.println("Yanlýþ Giriþ");
		}
		System.out.println(sonuc);
		
	}
}