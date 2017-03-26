package tr.edu.medipol.hafta5.grub_b;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OgrenciProgrami extends JFrame  {

	private JTextField girdiOgrenciAd = new JTextField();
	private JComboBox<String> ogrenciTipi = new JComboBox();
	private ButonAksiyonu b;
	private JTextArea ogrenciTextArea = new JTextArea(1,1);
	
	public void olustur() {
		
		// Ana JFrame ekraninin layoutunu ayarla
		this.setLayout(new GridLayout(2,0));
		
		// ogrenciFormu isimli bir panel olustur
		JPanel ogrenciFormu = new JPanel();
		ogrenciFormu.setLayout(new GridLayout(4,1));
		JLabel etiketOgrenciAd = new JLabel("Ad Soyad:"); 

		// ogrenciTipi:JComboBox degiskenine secenek ekle
		ogrenciTipi.addItem("Lisans");
		ogrenciTipi.addItem("Yuksek Lisans");

		// Gonder butonu ve aksiyonunu tanimla
		JButton gonderButonu = new JButton("Gonder");
		b = new ButonAksiyonu(girdiOgrenciAd, ogrenciTipi, ogrenciTextArea);
		gonderButonu.addActionListener(b);
		
		// ogrenciFormu isimli panele elemanlari ekle
		ogrenciFormu.add(etiketOgrenciAd);
		ogrenciFormu.add(girdiOgrenciAd);
		ogrenciFormu.add(ogrenciTipi);
		ogrenciFormu.add(gonderButonu);
		
		// ogrenciFormu isimli paneli JFrame'e ekle
		add(ogrenciFormu);
		
		// ogrenciTextArea'yi JFrame'e ekle
		add(ogrenciTextArea);
	}
	
	public static void main(String[] args) {

		OgrenciProgrami program = new OgrenciProgrami();
		program.olustur();
		program.setTitle("Ogrenci Programi - Hafta 5");
		program.setSize(500, 600); // 500 px en - 600 px yukseklik belirle
		program.setVisible(true);
		program.setResizable(false); // Pencere boyutlari degistirilemesin
		program.setDefaultCloseOperation(EXIT_ON_CLOSE); // Pencere kapaninca program sonlansin
	}

}
