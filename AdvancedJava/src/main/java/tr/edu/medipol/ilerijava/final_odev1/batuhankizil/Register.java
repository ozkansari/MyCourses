package tr.edu.medipol.ilerijava.final_odev1.batuhankizil;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Register {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtsurname;
	private DbConnection conn;
	
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final Register window = new Register();
					window.frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Register() {
		initialize();
	}
	
	private void initialize() {
		conn = new DbConnection();
		conn.createDB();
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLabel name = new JLabel("Your Name : ");
		name.setBounds(60, 11, 132, 23);
		frame.getContentPane().add(name);
		
		final JLabel surname = new JLabel("Your Surname : ");
		surname.setBounds(40, 45, 132, 23);
		frame.getContentPane().add(surname);
		
		txtname = new JTextField();
		txtname.setBounds(150, 12, 200, 23);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtsurname = new JTextField();
		txtsurname.setBounds(150, 46, 200, 22);
		frame.getContentPane().add(txtsurname);
		txtsurname.setColumns(10);
		
		final JLabel lblResult = new JLabel();
				
		final JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean successful = conn.insertData(txtname.getText(), txtsurname.getText());
				if(successful) {
					lblResult.setText("Registration Successful");
				}else {
					lblResult.setText("Registration Failed");
				}				
			}
		});
		btnSave.setBounds(150, 94, 89, 23);
		frame.getContentPane().add(btnSave);
		
		lblResult.setBounds(125, 130, 250, 22);
		frame.getContentPane().add(lblResult);
		
		
		
	}
}