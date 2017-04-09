package tr.edu.medipol.ogrenciler.melissatemelli.odev4;

//ozkans: importlari unutmussun. EKliyorum
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// ozkans implements ActionListener unutulmus
// public class ButonActions {
public class ButonActions implements ActionListener {
	// private List<Calisaan> calisanListesi= new ArrayList<>();
	private List<calisan> calisanListesi= new ArrayList<>();
	private JTextField girdiCalisanAdReferans;
	private JTextArea calisanTextArea;
	private JTextArea calisanTextAreaReferans;
	
	// ozkans: degisken rakamla baslamaz
	// public ButonActions (JTextField g, JComboBox o, JTextArea 1){
	public ButonActions (JTextField g, JComboBox o, JTextArea t){
		girdiCalisanAdReferans =g;
		calisanTextArea =t;
		calisanTextAreaReferans =t;
	}
	public void actionPerformed(ActionEvent e){
		String calisanAd = girdiCalisanAdReferans.getText();
		
		// ozkans calisanTipiReferans ve CalisanTip eksik
		// String calisanTip = (String) calisanTipiReferans.getSelectedItem();
		// System.out.println("Butona basildi." + calisanAd + CalisanTip);
		Calisaan calisan;
		// if(CalisanTip.equals("Optik")){
		if(calisanTextArea.equals("Optik")){
			// ozkans tanimlanmayan siniflar kullanilmaya calisilmis
			// calisan =new Optisyen(calisanAd);
		} else{
			// ozkans tanimlanmayan siniflar kullanilmaya calisilmis
			// calisan =new Pazarlamaci(calisanAd); 
		}
		// calisanListesi.add(calisan);
		String liste= "";
		for(calisan o: calisanListesi){
			liste = liste+ o.adSoyad+ ",";
			liste = liste+ o.adSoyad+ " "+ o.calisanTip()+",\n";
		}
		calisanTextArea.setText(liste);
		calisanTextAreaReferans.setText(liste);
		
		girdiCalisanAdReferans.setText("");
	}
	public List<calisan> getcalisanListesi(){
		return calisanListesi;
	}
}
