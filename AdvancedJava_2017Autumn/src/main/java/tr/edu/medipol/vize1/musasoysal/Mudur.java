package tr.edu.medipol.vize1.musasoysal;

public class Mudur extends Calisan {

    
    public Mudur() {
        super("mudur.txt");
    }

    public void calisanEkle(String isim, String soyisim, String tckn) {
        super.calisanEkle("Ad Soyad: " + isim, soyisim,"Tc Kimlik No:" + tckn);

       

        System.out.println("Yeni Mudur Sisteme Eklendi");
    }

    public String toString() {
    	return this.isim + " " + this.soyisim + "      " + this.tcKimlikNo + "       " +   "\n";
    }
}
