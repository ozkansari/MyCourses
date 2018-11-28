package tr.edu.medipol.ilerijava.vize.burakkaratepe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; 
import java.net.*; 
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 

// Client class 
public class Client extends JFrame
{ 	
	public JPanel anapanel = new JPanel();
	static JTextField yazi = new JTextField(10);
	static JButton button= new JButton("Gönder");
	static JLabel sonuc= new JLabel("");
	static Socket s = null; 
	Client(){
		this.setTitle("Kütüphane - Burak Karatepe V.0.1");
		this.setSize(500,650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		anapanel.add(new JLabel("Yapmak İstediğin işlemi aralarında boşluk bırakarak yaz."));
		anapanel.add(yazi);
		
		anapanel.add(button);
		anapanel.add(sonuc);
		this.add(anapanel);
		this.setVisible(true);
		
	}
	public static void main(String[] args) throws IOException 
	{ 
		new Client();
		try
		{ 
			// getting localhost ip 
			InetAddress ip = InetAddress.getByName("localhost"); 
	
			// establish the connection with server port 5056 
			Socket s = new Socket(ip, 5062); 
	
			// obtaining input and out streams 
			DataInputStream dis = new DataInputStream(s.getInputStream()); 
			DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
			
			// the following loop performs the exchange of 
			// information between client and client handler 
			
			button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	try {
	            		String tosend=yazi.getText();
	            		String received = dis.readUTF(); 
						sonuc.setText(received);
	            		if(tosend.equals("Exit")) 
	    				{ 
	    					System.out.println("Closing this connection : " + s); 
	    					s.close(); 
	    					System.out.println("Connection closed"); 
	    		
	    				} 
						dos.writeUTF(tosend);
						 received = dis.readUTF(); 
						sonuc.setText(received);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
			
						e1.printStackTrace();
					} 
	            }
	        });
			
			
			// closing resources 
		
		
		}catch(Exception e){ 
			e.printStackTrace(); 
		} 
	} 
} 
