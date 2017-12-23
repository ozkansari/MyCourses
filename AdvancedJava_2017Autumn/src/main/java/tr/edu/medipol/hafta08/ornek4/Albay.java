package tr.edu.medipol.hafta08.ornek4;

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
