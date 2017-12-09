package tr.edu.medipol.vize1.ibrahimkandemir;

import java.awt.*;
import javax.swing.*;


import java.io.*;
import java.util.*;
import java.util.List;


public class PersonnelManagement extends JFrame{
	
	private  JPanel personnelPanel = new JPanel();
	private  JPanel personnelList = new JPanel();
	private  JPanel personnelDelete = new JPanel();
	private PersonnelAction buttonAction;
	
	private  JTabbedPane tabMenu = new JTabbedPane();
		
	private JLabel employeeNameSurname_L = new JLabel("Name and Surname:");
	private JLabel employeeTCNo_L = new JLabel("T.C. Identity Number:");
	private JLabel registrationNo_L = new JLabel("Registration Number:");
	private JLabel employeeJobDate_L = new JLabel("Job Start Date:");
	private JLabel employeeSalary_L = new JLabel("Employee Salary:");
	private JLabel employeeDepartment_L = new JLabel("Department:");
	
	private JTextField employeeNameSurname_TF = new JTextField();
	private JTextField employeeTCNo_TF = new JTextField();
	private JTextField registrationNo_TF = new JTextField();
	private JTextField employeeJobDate_TF = new JTextField();	
	private JTextField employeeSalary_TF = new JTextField();
	
	private JComboBox<String> employeeDepartment = new JComboBox<>();
	
	private JLabel empDelete_L = new JLabel("Delete Enter Registration Number:");
	private JTextField empDelete_TF = new JTextField();
	private JButton empDelete_B = new JButton("Delete Personnel");
	private JButton home = new JButton("Home Screen");		
	private JButton personnelRegister = new JButton("Personnel Register");
	
	
	private JTextArea employee_TxtArea = new JTextArea();
	private JButton prsnlList_B = new JButton("Personnel List");
	

	private static String path = System.getProperty("user.home");
	private Scanner fileReader;
		
	
	public PersonnelManagement() {

		
		
		// Tab Menunun Ayarları
		personnelPanel.setLayout(new GridLayout(18, 1));
		personnelPanel.setBackground(new Color(41,182,246));

		personnelList.setLayout(null);
		personnelList.setBackground(new Color(216,27,96));

		personnelDelete.setLayout(new GridLayout(18,1));
		personnelDelete.setBackground(new Color(96,125,139));
		

		employeeDepartment.addItem("The Employee's Unit");
		employeeDepartment.addItem("CEO");
		employeeDepartment.addItem("IT");
		employeeDepartment.addItem("Sales Assistant");
		
		
		employee_TxtArea.setEditable(false);
		
		employee_TxtArea.setBounds(0, 30, 590, 690);
		prsnlList_B.setBounds(10, 2, 150, 25);

		
		
		personnelPanel.add(home);
		
		personnelPanel.add(employeeNameSurname_L);
		personnelPanel.add(employeeNameSurname_TF);
		personnelPanel.add(employeeTCNo_L);
		personnelPanel.add(employeeTCNo_TF);
		personnelPanel.add(registrationNo_L);
		personnelPanel.add(registrationNo_TF);
		personnelPanel.add(employeeJobDate_L);
		personnelPanel.add(employeeJobDate_TF);
		personnelPanel.add(employeeSalary_L);
		personnelPanel.add(employeeSalary_TF);
		personnelPanel.add(employeeDepartment_L);
		personnelPanel.add(employeeDepartment);
		
		
		

		personnelPanel.add(personnelRegister);
		
		buttonAction = new PersonnelAction(employeeNameSurname_TF, employeeTCNo_TF, 
				registrationNo_TF, employeeJobDate_TF, employeeSalary_TF, employeeDepartment);
		
		personnelRegister.addActionListener(buttonAction);
		
		personnelList.add(employee_TxtArea);
		personnelList.add(prsnlList_B);
	
		
		personnelDelete.add(empDelete_L);
		personnelDelete.add(empDelete_TF);
		personnelDelete.add(empDelete_B);
		
		
		prsnlList_B.addActionListener(e -> {
			
			
			employee_TxtArea.setText("");

			File dir = new File(path + File.separator + "StoreManagementSystem");
			
			if(!dir.exists())
				dir.mkdirs();
			
			File file = new File (dir + File.separator + "Personnel.txt");	
			
			try {
				fileReader = new Scanner(file);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
					
			 while (fileReader.hasNextLine()) {
				 String currentLine = fileReader.nextLine();
				 employee_TxtArea.append(currentLine + "\n");
				
			}
			 fileReader.close();
		});
		 
		        
		 

		tabMenu.addTab("Personnel Register", personnelPanel);
		tabMenu.addTab("Personnel List", personnelList);
		tabMenu.addTab("Personnel Delete", personnelDelete);

		add(tabMenu);
		
		
		
		
		home.addActionListener(e -> {
			
			this.dispose();
			new HomeScreen();
			
		});
		
	}
}



