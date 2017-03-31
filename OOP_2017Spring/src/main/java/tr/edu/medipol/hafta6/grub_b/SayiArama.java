package tr.edu.medipol.hafta6.grub_b;

public class SayiArama {

	public static void main(String[] args) {		
		int aranacakSayi = 2334;
		int[] sayiDizisi = {1,2,654,24,86,2334,75,232,75654,445};
		
		SayiArama sayiArama = new SayiArama();
		int arananSayiIndisi = sayiArama.sayiDizisindeArama(sayiDizisi, aranacakSayi);
		if (arananSayiIndisi == -1) {
			System.out.println("Sayi bulunamadi");
		} else {
			System.out.println("Sayi bulundu. Pozisyonu: " + arananSayiIndisi);
		}
	}
	
	/**
	 * Sayi Dizisinde verilen sayiyi arayan bir metod.
	 * @param sayiDizisi aramanin yapilacagi dizin
	 * @param aranacakSayi dizide aranaak sayi
	 * @return Bulunamadiysa -1 doner, Bulunduysa dizideki pozisyonunu doner
	 */
	private int sayiDizisindeArama( int [] sayiDizisi, int aranacakSayi) {
		for (int i=0; i<sayiDizisi.length;i++) {
			if ( sayiDizisi[i] == aranacakSayi ) {
				return i;
			}
		}
		return -1;
	}
	
}
