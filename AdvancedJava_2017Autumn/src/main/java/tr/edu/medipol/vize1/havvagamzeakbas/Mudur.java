package tr.edu.medipol.vize1.havvagamzeakbas;

public class Mudur extends Calisan {

    public Mudur() {
        super("mudur.txt");
    }

    public void calisanEkle(String isim, String soyisim, String tckn) {
        super.calisanEkle(isim, soyisim, tckn);



        System.out.println("Yeni Mudur Sisteme Eklendi");
    }

    public String toString() {
        return this.isim + "," + this.soyisim + "," + this.tcKimlikNo + ","  + "\n";
    }
}
