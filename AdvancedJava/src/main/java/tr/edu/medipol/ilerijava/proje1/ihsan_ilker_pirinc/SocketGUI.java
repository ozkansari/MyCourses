package tr.edu.medipol.ilerijava.proje1.ihsan_ilker_pirinc;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//Socket icin gerekli inputlar
import java.net.*;
import java.io.*;

public class SocketGUI extends JFrame {

	private JTextArea kullanicilar = new JTextArea("Kullanici listesi");
	private JTextField sayialan1 = new JTextField();
	private JTextField sayialan2 = new JTextField();
	private JTextArea sonucGoster = new JTextArea("Sonuclar burada gosterilecektir");
	private JButton mesajGonder = new JButton("Hesapla");
	String [] secim = {"+", "-", "*", "%"};
    private JComboBox <String> islemSecimi = new JComboBox <String>(secim);
	
	private InputThread inThread;
	private DataOutputStream out;
	
	public SocketGUI() throws Exception {
		
		String kullaniciAdi = JOptionPane.showInputDialog(this, "Kullanici Adi:");
		
		Socket sunucuSckt = new Socket("localhost", 88);
		DataInputStream in = new DataInputStream(sunucuSckt.getInputStream());
		out = new DataOutputStream(sunucuSckt.getOutputStream());
		
		// istemci baglanir baglanmaz ismini sunucuya gonderir
		out.writeUTF(kullaniciAdi);
		
		inThread = new InputThread(in);
		inThread.start();
		
	
		ekraniOlustur();
		
	mesajGonder.addActionListener( e -> sonucGosterAksiyonu(e));
	}

	private void sonucGosterAksiyonu(ActionEvent e) {

	String gonderilecekMesaj=sayialan1.getText()+";"+sayialan2.getText()+","+islemSecimi.getSelectedIndex()+".";
			
	try {
			out.writeUTF(gonderilecekMesaj);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "Mesaj gonderirken hata olustu. ");}
		
		}

	private class InputThread extends Thread {
		private DataInputStream in;
		public InputThread(DataInputStream in) {
			this.in = in;
		}
		@Override
		public void run() {
			super.run();
			while(true) {
				try {
					String mesaj = in.readUTF();
					
					System.out.println(mesaj);
					
					if(mesaj.startsWith("KULLANICILAR")) {
						kullanicilar.setText(mesaj);
						
					} else {
						sonucGoster.setText(mesaj);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		}
	}
	
	
	private void ekraniOlustur() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Socket GUI");
		this.setSize(600, 200);
		this.setLocation(600, 50);
		this.setResizable(false);
		this.setLayout(new GridLayout(3,1));
		
		JPanel satir1 = new JPanel();
		satir1.setLayout(new GridLayout(1,1));
		kullanicilar.setEditable(false);
		satir1.add(new JScrollPane(kullanicilar));
		this.add(satir1);
		
		JPanel satir2 = new JPanel();
		satir2.setLayout(new GridLayout(1,4));
		satir2.add(islemSecimi);
		satir2.add(sayialan1);
		satir2.add(sayialan2);
		satir2.add(mesajGonder);
		this.add(satir2);
		
		JPanel satir3 = new JPanel();
		satir3.setLayout(new GridLayout(1,1));
		satir3.add(sonucGoster);
		sonucGoster.setEditable(false);
		this.add(satir3);
	}
}