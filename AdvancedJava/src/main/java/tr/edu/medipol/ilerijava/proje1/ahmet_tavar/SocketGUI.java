package tr.edu.medipol.ilerijava.proje1.ahmet_tavar;

//GUI icin gerekli importlar
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//Socket icin gerekli inputlar
import java.net.*;
import java.io.*;

public class SocketGUI extends JFrame {


	private JTextField sayi1 = new JTextField();
	private JTextField islem = new JTextField();
	private JTextField sayi2 = new JTextField();
	private JButton hesapla = new JButton("Hesapla");
	private JTextArea sonuc = new JTextArea();

	
	private InputThread inThread;
	private DataOutputStream out;
	
	public SocketGUI() throws Exception {
		Socket sunucuSckt = new Socket("localhost", 82);
		DataInputStream in = new DataInputStream(sunucuSckt.getInputStream());
		out = new DataOutputStream(sunucuSckt.getOutputStream());
		
		inThread = new InputThread(in);
		inThread.start();
		
		ekraniOlustur();
		hesapla.addActionListener( e -> mesajGonderAksiyonu(e));
	}

	private Object mesajGonderAksiyonu(ActionEvent e) {
		try {
			out.writeUTF(sayi1.getText() + ";" + islem.getText() + ";" + sayi2.getText());
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(this, "Mesaj gonderirken hata olustu. " + e.toString());
		}
		return e;
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
					sonuc.setText( sonuc.getText() + " " + mesaj);
					//sonuc.setText(sayi1.getText() + " " + islem.getText() + " " + sayi2.getText() + "=" + mesaj);
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
		this.setSize(400, 500);
		this.setLocation(600, 50);
		this.setResizable(false);
		this.setLayout(new GridLayout(5,2));
		
		/*JPanel satir1 = new JPanel();
		satir1.setLayout(new GridLayout(1,1));
		satir1.add(sonuc);
		this.add(satir1);
		*/
		
		JPanel satir2 = new JPanel();
		satir2.setLayout(new GridLayout(1,2));
		satir2.add(sayi1);
		satir2.add(islem);
		satir2.add(sayi2);
		satir2.add(hesapla);
		satir2.add(sonuc);
		this.add(satir2);
	}
}