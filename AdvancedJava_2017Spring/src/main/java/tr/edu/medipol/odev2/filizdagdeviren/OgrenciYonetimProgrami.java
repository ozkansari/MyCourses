package tr.edu.medipol.odev2.filizdagdeviren;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

/** ozkans Degerlendirme

Ekran: 20/20
Ogrenci Islemleri: 0/15
Polimorphism: 0/15
Dosyadan Okuma: 0/20
Dosyaya Yazma:  0/20
Genel Program: 10/10
Bonus:0/25
--------------------------
SONUC: 30/125
 */
public class OgrenciYonetimProgrami {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OgrenciYonetimProgrami window = new OgrenciYonetimProgrami();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OgrenciYonetimProgrami() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblrenciAd = new JLabel("\u00D6\u011Frenci Ad\u0131:");
		lblrenciAd.setBounds(37, 29, 97, 30);
		frame.getContentPane().add(lblrenciAd);
		
		textField = new JTextField();
		textField.setBounds(132, 34, 138, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblrenciBlm = new JLabel("\u00D6\u011Frenci Tipi:");
		lblrenciBlm.setBounds(37, 90, 90, 14);
		frame.getContentPane().add(lblrenciBlm);
		
		JCheckBox chckbxYksekLisans = new JCheckBox("Y\u00FCksek Lisans");
		chckbxYksekLisans.setBounds(132, 86, 97, 23);
		frame.getContentPane().add(chckbxYksekLisans);
		
		JCheckBox chckbxDoktora = new JCheckBox("Doktora");
		chckbxDoktora.setBounds(132, 123, 97, 23);
		frame.getContentPane().add(chckbxDoktora);
		
		JCheckBox chckbxDier = new JCheckBox("Di\u011Fer");
		chckbxDier.setBounds(132, 161, 97, 23);
		frame.getContentPane().add(chckbxDier);
		
		JLabel lblrenciBlm_1 = new JLabel("\u00D6\u011Frenci B\u00F6l\u00FCm\u00FC:");
		lblrenciBlm_1.setBounds(37, 206, 90, 14);
		frame.getContentPane().add(lblrenciBlm_1);
		
		JCheckBox chckbxMyo = new JCheckBox("MYO");
		chckbxMyo.setBounds(132, 202, 97, 23);
		frame.getContentPane().add(chckbxMyo);
		
		JCheckBox chckbxIletme = new JCheckBox("\u0130\u015Fletme");
		chckbxIletme.setBounds(132, 236, 97, 23);
		frame.getContentPane().add(chckbxIletme);
		
		JCheckBox chckbxDier_1 = new JCheckBox("Di\u011Fer");
		chckbxDier_1.setBounds(132, 269, 97, 23);
		frame.getContentPane().add(chckbxDier_1);
		
		JButton btnrenciEkle = new JButton("\u00D6\u011Frenci Ekle");
		btnrenciEkle.setBounds(340, 255, 129, 37);
		frame.getContentPane().add(btnrenciEkle);
	}
}
