package tr.edu.medipol.ogrenciler.anilokumus.odev4;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalisanProgrami extends JFrame{
	private JTextField girdiCalisanAd = new JTextField();
	private JTextField girdiCalisanYil = new JTextField();
	private JComboBox<String> calisanTipi = new JComboBox();
	private ButonAksiyonu b;
	private JTextArea calisanTextArea = new JTextArea(1,1);
	private JTextArea calisanYilTextArea = new JTextArea(1,1);
	
	
	public void olustur(){
		this.setLayout(new GridLayout(2,0));
		JPanel calisanFormu = new JPanel();
		calisanFormu.setLayout(new GridLayout(4,1));
		JLabel etiketCalisanAd = new JLabel("Ad Soyad:");
		JLabel etiketCalisanYil = new JLabel("Ise Giris Yili:");
		calisanTipi.addItem("Mudur");
		calisanTipi.addItem("Yazilimci");
		calisanTipi.addItem("MYardimcisi");
		JButton gonderButonu = new JButton("Gonder");
		b = new ButonAksiyonu(girdiCalisanAd,girdiCalisanYil, calisanTipi, calisanTextArea);
		gonderButonu.addActionListener(b);
		calisanFormu.add(etiketCalisanAd);
		calisanFormu.add(etiketCalisanYil);
		calisanFormu.add(girdiCalisanAd);
		calisanFormu.add(girdiCalisanYil);
		calisanFormu.add(calisanTipi);
		calisanFormu.add(gonderButonu);
		add(calisanFormu);
		add(calisanTextArea);
		
	}
	public static void main(String[] args) {

		CalisanProgrami program = new CalisanProgrami();
		program.olustur();
		program.setTitle("Calisan Programi");
		program.setSize(700,800);
		program.setVisible(true);
		program.setResizable(false); 
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

}
