package tr.edu.medipol.ogrenciler.ibrahimkandemir.odev4;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButonAksiyonu implements ActionListener{
	
	private List<Calisanlar> calisanListesi = new ArrayList<>();	
	private JTextField calisanAdReferans;
	private JTextField calisanTCReferans;
	private JTextField calisansicilNoReferans;
	private JTextField calisanIsBaslangicReferans;
	private JTextField calisanMaasReferans;
	private JComboBox<String> calisanTipiReferans;
	private JTextArea calisanTextArea;
	
	public ButonAksiyonu(JTextField calisaninAdi, JTextField calisanTc, JTextField calisanSicilNo,
			JTextField isBaslangic, JComboBox<String> calisanBirim, JTextField calisanMaas,JTextArea aciklama){
		calisanAdReferans = calisaninAdi;
		calisanTCReferans = calisanTc;
		calisansicilNoReferans = calisanSicilNo;
		calisanIsBaslangicReferans = isBaslangic;
		calisanTipiReferans = calisanBirim;
		calisanMaasReferans = calisanMaas;
		calisanTextArea=aciklama;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String adSoyadi = null;
		String tcNo = null;
		String sicilNo = null;
		String iseBaslangic = null;
		String maas = null;
		String calisanTipi = (String) calisanTipiReferans.getSelectedItem();
	

		try{
			if( (calisanTipi.equals("Seciniz..")) ){
			
				JOptionPane.showMessageDialog(null,"GEREKLI ALANLAR BOS BIRAKILAMAZ.","HATA",JOptionPane.ERROR_MESSAGE);
					return;
			}
				
		}catch(NullPointerException n){
			JOptionPane.showMessageDialog(null,"Gecerli bir birim girin.","HATA",JOptionPane.ERROR_MESSAGE);
		}
		
				
			
		if(calisanAdReferans.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Isim kismi bos birakilamaz.Tekrar deneyin.","HATA",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			adSoyadi = calisanAdReferans.getText();
		}

		if(calisanTCReferans.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"TC kimlik numaras� bos birakilamaz.Tekrar deneyin.","HATA",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			tcNo = calisanTCReferans.getText();
		}
		
		if(calisansicilNoReferans.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Sicil numaras� bos birakilamaz.Tekrar deneyin.","HATA",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			sicilNo = calisansicilNoReferans.getText();
		}
		
		if(calisanIsBaslangicReferans.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Is baslangic tarihi bos birakilamaz.Tekrar deneyin.","HATA",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			iseBaslangic = calisanIsBaslangicReferans.getText();
		}
		
		if(calisanMaasReferans.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Maas kismi bos birakilamaz.Tekrar deneyin.","HATA",JOptionPane.ERROR_MESSAGE);
		}
		else{ 	
			maas = calisanMaasReferans.getText();
		}
				
		
		
		
		if( !(calisanAdReferans.getText().isEmpty()) && 
				!(calisanTCReferans.getText().isEmpty()) && 
					!(calisansicilNoReferans.getText().isEmpty()) && 
						!(calisanIsBaslangicReferans.getText().isEmpty()) &&
							!(calisanMaasReferans.getText().isEmpty()) ){
		
									JOptionPane.showMessageDialog(null,"CALISAN KAYIT EDILDI","BILGI",JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		Calisanlar calisan = null;
		if(calisanTipi.equals("Mudur")){
			calisan = new Mudur(adSoyadi, tcNo, sicilNo, iseBaslangic, calisanTipi, maas);
		}
		else if(calisanTipi.equals("Direktor")){
			calisan = new Direktor(adSoyadi, tcNo, sicilNo, iseBaslangic, calisanTipi, maas);
		}
		else if(calisanTipi.equals("Yazilimci")){
			calisan = new Yazilimci(adSoyadi, tcNo, sicilNo, iseBaslangic, calisanTipi, maas);
		}
		
		else if(calisanTipi.equals("Analist")){
			calisan = new Analist(adSoyadi, tcNo, sicilNo, iseBaslangic, calisanTipi, maas);
		}
		
		else if(calisanTipi.equals("Muhasebe")){
			calisan = new Muhasebe(adSoyadi, tcNo, sicilNo, iseBaslangic, calisanTipi, maas);
		}
		
		else if(calisanTipi.equals("Insan Kaynaklari")){
			calisan = new InsanKaynaklari(adSoyadi, tcNo, sicilNo, iseBaslangic, calisanTipi, maas);
		}
		
		else if(calisanTipi.equals("Isci")){
			calisan = new Isci(adSoyadi, tcNo, sicilNo, iseBaslangic, calisanTipi, maas);
		}

		calisanListesi.add(calisan);
		
		String liste="";
		for(Calisanlar c:calisanListesi){
			liste = liste+
					"\n"+
					"Calisanin Adi:"+c.calisaninAdi+
					" | T.C. Kimlik No:"+c.calisanTC+
					" | Sicil Numaras�:"+c.calisanSicilNo+
					" | Ise Baslangic Tarihi:"+c.calisaninIseBas+
					" | Calisanin Maasi"+c.calisanMaas+
					" | Calisanin Birimi:"+c.calisanTipi;
		}
		calisanTextArea.setText(liste);

	}	
}



	
