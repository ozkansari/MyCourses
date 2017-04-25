package tr.edu.medipol.hafta10;


public class AramaAlgoritmalari {

	public static void main(String[] args) {		
		int aranacakSayi = 232;
		int[] sayiDizisi = {1,2,24,86,232,445};
		
		AramaAlgoritmalari sayiArama = new AramaAlgoritmalari();
		
		System.out.println("Dogrusal Arama :");
		int arananSayiIndisi = sayiArama.dogrusalArama(sayiDizisi, aranacakSayi);
		if (arananSayiIndisi == -1) {
			System.out.println("Sayi bulunamadi");
		} else {
			System.out.println("Sayi bulundu. Pozisyonu: " + arananSayiIndisi);
		}
		
		System.out.println("Ikili Arama :");
		int arananSayiIndisi2 = sayiArama.ikiliArama(sayiDizisi, aranacakSayi);
		if (arananSayiIndisi2 == -1) {
			System.out.println("Sayi bulunamadi");
		} else {
			System.out.println("Sayi bulundu. Pozisyonu: " + arananSayiIndisi2);
		}
	}
	
	/**
	 * Sayi Dizisinde verilen sayiyi arayan bir metod.
	 * @param sayiDizisi aramanin yapilacagi dizin
	 * @param arananSayi dizide aranacak sayi
	 * @return Bulunamadiysa -1 doner, Bulunduysa dizideki pozisyonunu doner
	 */
	private int dogrusalArama( int [] sayiDizisi, int arananSayi) {
		for (int i=0; i<sayiDizisi.length;i++) {
			if ( sayiDizisi[i] == arananSayi ) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	 * @param sayiDizisi sirali olmak zorunda
	 * @param arananSayi dizide aranacak sayi
	 * @return Bulunamadiysa -1 doner, Bulunduysa dizideki pozisyonunu doner
	 */
	public int ikiliArama(int[] sayiDizisi, int arananSayi) {
		int solIndis = 0;
		int sagIndis = sayiDizisi.length-1;
		
		while (solIndis <= sagIndis) {
			int ortaIndis = (solIndis + sagIndis) / 2;
			if (sayiDizisi[ortaIndis] == arananSayi) {
				return ortaIndis;
			} else if (sayiDizisi[ortaIndis] < 0) {
				sagIndis = ortaIndis - 1;
			} else {
				solIndis = ortaIndis + 1;
			}
		}
		return -1; // aranan bulunamadı
	}
}
