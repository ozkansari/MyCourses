package tr.edu.medipol.odevler.kerem_arca.odev1;
import java.util.Scanner;

// ses cikardaki tip kontrolu hatali: -20

public class HayvanatBahcesi extends Hayvan {
	 private static final Hayvan Hayvan = null;

	public static void main(String[] args) {
		 

		 
	        Scanner input = new Scanner(System.in);
			int hyvn;

			System.out.print("Hayvan Se� --> (1- Kedi | 2- K�pek | 3- Z�rafa): ");
			hyvn = input.nextInt();
			
			Scanner input2 = new Scanner(System.in);
			int sayi = 0;
			sayi = hyvn;
			
			if(hyvn == 1)
			{
			Hayvan kedi1=new Kedi();
			sesCikar(sayi,kedi1);
			}
			else if(hyvn == 2)
			{
			Hayvan kopek1=new Kopek();
			sesCikar(sayi,kopek1);
			}
			else if(hyvn == 3)
			{
			Hayvan zurafa1=new Zurafa();
			sesCikar(sayi,zurafa1);
			}
			else
			System.out.println("Ge�ersiz!");

	    }
	 
	 private static int sesCikar(int sesSeviyesi, Hayvan hayvan)
	 {
		 	Hayvan kedi=new Kedi();
	        Hayvan kopek=new Kopek();
	        Hayvan zurafa=new Zurafa();
	
			if(hayvan == kedi || sesSeviyesi == 1)
			{
		 	kedi.Ses(sesSeviyesi);
			}
			
			else if(hayvan == kopek || sesSeviyesi == 2)
			{
	        kopek.Ses(sesSeviyesi);
			}
			
			else if(hayvan == zurafa || sesSeviyesi == 3)
			{
	        zurafa.Ses(sesSeviyesi);
			}
			
			return sesSeviyesi;
	 }

	}