package tr.edu.medipol.hafta4.grub_a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OgrenciGirisEkrani extends JFrame {
	private JLabel etiketAdSoyad = new JLabel("Ad ve Soyad:");
	private JTextField girdiAdSoyad = new JTextField();
	private JButton gonderButonu = new JButton("GONDER");
	private JButton temizleButonu = new JButton("TEMIZLE");
	private JTextField mesajAlani = new JTextField();

	
	private ArrayList<String> ogrenciler = new ArrayList<String>();
	
	public OgrenciGirisEkrani() {
		// elemanlarin ekrana nasil eklenecegini belirtiyoruz: 7 satir, 1 sutun izgara
		setLayout(new GridLayout(7, 1)); 
		mesajAlani.setEditable(false); // mesaj alanina girdiyi engelle
		
		// Buton icin asagida tanimladigimiz aksiyon nesnesini new ile olustur
		ButonAksiyonu butonAksiyonu = new ButonAksiyonu();
		gonderButonu.addActionListener(butonAksiyonu); // buton aksiyonu belirttik
		temizleButonu.addActionListener(butonAksiyonu);
		
		// add ile ekrana ekliyoruz
		add(etiketAdSoyad); 
		add(girdiAdSoyad);
		add(gonderButonu);
		add(temizleButonu);
		add(mesajAlani);
		
		addWindowListener(new PencereAktiviteDinleyici());
	}
	
	// Bir aksiyon sinifi tanimladik
	private class ButonAksiyonu implements ActionListener {
		
		// Butona basinca bu metod icine dusecek
		public void actionPerformed(ActionEvent olayNesnesi) {

			// Hangi elemana basildigini tespit icin 
			// ActionEvent'in getSource() metodunu kullaniyoruz
			// olayNesnesi.getSource() olay'in kaynagini verir

			JButton basilanButon = (JButton) olayNesnesi.getSource(); 
			String basilanButonAdi = basilanButon.getText();
			if (basilanButonAdi == "GONDER") { // Demek ki GONDER butonuna basilmis

				ogrenciler.add(girdiAdSoyad.getText());
				
				// Ekran mesajini olustur
				String ekranMesaji = "";
				for (String ogr : ogrenciler) {
					ekranMesaji += ogr + ",";
				}
				
				// Ekran mesajini goster
				mesajAlani.setText(ekranMesaji);
				
				// Girdi alanini temizle
				girdiAdSoyad.setText("");
				
			} else if (basilanButonAdi == "TEMIZLE") { // Demek ki TEMIZLE butonuna basilmis
				
				mesajAlani.setText("");
				ogrenciler.clear();
				
			}
			
		}
	}
	
	// Penceredeki KAPAMA gibi tuslara basinca ne yapacagimizi belirliyoruz
	private class PencereAktiviteDinleyici extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			System.exit(0); // Programi sonlandir
		}
	}
	
	
}
