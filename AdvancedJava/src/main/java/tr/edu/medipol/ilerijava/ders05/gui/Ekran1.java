package tr.edu.medipol.ilerijava.ders05.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ekran1 extends JFrame {
	private JTextField adSoyadGirisi = new JTextField();
	private JTextField okulNumarasiGirisi = new JTextField();
	private JTextArea bilgiAlani = new JTextArea();
	private JButton girisButonu = new JButton("Ekle");
	private void butonIslemi(ActionEvent event) {
		System.out.println("Buton cagrildi: " + event.getActionCommand());
		bilgiAlani.setText( bilgiAlani.getText() 
				+ adSoyadGirisi.getText() + " " 
				+ okulNumarasiGirisi.getText() + "\n");
		adSoyadGirisi.setText("");
		okulNumarasiGirisi.setText("");
	}
	public Ekran1() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Ders 5 - Ekran 1");
		this.setSize(500, 200);
		this.setLocation(600, 50);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.CYAN);
		this.bilgiAlani.setEditable(false);
		//this.bilgiAlani.getScrollableTracksViewportHeight();
		
		this.setLayout(new GridLayout(3,1));
		
		JPanel kullaniciGirisiPaneli = new JPanel();
		kullaniciGirisiPaneli.setLayout(new GridLayout(2,2));
		kullaniciGirisiPaneli.add(new JLabel("Ad-Soyad:"));
		kullaniciGirisiPaneli.add(adSoyadGirisi);
		kullaniciGirisiPaneli.add(new JLabel("Okul Numarasi:"));
		kullaniciGirisiPaneli.add(okulNumarasiGirisi);
		this.add(kullaniciGirisiPaneli);
		
		this.add(new JScrollPane(bilgiAlani));
		
		this.add(girisButonu);
		girisButonu.addActionListener( e -> butonIslemi(e) );
		
		/* --
		girisButonu.addActionListener( e -> {
			butonIslemi(e);
		});
		girisButonu.addActionListener( System.out::println );
		*/
		
		/*--
		// 2. Yontem
		girisButonu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				butonIslemi(e);
			}
		});
		*/
		
		// 3. Yontem
		// girisButonu.addActionListener(new ButtonAction());
		
	}

	// 1. Yontem icin gerekli
	/*--
	private class ButtonAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			butonIslemi(e);
		}
	}
	*/
}
