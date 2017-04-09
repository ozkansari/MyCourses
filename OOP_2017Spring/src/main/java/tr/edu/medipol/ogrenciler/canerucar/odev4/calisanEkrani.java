package tr.edu.medipol.ogrenciler.canerucar.odev4;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class calisanEkrani extends JFrame 
{ 
	JTextField kullaniciAdi = new JTextField();
	
	JLabel mesaj = new JLabel();
	
	ArrayList<String> adSoyadListesi = new ArrayList<>();
	
	public calisanEkrani()
	{
		
		System.out.println("Calisan ekrani olustu");
		
		setTitle("Calisan Programi");
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(27, 1));
		
		JLabel etiketAdSoyad = new JLabel("Ad Soyad: ");
		JLabel IseGirisYili = new JLabel("Ise Giris Yili: ");
		JButton buton = new JButton("Gonder");
		ButonAksiyonu aksiyon = new ButonAksiyonu();
		buton.addActionListener(aksiyon);
		
		add(etiketAdSoyad);
		add(IseGirisYili);
		add(kullaniciAdi);
		add(buton);
		add(mesaj);
		
		setVisible(true);
		
	}
	
	public class ButonAksiyonu implements ActionListener 
	{

		public void actionPerformed(ActionEvent e)
		{
			adSoyadListesi.add(kullaniciAdi.getText());
			
			String ekranMetni = "";
			for (String adSoyad : adSoyadListesi)
			{
				ekranMetni = ekranMetni + adSoyad + ",";
			}
			mesaj.setText(ekranMetni);
			
			kullaniciAdi.setText("");
			
			revalidate();
			repaint();
		}

	}
	
}