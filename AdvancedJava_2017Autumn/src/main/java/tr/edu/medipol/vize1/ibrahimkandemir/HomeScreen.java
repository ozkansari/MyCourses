package tr.edu.medipol.vize1.ibrahimkandemir;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomeScreen extends JFrame {
	
	
	
	private JLabel programtitle = new JLabel("Store Management System");
	
	private JButton personnelManagement = new JButton("Personnel Management");
	private JButton stockManagement = new JButton("Stock Management");
	private JButton programExit = new JButton("Exit");	
	
	private JPanel homePanel = new JPanel();
	
	PersonnelManagement pm = null;
	StockManagement sm = null;
	
	
	public HomeScreen() {
		
		setTitle("Store Management System");
		setSize(400,600);
		setLocationRelativeTo(null);
		setVisible(true);        
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(null);
		homePanel.setLayout(null);
		homePanel.setBackground(new Color(74,20,140));
		
		
		
		
		programtitle.setBounds(35, 50, 340, 35);
		programtitle.setBackground(Color.WHITE);
		programtitle.setForeground(new Color(250,250,250));
		programtitle.setFont(new Font("Arial", Font.BOLD, 24));
		
		
		
		personnelManagement.setBounds(85, 150, 220, 30);
		personnelManagement.setBackground(Color.WHITE);
		personnelManagement.setForeground(new Color(49,27,146));
		personnelManagement.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		personnelManagement.setToolTipText("Personnel in the department, new personnel, add, delete, or list."); //Buton üzerine açıklama yazma
		
		
		stockManagement.setBounds(100, 200, 190, 30);
		stockManagement.setBackground(Color.WHITE);
		stockManagement.setForeground(new Color(49,27,146));
		stockManagement.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		stockManagement.setToolTipText("In the section inventory, new inventory to add, delete, or list you can use to");
		
		
		programExit.setBounds(115, 250, 150, 30);
		programExit.setBackground(Color.WHITE);
		programExit.setForeground(new Color(49,27,146));
		programExit.setFont(new Font("Arial", Font.CENTER_BASELINE, 15));
		
				
		personnelManagement.addActionListener(e -> {
			this.dispose();			
			pm = new PersonnelManagement();
			
			// Personel Panelin Ana Ayarları
			pm.setTitle("Store Management System - Personnel Management");
			pm.setSize(600,700);
			pm.setLocationRelativeTo(null);
			pm.setLayout(new GridLayout(1,1));
			pm.setVisible(true);        
			pm.setResizable(false);
			pm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		});
		
		stockManagement.addActionListener(e -> {
			this.dispose();
			sm = new StockManagement();
			
			// Stok Panelin Ana Ayarları
			sm.setTitle("Store Management System - StockManagement");
			sm.setSize(600,700);
			sm.setLocationRelativeTo(null);
			sm.setLayout(new GridLayout(1,1));
			sm.setVisible(true);        
			sm.setResizable(false);
			sm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
			//setLayout(null);
		});
		
		programExit.addActionListener(e -> {
			System.exit(0);
		});
		
		
		homePanel.add(programtitle);  
		homePanel.add(personnelManagement);
		homePanel.add(stockManagement);
		homePanel.add(programExit);
		
		homePanel.setBounds(0,0, 400, 600);
		add(homePanel);
	}

}
