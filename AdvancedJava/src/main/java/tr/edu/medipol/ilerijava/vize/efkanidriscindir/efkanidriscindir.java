package tr.edu.medipol.ilerijava.vize.efkanidriscindir;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class efkanidriscindir {
	private static final int SERVER_PORT = 2222;
	private static Socket sunucuBaglantisi;
	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		int s1 = 0, s2 = 0;
		String istenen;
		System.out.print("Üç sayi giriniz:");
		s1 = input.nextInt();
		s2 = input.nextInt();
		System.out.println("Yapmak istediðiniz iþlemi giriniz.");
		System.out.println("Toplama için: (+)");
		System.out.println("Çýkarma için: (-)");
		System.out.println("Bölme için: (/)");
		System.out.println("Çarpma için (*)");
		istenen = input.next();
		System.out.println("Istemci aciliyor.");
		PrintWriter sunucuMesajGonderici = null;
		try {
			sunucuBaglantisi = new Socket("localhost",

			    efkanidriscindir.SERVER_PORT);

			sunucuMesajGonderici =

			    new PrintWriter(sunucuBaglantisi.getOutputStream());

		} catch (UnknownHostException e) {
			System.out.println("Sunucu IP hatali" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Sunucuya baglanirken hata alindi:" +

			    e.getMessage());

		}
		sunucuMesajGonderici.println(s1);
		sunucuMesajGonderici.println(s2);
		sunucuMesajGonderici.println(istenen);
		sunucuMesajGonderici.flush();

	}
}