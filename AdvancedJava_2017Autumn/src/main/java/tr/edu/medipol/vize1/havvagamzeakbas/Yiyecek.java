package tr.edu.medipol.vize1.havvagamzeakbas;

public class Yiyecek extends Stok {

    public Yiyecek() {
        super("yiyecek.txt");
    }

    public void stokEkle(String stokIsmi, String stokAdedi, String stokNumarasi) {
        super.stokEkle(stokIsmi,stokAdedi,stokNumarasi);

        System.out.println("Yeni Yiyecek Sisteme Eklendi");
    }

    public String toString() {
        return this.stokIsmi + "," + this.stokAdedi + "," + this.stokNumarasi + "\n";
    }
}
