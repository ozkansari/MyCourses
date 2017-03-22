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
	private JTextArea ogrenciTextArea = new JTextArea();
	
	public void olustur() {
		
		JPanel ogrenciFormu = new JPanel();
		ogrenciFormu.setLayout(new GridLayout(15,1));
		JLabel etiketOgrenciAd = new JLabel("Ad Soyad:"); 

		ogrenciTipi.addItem("Lisans");
		ogrenciTipi.addItem("Yuksek Lisans");

		JButton gonderButonu = new JButton("Gonder");
		b = new ButonAksiyonu(girdiOgrenciAd, ogrenciTipi, ogrenciTextArea);
		gonderButonu.addActionListener(b);
		
		ogrenciFormu.add(etiketOgrenciAd);
		ogrenciFormu.add(girdiOgrenciAd);
		ogrenciFormu.add(ogrenciTipi);
		ogrenciFormu.add(gonderButonu);
		ogrenciFormu.add(ogrenciTextArea);
		add(ogrenciFormu);
	}
	
	public static void main(String[] args) {

		OgrenciProgrami program = new OgrenciProgrami();
		program.olustur();
		program.setTitle("Ogrenci Programi - Hafta 5");
		program.setSize(500, 600);
		program.setVisible(true);
		program.setResizable(false);
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
