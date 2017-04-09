package tr.edu.medipol.ogrenciler.melissatemelli.odev4;

//ozkans: importlari unutmussun. EKliyorum
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// ozkans: Sinif tanimini unutmussun. Sonraki satiri Ekliyorum. 
public class calisanProgrami extends JFrame {

	private JTextField girdiCalisanAd = new JTextField();
	// private JComboBox<String> calisanTip = new JComboBox; // ozkans: newlerken () unutulmamali. Duzelttim.
	private JComboBox<String> calisanTip = new JComboBox(); 
	private ButonActions b;
	private JTextArea calisanTextArea = new JTextArea(1,1);
	// private JTextArea calisanTextArea = new JTextArea(); // ozkans: ayni degisken iki kere tanimlanmis.
	
	// public void Olustur { // ozkans: metod taniminda () unutulmus
	public void olustur() { 
		this.setLayout(new GridLayout(2,0));
		JPanel calisanFormu = new JPanel();
		calisanFormu.setLayout(new GridLayout(15,1));
		calisanFormu.setLayout(new GridLayout(4,1));
		JLabel etiketCalisanAd = new JLabel("Ad Soyad");
		
		calisanTip.addItem("Optisyen");
		calisanTip.addItem("Pazarlamaci");
		
		JButton gonderButonu = new JButton("Gonder");
		b = new ButonActions(girdiCalisanAd, calisanTip,calisanTextArea);
		gonderButonu.addActionListener(b);
		
		calisanFormu.add(etiketCalisanAd);
		calisanFormu.add(girdiCalisanAd);
		calisanFormu.add(calisanTip);
		calisanFormu.add(gonderButonu);
		calisanFormu.add(calisanTextArea);
		
		add(calisanFormu);
		add(calisanTextArea);
	}
	public static void main(String[] args){
		calisanProgrami program= new calisanProgrami();
		program.olustur();
		program.setTitle("Calisan Programi");
		program.setSize(500,600);
		program.setSize(500,600);
		program.setVisible(true);
		program.setResizable(false);
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
		program.setResizable(false);
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


//ozkans: Sinif tanimini unutmussun. Sonraki satiri Ekliyorum.
}