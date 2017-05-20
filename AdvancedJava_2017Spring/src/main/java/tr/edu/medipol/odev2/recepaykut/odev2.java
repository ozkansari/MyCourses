package tr.edu.medipol.odev2.recepaykut;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;

/** ozkans Degerlendirme
Ekran: 20/20
Ogrenci Islemleri: 15/15
Polimorphism: 0/15
Dosyadan Okuma: 15/20 (Tum bilgiler bir satirda okunuyor)
Dosyaya Yazma:  5/20 (Dosya pathi D:\ seklinde belirtilmis, Tum bilgiler bir satirda yaziliyor, Eklerken append yapmiyor onceki kayitlar ezilir.
Genel Program: 5/10 (Bos kayit kontrolu olsa iyi olurdu)
Bonus:25/25 (Scroll, table, combo kullanimi)
--------------------------
SONUC: 85/125

 */
public class odev2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JScrollPane scrollPane;
	FileWriter fileWriter;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					odev2 window = new odev2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public odev2() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(224, 255, 255));
		frame.getContentPane().setForeground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Isim");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Soyisim");
		lblSurname.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSurname.setBounds(10, 39, 46, 14);
		frame.getContentPane().add(lblSurname);
		
		textField = new JTextField();
		textField.setBounds(62, 8, 70, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(62, 36, 70, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ogrenim Turu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(166, 11, 70, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBlm = new JLabel("Bolum");
		lblBlm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBlm.setBounds(166, 39, 46, 14);
		frame.getContentPane().add(lblBlm);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Onlisans", "Lisans", "Yuksek Lisans", "Doktora"}));
		comboBox.setBounds(246, 8, 87, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Bilgisayar Prog.", "Mimarlik", "Hukuk", "Insaat Muhendisligi", "Paramedik"}));
		comboBox_1.setBounds(246, 36, 87, 20);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnEkle = new JButton("Ekle");
		btnEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[]{textField.getText(), textField_1.getText(), comboBox.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString() });
				
				try{
					fileWriter = new FileWriter ("D:\\Data.txt");
					fileWriter.write(lblName.getText() + " : " + textField.getText() + "  ");
					fileWriter.write(lblSurname.getText() + " : " + textField_1.getText() + "  ");
					fileWriter.write(lblNewLabel.getText() + " : " + comboBox.getSelectedItem().toString() + "  ");
					fileWriter.write(lblBlm.getText() + " : " + comboBox_1.getSelectedItem().toString()+ "  ");
					
					fileWriter.close();
					
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, e+"");
				}
 			}
		});
		btnEkle.setBounds(343, 22, 81, 20);
		frame.getContentPane().add(btnEkle);
		
		
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane);
		scrollPane.setBounds(10, 67, 414, 148);
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Isim", "Soyisim", "Bolum", "Tip"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(10, 74, 414, 135);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		scrollPane.setColumnHeaderView(panel);
		panel.setBackground(new Color(70, 130, 180));
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(table.getSelectedRow());
			}
		});
		btnSil.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSil.setBounds(343, 227, 81, 23);
		frame.getContentPane().add(btnSil);
		
		
		
		
		
	}
	 

}
