package tr.edu.medipol.vize1.cihangunacti;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionStok implements ActionListener {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private JTextField StokAdi;
	private JTextField Stok_Kodu;
	private JTextField Kdv;
	private JTextField Marka;
	private JTextField Stok_Aciklama;
	private JTextField _zel_Kod;
	private JComboBox<String> Stok_Type;
	private JTextArea PersonelTextArea;
	private JTextField sil;
    public ActionStok(JTextField i, JTextField j, JTextField k,
			  JTextField o,JTextField t,JTextField e, JComboBox<String> g,JTextArea b,JTextField c ) {
		
    	StokAdi=i;
    	Stok_Kodu=j;
    	Kdv=k;
    	Marka=o;
    	Stok_Aciklama=t;
    	_zel_Kod=e;
    	Stok_Type=g;
		PersonelTextArea=b;
		sil=c;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton incoming=(JButton) e.getSource();
		String incomingData=incoming.getText();
		 
		
		 String StokName=StokAdi.getText();
	     String Stokodu=Stok_Kodu.getText();
		 String Kdvv=Kdv.getText();
		 String Markaa=Marka.getText();
		 String StokAciklama=Stok_Aciklama.getText();
		 String _zelKod=_zel_Kod.getText();
		 String StokType=(String)Stok_Type.getSelectedItem();
		 String delete2=sil.getText();
		
		 Stok stok=null;
		 

		 
		 if(incomingData=="Kaydet") {
               
	      

			 System.out.println(""+"Stock Name: "
						+ ""+StokName+
						" Stock Cod: "+Stokodu+
						"KDV: "+Kdvv+
						" Brand: "+Markaa+
						" Stock statement : "+StokAciklama+
						"Specific Code:"+_zelKod+
						"Stock Type:"+StokType);
		
		
		if(StokType.equals("Plazma TV")){
			
			stok=new PlazmaTv(StokName,Stokodu,Kdvv,Markaa,StokAciklama,_zelKod,StokType);
		}
		else if(StokType.equals("Bula__k Makinesi")){
			stok=new BulasikMakinesi(StokName, Stokodu, Kdvv, Markaa, StokAciklama, _zelKod, StokType);
		}
		else if(StokType.equals("Cep Telefonu")){
			stok=new CepTelefonu(StokName, Stokodu, Kdvv, Markaa, StokAciklama, _zelKod, StokType);
		}
		else if(StokType.equals("_ama__r Makinesi")){
			stok=new CamasirMakinesi(StokName, Stokodu, Kdvv, Markaa, StokAciklama, _zelKod, StokType);
		}
		else if(StokType.equals("Bilgisayar")){
			stok=new Bilgisayar(StokName, Stokodu, Kdvv, Markaa, StokAciklama, _zelKod, StokType);
		}
		else if(StokType.equals("Buzdolab_")){
			stok=new Buzdolabi(StokName, Stokodu, Kdvv, Markaa, StokAciklama, _zelKod, StokType);
		}
		

		PersonelTextArea.setText("Kay_t Ba_ar_yla Olmu_tur...");

			 File file = new File(".\\config\\stoklar.txt");

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
		            	bw.write(StokName+"\n"+Stokodu+"\n"+Kdvv+
				       			   "\n"+Markaa+"\n"+StokAciklama+"\n"+
		            			   _zelKod+"\n"+StokType+"\n");
				            bw.write("---------------------------------------------------\n");
		            
					
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
				JFrame listView =new JFrame("Stoklar");
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
		            br = new BufferedReader(new FileReader(".\\config\\stoklar.txt"));
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
			deleteData(delete2);
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
			
		 br = new FileInputStream(new File(".\\config\\stoklar.txt"));
		 
		 Scanner fileReader=new Scanner(br);
		 while(fileReader.hasNextLine()) {
 			String currentRow=fileReader.nextLine();
 			
			
			/*br.lines().forEach(ae->
			{
				
			});*/
			if((search=currentRow)!=null) 
			{
				
				if(search.equals(sil)) 
				{
			       //System.out.println("sil bulundu"+sil);
					for (int i = 0; i < 7; i++) {
                      currentRow=fileReader.nextLine();
					}

				}
				if(currentRow!=" ") {		
				str.append(currentRow+"\n");
				}
			}
			
			
		 }
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter pw=new PrintWriter(new FileOutputStream(new File(".\\config\\stoklar.txt")));
		pw.println(str.toString());
		pw.close();
       // System.out.println(str.toString());
			
				
}
}


