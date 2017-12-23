package tr.edu.medipol.hafta08.ornek4;

public class Er implements Asker  {

    private String isim;
    
    public Er(String isim) {
        this.isim = isim;
    }

    @Override
    public String isim() {
        System.out.println("Er " + isim); 
        return isim;
    }

    public void selamVer() {
        System.err.println("Ben " + isim + ". Emret komutanim.");
    }

}
