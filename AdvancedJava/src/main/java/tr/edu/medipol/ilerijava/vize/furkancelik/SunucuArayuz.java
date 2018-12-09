package tr.edu.medipol.ilerijava.vize.furkancelik;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SunucuArayuz extends JFrame {

	private JPanel contentPane;

	private static final String sunucuIP = "localhost";
	private static final int sunucuPort = 7779;
	public static final int SERVER_PORT = 7778;
	public static int sonuc = 0;
	public static String islemText;

	public static List liste = new List();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SunucuArayuz frame = new SunucuArayuz();
					frame.setVisible(true);

					try {
						ServerSocket sunucuSocketi = new ServerSocket(SERVER_PORT);

						System.out.println("Sunucu aciliyor.");
						
						while (true) {
							Socket istemciBaglantisi = sunucuSocketi.accept();

							System.out.println("Istemci baglandi." + istemciBaglantisi.getInetAddress());
							
							liste.add(istemciBaglantisi.getInetAddress().toString());
							DataInputStream sayi1 = new DataInputStream(istemciBaglantisi.getInputStream());
							DataInputStream sayi2 = new DataInputStream(istemciBaglantisi.getInputStream());
							DataInputStream islem = new DataInputStream(istemciBaglantisi.getInputStream());

							int sayiBir = sayi1.readInt();
							int sayiIki = sayi2.readInt();

							islemText = islem.readUTF();
							String carpma = "*";
							String bolme = "/";
							String topla = "+";
							String cikar = "-";
							
							if(islemText.equals(topla)) {
								sonuc = (sayiBir + sayiIki);
							}
							if(islemText.equals(cikar)) {
								sonuc = (sayiBir - sayiIki);
							}
							if(islemText.equals(carpma)) {
								sonuc = (sayiBir * sayiIki);
							}
							if(islemText.equals(bolme)) {
								sonuc = (sayiBir / sayiIki);
							}
							
							

							sayi1.close();
							sayi2.close();
							islem.close();
							istemciBaglantisi.close();

							Socket sunucuBaglantisi = null;
							try {
								sunucuBaglantisi = new Socket(sunucuIP, sunucuPort);
								DataOutputStream dos = new DataOutputStream(sunucuBaglantisi.getOutputStream());
								dos.writeInt(sonuc);
								dos.close();
								sunucuBaglantisi.close();
							} catch (UnknownHostException e) {
								System.out.println("Sunucu IP hatali" + e.getMessage());
							} catch (IOException e) {
								System.out.println("Sunucuya baglanirken hata alindi:" + e.getMessage());
							}
						}
					} catch (IOException e) {
						System.out.println(SERVER_PORT + " numarali porttan soket acilamadi.");
						e.printStackTrace();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public SunucuArayuz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(liste, BorderLayout.WEST);

	}

}
