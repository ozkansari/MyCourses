package tr.edu.medipol.ogrenciler.dogankoc.extra1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pencere extends JFrame implements ActionListener {
	
	public ArrayList<String> isimler = new ArrayList<String>();
	private JLabel etiketMesaji = new JLabel();

	JTextField girdiAdsoyad = new JTextField();

	public Pencere() {
		setLayout(new GridLayout(7, 2));

		JLabel etiketadSoyad = new JLabel("Ad Soyad: ");
		
		JButton buton = new JButton("Ekle");
		buton.addActionListener(this);
		
		JButton buton2 = new JButton("Pencere 2");
		Pencere2 op2 = new Pencere2(isimler);
		buton2.addActionListener(op2);

		JButton buton3 = new JButton("TEMİZLE");
		buton3.addActionListener(this);
		
		add(etiketadSoyad);
		add(girdiAdsoyad);
		add(buton);
		add(etiketMesaji);
		add(buton2);
		add(buton3);
	}

	public void actionPerformed(ActionEvent arg0) {
		JButton basilan = (JButton) arg0.getSource();
		String basilanButonAdi = basilan.getText();
		if (basilanButonAdi == "Ekle") {
			isimler.add(girdiAdsoyad.getText());
			etiketMesaji.setText("Ad Soyad :" + girdiAdsoyad.getText() + "-");

		}
		if (basilanButonAdi == "TEMİZLE") {
			etiketMesaji.setText("");
			girdiAdsoyad.setText("");
		}

	}

	public static void main(String[] args) {

		Pencere program = new Pencere();
		program.setTitle("Ornek Program");
		program.setSize(500, 500);
		program.setVisible(true);
	}


}
