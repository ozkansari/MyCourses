package tr.edu.medipol.vize1.muhammedkerimkilicoz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.management.modelmbean.ModelMBean;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Isci extends JFrame {
	public static final String Ad=null;
	public static final String Yas=null;
	public static final String Pozisyon=null;
	private JTable table;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	IsciAna isci = new IsciAna(Ad,Yas,Pozisyon);
	private JTable table_1;
	private JTable table_2;
    private final String FILENAME = "C:\\Users\\Muhammed\\Desktop\\db.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Isci frame = new Isci();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Isci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_1 = new JTable();
		table_1.setForeground(Color.BLACK);
		table_1.setBounds(329, 41, 77, 235);
		contentPane.add(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"     "
				}
			));
		
		table_2 = new JTable();
		table_2.setForeground(Color.BLACK);
		table_2.setBounds(422, 41, 77, 235);
		contentPane.add(table_2);
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"     "
				}
			));
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"     "
			}
		));
		table.setBounds(232, 41, 77, 235);
				contentPane.add(table);
				
				JButton Add = new JButton("Ekle");
				Add.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					 	isci.setAd(textField.getText());
						isci.setYas(textField_2.getText());
						isci.setPozisyon(textField_1.getText());
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
						DefaultTableModel model2 = (DefaultTableModel) table_2.getModel();
					    Vector row = new Vector();
					    Vector row1 = new Vector();
					    Vector row2 = new Vector();
					    row.add(isci.getAd());
					    row1.add(isci.getYas());
					    row2.add(isci.getPozisyon());
					    model.addRow(row);
					    model1.addRow(row1);
					    model2.addRow(row2);
					}
				});
				Add.setBounds(123, 258, 89, 23);
				contentPane.add(Add);
				JButton Delete = new JButton("Sil");
				Delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
						DefaultTableModel model2 = (DefaultTableModel) table_2.getModel();
						int row = table.getSelectedRow();
						model.removeRow(row);
						model1.removeRow(row);
						model2.removeRow(row);
			
					}
				});
				Delete.setBounds(123, 292, 89, 23);
				contentPane.add(Delete);
				
				textField = new JTextField();
				textField.setBounds(110, 83, 86, 20);
				contentPane.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(110, 114, 86, 20);
				contentPane.add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(110, 146, 86, 20);
				contentPane.add(textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Ad");
				lblNewLabel.setBounds(10, 86, 46, 14);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Ya_");
				lblNewLabel_1.setBounds(10, 117, 46, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Pozisyon");
				lblNewLabel_2.setBounds(10, 149, 62, 14);
				contentPane.add(lblNewLabel_2);
				
				JLabel lblalanlar = new JLabel("\u0130sim");
				lblalanlar.setBounds(260, 16, 69, 26);
				contentPane.add(lblalanlar);
				
				JButton btnNewButton = new JButton("Geri");
				btnNewButton.setBounds(20, 18, 89, 23);
				contentPane.add(btnNewButton);
				
				JLabel lblNewLabel_3 = new JLabel("Pozisyon\r\n");
				lblNewLabel_3.setBounds(343, 22, 63, 14);
				contentPane.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("Ya\u015F\r\n");
				lblNewLabel_4.setBounds(440, 22, 46, 14);
				contentPane.add(lblNewLabel_4);
				
				JButton btnNewButton_1 = new JButton("De\u011Fi\u015Fiklikleri Kaydet\r\n\r\n");
				btnNewButton_1.setBounds(293, 292, 169, 40);
				contentPane.add(btnNewButton_1);
				
				JButton btnListele = new JButton("Listele");
				btnListele.setBounds(42, 202, 136, 40);
				contentPane.add(btnListele);
				
				btnListele.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						try {
							BufferedReader in = new BufferedReader(new FileReader(FILENAME));
							DefaultTableModel model = (DefaultTableModel) table.getModel();	
							DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();	
							DefaultTableModel model2 = (DefaultTableModel) table_2.getModel();
							String line = in.readLine();
							
							while(line!=null)
							{
								String[] part = line.split(" ");			
								Vector row = new Vector();
								row.add(part[0]);
								model.addRow(row);	
											
								Vector row1 = new Vector();
								row1.add(part[1]);
								model1.addRow(row1);						
														
								Vector row2 = new Vector();
								row2.add(part[2]);
								model2.addRow(row2);
								line = in.readLine();					
			
							}
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
				});
				
				
				btnNewButton_1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						 {
						try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
							DefaultTableModel model = (DefaultTableModel) table.getModel();	
							DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();	
							DefaultTableModel model2 = (DefaultTableModel) table_2.getModel();	
							for(int i=0;i<model.getRowCount();i++){
								System.out.println(model.getRowCount());
								String content = (String) model.getValueAt(i, 0)+" "+model1.getValueAt(i, 0)+" "+model2.getValueAt(i, 0);
								bw.write(content);
								bw.newLine();
							}	
								System.out.println("test");
							} catch (IOException e1) {

								e1.printStackTrace();

							}

						}
			
					}
				});
				
				btnNewButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
	
						AnaMenu anamenu = new AnaMenu();
						anamenu.setVisible(true);
						setVisible(false);
						dispose();
					}
				});
		
	}
}
