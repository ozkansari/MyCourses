package tr.edu.medipol.ogrenciler.muhittinayri.odev4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

import javax.swing.JTextArea;
import javax.swing.JTextField;



public class ButonAksiyon implements ActionListener{
	
	private List<Calisanlar> CalisanListe = new ArrayList<>();
	private JTextField eCalisanAdSoyad;
	private JTextField eTarih;
	private JTextField eUcret;
	private JComboBox<String> eCalismaSekli;
	private JComboBox<String> eCalisanTipi;
	private JTextArea CalisanTextArea;
	
	public ButonAksiyon(JTextField g,JTextField o,JTextField m,JComboBox<String> r,JComboBox<String> n,JTextArea l){
		eCalisanAdSoyad = g;
		eTarih = o;
		eUcret = m;
		eCalismaSekli=r;
		eCalisanTipi = n;
		CalisanTextArea = l;
		
	}
	
	public void actionPerformed(ActionEvent e){
		String CalisanAdSoyad=eCalisanAdSoyad.getText();
		String Tarih=eTarih.getText();
		String Ucret=eUcret.getText();
		String CalismaSekli = (String) eCalismaSekli.getSelectedItem();
		String CalisanTipi = (String) eCalisanTipi.getSelectedItem();
		
		System.out.println("Ad Soyad="+CalisanAdSoyad);
		System.out.println("iie Girii Tarihi="+Tarih);
		System.out.println("Aldiii icret="+Ucret);
		System.out.println("Calisma Sekli="+CalismaSekli);
		System.out.println("Departman="+CalisanTipi);
		
		Calisanlar calisanlar;
		if(CalisanTipi.equals("Analist"))
		{
			calisanlar = new Analist(CalisanAdSoyad,Tarih,Ucret,CalismaSekli,CalisanTipi);
		}
		if (CalisanTipi.equals("Mudur"))
		{
			calisanlar = new Mudur(CalisanAdSoyad,Tarih,Ucret,CalismaSekli,CalisanTipi);
		}
		else
		{
			calisanlar = new Yazilimci(CalisanAdSoyad,Tarih,Ucret,CalismaSekli,CalisanTipi);
		}
		
		CalisanListe.add(calisanlar);
		
		String liste="";
		for(Calisanlar f : CalisanListe)
		{
			liste = liste +("Adi Soyadi=") + f.adSoyad +"\n"+("iie Girii Tarihi=")+ f.Tarih + "\n" +("Aldiii icret=")+ f.Ucret+ "\n" +("Calisma Sekli=") + f.CalismaSekli+" \n" +("Departman=") + f.CalisanTipi + "\n";
			
		}
		CalisanTextArea.setText(liste);
		eCalisanAdSoyad.setText("");
		eTarih.setText("");
		eUcret.setText("");
		eCalismaSekli.setSelectedItem("");
		eCalisanTipi.setSelectedItem("");
	}
	public List<Calisanlar> getCalisanListesi() {
		return CalisanListe;
	}
		
		
		
		
}
