package tr.edu.medipol.hafta08.ornek4;

import java.util.ArrayList;
import java.util.List;


public class OrduUygulamasi {
    
    public static void main(String[] args) {
        
        Asker er = new Er("Musa Askerovski");
        Asker albay1 = new Albay("Mehmet Albaygil");
        Asker yarbay1 = new Yarbay("Fikret Yarbaygil");
    
        List<Asker> askerler = 
                new ArrayList<>();
        
        for (Asker asker : askerler) {
            System.out.println(asker.isim());
            
            if(asker instanceof Er) {
                ( (Er) asker).selamVer();
            }
        }

    }
}
