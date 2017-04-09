package tr.edu.medipol.ogrenciler.yusufucar.odev4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ButonAksiyonu implements ActionListener {

	


	private List<Calisanlar> calisanListesi = new ArrayList<>();

	
	private JTextField calisanAdi;
	private JComboBox<String> calisanTipi;
	private JTextArea calisanTextArea;
	
	
	public ButonAksiyonu(JTextField a, 
			JComboBox<String> b,
			JTextArea c) {
		calisanAdi = a;
		calisanTipi = b;
		calisanTextArea = c;
	}
	
	
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String calisanAd = calisanAdi.getText();
		String calisanTip = (String) calisanTipi.getSelectedItem();

		
		System.out.println("|>>" + " " + calisanAd + " " + " " + calisanTip );
		
		
		Calisanlar calisan = null ;
		if (calisanTip.equals("Mudur")) {
			calisan = new Mudur(calisanAd);
		} 
		else if (calisanTip.equals("Yazilimci")) {
			calisan = new Yazilimci(calisanAd);
		} 
		else if (calisanTip.equals("Analist")) {
			calisan = new Analist(calisanAd);
		} 
		else if (calisanTip.equals("Temizlikci")) {
			calisan = new Temizlikci(calisanAd);
		} 
		else if (calisanTip.equals("Guvenlik")) {
			calisan = new Guvenlik(calisanAd);
		}
		else if (calisanTip.equals("Muhasebe")) {
			calisan = new Muhasebe(calisanAd);
		}
		else if (calisanTip.equals("Tasarimci")) {
			calisan = new Tasarimci(calisanAd);
		}
		
		
		
		calisanListesi.add(calisan);
		
		
		String liste = "";
		for (Calisanlar b : calisanListesi) {
			liste = liste + b.adSoyad + " " + "=> " + b.calisanTipi() + " " +  "\n";
		}
		calisanTextArea.setText(liste);
		
		calisanAdi.setText("");
	}
	
	
	public List<Calisanlar> getCalisanlarListesi() {
		return calisanListesi;
	}

}

