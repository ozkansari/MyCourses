package tr.edu.medipol.ilerijava.vize.riza_furkan_sahin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ilkSunucu {
	
	public static void main (String[] args) {
		
		try
		{
		
		System.out.println("Sunucu bekleniyor...");
		ServerSocket ss = new ServerSocket(9806);
		Socket soc = ss.accept();
		System.out.println("Baðlantý Baþarýlý");
		BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		String sayi1 = in.readLine();
		PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
		out.println("Faktoriyel: "+sayi1 + hesapla(sayi1));
		
		
		}
		
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
	
private static String hesapla(String sayi1) {
		// TODO Auto-generated method stub
		return null;
	}

static int hesapla(int sayi1) {
		
		int fact=1;
		for(int i=1;i<=sayi1;i++)
		{
			fact = fact*1;
		}
	
	}

