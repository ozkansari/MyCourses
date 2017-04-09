package tr.edu.medipol.ogrenciler.muhammetaktas.odev4;

import java.awt.*;

import javax.swing.*;

public class CalisanlarEkrani extends JFrame  {

	private JTextField girdiCalisanAd = new JTextField();
	private JTextField girdiCalisanGirisYili = new JTextField();
	private JComboBox<String> calisanTipi = new JComboBox<String>();
	private ButonAksiyonu b;
	private JTextArea calisanTextArea = new JTextArea(1,1);
	
	public void olustur() {
		

		this.setLayout(new GridLayout(2,0));
		
		JPanel calisanFormu = new JPanel();
		calisanFormu.setLayout(new GridLayout(4,1));
		JLabel etiketCalisanAd= new JLabel("Ad Soyad:"); 
		JLabel etiketCalisanGirisYili= new JLabel("Giris Yili:"); 


		calisanTipi.addItem("Mudur");
		calisanTipi.addItem("Yazilimci");
		calisanTipi.addItem("Analist");

		JButton gonderButonu = new JButton("Gonder");
		b = new ButonAksiyonu(girdiCalisanAd,girdiCalisanGirisYili, calisanTipi, calisanTextArea);
		gonderButonu.addActionListener(b);
		
		calisanFormu.add(etiketCalisanAd);
		calisanFormu.add(girdiCalisanAd);
		calisanFormu.add(etiketCalisanGirisYili);
		calisanFormu.add(girdiCalisanGirisYili);
		calisanFormu.add(calisanTipi);
		calisanFormu.add(gonderButonu);
		
		add(calisanFormu);
		
		add(calisanTextArea);
	}
	
	public static void main(String[] args) {

		CalisanlarEkrani program = new CalisanlarEkrani();
		program.olustur();
		program.setTitle("Ogrenci Programi - Hafta 5");
		program.setSize(400, 500); 
		program.setVisible(true);
		program.setResizable(false); 
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


