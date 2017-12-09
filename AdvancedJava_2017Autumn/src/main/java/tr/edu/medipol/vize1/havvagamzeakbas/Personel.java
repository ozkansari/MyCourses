package tr.edu.medipol.vize1.havvagamzeakbas;

public class Personel extends Calisan {

    public Personel() {
        super("personel.txt");
    }

    public void calisanEkle(String isim, String soyisim, String tckn) {
        super.calisanEkle(isim, soyisim, tckn);

  

        System.out.println("Yeni Personel Sisteme Eklendi");
    }

    public String toString() {
        return this.isim + "," + this.soyisim + "," + this.tcKimlikNo + "," + "\n";
    }
}
