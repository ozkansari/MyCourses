package tr.edu.medipol.ogrenciler.batinarslan.odev4;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class CalisanProgrami extends JFrame  {
	
	private JTextField CalisanADSoyad = new JTextField();
	private JTextField Tel = new JTextField();
	private JTextField Adres = new JTextField();
	private JComboBox<String> Pozisyon = new JComboBox();
	private Buton b;

	
	
	public void olustur() 
	{
		JPanel CalisanFormu = new JPanel();
		CalisanFormu.setLayout(new GridLayout(15,1));
		JLabel CalisanAdSoyad = new JLabel("Ad Soyad:");
		JLabel CalisanTel = new JLabel("Telefon Numarasini Giriniz:");
		JLabel CalisanAdres = new JLabel("Caliianin Adresini Giriniz:");

			
		Pozisyon.addItem("Muhasebe");
		Pozisyon.addItem("Mudur");
		Pozisyon.addItem("insan Kaynaklari");

		
		
		JButton gonderButonu = new JButton("Kaydet");
		b = new Buton(CalisanADSoyad,Tel,Adres,Pozisyon);
		gonderButonu.addActionListener(b);
		
		CalisanFormu.add(CalisanAdSoyad);
		CalisanFormu.add(CalisanADSoyad);
		CalisanFormu.add(CalisanTel);
		CalisanFormu.add(Tel);
		CalisanFormu.add(CalisanAdres);
		CalisanFormu.add(Adres);
		CalisanFormu.add(Pozisyon);
		CalisanFormu.add(gonderButonu);
		add(CalisanFormu);

	}
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalisanProgrami calisan = new CalisanProgrami();
		calisan.olustur();
		calisan.setTitle("Calisanlar Programi");
		calisan.setSize(500,600);
		calisan.setVisible(true);
		calisan.setResizable(true);
		calisan.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}

}
