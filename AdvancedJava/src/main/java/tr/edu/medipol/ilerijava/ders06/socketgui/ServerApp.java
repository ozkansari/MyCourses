package tr.edu.medipol.ilerijava.ders06.socketgui;

import java.net.*;
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
					System.out.println( ">" + mesaj);
					for(DataOutputStream o : dataOutList) {
						o.writeUTF(mesaj);
					}
				} catch (Exception e) {
					System.out.println("Mesaj okuma hatasi: " + e.getMessage());
					dataOutList.remove(dataOut);
					break;
				}
				
				
			}
			
		}
		
		
	}
}
