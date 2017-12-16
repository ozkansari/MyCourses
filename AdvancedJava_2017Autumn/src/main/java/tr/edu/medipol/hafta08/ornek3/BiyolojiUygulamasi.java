package tr.edu.medipol.hafta08.ornek3;

/**
 *
 * @author bprlab
 */
public class BiyolojiUygulamasi {
    
    public static void main(String[] args) {
        
        // Tanimlarken tip donusumu / cok yuzluluk
        Kedi minnos = new Kedi();
        minnos.miyavla();
        
        Memeli minnos2 = new Kedi();
        // minnos2.miyavla();
        
        Hayvan minnos3 = new Kedi();
        Insan trump = new Insan();
        
        // Sonradan tip donusumu
        Memeli minnos4 = minnos;
        Hayvan minnos5 = minnos;
        
        Memeli [] canlilar = { minnos, minnos2, trump};
        for (Memeli memeli : canlilar) {
            System.err.println("memeli ayak sayisi: " 
                    + memeli.ayakSayisi());
            
            // bu bir kedi ensnesi mi?
            if (memeli instanceof Kedi) {
                Kedi k = (Kedi) memeli;
                k.miyavla();
            }
        }
    }
}
