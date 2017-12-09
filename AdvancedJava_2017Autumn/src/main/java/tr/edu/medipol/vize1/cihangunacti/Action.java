package tr.edu.medipol.vize1.cihangunacti;
import java.util.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
public class Action implements ActionListener  {
	String veri1,veri2,veri3,veri4,veri5,veri6,veri7,veri8;
	Action(String veri1,String veri2,String veri3,String veri4,
			String veri5,String veri6,String veri7,String veri8)
	{
		this.veri1=veri1;
		this.veri2=veri2;
		this.veri3=veri3;
		this.veri4=veri4;
		this.veri5=veri5;
		this.veri6=veri6;
		this.veri7=veri7;
		this.veri8=veri8;
	}
	
	private JTextField PersonelNameandSurnameReference;
	private JTextField PersonelTc_no;
	private JTextField SalaryReference;
	private JTextField ReferenceYearofPersonel;
	private JComboBox<String> PersonelTypeReference;
	private JTextArea PersonelTextArea;
	private JTextField sil;
	public Action(JTextField i, JTextField j, JTextField k,
			  JTextField o, JComboBox<String> g,JTextArea b,JTextField c ) {
		
		PersonelNameandSurnameReference=i;
		PersonelTc_no=j;
		SalaryReference=k;
		ReferenceYearofPersonel=o;
		PersonelTypeReference=g;
		PersonelTextArea=b;
		sil=c;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton incoming=(JButton) e.getSource();
		 String incomingData=incoming .getText();
		 
		
		 String PersonelNameandSurname=PersonelNameandSurnameReference.getText();
	     String tc=PersonelTc_no.getText();
		 String Salary=SalaryReference.getText();
		 String YearofPersonel=ReferenceYearofPersonel.getText();
		 String sil2=sil.getText();
		 String PersonelType=(String)PersonelTypeReference.getSelectedItem();
		 Personel personel=null;
		 

		 
		 if(incomingData=="Kaydet") {
               
	      

			 System.out.println(""+"Name And Surname: "
						+ ""+PersonelNameandSurname+
						" TC: "+tc+
						"Salary: "+Salary+
						" Year Of Employment: "+YearofPersonel+
						" Personel Type: "+PersonelType);
		
		if(PersonelType.equals("M_d_r")){
			personel=new Manager(PersonelNameandSurname,tc,Salary,YearofPersonel,PersonelType);
		}
		else if(PersonelType.equals("Tasar_mc_")){
			personel=new Designer(PersonelNameandSurname,tc,Salary,YearofPersonel,PersonelType);
		}
		else if(PersonelType.equals("IT")){
			personel=new IT(PersonelNameandSurname,tc,Salary,YearofPersonel,PersonelType);
		}
		else if(PersonelType.equals("Stajyer")){
			personel=new Stajyer(PersonelNameandSurname,tc,Salary,YearofPersonel,PersonelType);
		}
		else if(PersonelType.equals("G_venlik")){
			personel=new Security(PersonelNameandSurname,tc,Salary,YearofPersonel,PersonelType);
		}
		else if(PersonelType.equals("Muhasebeci")){
			personel=new Accountant(PersonelNameandSurname,tc,Salary,YearofPersonel,PersonelType);
		}
		

		PersonelTextArea.setText("Kay_t Ba_ar_yla Olmu_tur...");

			 File file = new File(".\\config\\personel.txt");

		        //if file doesn't exists , then create it
		        if (!file.exists())
		            try {
		                file.createNewFile();
		            } catch (Exception e1) {
		                e1.printStackTrace();
		            }

		        try {
		        	 FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		            BufferedWriter bw = new BufferedWriter(fw);
		            	bw.write("\n"+PersonelNameandSurname+"\n"+tc+"\n"+Salary+
				       			   "\n"+YearofPersonel+"\n"+PersonelType+"\n"+
				       			"---------------------------------------------------\n");
				            
		            
		            	
					
		            bw.close();
		            System.out.println("SUCCESS..");
		        } catch (Exception e2) {
		            e2.printStackTrace();
		        }
		    }
		 
		 
		 if(incomingData=="Listele" ) {
			 JTextArea listArea=new JTextArea();
			 JScrollPane scroll = new JScrollPane();
			 scroll.setBounds(0,0,500,400);
				listArea.setEditable(false);
				JFrame listView =new JFrame("Personeller");
				listView.setVisible(true);
				listView.setResizable(false);
				listView.add(scroll);
				listView.setLocation(50, 60);
				listView.setSize(505,425);
				listView.add(listArea);
				scroll.setViewportView(listArea);
				listView.setDefaultCloseOperation(1);
			    BufferedReader br = null;
		        String sCurrentLine;
		        try {
		            br = new BufferedReader(new FileReader(".\\config\\personel.txt"));
		            Scanner fileReader=new Scanner(br);
		            for (int i = 0; fileReader.hasNextLine(); i++) {
	        			String currentRow=fileReader.nextLine();
	        			System.out.println(currentRow);
	        			listArea.append(currentRow+"\n\n");
	        			//PersonelList2.add(mevcutSatir);
	        			}
		            while ((sCurrentLine = br.readLine()) != null) {
		               System.out.println("READ ::::: " + sCurrentLine);
		            }
		        } catch (Exception e3) {
		            e3.printStackTrace();
		        } finally {
		            try {
		                br.close();
		            } catch (Exception e4) {
		                e4.printStackTrace();
		            }
		        }

		    }
		 
		 
		if(incomingData=="Sil") {
			
		try {
			deleteData(sil2);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
				
			
	}
}
	public void deleteData(String sil) throws FileNotFoundException
	{  
		
		int index=0;
		String search = null;
		StringBuffer str;
		str=new StringBuffer();
		FileInputStream br = null;
		
		
		try {
			
		 br = new FileInputStream(new File(".\\config\\personel.txt"));
		 
		 Scanner fileReader=new Scanner(br);
		 while(fileReader.hasNextLine()) {
 			String currenRow=fileReader.nextLine();
 			
			
			/*br.lines().forEach(ae->
			{
				
			});*/
			if((search=currenRow)!=null) 
			{
				
				if(search.equals(sil)) 
				{
			       //System.out.println("sil bulundu"+sil);
					for (int i = 0; i < 5; i++) {
						currenRow=fileReader.nextLine();
					}

				}
				if(currenRow!=" ") {		
				str.append(currenRow+"\n");
				}
			}
			
			
		 }
		 br.close();
		 fileReader.close();
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw=new PrintWriter(new FileOutputStream(new File(".\\config\\personel.txt")));
		pw.println(str.toString());
		pw.close();
       // System.out.println(str.toString());
			
				
}
}


