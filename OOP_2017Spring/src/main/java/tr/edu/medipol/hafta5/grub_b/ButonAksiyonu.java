package tr.edu.medipol.hafta5.grub_b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButonAksiyonu implements ActionListener {

	private List<Ogrenci> ogrenciListesi = new ArrayList<>();

	private JTextField girdiOgrenciAdReferans;
	private JComboBox<String> ogrenciTipiReferans;
	private JTextArea ogrenciTextArea;
	
	public ButonAksiyonu(JTextField g, 
			JComboBox<String> o,
			JTextArea l) {
		girdiOgrenciAdReferans = g;
		ogrenciTipiReferans = o;
		ogrenciTextArea = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ogrenciAd = girdiOgrenciAdReferans.getText();
		String ogrenciTip = (String) ogrenciTipiReferans.getSelectedItem();
		
		System.out.println("Butona basildi. " + ogrenciAd + ogrenciTip);
		
		Ogrenci ogrenci ;
		if (ogrenciTip.equals("Lisans")) {
			ogrenci = new LisansOgrencisi(ogrenciAd);
		} else {
			ogrenci = new YuksekLisansOgrencisi(ogrenciAd);
		} 
		ogrenciListesi.add(ogrenci);
		
		String liste = "";
		for (Ogrenci o : ogrenciListesi) {
			liste = liste + o.adSoyad + ",";
		}
		ogrenciTextArea.setText(liste);
		
		girdiOgrenciAdReferans.setText("");
	}
	
	public List<Ogrenci> getOgrenciListesi() {
		return ogrenciListesi;
	}


}
