package tr.edu.medipol.ogrenciler.yusufucar.odev4;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalisanProgrami extends JFrame  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField calisanAdi = new JTextField();
	private JComboBox<String> calisanTipi = new JComboBox<String>();
	private ButonAksiyonu b;
	private JTextArea calisanTextArea = new JTextArea(1,1);
	
	public void olustur() {
		
		
		this.setLayout(new GridLayout(2,0));
		
		
		JPanel calisanFormu = new JPanel();
		calisanFormu.setLayout(new GridLayout(4,1));
		JLabel etiketCalisanAd = new JLabel("Ad Soyad / Giris Yili :"); 

		
		calisanTipi.addItem("Mudur");
		calisanTipi.addItem("Yazilimci");
		calisanTipi.addItem("Analist");
		calisanTipi.addItem("Temizlikci");
		calisanTipi.addItem("Guvenlik");
		calisanTipi.addItem("Muhasebe");
		calisanTipi.addItem("Tasarimci");

		
		JButton gonderButonu = new JButton("Gonder");
		b = new ButonAksiyonu(calisanAdi, calisanTipi, calisanTextArea );
		gonderButonu.addActionListener(b);
		
		
		calisanFormu.add(etiketCalisanAd);
		calisanFormu.add(calisanAdi);
		calisanFormu.add(calisanTipi);
		calisanFormu.add(gonderButonu);
		
		
		add(calisanFormu);
		
		
		add(calisanTextArea);
	}
	
	public static void main(String[] args) {

		CalisanProgrami program = new CalisanProgrami();
		program.olustur();
		program.setTitle("Calisan Programi - Hafta 5");
		program.setSize(300, 300); 
		program.setVisible(true);
		program.setResizable(false); 
		program.setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}

}

