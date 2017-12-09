package tr.edu.medipol.vize1.havvagamzeakbas;

public class Stajyer extends Calisan {

    public Stajyer() {
        super("stajyer.txt");
    }

    public void calisanEkle(String isim, String soyisim, String tckn) {
        super.calisanEkle(isim, soyisim, tckn);

     

        System.out.println("Yeni Stajyer Sisteme Eklendi");
    }

    public String toString() {
        return this.isim + "," + this.soyisim + "," + this.tcKimlikNo + "," +"\n";
    }
}
