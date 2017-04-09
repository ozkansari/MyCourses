package tr.edu.medipol.ogrenciler.cihangunacti.odev4;


import java.awt.Color;
import java.awt.*;


import javax.swing.*;




public class StudyProgram extends JFrame {
	private JTextField WorkingNameSurname=new JTextField();
	private JTextField YearofEmployment=new JTextField();
	private ButtonAction button;
	private JComboBox<String> WorkingType=new JComboBox<String>();
	private JTextField WorkingSalary=new JTextField();
	private JTextArea WorkingTextArea=new JTextArea();
	private ButtonGroup GenderGroup = new ButtonGroup();
	private JRadioButton GenderType = new JRadioButton("ERKEK", false),
			GenderType2 = new JRadioButton("KADIN", false);
	public void olustur(){
		
		this.setLayout(new GridLayout(2,0));
		
		JPanel WorkingForm=new JPanel();
		WorkingForm.setLayout(new GridLayout(15,0));
		WorkingForm.setBackground(Color.ORANGE);
		JLabel calisanAd=new JLabel("Please enter your Name and Surname");
		JLabel calisaniseGirisYili=new JLabel("Year Of Employment");
		JLabel maas=new JLabel("Salary");
		
		
		WorkingType.addItem("Please Select...");
		WorkingType.addItem("Manager");	
		WorkingType.addItem("Programmer");
		WorkingType.addItem("Controller");
		WorkingType.addItem("Stajyer");
		
		JButton submitButton=new JButton("Submit");
		button=new ButtonAction(WorkingNameSurname,YearofEmployment,WorkingType,WorkingSalary,WorkingTextArea);
		submitButton.addActionListener(button);

		
		WorkingForm.add(calisanAd);
		WorkingForm.add(WorkingNameSurname);
		WorkingForm.add(calisaniseGirisYili);
		WorkingForm.add(YearofEmployment);
		WorkingForm.add(maas);
		WorkingForm.add(WorkingSalary);
		GenderGroup.add(GenderType);
		GenderGroup.add(GenderType2);
		WorkingForm.add(GenderType);
		WorkingForm.add(GenderType2);
		WorkingForm.add(WorkingType);
		WorkingForm.add(submitButton);

		add(WorkingForm);
		add(WorkingTextArea);
		
		
	}

	public static void main(String[] args) {
		
		StudyProgram program=new StudyProgram();
		program.olustur();
		program.setTitle("Work Record Program");
		program.setSize(600,600);	
		program.setVisible(true);
		program.setResizable(false);
		program.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

}
