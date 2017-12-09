package tr.edu.medipol.vize1.musasoysal;

public class Personel extends Calisan{

 
    public Personel() {
        super("personel.txt");
    }

    public void calisannEkle(String isim, String soyisim, String tckn) {
        super.calisannEkle("Ad Soyad: " + isim, soyisim,"Tc Kimlik No:" + tckn);

       

        System.out.println("Yeni Personel Sisteme Eklendi");
    }

    public String toString() {
        return this.isim + " " + this.soyisim + "      " + this.tcKimlikNo + "       " +   "\n";
    }

}
