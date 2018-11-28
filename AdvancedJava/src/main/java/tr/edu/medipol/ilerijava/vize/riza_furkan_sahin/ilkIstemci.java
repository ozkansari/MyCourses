package tr.edu.medipol.ilerijava.vize.riza_furkan_sahin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ilkIstemci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		System.out.println("Ýstemci Acýldý");
		Socket soc = new Socket ("localhost" , 9806);
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Birinci Sayýyý gir");
		int sayi1 = Integer.parseInt(userInput.readLine());
		PrintWriter out = new PrintWriter(soc.getOutputStream(),true);
		out.println("Faktoriyel" + sayi1 + hesapla(sayi1));
		BufferedReader in = new BufferedReader (new InputStreamReader(soc.getInputStream()));
		System.out.println(in.readLine());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	private static String hesapla(int sayi1) {
		// TODO Auto-generated method stub
		return null;
	}

		
		
	}

