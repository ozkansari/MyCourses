package tr.edu.medipol.ilerijava.ders07;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OgrenciYonetimEkrani extends JFrame {

	public OgrenciYonetimEkrani() {
		super("Ogrenci Yonetim");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750, 500);
		setLocation(100, 50);
		setLayout(new GridLayout(2, 1));
		
		JPanel gosterimPaneli = new JPanel();
		JTextArea mesajlarJTA;
		mesajlarJTA = new JTextArea(50,50);
		mesajlarJTA.setSize(300, 300);
		mesajlarJTA.setEditable(false);
		mesajlarJTA.getScrollableTracksViewportHeight();
		JScrollPane mesajlarJTAScroll = new JScrollPane(mesajlarJTA);
		gosterimPaneli.add(mesajlarJTAScroll);
		add(gosterimPaneli);
		
		// --------------------------------------------------
		// Giris Paneli
		// --------------------------------------------------
		JPanel girisPaneli = new JPanel();
		
		JTextField ogrenciAdGiris = new JTextField(10);
		girisPaneli.add(new JLabel("Ad : "));
		girisPaneli.add(ogrenciAdGiris);
		
		JTextField ogrenciSoyadGiris = new JTextField(10);
		girisPaneli.add(new JLabel("Soyad : "));
		girisPaneli.add(ogrenciSoyadGiris);
		
		JTextField ogrenciYasGiris = new JTextField(10);
		girisPaneli.add(new JLabel("Yas : "));
		girisPaneli.add(ogrenciYasGiris);
		
		JButton gonderBtn = new JButton("GONDER");
		girisPaneli.add(gonderBtn);
		gonderBtn.addActionListener(event -> {
			
		});
		
		add(girisPaneli);
		// --------------------------------------------------
	}
	
	public static void main(String[] args) {
		JFrame ekran = new OgrenciYonetimEkrani();
		ekran.setVisible(true);
	}
}
