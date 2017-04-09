package tr.edu.medipol.ogrenciler.ismailsahin.odev4;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButonAksiyon implements ActionListener {
	
	public ArrayList<Calisan> calisanListesi = new ArrayList<>();
	
	private JTextField girdiCalisanAdReferans;
	private JComboBox<String> calisanTipiReferans;
	private JTextArea calisanTextAreaReferans;
	private JTextField calisanMaasReferans;
	

	public ButonAksiyon(JTextField girdiCalisanAd, JTextField girdiCalisanMaas, 
						JComboBox<String> calisanTipi, JTextArea calisanTextArea){
		girdiCalisanAdReferans=girdiCalisanAd;
		calisanTipiReferans=calisanTipi;
		calisanTextAreaReferans=calisanTextArea;
		calisanMaasReferans=girdiCalisanMaas;
	}

	public void actionPerformed(ActionEvent e) {
		String calisanAd = girdiCalisanAdReferans.getText();
		String calisanTip = (String) calisanTipiReferans.getSelectedItem();
		String calisanTextArea=calisanTextAreaReferans.getText();
		String calisanMaas=calisanMaasReferans.getText();
		
		//System.out.println("Butona basildi. " + calisanAd + calisanTip);
		
		// Kullanicinin ogrenciTip secimine gore LisansOgrencisi ya da YuksekLisansOgrencisi olustur
		Calisan calisan ;
		if (calisanTip.equals("Tasarimci")) {
			calisan = new Tasarimci(calisanAd,calisanMaas);
		} else if(calisanTip.equals("Yazilimci")) {
			calisan = new Yazilimci(calisanAd,calisanMaas);
		} else if(calisanTip.equals("Gorevli")){
			calisan = new Gorevli(calisanAd,calisanMaas);
		} else{
			calisan = new Yonetici(calisanAd,calisanMaas);
		}
		
		calisanListesi.add(calisan);
		
		String liste = "";
		for (Calisan o : calisanListesi) {
			liste = liste + o.adSoyad + ", " + o.calisanTipi() +", "+o.maas +"\n";
		}
		calisanTextAreaReferans.setText(liste);
		
		girdiCalisanAdReferans.setText("");
		calisanMaasReferans.setText("");
	}	
}
