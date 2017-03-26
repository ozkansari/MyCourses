package tr.edu.medipol.hafta5.grub_b;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Buton aksiyonlarini belirleyen sinif
 */
public class ButonAksiyonu implements ActionListener {

	/**
	 * Ogrenci tipindeki listeleri tutan degisken
	 */
	private List<Ogrenci> ogrenciListesi = new ArrayList<>();

	// OgrenciProgrami sinifina referans eden degiskenler
	private JTextField girdiOgrenciAdReferans;
	private JComboBox<String> ogrenciTipiReferans;
	private JTextArea ogrenciTextAreaReferans;
	
	/**
	 * Yapilandirici : Ogrenci Programindan nesnelerin refereanslarini alir
	 * 
	 * @param g OgrenciProgrami sinifindaki girdiOgrenciAd degiskeninin referansı
	 * @param o OgrenciProgrami sinifindaki ogrenciTipi degiskeninin referansı
	 * @param l OgrenciProgrami sinifindaki ogrenciTextArea degiskeninin referansı
	 */
	public ButonAksiyonu(JTextField g, 
			JComboBox<String> o,
			JTextArea l) {
		girdiOgrenciAdReferans = g;
		ogrenciTipiReferans = o;
		ogrenciTextAreaReferans = l;
	}
	
	/**
	 * Butona tiklandiginda cagrilan metod
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Referanslardan kullanicinin secim yaptigi ogrenci ad ve tip degerlerini al
		String ogrenciAd = girdiOgrenciAdReferans.getText();
		String ogrenciTip = (String) ogrenciTipiReferans.getSelectedItem();
		
		System.out.println("Butona basildi. " + ogrenciAd + ogrenciTip);
		
		// Kullanicinin ogrenciTip secimine gore LisansOgrencisi ya da YuksekLisansOgrencisi olustur
		Ogrenci ogrenci ;
		if (ogrenciTip.equals("Lisans")) {
			ogrenci = new LisansOgrencisi(ogrenciAd);
		} else {
			ogrenci = new YuksekLisansOgrencisi(ogrenciAd);
		} 
		// Olusturulan yeni ogrenciyi listeye ekle
		ogrenciListesi.add(ogrenci);
		
		// EKrana basmak icin ogrenciListesi degerlerini al
		String liste = "";
		for (Ogrenci o : ogrenciListesi) {
			liste = liste + o.adSoyad + " " + o.ogrenciTipi() + " ,\n";
		}
		ogrenciTextAreaReferans.setText(liste);
		
		girdiOgrenciAdReferans.setText("");
	}
	
	/**
	 * ogrenciListesi'ne diger siniflardan erismek icin GETTER
	 * 
	 * @return
	 */
	public List<Ogrenci> getOgrenciListesi() {
		return ogrenciListesi;
	}

}
