package tr.edu.medipol.vize1.musasoysal;

import java.io.*;

public class Stok {
    protected String isim;
    protected String adet;
    protected String num;
    protected String dosyaYeri;

    public Stok(String dosyaYeri) {
        this.dosyaYeri = dosyaYeri;
    }

    public void giyecekEkle(String isim, String adet, String num) {
        this.isim = isim;
        this.adet = adet;
        this.num = num;
    }

    public void dosyayaEkle() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(this.dosyaYeri,true));
            out.write(toString());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String toString() {
        return this.isim + "," + this.adet + "," + this.num + "\n";
    }

	public void calisanEkle(String string, String soyisim2, String string2) {
		// TODO Auto-generated method stub
		
	}

  

   
}
