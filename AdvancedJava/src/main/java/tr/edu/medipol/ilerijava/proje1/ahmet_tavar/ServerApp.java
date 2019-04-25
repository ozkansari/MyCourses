package tr.edu.medipol.ilerijava.proje1.ahmet_tavar;

import java.net.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;

public class ServerApp {

	private static List<DataOutputStream> dataOutList = new Vector< >();
	
	public static void main(String [] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(82);
		
		while(true) {
			Socket istemciSocket =  serverSocket.accept();
			
			InputStream inStream = istemciSocket.getInputStream();
			DataInputStream dataIn = new DataInputStream(inStream);
			
			DataOutputStream dataOut = new DataOutputStream(
					istemciSocket.getOutputStream()
			);
			dataOutList.add(dataOut);
			
			ClientSpesificThread t = new ClientSpesificThread(dataIn, dataOut);
			t.start();
		}
		
	}
	
	private static class ClientSpesificThread extends Thread {

		private DataInputStream dataIn;
		private DataOutputStream dataOut;
		
		public ClientSpesificThread(DataInputStream dataIn, DataOutputStream dataOut) {
			super();
			this.dataIn = dataIn;
			this.dataOut = dataOut;
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					
					String mesaj = dataIn.readUTF();
					System.out.println( "mesaj: " + mesaj);
					String [] parca = mesaj.split(";");
					
					String sayi1 = parca[0];
					String islem = parca[1];
					String sayi2 = parca[2];
					
					
					int sayi1int = Integer.valueOf(sayi1);
					int sayi2int = Integer.valueOf(sayi2);
					int sonuc = islemAksiyonu(sayi1int,sayi2int,islem);
					
					System.out.println( "sonuç: " + sonuc);
					for(DataOutputStream o : dataOutList) {
						o.writeUTF("sonuç: "+sonuc);
					}
					
				} catch (Exception e) {
					System.out.println("Mesaj okuma hatasi: " + e);
					dataOutList.remove(dataOut);
					break;
				}
				
			}
			
		}
		
		
		
		private int islemAksiyonu(int sayi1, int sayi2, String islem) {
			int sonuc = 0;
			if(islem.equals("+")) {
				sonuc = sayi1+sayi2;
			}
			else if(islem.equals("*")) {
				sonuc = sayi1*sayi2;
			}
			else if(islem.equals("-")) {
				sonuc = sayi1-sayi2;
			}
			else if(islem.equals("/")) {
				sonuc = sayi1/sayi2;
			}
			return sonuc;
			
		}
		
	}
}