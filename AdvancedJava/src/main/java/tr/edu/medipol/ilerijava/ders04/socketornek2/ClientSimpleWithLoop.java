package tr.edu.medipol.ilerijava.ders04.socketornek2;

import java.net.*;
import java.io.*;

public class ClientSimpleWithLoop {

	public static void main(String[] args) throws Exception {
		
		// https://www.whatismyip.com/ 
		// MacOS terminal > ifconfig -a
		// Win terminal > ipconfig -all
		// 10.201.64.224
		// 192.168.5.239 
		// localhost
		// 127.0.0.1
		while(true) {
			Socket sunucuBaglantisi = new Socket("10.201.64.224", 82);
			DataInputStream in = new DataInputStream(sunucuBaglantisi.getInputStream());
			DataOutputStream out = new DataOutputStream(sunucuBaglantisi.getOutputStream());
			out.writeUTF("Merhaba Ben Ozkan " + sunucuBaglantisi.getLocalSocketAddress());
			System.out.println( in.readUTF() );
			Thread.sleep(5000);
		}

	}

}
