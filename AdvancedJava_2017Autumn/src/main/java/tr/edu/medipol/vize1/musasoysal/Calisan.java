package tr.edu.medipol.vize1.musasoysal;

import java.io.*;

public class Calisan {
    protected String isim;
    protected String soyisim;
    protected String tcKimlikNo;
    protected String dosyaYeri;

    public Calisan(String dosyaYeri) {
        this.dosyaYeri = dosyaYeri;
    }

    public void calisannEkle(String isim, String soyisim, String tckn) {
        this.isim = isim;
        this.soyisim = soyisim;
        this.tcKimlikNo = tckn;
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
        return this.isim + "," + this.soyisim + "," + this.tcKimlikNo + "\n";
    }

	public void calisanEkle(String string, String soyisim2, String string2) {
		// TODO Auto-generated method stub
		
	}

  

   
}
