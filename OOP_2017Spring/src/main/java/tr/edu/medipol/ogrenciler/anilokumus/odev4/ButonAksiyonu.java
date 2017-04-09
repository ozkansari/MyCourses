package tr.edu.medipol.ogrenciler.anilokumus.odev4;

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
	private JTextField girdiCalisanYilReferans;
	private JComboBox<String> calisanTipiReferans;
	private JTextArea calisanTextAreaReferans;
	public ButonAksiyonu(JTextField g, 
			JTextField z,
			JComboBox<String> o,
			JTextArea l) {
		girdiCalisanYilReferans=z;
		girdiCalisanAdReferans = g;
		calisanTipiReferans = o;
		calisanTextAreaReferans = l;
	}
	public void actionPerformed(ActionEvent e) {
		String calisanAd = girdiCalisanAdReferans.getText();
		String calisanYil = (String)girdiCalisanYilReferans.getText();
		String calisanTip = (String) calisanTipiReferans.getSelectedItem();
		
		System.out.println(calisanAd +calisanYil+ calisanTip);
	
		Calisan calisan = null;
		
		if (calisanTip.equals("Mudur")) {
			calisan = new Mudur(calisanAd,calisanYil);
		} 
		if (calisanTip.equals("MYardimcisi")) {
			calisan = new MYardimcisi(calisanAd,calisanYil);
		} 
		if (calisanTip.equals("Yazilimci")){
			calisan = new Yazilimci(calisanAd,calisanYil);
		} 
		calisanListesi.add(calisan);
		String liste = "";
		for (Calisan o : calisanListesi) {
			liste = liste + o.adSoyad+ ", "+o.calisanYil+" ,"+ o.calisanTipi() + " ,\n";
		}

		calisanTextAreaReferans.setText(liste);
		
		girdiCalisanAdReferans.setText("");
		girdiCalisanYilReferans.setText("");
	}
	public List<Calisan> getOgrenciListesi() {
		return calisanListesi;
	}
}

