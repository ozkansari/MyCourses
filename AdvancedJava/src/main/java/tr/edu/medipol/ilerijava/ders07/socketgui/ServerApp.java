package tr.edu.medipol.ilerijava.ders07.socketgui;

import java.net.*;
import java.io.*;
import java.util.*;

public class ServerApp {

	private static List<DataOutputStream> dataOutList = new Vector< >();
	private static Map<String, DataOutputStream> userDataOutMap = new HashMap<>();
	
	public static void main(String [] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(82);
		
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
				// istemcinin ilk mesaji kullanici adi, bunu al
				kullaniciAdi = dataIn.readUTF();
				userDataOutMap.put(kullaniciAdi, dataOut);
				
				while (true) {
					String mesaj = dataIn.readUTF();
					int idx = mesaj.indexOf(';');
					String hedefKullanici = mesaj.substring(0, idx);
					
					System.out.println("hedef: " + hedefKullanici);
					System.out.println(kullaniciAdi + ">" + mesaj);
					
					/*--
					String userList = userDataOutMap.keySet()
							.stream()
							.map(k->k.toString()+";")
							.reduce("",String::concat);
					*/
					String userList = "";
					for(String k : userDataOutMap.keySet()) {
						userList = userList + k + ";";
					}
					
					if(hedefKullanici.contentEquals("<<HERKES>>")) {
						for (DataOutputStream o : dataOutList) {
							o.writeUTF(kullaniciAdi + ">" + mesaj);
							o.writeUTF("USERLIST " + userList);
						}
					} else {
						DataOutputStream o = userDataOutMap.get(hedefKullanici);
						o.writeUTF(kullaniciAdi + ">" + mesaj);
						o.writeUTF("USERLIST " + userList);
					}
					
					
				}
				
			} catch (Exception e) {
				System.out.println("Mesaj okuma hatasi: " + e.getMessage());
				dataOutList.remove(dataOut);
				userDataOutMap.remove(kullaniciAdi);
			}

		}
		
		
	}
}
