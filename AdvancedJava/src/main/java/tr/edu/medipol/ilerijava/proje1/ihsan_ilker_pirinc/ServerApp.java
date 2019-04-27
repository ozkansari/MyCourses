package tr.edu.medipol.ilerijava.proje1.ihsan_ilker_pirinc;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerApp {

	private static List<DataOutputStream> dataOutList = new Vector< >();
	private static Map<String, DataOutputStream> userDataOutMap = new HashMap<>();
	
	public static void main(String [] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(88);
		
		while(true) {
			Socket istemciSocket =  serverSocket.accept();
			
			InputStream inStream = istemciSocket.getInputStream();
			DataInputStream dataIn = new DataInputStream(inStream);
			
			DataOutputStream dataOut = new DataOutputStream(
					istemciSocket.getOutputStream()
			);

			ClientSpesificThread t = new ClientSpesificThread(dataIn, dataOut);
			t.start();
		}
		
	}
	
	private static class ClientSpesificThread extends Thread {

		private DataInputStream dataIn;
		private DataOutputStream dataOut;
		private String kullaniciAdi;
		
		public ClientSpesificThread(DataInputStream dataIn, DataOutputStream dataOut) {
			super();
			this.dataIn = dataIn;
			this.dataOut = dataOut;
			dataOutList.add(dataOut);
			
		}
		
		@Override
		public void run() {
			try {
				// istemcinin ilk mesaji kullanici adidir
				kullaniciAdi = dataIn.readUTF();
				userDataOutMap.put(kullaniciAdi, dataOut);
				System.out.println(kullaniciAdi);
				
				while (true) {
					String mesaj = dataIn.readUTF();
					System.out.println(mesaj);
					double result=0;
					
					int idx = mesaj.indexOf(';');
					double x = Double.parseDouble(mesaj.substring(0, idx));
					int idy = mesaj.indexOf(',');
					double y = Double.parseDouble(mesaj.substring(idx+1, idy));
					int idi = mesaj.indexOf('.');
					double islem = Double.parseDouble(mesaj.substring(idy+1, idi));
					
					if (islem ==0){
						result = x + y;}
						
						else if (islem ==1){
						result = x - y;
						}
						
						else if (islem ==2){
						result = x * y;
						}
						
						else if (islem ==3){
						result = x / y;
						}
					
					String userList = "";
					for(String k : userDataOutMap.keySet()) {
						userList = userList + k + ";";}
						
					// Sonuc ve kullanicilar konsolda goruntulenir.
					
					System.out.println("SONUC: " + result);
					System.out.println("KULLANICILAR " + userList);
					dataOut.writeUTF("SONUC: " + result);
					dataOut.writeUTF("KULLANICILAR " + userList);
				}
				
			} catch (Exception e) {
				System.out.println("Mesaj okuma hatasi: " + e.getMessage());
				dataOutList.remove(dataOut);
				userDataOutMap.remove(kullaniciAdi);
			}

		}
		
		
	}
}