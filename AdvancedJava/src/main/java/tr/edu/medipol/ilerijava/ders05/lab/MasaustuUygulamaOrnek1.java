package tr.edu.medipol.ilerijava.ders05.lab;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MasaustuUygulamaOrnek1 extends JFrame {

	private JLabel bilgiPaneli = new JLabel("Medipol Mebis v1");
	private JTextField kullaniciAdi = new JTextField(20);
	private JButton girisButonu = new JButton("EKLE");

	public MasaustuUygulamaOrnek1() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));

		this.add(bilgiPaneli);

		JPanel girisPaneli = new JPanel();
		girisPaneli.setLayout(new GridLayout(2, 1));
		girisPaneli.add(kullaniciAdi);
		girisPaneli.add(girisButonu);
		this.add(girisPaneli);

		// YONTEM 1
		girisButonu.addActionListener(e -> {
			System.out.println("...");
			butonIslemi(e);
		});

		/*--
		// YONTEM 2
		girisButonu.addActionListener(e -> butonIslemi(e) );
		
		// YONTEM 3
		girisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butonIslemi(e);
			}
		});
		
		// YONTEM 4
		girisButonu.addActionListener(new ButonIslemiActionListener());
		*/
	}

	/*--
	// YONTEM 4 ICIN
	private static class ButonIslemiActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			butonIslemi(e);
		}		
	}
	*/

	private static Object butonIslemi(ActionEvent e) {
		System.out.println("buton tiklandi");
		return e;
	}

	public static void main(String[] args) {
		MasaustuUygulamaOrnek1 ekran = new MasaustuUygulamaOrnek1();
		ekran.setTitle("Ornek 1");
		ekran.setSize(500, 300);
		ekran.setLocation(350, 150);
		ekran.setResizable(false);
		ekran.setVisible(true);

	}

}
