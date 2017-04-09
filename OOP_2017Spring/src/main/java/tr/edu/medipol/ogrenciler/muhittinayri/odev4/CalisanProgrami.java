package tr.edu.medipol.ogrenciler.muhittinayri.odev4;


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
	
	private JTextField CalisanAdSoyad = new JTextField();
	private JTextField Tarih = new JTextField();
	private JTextField Ucret = new JTextField();
	private JComboBox<String> CalismaSekli = new JComboBox();
	private JComboBox<String> CalisanTipi = new JComboBox();
	private ButonAksiyon b;
	private JTextArea CalisanTextArea = new JTextArea(1000,1000);
	
	
	public void olustur() 
	{
		JPanel CalisanFormu = new JPanel();
		CalisanFormu.setLayout(new GridLayout(10,1));
		JLabel eCalisanAdSoyad = new JLabel("Ad Soyad:");
		JLabel eTarih = new JLabel("Girii Tarihi:");
		JLabel eUcret = new JLabel("Aylik Ucretini Giriniz:");
		
		CalismaSekli.addItem("Caliima Seklini Seciniz");
		CalismaSekli.addItem("Stajyer");
		CalismaSekli.addItem("Sirekli/Tam Zamanli");
		CalismaSekli.addItem("Yari Zamanli/Part Time");
		
		CalisanTipi.addItem("Calisanin Tipini Seciniz");
		CalisanTipi.addItem("Analist");
		CalisanTipi.addItem("Mudur");
		CalisanTipi.addItem("Yazilimci");

		JButton gonderButonu = new JButton("Ekle");
		b = new ButonAksiyon(CalisanAdSoyad, Tarih, Ucret,CalismaSekli,CalisanTipi,CalisanTextArea);
		gonderButonu.addActionListener(b);
		
		CalisanFormu.add(eCalisanAdSoyad);
		CalisanFormu.add(CalisanAdSoyad);
		CalisanFormu.add(eTarih);
		CalisanFormu.add(Tarih);
		CalisanFormu.add(eUcret);
		CalisanFormu.add(Ucret);
		CalisanFormu.add(CalismaSekli);
		CalisanFormu.add(CalisanTipi);
		CalisanFormu.add(gonderButonu);
		CalisanFormu.add(CalisanTextArea);
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
