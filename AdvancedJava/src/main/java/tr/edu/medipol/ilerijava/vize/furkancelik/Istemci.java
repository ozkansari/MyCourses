package tr.edu.medipol.ilerijava.vize.furkancelik;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.TextField;
import java.awt.Button;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Istemci extends JFrame {

	private JPanel contentPane;
	private Button button;
	List list = new List();
	
	private static final String sunucuIP = "localhost";
	private static final int sunucuPort = 7778;
	public static final int SERVER_PORT = 7779;
	static PrintWriter sunucuMesajGonderici = null;
	
	public static String islem;
	public static String islemText;
	public static int gelenSonuc;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Istemci frame = new Istemci();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Istemci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		TextField textField = new TextField();
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		panel.add(textField_1);
		
		TextField islemTxt = new TextField();
		panel.add(islemTxt);
		
		button = new Button("G\u00F6nder");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("Istemci aciliyor.");

				Socket sunucuBaglantisi = null;
				try {
					sunucuBaglantisi = new Socket(sunucuIP, sunucuPort);
					
					System.out.println("Sunucu baglantisi kuruldu.");
					
					DataOutputStream dos = new DataOutputStream(sunucuBaglantisi.getOutputStream());
					int sayi1 = Integer.parseInt(textField.getText());
					int sayi2 = Integer.parseInt(textField_1.getText());
					String islemText = islemTxt.getText();
					dos.writeInt(sayi1);
					dos.writeInt(sayi2);
					dos.writeUTF(islemText);
					dos.close();
					sunucuBaglantisi.close();
				} catch (UnknownHostException e1) {
					System.out.println("Sunucu IP hatali" + e1.getMessage());
				} catch (IOException e1) {
					System.out.println("Sunucuya baglanirken hata alindi:" + e1.getMessage());
				}

				while (true) {
					try {
						ServerSocket sunucuSocketi = new ServerSocket(SERVER_PORT);
						System.out.println("Sunucu bekleniyor... Port numarasi: " + sunucuSocketi.getLocalPort());

						while (true) {
							Socket istemciBaglantisi = sunucuSocketi.accept();
							System.out.println("Sunucudan sonuc geldi");
							DataInputStream gelenSonuc = new DataInputStream(istemciBaglantisi.getInputStream());
							String gelenSonucString = String.valueOf(gelenSonuc.readInt());
							System.out.println("Sunucudan gelen sonuc: " + gelenSonucString);
							list.add(gelenSonucString);
						}
					} catch (IOException e1) {
						System.out.println(SERVER_PORT + " numarali porttan soket acilamadi.");
						e1.printStackTrace();
					}
				}
				
			}
		});
		contentPane.add(button, BorderLayout.SOUTH);
		
		
		contentPane.add(list, BorderLayout.EAST);
	}

}
