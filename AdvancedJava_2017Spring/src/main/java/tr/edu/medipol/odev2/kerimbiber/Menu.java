package tr.edu.medipol.odev2.kerimbiber;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

/** ozkans Degerlendirme

1 gun Gec gonderim.

Ekran: 20/20
Ogrenci Islemleri: 15/15
Polimorphism: 15/15
Dosyadan Okuma: 0/20
Dosyaya Yazma:  5/20
Genel Program: 10/10
Bonus:25/25
--------------------------
SONUC: 90/125
 */
public class Menu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtAd;
	private JTextField txtSoyad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	Path path = Paths.get("./dosya.txt");
		
		ArrayList arrayList = new ArrayList<>();
		try{
			FileOutputStream fileOut = new FileOutputStream(path.getFileName().toString());
			ObjectOutputStream outSerialize = new ObjectOutputStream(fileOut);
			outSerialize.writeObject(arrayList);
			outSerialize.flush();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 418, 102);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ad", "Soyad", "Bolum"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblOgrenciAdi = new JLabel("Ogrenci Adi:");
		lblOgrenciAdi.setBounds(10, 253, 108, 14);
		contentPane.add(lblOgrenciAdi);
		
		JLabel lblOgrenciSoyadi = new JLabel("Ogrenci Soyadi:");
		lblOgrenciSoyadi.setBounds(10, 278, 108, 14);
		contentPane.add(lblOgrenciSoyadi);
		
		JLabel lblOgrenciBolumu = new JLabel("Ogrenci Bolumu:");
		lblOgrenciBolumu.setBounds(10, 303, 108, 14);
		contentPane.add(lblOgrenciBolumu);
		
		txtAd = new JTextField();
		txtAd.setBounds(128, 247, 102, 20);
		contentPane.add(txtAd);
		txtAd.setColumns(10);
		
		txtSoyad = new JTextField();
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(128, 272, 102, 20);
		contentPane.add(txtSoyad);
		
		JComboBox cbBolum = new JComboBox();
		cbBolum.setModel(new DefaultComboBoxModel(new String[] {"Lisans", "Yuksek Lisans", "Doktora"}));
		cbBolum.setBounds(128, 297, 102, 20);
		contentPane.add(cbBolum);
		
		JButton btnEkle = new JButton("Ogrenci Ekle");
		btnEkle.addActionListener(new ActionListener() {
			
			
			
			
			
			
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{txtAd.getText(), txtSoyad.getText(), cbBolum.getSelectedItem().toString() });
 			}
		});
		btnEkle.setBounds(10, 124, 108, 28);
		contentPane.add(btnEkle);
		
		JButton btSil = new JButton("Ogrenci Sil");
		btSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(table.getSelectedRow());
			}
		});
		btSil.setBounds(320, 124, 108, 28);
		contentPane.add(btSil);
	}
}
