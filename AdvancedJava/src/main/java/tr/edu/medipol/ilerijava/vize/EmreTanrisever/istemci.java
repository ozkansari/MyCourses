package tr.edu.medipol.ilerijava.vize.EmreTanrisever;

import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.InetAddress; 
import java.net.Socket; 
import java.net.UnknownHostException; 
import java.util.Scanner; 

public class istemci {

	public static void main(String[] args) throws IOException 
	{ 
		InetAddress ip = InetAddress.getLocalHost(); 
        int port = 7777; 
        Scanner sc = new Scanner(System.in); 
  
        Socket s = new Socket(ip, port); 
  
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
  
        System.out.print("1. sayiyi giriniz : ");
        String sayi1 = sc.nextLine();
        System.out.print("iþlemi giriniz : ");
        String islem = sc.nextLine();
        System.out.print("2. sayiyi giriniz : ");
        String sayi2 = sc.nextLine();
            
        String inp = sayi1+ " " + islem +" " + sayi2; 
            
        if (inp.equals("bye")) 

        dos.writeUTF(inp); 

        String sonuc = dis.readUTF(); 
        System.out.println("Sonuç = " + sonuc); 

	} 

}
