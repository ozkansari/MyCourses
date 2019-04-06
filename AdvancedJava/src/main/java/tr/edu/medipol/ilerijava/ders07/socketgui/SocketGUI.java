package tr.edu.medipol.ilerijava.ders07.socketgui;

// GUI icin gerekli importlar
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
// Socket icin gerekli inputlar
import java.net.*;
import java.io.*;

public class SocketGUI extends JFrame {

	private JTextArea tumMesajlar = new JTextArea();
	private JTextField gonderilecekMesaj = new JTextField();
	private JButton mesajGonder = new JButton("Gonder");
	
	private InputThread inThread;
	private DataOutputStream out;
	
	private String kullaniciAdi;
	
	public SocketGUI() throws Exception {
		
		kullaniciAdi = JOptionPane.showInputDialog(this, "Kullanici Adi:");
		
		Socket sunucuSckt = new Socket("10.201.64.224", 82);
		DataInputStream in = new DataInputStream(sunucuSckt.getInputStream());
		out = new DataOutputStream(sunucuSckt.getOutputStream());
		
		out.writeUTF(kullaniciAdi);
		
		inThread = new InputThread(in);
		inThread.start();
		
		ekraniOlustur();
		mesajGonder.addActionListener( e -> mesajGonderAksiyonu(e));
	}

	private Object mesajGonderAksiyonu(ActionEvent e) {
		try {
			out.writeUTF(gonderilecekMesaj.getText());
			gonderilecekMesaj.setText("");
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
					tumMesajlar.setText( tumMesajlar.getText() + "\n" + mesaj);
					tumMesajlar.setCaretPosition(tumMesajlar.getDocument().getLength());
					// https://stackoverflow.com/questions/5147768/scroll-jscrollpane-to-bottom
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
		this.setLayout(new GridLayout(2,1));
		
		JPanel satir1 = new JPanel();
		satir1.setLayout(new GridLayout(1,1));
		tumMesajlar.setEditable(false);
		satir1.add(new JScrollPane(tumMesajlar));
		this.add(satir1);
		
		JPanel satir2 = new JPanel();
		satir2.setLayout(new GridLayout(1,2));
		satir2.add(gonderilecekMesaj);
		satir2.add(mesajGonder);
		this.add(satir2);
	}
}
