package tr.edu.medipol.ilerijava.vize.EmreTanrisever;

import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.StringTokenizer;

public class sunucu {

	public static final int Port_No=7777;
	
	public static void main(String args[]) throws IOException 
	{ 
		System.out.println(Port_No + " üzerinden sunucu acýlýyor.");
		ServerSocket ss = new ServerSocket(Port_No); 
		
		while(true) {
			Socket s = ss.accept(); 
			System.out.println(s.getInetAddress()+ " baðlandý");
			SunucuThread thread  = new SunucuThread(s);
			
			thread.start();
		}
	} 

}
