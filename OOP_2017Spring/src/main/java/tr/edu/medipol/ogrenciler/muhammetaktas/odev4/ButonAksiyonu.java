package tr.edu.medipol.ogrenciler.muhammetaktas.odev4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButonAksiyonu implements ActionListener {

	private List<Calisan> calisanListesi = new ArrayList<>();

	private JTextField girdiCalisanAdReferans;
	private JTextField girdiGirisYiliReferans;
	private JComboBox<String> calisanTipiReferans;
	private JTextArea calisanTextAreaReferans;
	public ButonAksiyonu(JTextField g, JTextField c,
			JComboBox<String> o,
			JTextArea l) {
		girdiCalisanAdReferans = g;
		girdiGirisYiliReferans = c;
		calisanTipiReferans = o;
		calisanTextAreaReferans = l;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String calisanAd = girdiCalisanAdReferans.getText();
		String calisanGirisYili = girdiGirisYiliReferans.getText();
		String calisanTip = (String) calisanTipiReferans.getSelectedItem();
		
		System.out.println("Butona basildi. " + calisanAd + calisanGirisYili + calisanTip);
	
		Calisan calisan ;
		if (calisanTip.equals("M�d�r")) {
			calisan = new mudur(calisanAd,calisanGirisYili);
		} 
		else if (calisanTip.equals("Yaz�l�mc�")) {
			calisan = new yazilimci(calisanAd,calisanGirisYili);
		}
		else {
			calisan = new analist(calisanAd,calisanGirisYili);
			
		}
		calisanListesi.add(calisan);
		
		String liste = "";
		for (Calisan o : calisanListesi) {
			liste = liste + "Ad Soyad: "+ o.adSoyad +" - " + " Ba�lama Tarihi: " + o.girisYili +" - " + "B�l�m: " + o.CalisanTipi() + " ,\n";
		}
		calisanTextAreaReferans.setText(liste);
		
		girdiCalisanAdReferans.setText("");
		girdiGirisYiliReferans.setText("");
	}
	
	public List<Calisan> getOgrenciListesi() {
		return calisanListesi;
	}

}
