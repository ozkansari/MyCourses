package tr.edu.medipol.vize1.havvagamzeakbas;

public class Kiyafet extends Stok {

    public Kiyafet(){
        super("giyecek.txt");
    }

    public void stokEkle(String stokIsmi, String stokAdedi, String stokNumarasi) {
        super.stokEkle(stokIsmi,stokAdedi,stokNumarasi);

        System.out.println("Yeni Giyecek Sisteme Eklendi");
    }

    public String toString() {
        return this.stokIsmi + "," + this.stokAdedi + "," + this.stokNumarasi + "\n";
    }
}
