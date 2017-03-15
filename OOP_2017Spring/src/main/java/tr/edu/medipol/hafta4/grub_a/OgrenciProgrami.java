package tr.edu.medipol.hafta4.grub_a;

public class OgrenciProgrami {

	public static void main(String[] args) {
		
		// OgrenciGirisEkrani sinifindan bir nesne olustur 
		OgrenciGirisEkrani ekranNesnesi = new OgrenciGirisEkrani();
		
		// Pencere basligi belirle
		ekranNesnesi.setTitle("OGRENCI PROGRAMI"); 
		
		int en = 600;
		int boy = 500;
		ekranNesnesi.setSize(en,boy); // Pencere boyutunu belirle
		ekranNesnesi.setVisible(true); // Ekrana gorunur yaptik
	}

}
