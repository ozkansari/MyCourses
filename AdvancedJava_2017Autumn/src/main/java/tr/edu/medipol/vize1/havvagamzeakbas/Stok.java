package tr.edu.medipol.vize1.havvagamzeakbas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Stok {
    protected String stokIsmi;
    protected String stokAdedi;
    protected String stokNumarasi;
    protected String dosyaYeri;

    public Stok(String dosyaYeri) {
        this.dosyaYeri = dosyaYeri;
    }

    public void stokEkle(String stokIsmi, String stokAdedi, String stokNumarasi) {
        this.stokIsmi = stokIsmi;
        this.stokNumarasi = stokAdedi;
        this.stokAdedi = stokAdedi;
    }

    public void stokDosyayaEkle() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(this.dosyaYeri,true));
            out.write(toString());
            System.out.println("Stok dosyaya eklendi.");
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
        return this.stokIsmi + "," + this.stokAdedi + "," + this.stokNumarasi + "\n";
    }

    public List<String[]> stokListele() {
        BufferedReader in = null;
        ArrayList<String[]> data = new ArrayList<String[]>();
        try {
            in = new BufferedReader(new FileReader(this.dosyaYeri));
            String satir;
            String stokIsmi;
            String stokAdedi;
            String stokNumarasi;

            while ((satir = in.readLine()) != null) {
                String[] splittedData = satir.split(",");
                stokIsmi = splittedData[0];
                stokAdedi = splittedData[1];
                stokNumarasi = splittedData[2];
                if(this.dosyaYeri.equals("giyecek.txt")) {
                    data.add(new String[] {stokIsmi, stokAdedi, stokNumarasi, "Giyecek"});
                } else if(this.dosyaYeri.equals("yiyecek.txt")) {
                    data.add(new String[]{stokIsmi, stokAdedi, stokNumarasi, "Yiyecek"});
                } else if(this.dosyaYeri.equals("aksesuar.txt")) {
                    data.add(new String[] {stokIsmi, stokAdedi, stokNumarasi, "Aksesuar"});
                }
            }
            return data;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    public void stokSilme(String stokNo) {
        BufferedReader in = null;
        String yeniDosyaBilgileri = "";
        try {
            in = new BufferedReader(new FileReader(this.dosyaYeri));
            String satir;
            while ((satir = in.readLine()) != null) {
                if(! satir.contains(stokNo)) {
                    yeniDosyaBilgileri += satir + "\n";
                    System.out.println("Eski Stok Alindi");
                }
                else {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(this.dosyaYeri));
            out.write(yeniDosyaBilgileri);
            System.out.println("Stok Silindi");
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
}
