package tr.edu.medipol.vize1.havvagamzeakbas;

public class Aksesuar extends Stok{
    public Aksesuar() {
        super("aksesuar.txt");
    }

    public void stokEkle(String stokIsmi, String stokAdedi, String stokNumarasi) {
        super.stokEkle(stokIsmi,stokAdedi,stokNumarasi);

        System.out.println("Yeni Aksesuar Sisteme Eklendi");
    }

    public String toString() {
        return this.stokIsmi + "," + this.stokAdedi + "," + this.stokNumarasi + "\n";
    }
}