package tr.edu.medipol.ilerijava.proje1.berke_bac;

import javax.swing.*;
import java.awt.*;

import java.net.*;
import java.io.*;

public class SocketGUI extends JFrame{

	
	String kullaniciAdi;
	
	private JTextField sayi1 = new JTextField();
	private Label sayi1label= new Label("Sayi1 :");
	private JTextField sayi2 = new JTextField();
	private Label sayi2label= new Label("Sayi2 :");
	private JTextField islem = new JTextField();
	private Label islemlabel= new Label("Islem :");
	private JButton hesapla = new JButton("Hesapla");

	private Label sonuc= new Label(" ");
	
	private InputThread inThread;
	//private OutputThread outThread;
	private DataOutputStream out;
	public SocketGUI() throws Exception{
		
		kullaniciAdi = JOptionPane.showInputDialog(this, "Kullanıcı adı: ");
		
		Socket sunucuSckt = new Socket("localhost",82);
		DataInputStream in = new DataInputStream(sunucuSckt.getInputStream());
		out = new DataOutputStream(sunucuSckt.getOutputStream());
		out.writeUTF(kullaniciAdi);
		inThread = new InputThread(in);
		inThread.start();

		//outThread = new OutputThread(out);
		//outThread.start();
		
		ekraniOlustur();
		hesapla.addActionListener( e-> {
			try {
				
				out.writeUTF(sayi1.getText() + " " + islem.getText() + " " + sayi2.getText());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Hata");
			}
		});
		
		
	}
	

	
	private class InputThread extends Thread {
		private DataInputStream in;
		public InputThread(DataInputStream in) {
			this.in =in;
		}
		@Override
		public void run() {
			super.run();
			
			
			
		}
	}
	
	/*private class OutputThread extends Thread {
		private DataOutputStream out;
		public OutputThread(DataOutputStream out) {
			this.out=out;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
	}*/


	private void ekraniOlustur() {
		
		this.setTitle("Socket GUI");
		this.setSize(500, 500);
		this.setLocation(600, 50);
		this.setResizable(false);
		this.setLayout(new GridLayout(4,1));
		
		JPanel satir1= new JPanel();
		satir1.setLayout(new GridLayout(1,2));
		satir1.add(sayi1label);
		satir1.add(sayi1);
		this.add(satir1);
		
		JPanel satir2= new JPanel();
		satir2.setLayout(new GridLayout(2,2));
		satir2.add(sayi2label);
		satir2.add(sayi2);
		this.add(satir2);
		
		JPanel satir3= new JPanel();
		satir3.setLayout(new GridLayout(3,2));
		satir3.add(islemlabel);
		satir3.add(islem);
		this.add(satir3);

		JPanel satir4= new JPanel();
		satir4.setLayout(new GridLayout(4,2));
		satir4.add(hesapla);
		satir4.add(sonuc);
		this.add(satir4);
		
	}
	
	

}
