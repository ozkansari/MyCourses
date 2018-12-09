package tr.edu.medipol.ilerijava.vize.burakkaratepe;

import java.io.*; 
import java.text.*; 
import java.util.*; 
import java.net.*; 

// Server class 
public class Server 
{ 
	public static void main(String[] args) throws IOException 
	{ 

		ServerSocket ss = new ServerSocket(5062); 
		
		
		while (true) 
		{ 
			Socket s = null; 
			
			try
			{ 
				
				s = ss.accept(); 
				
				System.out.println("Yeni baglantı : " + s); 
				
			
				DataInputStream dis = new DataInputStream(s.getInputStream()); 
				DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
				
				

			
				Thread t = new ClientHandler(s, dis, dos); 

				
				t.start(); 
				
			} 
			catch (Exception e){ 
				s.close(); 
				e.printStackTrace(); 
			} 
		} 
	} 
} 

// ClientHandler class 
class ClientHandler extends Thread 
{ 

	final DataInputStream dis; 
	final DataOutputStream dos; 
	final Socket s; 
	

	// Constructor 
	public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) 
	{ 
		this.s = s; 
		this.dis = dis; 
		this.dos = dos; 
	} 

	@Override
	public void run() 
	{ 
		String received; 
		String toreturn; 
		while (true) 
		{ 
			try { 

				// Ask user what he wants 
				dos.writeUTF("Yapmak istediğin işlemi yazarmısın..\n"); 
				
				// receive the answer from client 
				received = dis.readUTF(); 
				
				if(received.equals("Exit")) 
				{ 
					
					this.s.close(); 
					System.out.println("Baglantı kapatıldı"); 
					break; 
				} 
				
				String[] splited = received.split("\\s+");
				if(splited.length!=3 ) {
					dos.writeUTF("Geçersiz işlem!!"+splited.length); 
					break; 
				}
				String islem = splited[1].toString();
				int sayi1=Integer.parseInt(splited[0]);
				int sayi2=Integer.parseInt(splited[2]);
				switch (islem) { 
					case "*" : 
						toreturn = (sayi1*sayi2)+""; 
						dos.writeUTF(toreturn); 
						break; 
						
					case "/" : 
						toreturn = (sayi1/sayi2)+""; 
						dos.writeUTF(toreturn); 
						break; 
					case "-" : 
						toreturn = (sayi1-sayi2)+""; 
						dos.writeUTF(toreturn); 
						break; 
					
					case "+" : 
						toreturn = (sayi1+sayi2)+""; 
						dos.writeUTF(toreturn); 
						break; 
					default: 
						dos.writeUTF("Geçersiz işlem!"); 
						break; 
				} 
				
			} catch (Exception e) { 
				e.printStackTrace(); 
			} 
		} 
		
	
	} 
} 