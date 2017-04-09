package tr.edu.medipol.ogrenciler.selahattinbozat.odev4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class calisanlar extends JFrame 
{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 4568526288883750008L;

	JTextField kullaniciAdi = new JTextField();
	JTextField calistigiYer = new JTextField();
	JTextField calistigiKonum = new JTextField();
	JTextField calistigiBolum = new JTextField();
	JTextField iseGirisYili = new JTextField();
	JLabel mesaj = new JLabel();
	
	ArrayList<String> adSoyadListesi = new ArrayList<>();
	ArrayList<String> calistigiYerListesi = new ArrayList<>();
	ArrayList<String> calistigiKonumListesi = new ArrayList<>();
	ArrayList<String> calistigiBolumListesi = new ArrayList<>();
	ArrayList<String> iseGirisYiliListesi = new ArrayList<>();
	
	public calisanlar()
	{ 
		System.out.println("Calisanlar ekrani oluistu..");
		
		setTitle("Calisanlar");
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		setLayout(new GridLayout(27, 1));
		
		JLabel etiketAdSoyad = new JLabel("Ad Soyad: ");
		JButton buton = new JButton("Gonder");
		JButton buton1 = new JButton("Temizle");
		JLabel etiketcalistigiYer = new JLabel("calistigi Yer : ");
		JLabel etiketcalistigiKonum = new JLabel("calistigi Kurum : ");
		JLabel etiketcalistigiBolum = new JLabel("calstigi Bolim : ");
		JLabel etiketiseGirisYili = new JLabel("ise Giris Yili : ");
		ButonAksiyonu aksiyon = new ButonAksiyonu();
		ButonAksiyonu1 aksiyonn = new ButonAksiyonu1();
		buton.addActionListener(aksiyon);
		buton1.addActionListener(aksiyonn);
		add(etiketAdSoyad);
		add(kullaniciAdi);
		
		add(etiketcalistigiYer);
		add(calistigiYer);
		
		add(etiketcalistigiKonum);
		add(calistigiKonum);
		
		add(etiketcalistigiBolum);
		add(calistigiBolum);
		
		add(etiketiseGirisYili);
		add(iseGirisYili);
		
		
		add(buton);
		add(buton1);
		add(mesaj);
		
		setVisible(true);
		
	} 
	
	public class ButonAksiyonu implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			adSoyadListesi.add(kullaniciAdi.getText());
			adSoyadListesi.add(calistigiYer.getText());
			adSoyadListesi.add(calistigiKonum.getText());
			adSoyadListesi.add(calistigiBolum.getText());
			adSoyadListesi.add(iseGirisYili.getText());
			String ekranMetni = "";
			JOptionPane.showMessageDialog(null, "Baiariyla Ekleme Yaptiniz...");
			for (String adSoyad : adSoyadListesi) {
				ekranMetni = ekranMetni + adSoyad + ",";
			}
			mesaj.setText(ekranMetni);
		}
	}
	public class ButonAksiyonu1 implements ActionListener {

		public void actionPerformed(ActionEvent e)
		{
			
			
			kullaniciAdi.setText("");
			calistigiYer.setText("");
			calistigiKonum.setText("");
			calistigiBolum.setText("");
			iseGirisYili.setText("");
			revalidate();
			repaint();
			JOptionPane.showMessageDialog(null, "Baiariyla Temizlendi...");
		}
		
		}
}
	
