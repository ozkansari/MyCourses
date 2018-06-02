package tr.edu.medipol.odevler2.keremarca.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import tr.edu.medipol.odevler2.keremarca.db.ogrenciDB;
import tr.edu.medipol.odevler2.keremarca.setget.ogrenciSetGet;
import tr.edu.medipol.odevler2.keremarca.test.gui;



public class KayitYapGui extends JDialog implements gui{
	
//	ogrenciDB baglanti = new ogrenciDB();
//	ogrenciSetGet yeniKayit = new ogrenciSetGet();
	
	public KayitYapGui() {
		pencere();
	}
	
	public void pencere() {
		JPanel panel = Panel();
		
		add(panel);
		setTitle("��renci Ekle");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}

	public JPanel Panel() {
		
		JPanel panel = new JPanel(new GridLayout(8, 2));
		
		JLabel adsoyad = new JLabel("Ad� Soyad�:",JLabel.LEFT);
		panel.add(adsoyad);
		final JTextField adsoyadField = new JTextField(15);
		panel.add(adsoyadField);
		JLabel bolum = new JLabel("B�l�m�:",JLabel.LEFT);
		panel.add(bolum);
		final JTextField bolumField = new JTextField(15);
		panel.add(bolumField);
		JLabel girisyili = new JLabel("Giri� Y�l�:",JLabel.LEFT);
		panel.add(girisyili);
		final JTextField girisyiliField = new JTextField(15);
		panel.add(girisyiliField);
		
		JButton ekle = new JButton("Ekle");
		panel.add(ekle);
		ekle.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String mailSablonu = "^[0-9]";
	     		Pattern sablonNesnesi = Pattern.compile(mailSablonu, Pattern.CASE_INSENSITIVE);
	     		
	     		Matcher eslestirici = sablonNesnesi.matcher(girisyiliField.getText());
	     		boolean eslestiMi = eslestirici.find();
	     		
	     		if(eslestiMi == false || girisyiliField.getText() == null || girisyiliField.getText().trim().isEmpty() || girisyiliField.getText().equals("*")
	     				|| adsoyadField.getText() == null || adsoyadField.getText().trim().isEmpty() || adsoyadField.getText().equals("*")
	     				|| bolumField.getText() == null || bolumField.getText().trim().isEmpty() || bolumField.getText().equals("*")) {

			
	     			 JOptionPane.showMessageDialog(null, "Alanlar Bo� veya Giri� Y�l� rakam de�il", "Failure", JOptionPane.ERROR_MESSAGE);

	     		}
	     		else {
				
//				yeniKayit.setAdsoyad(adsoyadField.getText());
//				yeniKayit.setBolum(bolumField.getText());
//				yeniKayit.setGirisyili(girisyiliField.getText());
//				
//				baglanti.yeniKayit(yeniKayit);
				
								
	     			JOptionPane.showMessageDialog(null, "��renci Eklendi");
				
			}
			}
		});
		
	
		
		return panel;
	}

	@Override
	public JMenuBar Menu() {
		// TODO Auto-generated method stub
		return null;
	}


}
