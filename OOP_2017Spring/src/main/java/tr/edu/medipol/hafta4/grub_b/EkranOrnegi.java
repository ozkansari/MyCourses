package tr.edu.medipol.hafta4.grub_b;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EkranOrnegi 
	// javax.swing.JFrame: sinifi EkranOrnegi sinifimiza masaustu programi ozelligi kazandirir
	extends JFrame 
	// java.awt.event.ActionListener: sinifi butona basma gibi olaylari yakalamamizi saglar
	implements ActionListener {

	private JTextField girdiAdSoyad = new JTextField(); 
	private JLabel etiketMesajAlani = new JLabel();
	
	// implements ActionListener dedigimiz icin bu metodu yazmak zorundayiz
	// Butona basildiginda bu metoda girecek cunku buton.addActionListener(this); dedik
	public void actionPerformed(ActionEvent arg0) {
		etiketMesajAlani.setText("Girilen: " + girdiAdSoyad.getText());
	}
	
	public EkranOrnegi(){
		
		// Ekrana eklenen elemanlarin ekrana nasil yerlestirilecegini belirler
		setLayout(new GridLayout(7, 2)); 
		
		// Ekrana metin ekle (System.out.println gibi )
		JLabel etiketAdSoyad = new JLabel("Ad Soyad: "); 
		add(etiketAdSoyad); // etiketAdSoyad'i ekrana ekle
		
		// Kullanici girisi icin alan olustur (Scanner gibi)
		add(girdiAdSoyad); // girdiAdSoyad'i ekrana ekle
		
		// Buton olustur
		JButton buton = new JButton("Ekle"); 
		buton.addActionListener(this); // Buton'a basildiginda ne yapilacagini belirler
		// addActionListener'a parametre verilecek nesne "implements ActionListener" yapan bir sinif olmali
		// Bulundugumuz EkranOrnegi sinifi implements ActionListener oldugundan "this" diyoruz
		add(buton); // butonu ekrana ekle
		
		add(etiketMesajAlani);
	}
	
	public static void main(String[] args) {
		EkranOrnegi program = new EkranOrnegi();
		program.setTitle("Ornek Program");
		program.setSize(500, 500);
		program.setVisible(true);
	}

	

}
