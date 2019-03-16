package tr.edu.medipol.ilerijava.ders04.socketornek1;

import java.net.*;
import java.io.*;

public class ServerClientSimple {

	public static void main(String[] args) throws Exception {
		
		// https://www.whatismyip.com/ 
		// MacOS terminal > ifconfig -a
		// Win terminal > ipconfig -all
		// 10.201.64.224
		// 192.168.4.233 
		// localhost
		// 127.0.0.1
		
		Socket sunucuBaglantisi = new Socket("10.201.64.224", ServerMain.SERVER_PORT);
		DataInputStream in = new DataInputStream(sunucuBaglantisi.getInputStream());
		DataOutputStream out = new DataOutputStream(sunucuBaglantisi.getOutputStream());
		out.writeUTF("Merhaba " + sunucuBaglantisi.getLocalSocketAddress());
		System.out.println( in.readUTF() );

	}

}
