package tr.edu.medipol.ogrenciler.ismailsahin.odev4;

import javax.swing.*;
import java.awt.*;

public class CalisanUygulamasi extends JFrame {

	private JTextField girdiCalisanAd = new JTextField();
	private JTextField girdiCalisanMaas = new JTextField();
	private JComboBox<String> calisanTipi = new JComboBox();
	
    private ButonAksiyon b;
	
	private JTextArea calisanTextArea = new JTextArea(1, 1);
	
	JPanel panel = new JPanel(new GridLayout(1, 2));
	JPanel panel2 = new JPanel(new GridLayout(1, 2));

	public CalisanUygulamasi() {
		setSize(300, 300);
		setTitle("Week5");
		setVisible(true);
		setLayout(new GridLayout(2, 0));

		JPanel calisanFormu = new JPanel();
		calisanFormu.setLayout(new GridLayout(7, 1));
		JLabel etiketCalisanAd = new JLabel("Ad Soyad:");
		JLabel etiketCalisanMaas = new JLabel("Maas:");
		JLabel etiketCalisanPozizyon = new JLabel("Pozisyon:");

		calisanTipi.addItem("Yonetici");
		calisanTipi.addItem("Yazilimci");
		calisanTipi.addItem("Tasarimci");
		calisanTipi.addItem("Gorevli");

		calisanFormu.add(etiketCalisanAd);
		calisanFormu.add(girdiCalisanAd);
		calisanFormu.add(etiketCalisanMaas);
		calisanFormu.add(girdiCalisanMaas);
		calisanFormu.add(etiketCalisanPozizyon);
		calisanFormu.add(calisanTipi);
		
		JButton gonderButonu = new JButton("Ekle");
		ButonAksiyon b = new ButonAksiyon(girdiCalisanAd, girdiCalisanMaas, calisanTipi,calisanTextArea);
		gonderButonu.addActionListener(b);
		
		calisanFormu.add(gonderButonu);

		calisanTextArea.setEditable(false);
		
		panel2.add(calisanTextArea);

		add(calisanFormu);
		add(panel2);

		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		CalisanUygulamasi Week5 = new CalisanUygulamasi();
	}
}
