package tr.edu.medipol.ilerijava.proje1.berke_bac;
import java.net.*;
import java.io.*;
import java.util.*;
public class ServerApp {
	private static List<DataOutputStream> dataOutList = new ArrayList< >();
	private static Map<String,DataOutputStream> userDataOutMap =new HashMap<>();
	
	public static void main(String [] args) throws Exception{

		ServerSocket serverSocket =new ServerSocket(82);
		while(true) {
			Socket istemciSocket=serverSocket.accept();
			
			InputStream inStream = istemciSocket.getInputStream();	
			DataInputStream dataIn =new DataInputStream(inStream);
			
			String k = dataIn.readUTF();
			
			DataOutputStream dataOut = new DataOutputStream(
					istemciSocket.getOutputStream()
		);
		
		dataOutList.add(dataOut);
		ClientSpesificThread t = new ClientSpesificThread(dataIn,dataOut);
		t.start();
		}
	}

	private static class ClientSpesificThread extends Thread {
		
		private DataInputStream dataIn;
		private DataOutputStream dataOut;
		public ClientSpesificThread(DataInputStream dataIn, DataOutputStream dataOut) {
			super();
			this.dataIn = dataIn;
			this.dataOut= dataOut;
		}
	
		@Override
		public void run() {
			try {
				int sonuc=0;
				
				while (true) {
					String mesaj= dataIn.readUTF();
					System.out.println("mesaj : " + mesaj);
					String[] parca = mesaj.split(" ");
					String sayi1 =parca[0];
					String islemtipi =parca[1];
					String sayi2 =parca[2];
					
					if(islemtipi.equals("+"))
						sonuc=Integer.parseInt(sayi1)+Integer.parseInt(sayi2);
					if(islemtipi.equals("-"))
						sonuc=Integer.parseInt(sayi1)-Integer.parseInt(sayi2);
					if(islemtipi.equals("*"))
						sonuc=Integer.parseInt(sayi1)*Integer.parseInt(sayi2);
					if(islemtipi.equals("/"))
						sonuc=Integer.parseInt(sayi1)/Integer.parseInt(sayi2);
					
					System.out.println(sonuc);
					dataOut.write(sonuc);
					}
					
				}catch (IOException e) {
					System.out.println("Mesaj okuma hatasi:" + e.getMessage());
					dataOutList.remove(dataOut);
			} 

			}
			
		}
		
		
	}
	



