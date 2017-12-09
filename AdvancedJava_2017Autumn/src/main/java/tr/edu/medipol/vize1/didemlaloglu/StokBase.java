/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.medipol.vize1.didemlaloglu;

public class StokBase {
   private int stok_sayisi; 
   private String stok_tipi;
   private String urun;



    public int getStok_sayisi() {
        return stok_sayisi;
    }

    public void setStok_sayisi(int stok_sayisi) {
        this.stok_sayisi = stok_sayisi;
    }

    public String getStok_tipi() {
        return stok_tipi;
    }

    public void setStok_tipi(String stok_tipi) {
        this.stok_tipi = stok_tipi;
    }

    public String getUrun() {
        return urun;
    }

    public void setUrun(String urun) {
        this.urun = urun;
    }
   
   public StokBase( int stok_sayisi, String stok_tipi, String urun_ismi){
       this.setStok_sayisi(stok_sayisi);
       this.setStok_tipi(stok_tipi);
       this.setUrun(urun_ismi);
   }
}
