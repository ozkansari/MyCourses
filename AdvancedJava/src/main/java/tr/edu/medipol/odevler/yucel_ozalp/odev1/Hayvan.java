package tr.edu.medipol.odevler.yucel_ozalp.odev1;

public class Hayvan{
     
     public class kedi {
    	   private static final String NESNE_ADI = "KED�";
           public int ID;
           public String Turu;
           public String Renk;
           public int Yasi;
           public int sesDesibeli;
           
    
           
           public kedi(int ID, String Turu, String Renk, int Yasi, int sesDesibeli) {
               super();
               this.ID = ID;
               this.Turu = Turu;
               this.Renk = Renk;
               this.Yasi = Yasi;
               this.sesDesibeli = sesDesibeli;
           }
       
           public void ekranaYaz() {
           System.out.print("Hayvan T�r�: " + NESNE_ADI + "\n ID: " + ID + "\n T�r�: " + Turu + "\n Renk: " + Renk + "\n Ya��: " + Yasi + "\n ��kard��� Ses: " + sesDesibeli);
   	 	   System.out.println("\n ------------- ");
   		
           }
     }
     
     public class kopek {
  	   private static final String NESNE_ADI = "K�PEK";
         public int ID;
         public String Turu;
         public String Renk;
         public int Yasi;
         public int sesDesibeli;
  
         
         public kopek(int ID, String Turu, String Renk, int Yasi, int sesDesibeli) {
             super();
             this.ID = ID;
             this.Turu = Turu;
             this.Renk = Renk;
             this.Yasi = Yasi;
             this.sesDesibeli = sesDesibeli;
         }
     
         public void ekranaYaz() {
         System.out.print("Hayvan T�r�: " + NESNE_ADI + "\n ID: " + ID + "\n T�r�: " + Turu + "\n Renk: " + Renk + "\n Ya��: " + Yasi + "\n ��kard��� Ses: " + sesDesibeli);
 	 	   System.out.println("\n ------------- ");
 		
         }
   }
     
     public class zurafa {
  	   private static final String NESNE_ADI = "Z�RAFA";
         public int ID;
         public String Turu;
         public String Renk;
         public int Yasi;
         public int sesDesibeli;
         
         public zurafa(int ID, String Turu, String Renk, int Yasi, int sesDesibeli) {
             super();
             this.ID = ID;
             this.Turu = Turu;
             this.Renk = Renk;
             this.Yasi = Yasi;
             this.sesDesibeli = sesDesibeli;
         }
     
         public void ekranaYaz() {
         System.out.print("Hayvan T�r�: " + NESNE_ADI + "\n ID: " + ID + "\n T�r�: " + Turu + "\n Renk: " + Renk + "\n Ya��: " + Yasi + "\n ��kard��� Ses: " + sesDesibeli);
 	 	   System.out.println("\n ------------- ");
 		
         }
   }

    
}
