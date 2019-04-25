package tr.edu.medipol.ilerijava.proje1.azizbirinci;

//GUI icin gerekli importlar
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
//Socket icin gerekli inputlar
import java.net.*;
import java.io.*;


public class SocketGUI extends JFrame {

	private JTextArea tumMesajlar = new JTextArea();
	private JTextField gonderilecekMesaj = new JTextField();
	private JTextField gonderilecekMesaj2 = new JTextField();
	private JTextField gonderilecekMesaj3 = new JTextField();
	private JButton mesajGonder = new JButton("Gonder");
	private PrintWriter sunucuMesajGonderici = null;
	private static Socket sunucuBaglantisi;
	private static final int SERVER_PORT = 2222;
	public SocketGUI() throws Exception {

		try {
			ekraniOlustur();
			sunucuBaglantisi = new Socket("localhost",

					SocketGUI.SERVER_PORT);

			sunucuMesajGonderici =

					new PrintWriter(sunucuBaglantisi.getOutputStream());

		} catch (UnknownHostException e) {
			System.out.println("Sunucu IP hatali" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Sunucuya baglanirken hata alindi:" +

					e.getMessage());

		}
		mesajGonder.addActionListener(e->mesajGonder(e));/*
        try {
				sunucuSocketi = new ServerSocket(3333);
				System.out.println("Istemciler bekleniyor." + sunucuSocketi.getLocalPort());

					Socket istembag = sunucuSocketi.accept();
					System.out.println("Istemci baðlantýsý baþarýlý. " +

							istembag.getInetAddress());
				
			} catch (IOException e2) {
				System.out.println(3333 +

						" sunucu socketi acarken hata olustu");

				e2.printStackTrace();
			}
		}*/
	}


	
	private Object mesajGonder(ActionEvent e) {
		try {
			sunucuMesajGonderici.println(gonderilecekMesaj.getText());
			sunucuMesajGonderici.println(gonderilecekMesaj2.getText());
			sunucuMesajGonderici.println(gonderilecekMesaj3.getText());
			sunucuMesajGonderici.flush();

			/*
			BufferedReader istemciOkuyucu = null;

			try {
				InputStream girdi = ((Socket) this.istembag).getInputStream();
				InputStreamReader girdiOkuyucu = new InputStreamReader(girdi);
				istemciOkuyucu = new BufferedReader(girdiOkuyucu);
				istemciOkuyucu = new BufferedReader(new InputStreamReader(

						((Socket) istembag).getInputStream()

				)

				);
			} catch (IOException e3) {
				System.out.println("Istemci okuyucu acilirken hata: "

						+ e3.getMessage());

			}*/
			
		}catch(Exception e1) {
			e1.getMessage();
		}
		return e;
	}



	public void ekraniOlustur() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Socket GUI");
		this.setSize(500, 500);
		this.setLocation(600, 50);
		this.setResizable(false);
		this.setLayout(new GridLayout(2,1));
		
		
		JPanel satir1 = new JPanel();
		satir1.setLayout(new GridLayout(1,1));
		tumMesajlar.setEditable(false);
		satir1.add(new JScrollPane(tumMesajlar));
		this.add(satir1);
		
		JPanel satir2 = new JPanel();
		satir2.setLayout(new GridLayout(1,3));
		satir2.add(gonderilecekMesaj);
		satir2.add(gonderilecekMesaj2);
		satir2.add(gonderilecekMesaj3);
		satir2.add(mesajGonder);
		this.add(satir2);
	}
}