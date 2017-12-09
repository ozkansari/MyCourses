package tr.edu.medipol.vize1.havvagamzeakbas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Calisan {
    protected String isim;
    protected String soyisim;
    protected String tcKimlikNo;
    protected String dosyaYeri;

    public Calisan(String dosyaYeri) {
        this.dosyaYeri = dosyaYeri;
    }

    public void calisanEkle(String isim, String soyisim, String tckn) {
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

    public List<String[]> calisanListele() {
        BufferedReader in = null;
        ArrayList<String[]> data = new ArrayList<String[]>();
        try {
            in = new BufferedReader(new FileReader(this.dosyaYeri));
            String satir;
            String isim;
            String soyisim;
            String tckn;

            while ((satir = in.readLine()) != null) {
                String[] splittedData = satir.split(",");
                isim = splittedData[0];
                soyisim = splittedData[1];
                tckn = splittedData[2];
                if(this.dosyaYeri.equals("stajyer.txt")) {
                    data.add(new String[] {isim, soyisim, tckn, "Stajyer"});
                } else if(this.dosyaYeri.equals("personel.txt")) {
                    data.add(new String[]{isim, soyisim, tckn, "Personel"});
                } else if(this.dosyaYeri.equals("mudur.txt")) {
                    data.add(new String[] {isim, soyisim, tckn, "Mudur"});
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

    public void calisanSilme(String calisanTckn) {
        BufferedReader in = null;
        String yeniDosyaBilgileri = "";
        try {
            in = new BufferedReader(new FileReader(this.dosyaYeri));
            String satir;
            while ((satir = in.readLine()) != null) {
                if(! satir.contains(calisanTckn)) {
                    yeniDosyaBilgileri += satir + "\n";
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