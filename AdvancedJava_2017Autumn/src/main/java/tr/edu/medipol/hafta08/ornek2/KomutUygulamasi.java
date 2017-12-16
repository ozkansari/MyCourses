/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.medipol.hafta08.ornek2;

/**
 *
 * @author bprlab
 */
public class KomutUygulamasi {
    
    public static void main(String[] args) {
        
    }
    
    private class DirKomutu implements Komut, WindowsKomutu {

        @Override
        public void calistir() {
            System.out.println("dir");
        }

        @Override
        public void aciklama() {
            System.out.println("dir komutu aciklamasi");
        }
    
    }
    
    private abstract class DirKomutuAbstract implements Komut {
        // abstract class ise interfacede tanimli metodlari implement etmesine gerek yok
        // implementasyon alt siniflara birakilir
    }
}

