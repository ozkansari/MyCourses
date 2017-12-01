package tr.edu.medipol.odev1.dogankoc;

// 95

// Hatali class ismi
// TR - encoding problemleri
// Kod formatlama sorunlari

// public class Odev_2ileriJava {
public class Odev_3ileriJava {
	
	public static void main(String[] args) {
		
		int fromIndex=0,i=0;
		
		String str="i�indeolar�aramaodevi_o_laribul_o_lari";
		
		while(i < 0 ? false : true)
		{
			i=str.indexOf('o',fromIndex); //indexOf fromIndex den itibaren ararken son index e geldi�inde 'o' yu
			if(i >= 0)                     //bulamad���ndan indexOf -1 d�nd�r�r x -1 olur buna dikkat et
			System.out.println(str.charAt(i)+": "+i+". indexde");
			fromIndex=i+1;
			
		}
	}

}
