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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Stok extends JFrame {
	public static final String _r_n=null;
	public static final String adet=null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	StokAna stok = new StokAna(_r_n,adet);
	private JLabel lblStok;
	private JButton btnGeri;
	private JTable table_1;
	 private final String FILENAME = "C:\\Users\\Muhammed\\Desktop\\db2.txt";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stok frame = new Stok();
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
	public Stok() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(105, 95, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 138, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblrn = new JLabel("\u00DCr\u00FCn");
		lblrn.setBounds(24, 98, 46, 14);
		contentPane.add(lblrn);
		
		JLabel lblAdet = new JLabel("Adet");
		lblAdet.setBounds(24, 141, 46, 14);
		contentPane.add(lblAdet);
		
		table_1 = new JTable();
		table_1.setBounds(368, 59, 114, 235);
		contentPane.add(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"   _r_n"
				}
			));
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"     Adet"
			}
		));
		table.setBounds(232, 59, 114, 235);
				contentPane.add(table);
				
				JButton Add = new JButton("Ekle");
				Add.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent arg0) {
						
					  stok.Set_r_n(textField.getText());
					  stok.SetAdet(textField_1.getText());
						
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();

					    Vector row = new Vector();
					    Vector row1 = new Vector();
					    row.add(stok.get_r_n());
					    row1.add(stok.getAdet());
					    model.addRow(row);
					    model1.addRow(row1);
					}
				});
				Add.setBounds(113, 274, 78, 20);
				contentPane.add(Add);
				JButton Delete = new JButton("Sil");
				Delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						DefaultTableModel model = (DefaultTableModel) table.getModel();
						DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
						int row = table.getSelectedRow();
						model.removeRow(row);
						model1.removeRow(row);
	
					}
				});
	
				Delete.setBounds(113, 241, 78, 20);
				contentPane.add(Delete);
				
				lblStok = new JLabel("Stok Durumu");
				lblStok.setBounds(309, 11, 107, 14);
				contentPane.add(lblStok);
				
				btnGeri = new JButton("Geri");
				btnGeri.setBounds(24, 11, 89, 23);
				contentPane.add(btnGeri);
				
				JLabel lblNewLabel = new JLabel("\u00DCr\u00FCn\r\n");
				lblNewLabel.setBounds(271, 36, 46, 14);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Adet\r\n");
				lblNewLabel_1.setBounds(401, 36, 46, 14);
				contentPane.add(lblNewLabel_1);

				btnGeri.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						AnaMenu anamenu = new AnaMenu();
						anamenu.setVisible(true);
						setVisible(false);
						dispose();
					}
				});
				
				JButton btnListele = new JButton("Listele");
				btnListele.setBounds(42, 190, 136, 40);
				contentPane.add(btnListele);
				
				btnListele.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						try {
							BufferedReader in = new BufferedReader(new FileReader(FILENAME));
							DefaultTableModel model = (DefaultTableModel) table.getModel();	
							DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();	
							
							String line = in.readLine();
							
							while(line!=null)
							{
								String[] part = line.split(" ");			
								Vector row = new Vector();
								row.add(part[0]);
								model.addRow(row);
								System.out.println(part[0]);
			
								Vector row1 = new Vector();
								row1.add(part[1]);
								model1.addRow(row1);
								System.out.println(part[1]);
								
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


				JButton btnwrite = new JButton("De\u011Fi\u015Fiklikleri Kaydet\r\n\r\n");
				btnwrite.setBounds(288, 305, 169, 40);
				contentPane.add(btnwrite);


				btnwrite.addActionListener(new ActionListener() {
	
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
		
		
							{
								try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
									DefaultTableModel model = (DefaultTableModel) table.getModel();	
									DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();		
									for(int i=0;i<model.getRowCount();i++){
										System.out.println(model.getRowCount());
										String content = (String) model.getValueAt(i, 0)+" "+model1.getValueAt(i, 0);
										bw.write(content);
										bw.newLine();
									}
			
				
									System.out.println("Done");
								} catch (IOException e1) {

									e1.printStackTrace();

								}

							}

						}
				});
				
				
				
	}
}
