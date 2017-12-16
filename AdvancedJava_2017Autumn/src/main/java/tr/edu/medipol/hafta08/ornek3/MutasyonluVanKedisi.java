package tr.edu.medipol.hafta08.ornek3;

/**
 *
 * @author bprlab
 */
public class MutasyonluVanKedisi extends Kedi {
    
    @Override
    public void miyavla(){
        System.out.println("meowwwwww");
    }

    @Override
    public int ayakSayisi() {
        return super.ayakSayisi() + 1;
    }
    
    
}
