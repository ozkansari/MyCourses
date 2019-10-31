package tr.edu.medipol.ilerijava.ders05.lab;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MasaustuUygulamaOrnek1 extends JFrame {

	private JTextArea bilgiPaneli = new JTextArea();
	private JTextField kullaniciAdi = new JTextField(20);
	private JButton girisButonu = new JButton("EKLE");

	private Object butonIslemi(ActionEvent e) {
		System.out.println("buton tiklandi");
		String textInput = kullaniciAdi.getText();
		
		if(textInput != null && textInput.trim().length() > 0 ) {
			bilgiPaneli.setText( bilgiPaneli.getText() + " " +  textInput + "\n");
			bilgiPaneli.setCaretPosition(bilgiPaneli.getDocument().getLength());
		}
		kullaniciAdi.setText("");
		return e;
	}
	
	public MasaustuUygulamaOrnek1() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(2, 1));

		bilgiPaneli.setEditable(false);
		this.add( new JScrollPane(bilgiPaneli) );

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

	
	// YONTEM 4 ICIN
	/*--
	private class ButonIslemiActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			butonIslemi(e);
		}		
	}
	*/
	
	public static void main(String[] args) {
		MasaustuUygulamaOrnek1 ekran = new MasaustuUygulamaOrnek1();
		ekran.setTitle("Ornek 1");
		ekran.setSize(500, 300);
		ekran.setLocation(350, 150);
		ekran.setResizable(false);
		ekran.setVisible(true);

	}

}
