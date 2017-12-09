package tr.edu.medipol.vize1.ibrahimkandemir;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class PersonnelAction implements ActionListener {

	private List<Personnel> personnelList = new ArrayList<>();
	
	private JTextField employeeNameSurname_TF;
	private JTextField employeeTCNo_TF;
	private JTextField registrationNo_TF;
	private JTextField employeeJobDate_TF;	
	private JTextField employeeSalary_TF;
	
	private JComboBox<String> employeeDepartment;
	
	private static String path = System.getProperty("user.home");
	
	private static PrintWriter fileWrite;
	
	//private JTextField deleteEmp;
	
	
	
	
	public PersonnelAction(JTextField employeeNameSurname_TF, JTextField employeeTCNo_TF, JTextField registrationNo_TF,
			JTextField employeeJobDate_TF, JTextField employeeSalary_TF, JComboBox<String> employeeDepartment ) {
		
		this.employeeNameSurname_TF = employeeNameSurname_TF;
		this.employeeTCNo_TF = employeeTCNo_TF;
		this.registrationNo_TF = registrationNo_TF;
		this.employeeJobDate_TF = employeeJobDate_TF;
		this.employeeSalary_TF = employeeSalary_TF;
		this.employeeDepartment = employeeDepartment;

	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		File dir = new File(path + File.separator + "StoreManagementSystem");

		if (!dir.exists())
			dir.mkdirs();

		File file = new File(dir + File.separator + "Personnel.txt");
		Scanner fileReader;

		String employeeNameSurname = null;
		String employeeTCNo = null;
		String registrationNo = null;
		String employeeJobDate = null;
		String employeeSalary = null;
		String department = (String) employeeDepartment.getSelectedItem();

		try {
			if ((department.equals("The Employee's Unit"))) {

				JOptionPane.showMessageDialog(null, "Required fields cannot be left blank.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

		} catch (NullPointerException n) {
			JOptionPane.showMessageDialog(null, "Enter a valid unit.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		if (employeeNameSurname_TF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "The employee's First name or last name cannot be blank", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			employeeNameSurname = employeeNameSurname_TF.getText();
		}

		if (employeeTCNo_TF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "The employee number cannot be blank T. C.", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			employeeTCNo = employeeTCNo_TF.getText();
		}

		if (registrationNo_TF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "The employee registration number cannot be blank", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			registrationNo = registrationNo_TF.getText();
		}

		if (employeeJobDate_TF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "The start date of the employee's job cannot be blank", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			employeeJobDate = employeeJobDate_TF.getText();
		}

		if (employeeSalary_TF.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "The employee's salary cannot be left blank", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			employeeSalary = employeeSalary_TF.getText();
		}

		if (!(employeeNameSurname_TF.getText().isEmpty()) && !(employeeTCNo_TF.getText().isEmpty())
				&& !(registrationNo_TF.getText().isEmpty()) && !(employeeJobDate_TF.getText().isEmpty())
				&& !(employeeSalary_TF.getText().isEmpty())) {

			JOptionPane.showMessageDialog(null, "The employee were able to successfully register", "Info", JOptionPane.INFORMATION_MESSAGE);
		}

		Personnel personnel = null;

		if (department.equals("CEO")) {
			personnel = new CEO(employeeNameSurname, employeeTCNo, registrationNo, employeeJobDate, employeeSalary,
					department);
		} else if (department.equals("IT")) {
			personnel = new IT(employeeNameSurname, employeeTCNo, registrationNo, employeeJobDate, employeeSalary,
					department);
		} else if (department.equals("Sales Assistant")) {
			personnel = new SalesAssistant(employeeNameSurname, employeeTCNo, registrationNo, employeeJobDate,
					employeeSalary, department);
		}

		personnelList.add(personnel);

		try {

			fileWrite = new PrintWriter(new FileOutputStream(file, true));

			for (Personnel prsnl : personnelList) {
				fileWrite.println(prsnl.employeeNameSurname + "\n");
				fileWrite.println(prsnl.employeeTCNo + "\n");
				fileWrite.println(prsnl.registrationNo + "\n");
				fileWrite.println(prsnl.employeeJobDate + "\n");
				fileWrite.println(prsnl.employeeSalary + "\n");
				fileWrite.println(prsnl.employeeDepartment + "\n");

			}

			fileWrite.close();

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}
}
	

	

