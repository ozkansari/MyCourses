package tr.edu.medipol.ilerijava.ders03.lab1;

import java.net.*;
import java.io.*;

public class SunucuProgram1 {

	// 10.201.64.221
	
	public static void main(String[] args) {
		
		String myIp = getMyIp();
		
		// 1-) Sunucu tarafindaki socketi acmis oluyoruz
		ServerSocket serverSocket = sunucuSocketiOlustur(myIp);

		while(true) {
			// 2-) Istemci baglantisini kabul et
			Socket clientConnection = istemciBaglantisiKabulEt(serverSocket);
			
			// 3-) Istemciden mesaj al-ver
			istemciyleMesajlas(clientConnection);
		}

	}

	private static ServerSocket sunucuSocketiOlustur(String myIp) {
		int portNumber = 8182;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Sunucu socketi acildi: " + myIp + ":" + portNumber);
		} catch (IOException e) {
			System.out.println("Port kullanimda " + portNumber);
			e.printStackTrace();
			System.exit(0);
		}
		return serverSocket;
	}

	private static Socket istemciBaglantisiKabulEt(ServerSocket serverSocket) {
		Socket clientConnection = null;
		try {
			System.out.println(" Baglanti bekleniyor: " );
			clientConnection = serverSocket.accept();
		} catch (IOException e) {
			System.out.println("Client baglanti hatasi " + e.getMessage());
			e.printStackTrace();
		}
		return clientConnection;
	}
	
	private static void istemciyleMesajlas(Socket clientConnection) {
		try {
			InputStream clientIn = clientConnection.getInputStream();
			DataInputStream dataIn = new DataInputStream(clientIn);
			String messageIn = dataIn.readUTF();
			System.out.println("Mesaj - " + messageIn);
			
			OutputStream clientOut = clientConnection.getOutputStream();
			DataOutputStream dataOut = new DataOutputStream(clientOut);
			dataOut.writeUTF("Mesaj alindi " + messageIn);
			
		} catch (IOException e) {
			System.out.println("Client ile mesajlasmada hata olustu " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static String getMyIp() {
		try {
			InetAddress inetAddress = InetAddress. getLocalHost();
			// System.out.println("IP Address:- " + inetAddress. getHostAddress());
			// System.out.println("Host Name:- " + inetAddress. getHostName());
			return inetAddress. getHostAddress();
		} catch(Exception e) {
			
		}
		return "bilinmiyor";
	}

}
