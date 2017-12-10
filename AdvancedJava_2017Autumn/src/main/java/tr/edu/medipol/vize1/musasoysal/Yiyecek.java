package tr.edu.medipol.vize1.musasoysal;

public class  Yiyecek extends Stok {



    public Yiyecek() {
        super("yiyecek.txt");
    }

    public void giyecekEkle(String yiyecekAd, String yiyecekAdedi, String yiyecekBarkodu) {
    	super.giyecekEkle("Yiyecek Adı: " + yiyecekAd, "Yiyecek Adedi: " + yiyecekAdedi, "Yiyecek Barkodu: " + yiyecekBarkodu);

        

        System.out.println("Yeni Yiyecek Sisteme Eklendi");
    }

    public String toString() {
    	return this.isim + " " + this.adet + "      " + this.num+ "       " +   "\n";
    }
}
