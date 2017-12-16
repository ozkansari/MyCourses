/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.edu.medipol.hafta08.ornek4;

/**
 *
 * @author bprlab
 */
public class Albay implements Asker {

    private String isim;
    
    public Albay(String isim) {
        this.isim = isim;
    }

    @Override
    public String isim() {
        System.out.println("Albay " + isim); 
        return isim;
    }
 
}
