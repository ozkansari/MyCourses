package tr.edu.medipol.hafta06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasaustuEkran extends JFrame {

	private JTextField adKullaniciGirdi = new JTextField();
	private JTextField soyadKullaniciGirdi = new JTextField();
	private JButton girisButonu = new JButton("Ekle");
	private JTextArea bilgiAlani = new JTextArea();
	
	private void butonOperasyonu() {
		
		bilgiAlani.setText(
				bilgiAlani.getText() +
				"\n" +
				adKullaniciGirdi.getText() + ", " + soyadKullaniciGirdi.getText()
		);
		// System.out.println(adKullaniciGirdi.getText() + ", " + soyadKullaniciGirdi.getText());
		adKullaniciGirdi.setText("");
		soyadKullaniciGirdi.setText("");
	}

	public MasaustuEkran() {
		setTitle("Ekran Ornegi 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 800);

		setLayout(new GridLayout(3, 1));
		
		JPanel kullaniciGirdiPaneli = new JPanel();
		kullaniciGirdiPaneli.setLayout(new GridLayout(2, 2));
		kullaniciGirdiPaneli.add(new JLabel("Ad: "));
		kullaniciGirdiPaneli.add(adKullaniciGirdi);
		kullaniciGirdiPaneli.add(new JLabel("Soyad: "));
		kullaniciGirdiPaneli.add(soyadKullaniciGirdi);
		add(kullaniciGirdiPaneli);
		
		add(girisButonu);
		
		bilgiAlani.setEditable(false);
		bilgiAlani.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		add(bilgiAlani);
		
		// Yontem 3
		girisButonu.addActionListener( e -> {
			butonOperasyonu();
		});
				
		// Yontem 1
		//girisButonu.addActionListener(new ButonDinleyici());
		
		// Yontem 2
		/*--
		girisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butonOperasyonu();
			}
		});
		*/
		
		setVisible(true);
	}
	
	// Yontem 1 icin gerekli
	/*
	private class ButonDinleyici implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) {
			// Butona tıklanınca ne yapilacak
			butonOperasyonu();
		}
	}
	*/
	
}
