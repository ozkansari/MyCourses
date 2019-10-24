package tr.edu.medipol.ilerijava.ders04.lab;

import java.net.*;
import java.util.*;
import java.io.*;

public class IstemciProgrami2 {

	public static void main(String[] args) throws Exception {
		
		Socket sunucuBagl = new Socket("10.201.64.221", 8182);
		
		DataInputStream alici = new DataInputStream(sunucuBagl.getInputStream());
		DataOutputStream gonderici = new DataOutputStream(sunucuBagl.getOutputStream());
		Scanner konsolOkuyucu = new Scanner(System.in);
		
		gonderici.writeUTF("OZKAN");
		
		new OkuyucuThread(alici).start();
		
		do {
			System.out.print("> ");
			String mesaj = konsolOkuyucu.nextLine();
			gonderici.writeUTF(mesaj);
			
		} while(true);
	}
	
	private static class OkuyucuThread extends Thread {
		private DataInputStream alici;
		OkuyucuThread(DataInputStream alici) {
			this.alici = alici;
		}
		public void run() {
			try {
				while(true) {
					String gelen = alici.readUTF();
					System.out.println(gelen);
				}
			} catch(Exception e) {
				
			}
			
		}
	}
}










