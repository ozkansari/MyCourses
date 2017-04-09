package tr.edu.medipol.ogrenciler.batinarslan.odev4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Buton implements ActionListener{
	
	private List<Calisan> CalisanListe = new ArrayList<>();
	private JTextField CalisanAdSoyad;
	private JTextField CalisanTel;
	private JTextField CalisanAdres;
	private JComboBox<String> CalisanPozisyon;

	
	public Buton(JTextField g,JTextField o,JTextField m,JComboBox<String>r){
		CalisanAdSoyad = g;
		CalisanTel = o;
		CalisanAdres = m;
		CalisanPozisyon = r;
		
	}
	
	public void actionPerformed(ActionEvent e){
		String CalisanADSoyad = CalisanAdSoyad.getText();
		String Tel=CalisanTel.getText();
		String Adres=CalisanAdres.getText();
		String Pozisyon = (String) CalisanPozisyon.getSelectedItem();
		
		System.out.println("Ad Soyad="+CalisanADSoyad);
		System.out.println("Calisanin Telefon Numarasi="+Tel);
		System.out.println("Calisanin Adresi="+Adres);
		System.out.println("Pozisyon="+Pozisyon);
		
		Calisan calisanlar;
		if(Pozisyon.equals("Muhasebe"))
		{
			calisanlar = new Muhasebe(CalisanADSoyad,Tel,Adres,Pozisyon);
		}
		if (Pozisyon.equals("Mudur"))
		{
			calisanlar = new Mudur(CalisanADSoyad,Tel,Adres,Pozisyon);
		}
		else
		{
			calisanlar = new InsanKaynaklari(CalisanADSoyad,Tel,Adres,Pozisyon);
		}
		
		CalisanListe.add(calisanlar);
		
		String liste="";
		for(Calisan a : CalisanListe)
		{
			liste = liste +("Adi Soyadi=") + a.CalisanADSoyad +"\n"+("Calisanin Telefon Numarasi=")+ a.Tel + "\n" +("Calisanin Adresi=")+ a.Adres+ "\n" +("Calisma Sekli=") + a.Pozisyon+" \n" ;
			
		}
		CalisanAdSoyad.setText("");
		CalisanTel.setText("");
		CalisanAdres.setText("");
		CalisanPozisyon.setSelectedItem("");
	}
	public List<Calisan> getCalisanListesi() {
		return CalisanListe;
	}
		
		
		
		
}
