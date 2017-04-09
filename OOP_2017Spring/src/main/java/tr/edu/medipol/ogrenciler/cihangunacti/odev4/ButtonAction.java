package tr.edu.medipol.ogrenciler.cihangunacti.odev4;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;




public class ButtonAction implements ActionListener {
	private List<Working> EmployeeList=new ArrayList<>();
	private JTextField EmployeeNameandSurnameReference;
	private JTextField ReferenceYearofEmployment;
	private JComboBox<String> WorkingTypeReference;
	private JTextField SalaryReference;
	private JTextArea WorkingTextArea;
	public ButtonAction(JTextField i, JTextField j, JComboBox<String> k,
			 JTextField n, JTextArea o) {
		
		EmployeeNameandSurnameReference=i;
		ReferenceYearofEmployment=j;
		WorkingTypeReference=k;
		SalaryReference=n;
		WorkingTextArea=o;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String WorkingNameandSurname=EmployeeNameandSurnameReference.getText();
		String Year=ReferenceYearofEmployment.getText();
		String WorkingType=(String)WorkingTypeReference.getSelectedItem();
		String Salary=SalaryReference.getText();
		System.out.println(""+"Name And Surname "+WorkingNameandSurname+ " Year Of Employment: "+Year+" Working Type: "+WorkingType+" Salary: "+Salary);

	
		
		
		Working working=null;
		if(WorkingType.equals("Manager")){
			working=new Manager(WorkingNameandSurname,Year,WorkingType,Salary);
		}
		else if(WorkingType.equals("Programmer")){
			working=new Programmer(WorkingNameandSurname,Year,WorkingType,Salary);
		}
		else if(WorkingType.equals("Controller")){
			working=new Controller(WorkingNameandSurname,Year,WorkingType,Salary);
		}
		else if(WorkingType.equals("Stajyer")){
			working=new Stajyer(WorkingNameandSurname,Year,WorkingType,Salary);
		}
		
		
		EmployeeList.add(working);
		
		
		String liste="";
		for(Working o:EmployeeList){
			liste=liste +"Name and Surname: " +o.EmployeeName+ " Year Of Employment: "+Year+" Working Type: "+WorkingType+" Salary: "+Salary+"\n"; 
		}
		WorkingTextArea.setText(liste);
		
		
				
	}
	public List<Working>getEmployeeList(){
		return EmployeeList;
	}
	}
