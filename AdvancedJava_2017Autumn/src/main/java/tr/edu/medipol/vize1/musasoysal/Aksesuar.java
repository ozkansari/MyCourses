package tr.edu.medipol.vize1.musasoysal;

public class  Aksesuar extends Stok {



    public Aksesuar() {
        super("aksesuar.txt");
    }

    public void aksesuarEkle(String aksesuarAd, String aksesuarAdedi, String aksesuarBarkodu) {
    	super.giyecekEkle("Aksesuar Adı: " + aksesuarAd, "Aksesuar Adedi: " + aksesuarAdedi, "Aksesuar Barkodu: " + aksesuarBarkodu);

        

        System.out.println("Yeni Aksesuar Sisteme Eklendi");
    }

    public String toString() {
    	return this.isim + " " + this.adet + "      " + this.num+ "       " +   "\n";
    }
}
