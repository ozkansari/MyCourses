package tr.edu.medipol.vize1.muhammedkerimkilicoz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class AnaMenu extends JFrame {

	
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 AnaMenu frame = new AnaMenu(); //ana men_ frame olu_turur
					frame.setVisible(true);//g_r_n_r hale getirir
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	public AnaMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JButton btnCalisan = new JButton("_al__an");
		btnCalisan.setBounds(68, 89, 100, 75);
		getContentPane().add(btnCalisan);
		
		JButton btnStok = new JButton("Stok");
		btnStok.setBounds(264, 89, 100, 75);
		getContentPane().add(btnStok);
		
		JLabel lblNewLabel_1 = new JLabel("Ma\u011Faza Y\u00F6netimi");
		lblNewLabel_1.setBounds(171, 34, 131, 24);
		contentPane.add(lblNewLabel_1);
		
		btnCalisan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Isci isci = new Isci();
				isci.setVisible(true); // isci frame g_r_n_r hale gelir
				setVisible(false); //ana menu frame gizlenir
				dispose();

				
			}
		});
		
		btnStok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Stok stok = new Stok();
				stok.setVisible(true); //stok frame g_r_n_r hale gelir
				setVisible(false); // ana menu frame gizlenir
				dispose();

			}
		});
		
		
	}
}
