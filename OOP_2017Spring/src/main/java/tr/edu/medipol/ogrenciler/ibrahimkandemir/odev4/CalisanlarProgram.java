package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev4;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalisanlarProgram extends JFrame{
	
	private JTextField calisanAdiSoyadi = new JTextField();
	private JTextField tcNo = new JTextField();
	private JTextField sicilNo = new JTextField();
	private JTextField calisanIseBaslangic = new JTextField();	
	private JTextField calisaninMaasi = new JTextField();
	
	private JComboBox<String> calisanTipi = new JComboBox<>();
		
	private ButonAksiyonu btn;
	
	private JTextArea calisanTextArea = new JTextArea();

	
	public void calistir(){
		
		
		JTabbedPane tab = new JTabbedPane();
		
		JPanel calisanKayit = new JPanel();
		calisanKayit.setLayout(new GridLayout(18,0));
		
		JPanel calisanListele = new JPanel();
		calisanListele.setLayout(null);
		
		JLabel calisanAd = new JLabel("Ad� ve Soyad�:");
		JLabel tcNosu = new JLabel("T.C. Kimlik Numaras�:");
		JLabel sicilNosu = new JLabel("Sicil Numaras�:");
		JLabel iseBas = new JLabel("��e Ba�lang�� Tarihi:");
		JLabel calisanMaas = new JLabel("�al��an�n Maa��:");
		JLabel birimi = new JLabel("Birimi:");
		
		JLabel calisanlarinKayitListesi = new JLabel("KAYIT EDILEN CALISANLAR");
		calisanlarinKayitListesi.setBounds(450, -30, 500, 90);
		calisanTextArea.setBounds(0, 30, 1100, 600);
		
		tab.addTab("�al��an Kay�t", calisanKayit);
		calisanKayit.setBackground(Color.CYAN);
		
		tab.addTab("Kay�tlar� Listele", calisanListele);
		calisanListele.setBackground(Color.GREEN);

		calisanTipi.addItem("Seciniz..");
		calisanTipi.addItem("Mudur");
		calisanTipi.addItem("Direktor");
		calisanTipi.addItem("Yazilimci");
		calisanTipi.addItem("Analist");
		calisanTipi.addItem("Muhasebe");
		calisanTipi.addItem("Insan Kaynaklari");
		calisanTipi.addItem("Isci");

		JButton kaydetButonu = new JButton("Kaydet");
		//kaydetButonu.setBounds(300, 400, 20, 50);
		
		JButton temizlemeButonu = new JButton("Temizle");
		
		temizlemeButonu.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calisanAdiSoyadi.setText("");
				tcNo.setText("");
				sicilNo.setText("");
				calisanIseBaslangic.setText("");
				calisaninMaasi.setText("");
			}
		});
		
		JButton listeleEkranTemizle = new JButton("KAYIT LISTESINI TEMIZLE");
		listeleEkranTemizle.setBounds(50, 0, 200, 29);
		
		
		listeleEkranTemizle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg1) {
				calisanTextArea.setText("");
			}
		});
					
		btn = new ButonAksiyonu(calisanAdiSoyadi, tcNo, sicilNo, calisanIseBaslangic, calisanTipi, calisaninMaasi, calisanTextArea);	
		
		add(tab);
		
		kaydetButonu.addActionListener(btn);
		
		
		calisanKayit.add(calisanAd);
		calisanKayit.add(calisanAdiSoyadi);
		calisanKayit.add(tcNosu);
		calisanKayit.add(tcNo);
		calisanKayit.add(sicilNosu);
		calisanKayit.add(sicilNo);
		calisanKayit.add(iseBas);
		calisanKayit.add(calisanIseBaslangic);
		calisanKayit.add(calisanMaas);
		calisanKayit.add(calisaninMaasi);
		calisanKayit.add(birimi);
		calisanKayit.add(calisanTipi);
		calisanKayit.add(kaydetButonu);
		calisanKayit.add(temizlemeButonu);
		
		calisanListele.add(calisanlarinKayitListesi);
		calisanListele.add(calisanTextArea);
		calisanListele.add(listeleEkranTemizle);


	}

	public static void main(String[] args){
		CalisanlarProgram program = new CalisanlarProgram();
		program.calistir();
		program.setTitle("�al��anlar Kay�t Y�netim Program�");
		program.setSize(1100,700);
		program.setLocation(400, 200);
		program.setVisible(true);
		program.setResizable(false);
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
	}
}
