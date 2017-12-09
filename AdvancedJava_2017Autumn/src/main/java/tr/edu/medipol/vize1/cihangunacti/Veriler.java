package tr.edu.medipol.vize1.cihangunacti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Veriler {
	String veri1,veri2,veri3,veri4,veri5,veri6,veri7,veri8;
	Veriler(String veri1,String veri2,String veri3,String veri4,
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
	

	public void veriSil(String silinecekVeri) 
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(".\\config\\personel.txt"));
			int index=0;
			Veriler [] veriArray=new Veriler[50];
			while(br.readLine() != null) 
			{
				veriArray[index]=new Veriler("","","","","","","","");
				if(br.readLine().equals(silinecekVeri)) 
				{
					veriArray[index]=new Veriler(br.readLine(),br.readLine(),br.readLine(),
							br.readLine(),br.readLine(),br.readLine(),br.readLine(),br.readLine());
				}
			}
			index++;
			FileWriter fw = new FileWriter(".\\config\\personel.txt");
            BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < veriArray.length; i++) {
				bw.write(veriArray[index].veri1);
				bw.write(veriArray[index].veri2);
				bw.write(veriArray[index].veri3);
				bw.write(veriArray[index].veri4);
				bw.write(veriArray[index].veri5);
				bw.write(veriArray[index].veri6);
				bw.write(veriArray[index].veri7);
				bw.write(veriArray[index].veri8);
				
			}
		} catch (IOException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}
