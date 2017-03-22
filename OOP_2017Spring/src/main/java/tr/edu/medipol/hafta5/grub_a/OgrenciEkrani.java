package tr.edu.medipol.hafta5.grub_a;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class OgrenciEkrani extends JFrame 
{ 
	JTextField kullaniciAdi = new JTextField();
	
	JLabel mesaj = new JLabel();
	
	ArrayList<String> adSoyadListesi = new ArrayList<>();
	
	public OgrenciEkrani()
	{ // metod basliyor
		
		System.out.println("Ogrenci ekrani olustu");
		
		setTitle("Ogrenci Programi");
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Ekrana eklediklerimin nasil dagilacagini belirledim
		setLayout(new GridLayout(27, 1));
		
		JLabel etiketAdSoyad = new JLabel("Ad Soyad: ");
		
		// Butonun aksiyonunu belirle
		JButton buton = new JButton("Gonder");
		ButonAksiyonu aksiyon = new ButonAksiyonu();
		buton.addActionListener(aksiyon);
		
		add(etiketAdSoyad);
		add(kullaniciAdi);
		add(buton);
		add(mesaj);
		
		setVisible(true);
		
	} // metod bitiyor
	
	public class ButonAksiyonu implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			adSoyadListesi.add(kullaniciAdi.getText());
			
			String ekranMetni = "";
			for (String adSoyad : adSoyadListesi) {
				ekranMetni = ekranMetni + adSoyad + ",";
			}
			mesaj.setText(ekranMetni);
			
			kullaniciAdi.setText("");
			
			revalidate();
			repaint();
		}

	}
	
}
