package tr.edu.medipol.odev2.dogankoc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Randevular implements Comparable<String>{
	
   String randevuAdi;
   Date randevuTarihi;
   String randevuYeri;
   
   public Randevular(String rA,String rT,String rY,String tarihAyraci)
   {
	   randevuAdi=new String(rA);

	   try {
		  randevuTarihi=new SimpleDateFormat("dd"+tarihAyraci+"MM"+tarihAyraci+"yyyy").parse(rT);
	   } catch (ParseException e) {
		  e.printStackTrace();
	   }

	   randevuYeri=new String(rY);
	   
   }
   
   public String getRandevuAdi(){
	   return randevuAdi;
   }


   public Date getRandevuTarihi(){
	   return randevuTarihi;
   }

   public String getRandevuYeri(){
	   return randevuYeri;
   }

@Override
public int compareTo(String arg0) {
	//System.out.println("implements Comparable");
	return this.getRandevuAdi().compareTo(arg0);
}
   
}
