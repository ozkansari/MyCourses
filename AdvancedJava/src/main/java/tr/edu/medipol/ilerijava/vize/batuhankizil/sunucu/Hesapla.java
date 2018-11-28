package tr.edu.medipol.ilerijava.vize.batuhankizil.sunucu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Hesapla extends Thread {

	private HesapMakinaSunucu sunucu;
	private Socket socket;

	public Hesapla(final Socket socket, final HesapMakinaSunucu sunucu) {
		this.sunucu = sunucu;
		this.socket = socket;
	}

	@Override
	public void run() {
		try {	
			if(socket == null) {
				try {
					wait();
				} catch (final InterruptedException e) {
				
				}			
			}
			
	        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        final PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

	        String str = in.readLine();
	        while (str != null) {
	            double sonuc = 0, sayi1 = 0, sayi2 = 0;
	            String is = "+";
	            String islem = "";
	            if (str.contains("+")) {
	                System.out.println("Toplama");
	                islem = "Toplama";
	                is = "+";
	                final String[] sayilar = str.split("[+]");
	                sayi1 = Double.parseDouble(sayilar[0]);
	                sayi2 = Double.parseDouble(sayilar[1]);
	                sonuc = islemYap(sayi1, sayi2, islem);
	            } else if (str.contains("-")) {
	                System.out.println("Çýkartma");
	                islem = "Cikarma";
	                is = "-";
	                final String[] sayilar = str.split("[-]");
	                sayi1 = Double.parseDouble(sayilar[0]);
	                sayi2 = Double.parseDouble(sayilar[1]);
	                sonuc = islemYap(sayi1, sayi2, islem);
	            } else if (str.contains("/")) {
	                System.out.println("Bölme");
	                islem= "Bolme";
	                is = "/";
	                final String[] sayilar = str.split("[/]");
	                sayi1 = Double.parseDouble(sayilar[0]);
	                sayi2 = Double.parseDouble(sayilar[1]);
	                sonuc = islemYap(sayi1, sayi2, islem);
	            } else if (str.contains("*")) {
	                System.out.println("Çarpma");
	                islem = "Carpma";
	                is = "*";
	                final String[] sayilar = str.split("[*]");
	                sayi1 = Double.parseDouble(sayilar[0]);
	                sayi2 = Double.parseDouble(sayilar[1]);
	                sonuc = islemYap(sayi1, sayi2, islem);
	            }
	
	            final String hesaplanan = String.valueOf(sonuc);
	            
	            final String yapilanIslem = islem + " : " + sayi1 + " " + is + " " + sayi2  + " = " + hesaplanan;
	            sunucu.yazdir(yapilanIslem);
	            out.println(hesaplanan);
	            str = in.readLine();
	        }
        
		}catch(final IOException ex){
			ex.printStackTrace();
		}finally{
		try {
			socket.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}
}

	private static double islemYap(final double sayi1, final double sayi2, final String istem) {
		double sonuc = 0;
		switch (istem) {
		case "Toplama":
			sonuc = sayi1 + sayi2;
			break;
		case "Cikarma":
			sonuc = sayi1 - sayi2;
			break;
		case "Bolme":
			sonuc = sayi1 / sayi2;
			break;
		case "Carpma":
			sonuc = sayi1 * sayi2;
			break;
		default:
			sonuc = 0;
			break;
		}
		return sonuc;
	}
}
