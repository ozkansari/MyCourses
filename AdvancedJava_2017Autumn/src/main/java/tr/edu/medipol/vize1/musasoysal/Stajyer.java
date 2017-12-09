package tr.edu.medipol.vize1.musasoysal;

public class Stajyer extends Calisan {



    public Stajyer() {
        super("stajyer.txt");
    }

    public void calisannEkle(String isim, String soyisim, String tckn) {
    	super.calisannEkle("Ad Soyad: " + isim, soyisim,"Tc Kimlik No:" + tckn);

        

        System.out.println("Yeni Stajyer Sisteme Eklendi");
    }

    public String toString() {
    	return this.isim + " " + this.soyisim + "      " + this.tcKimlikNo + "       " +   "\n";
    }
}
