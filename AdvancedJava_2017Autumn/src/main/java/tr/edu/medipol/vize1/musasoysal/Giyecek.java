package tr.edu.medipol.vize1.musasoysal;

public class Giyecek extends Stok {



    public Giyecek() {
        super("giyecek.txt");
    }

    public void giyecekEkle(String giyecekAd, String giyecekAdedi, String ref) {
    	super.giyecekEkle("Giyecek Adı: " + giyecekAd, "Adedi: " + giyecekAdedi, "Referansı: " + ref);

        

        System.out.println("Yeni Giyecek Sisteme Eklendi");
    }

    public String toString() {
    	return this.isim + " " + this.adet + "      " + this.num+ "       " +   "\n";
    }
}

